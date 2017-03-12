/**
 * Created by molmo on 2017-02-06.
 */
window.Templater = function () {
  return {
    version: 0.01,
    CONST: {
      EVENT: {
        ADD: 'addEvent',
        SET: 'setEvent',
        REMOVE: 'removeEvent',
        MOVE: 'moveEvent'
      }
    },
    Event: function (type, content) {
      var version = this.version;
      if (!type)
        throw new Error("Event has no type.");

      return {
        type: type,
        version: version,
        time: (new Date()).getTime(),
        content: content || function () {
        },
        args: null,
        rollback: function () {
        },
        excute: function () {
          this.rollback = this.content(this.args);
        }
      }
    },
    undoCount: 0,
    cursor: 0,
    undo: function () {
      var event = this.events[this.cursor - 1];
      if (!event) {
        return;
      }
      this.cursor--;
      this.undoCount++;
      return event.rollback();
    },
    redo: function () {
      var event = this.events[this.cursor];
      if (!event) {
        return;
      }
      this.cursor++;
      this.undoCount--;
      return event.excute();
    },
    excute: function () {
      for (this.cursor; this.undoCount > 0; this.undoCount--) {
        this.events.splice(this.cursor, 1);
      }

      for (this.cursor; this.cursor < this.events.length; this.cursor++) {
        this.events[this.cursor].excute();
      }
    },
    events: [],
    canvas: {},
    modules: {},
    convert: {
      rgb2hex: function (rgb) {
        if (!rgb) return;


        var hexDigits = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"];
        var hex = function (x) {
          return isNaN(x) ? "00" : hexDigits[(x - x % 16) / 16] + hexDigits[x % 16];
        };

        var rgba = rgb.match(/^rgba\((\d+),\s*(\d+),\s*(\d+),\s*(\d+)\)$/);
        rgb = rgb.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
        return rgba ? hex(rgba[4]) + hex(rgba[1]) + hex(rgba[2]) + hex(rgba[3]) : hex(rgb[1]) + hex(rgb[2]) + hex(rgb[3]);
      }
    },
    get: {
      params: function () {
        var query_string = {};
        var query = window.location.search.substring(1);
        var vars = query.split("&");
        for (var i = 0; i < vars.length; i++) {
          var pair = vars[i].split("=");
          // If first entry with this name
          if (typeof query_string[pair[0]] === "undefined") {
            query_string[pair[0]] = decodeURIComponent(pair[1]);
            // If second entry with this name
          } else if (typeof query_string[pair[0]] === "string") {
            var arr = [query_string[pair[0]], decodeURIComponent(pair[1])];
            query_string[pair[0]] = arr;
            // If third or later entry with this name
          } else {
            query_string[pair[0]].push(decodeURIComponent(pair[1]));
          }
        }
        return query_string;
      },
      template: function (key) {
        var $head = $("head");
        var module = this._.modules[key];
        $head.find("script." + key).remove();
        $head.find("style." + key).remove();

        $head.append("<script class='" + key + "'>" + module.script + "</script>");
        $head.append("<style class='" + key + "'>" + module.style + "</style>");

        return module.template;
      }
    },
    load: {
      module: function (key, url, callback) {
        var modules = this._.modules;
        var option = {
          key: key,
          url: url,
          callback: callback
        };
        if (typeof key === "object") {
          option = key;
        }

        if (modules[key]) {
          if (typeof option.callback === "function") {
            option.callback(modules[key]);
          }
        }

        if (!option.url) {
          throw "해당하는 템플릿이 없습니다.";
        }
        $.get(option.url)
        .done(function (result) {
          if (result) {
            var $tpl = $("<div></div>");
            $tpl.html(result);
            modules[option.key] = {};
            if ($tpl.find("script").length > 0) {
              modules[option.key].script = $tpl.find("script").html();
              $tpl.find("script").remove();
            }

            if ($tpl.find("style").length > 0) {
              modules[option.key].style = $tpl.find("style").html();
              $tpl.find("style").remove();
            }

            modules[option.key].template = $tpl.html();

            if (typeof option.callback === "function") {
              option.callback(modules[option.key]);
            }
          }
        })
        .fail(function (error) {
          throw error;
        });
      }
    },
    print: {
      empty: function () {
        $('article#article').empty();
        $('nav#nav').empty();
        $('aside#aside').empty();
        $('footer#footer ~ *').remove();
      },
      module_only: function (key, data, destination) {
        $("aside#aside [data-id=" + key + "]").remove();
        $(destination).empty();
        return this.module(key, data, destination);
      },
      module: function (key, data, destination) {
        var template = this._.get.template(key);
        var $component = $("<div data-id='" + key + "'></div>").append(Mustache.render(template, data || {}));

        return function (x, y, z) {
          var attr = "";
          if (typeof x === "number") {
            attr = "left";
            if (x < 0) {
              attr = "right";
            }
            $component.css(attr, x);
          }

          if (typeof y === "number") {
            attr = "top";
            if (y < 0) {
              attr = "bottom";
            }
            $component.css(attr, y);
          }

          if (typeof z === "number") {
            $component.css("z-index", z);
          }

          $component.addClass("module");

          destination = destination || "aside#aside";
          $(destination).append($component);
          return $component;
        };
      }
    },
    init: function (parent) {
      var self = this;
      var undo = this.undo;
      var redo = this.redo;
      keyboardJS.on('ctrl > z', function (e) {
        if (!$(e.target).is('textarea') &&
          !$(e.target).is('input')) {
          undo.call(self);
          e.preventDefault();
        }
      });
      keyboardJS.on('ctrl > y', function (e) {
        if (!$(e.target).is('textarea') &&
          !$(e.target).is('input')) {
          redo.call(self);
          e.preventDefault();
        }
      });

      parent = parent || this;
      for (var key in parent) {
        if (typeof key === "object") {
          this.init(parent[key]);
          continue;
        }

        parent[key]._ = this;
        parent[key].parent = parent;
      }

      delete this.init;
      return this;
    }
  }.init();
};
