/**
 * Created by molmo on 2017-02-06.
 */
window.Templater = function () {
    return {
        _modules: {},
        get modules() {
            return this._modules;
        },
        get: {
            template: function (key) {
                var $head = $("head");
                var module = this._.modules[key];

                if (module.script && $head.find("script." + key).length <= 0) {
                    $head.append("<script class='" + key + "'>" + module.script + "</script>");
                }
                if (module.style && $head.find("style." + key).length <= 0) {
                    $head.append("<style class='" + key + "'>" + module.style + "</style>");
                }

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
            module_only: function (key, data, destination) {
                $("aside#aside [data-id=" + key + "]").remove();
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