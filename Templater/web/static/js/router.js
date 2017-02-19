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

    return {
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
            if(documentLength < 8) {
                data.body.empty_document = new Array(8 - documentLength);
            }
            if(formLength < 8) {
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
                    )(90, 180, 2).addClass("fixed");
                }
            });
        }
    };
};