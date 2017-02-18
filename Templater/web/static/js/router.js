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
        header.search(true);
    };

    if (init) {
        panic();
    }

    return {
        list: function (data) {
            header.search(false);
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
        }
        ,
        editor: function (data) {
            _.load.module({
                key: 'editor-nav',
                url: "./templates/editor/nav.mustache",
                callback: function () {
                    _.print.module_only(
                        'editor-nav',
                        data.nav,
                        "nav#nav"
                    )(0, 0, 1);
                }
            });

            _.load.module({
                key: 'editor-body',
                url: "./templates/editor/index.mustache",
                callback: function () {
                    _.print.module_only(
                        'editor-body',
                        data.body,
                        "article#article"
                    )(0, 0, 1);
                }
            });

            _.load.module({
                key: 'editor-aside',
                url: "./templates/editor/side_editor.mustache",
                callback: function () {
                    _.print.module_only(
                        'editor-aside',
                        data.aside
                    )(90, 180, 2).addClass("pinned");
                }
            });
        }
    };
};