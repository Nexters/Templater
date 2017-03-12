window.Router = function (_, init) {
  init = init || true;

  if (!(_ && typeof Templater === "function")) {
    throw Error("템플레터 라이브러리를 먼저 로드해주세요.");
  }

  var header = {
    self: $("header#header"),
    _search: true,
    search: function (exist) {
      this._search = exist;
      if (this._search) this.self.removeClass("no-search");
      else this.self.addClass("no-search");
    }
  };

  var panic = function () {
    header.search(false);
  };

  if (init) {
    panic();
  }
  var host = $(location).attr('protocol') + '//' + $(location).attr('host');
  host = 'http://localhost:63342/Templater/Templater/web/';

  var router = {
    _table: function (url) {
      var routeTable = {
        '/': {
          title: '초기화면',
          action: this.editor
        },
        '/signup': {
          title: '회원가입',
          action: this.signup
        },
        '/login': {
          title: '로그인',
          action: this.login
        },
        '/list': {
          title: '리스트',
          action: this.list
        },
        '/edit': {
          title: '에디터',
          action: this.editor
        }
      };
      return routeTable[url];
    },
    do: function (url, data) {
      var currentPath = $(location).attr('href').replace(host, '').split('?')[0];
      url = (url || '/').replace(host, '');
      var route = this._table(url);

      _.print.empty();

      //history.pushState({back: currentPath}, route.title, host + url);
      history.pushState({back: currentPath}, route.title, host + '?spa=' + url);
      if (route.action) {
        route.action.apply(null, [data]);
      }
    },
    list: function (data) {
      data = data || {};
      switch (data.tab) {
        default:
        case "document":
          data.body = $.extend(data.body || {}, {
            tab_form: "display:none;"
          });
          break;
        case "form":
          data.body = $.extend(data.body || {}, {
            tab_document: "display:none;"
          });
          break;
      }

      var documentLength = data.body.documents ? data.body.documents.length : 0;
      var formLength = data.body.forms ? data.body.forms.length : 0;
      if (documentLength < 8) {
        data.body.empty_document = new Array(8 - documentLength);
      }
      if (formLength < 8) {
        data.body.empty_form = new Array(8 - formLength);
      }
      _.load.module({
        key: 'list-nav',
        url: "./templates/list/nav.mustache",
        callback: function () {
          _.print.module_only(
            'list-nav',
            data.nav,
            "nav#nav"
          )(0, 0);
        }
      });
      _.load.module({
        key: 'list-body',
        url: "./templates/list/index.mustache",
        callback: function () {
          _.print.module_only(
            'list-body',
            data.body,
            "article#article"
          )(0, 0);
        }
      });
    }
    ,
    editor: function (data) {
      data = data || {};
      var nav = function () {
        var dfd = $.Deferred();
        _.load.module({
          key: 'editor-nav',
          url: "./templates/editor/nav.mustache",
          callback: function () {
            _.print.module_only(
              'editor-nav',
              data.nav,
              "nav#nav"
            )(0, 0, 1);
            dfd.resolve();
          }
        });
        return dfd;
      };

      var body = function () {
        var dfd = $.Deferred();
        _.load.module({
          key: 'editor-body',
          url: "./templates/editor/index.mustache",
          callback: function () {
            _.print.module_only(
              'editor-body',
              data.body,
              "article#article"
            )(0, 0, 1);
            dfd.resolve();
          }
        });
        return dfd;
      };

      var aside = function () {
        var dfd = $.Deferred();
        _.load.module({
          key: 'editor-aside',
          url: "./templates/editor/side_editor.mustache",
          callback: function () {
            _.print.module_only(
              'editor-aside',
              data.aside
            )(30, 160, 2).addClass("pinned");
            dfd.resolve();
          }
        });
        return dfd;
      };

      var util = function () {
        _.load.module('editor-util', "./templates/editor/util.mustache", function () {
          _.print.module_only('editor-util');
        });
      };

      nav().done(function () {
        aside().done(function () {
          body().done(function () {
            util();
          });
        })
      });
    },
    login: function (data) {
      data = data || {};
      var body = function () {
        var dfd = $.Deferred();
        _.load.module({
          key: 'login-body',
          url: "./templates/user/login.mustache",
          callback: function () {
            _.print.module_only(
              'login-body',
              data.body,
              "article#article"
            )(0, 0, 1);
            dfd.resolve();
          }
        });
        return dfd;
      };
      body();
    },
    signup: function (data) {
      data = data || {};
      var body = function () {
        var dfd = $.Deferred();
        _.load.module({
          key: 'signup-body',
          url: "./templates/user/signup.mustache",
          callback: function () {
            _.print.module_only(
              'signup-body',
              data.body,
              "article#article"
            )(0, 0, 1);
            dfd.resolve();
          }
        });
        return dfd;
      };
      body();
    }
  };

  $(document).on('click', 'a.inner', function (e) {
    e.preventDefault();
    router.do($(this).attr('href'), $(this).data('param'));
  });

  return router;
};
