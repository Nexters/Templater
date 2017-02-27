$(function () {
    var QueryString = function () {
        // This function is anonymous, is executed immediately and
        // the return value is assigned to QueryString!
        var query_string = {};
        var query = window.location.search.substring(1);
        var vars = query.split("&");
        for (var i=0;i<vars.length;i++) {
            var pair = vars[i].split("=");
            // If first entry with this name
            if (typeof query_string[pair[0]] === "undefined") {
                query_string[pair[0]] = decodeURIComponent(pair[1]);
                // If second entry with this name
            } else if (typeof query_string[pair[0]] === "string") {
                var arr = [ query_string[pair[0]],decodeURIComponent(pair[1]) ];
                query_string[pair[0]] = arr;
                // If third or later entry with this name
            } else {
                query_string[pair[0]].push(decodeURIComponent(pair[1]));
            }
        }
        return query_string;
    }();

    window._ = new Templater();
    var route = new Router(_);

    $("img").on("error", function () {
        var defaultSrc = $(this).data("default");
        if (defaultSrc) $(this).attr("src", defaultSrc);
        else $(this).remove();
    });

    $("#js_header_profile").on("click", function () {
        var offset = $(this).offset();
        var height = $(this).height();
        var x = offset.left + 15;
        var y = offset.top + 15 + height;
        var key = this.id;

        _.load.module({
            key: key,
            url: "./templates/header/profile.mustache",
            callback: function () {
                _.print.module_only(this.key, {
                    name: "Solecita",
                    email: "aboveall7035@gmail.com"
                })(x, y, 10).addClass("pinned");

                $(document).on('click', function (e) {
                    if ($(e.target).parents(".module[data-id=" + key + "]").length <= 0) {
                        $(".module[data-id=" + key + "]").remove();
                    }
                });
            }
        });
    });

    switch(QueryString['page']) {
        case "editor":
            route.editor({
                nav: {
                    title: "Untitled Documents"
                }
            });
            break;
        case "list":
            route.list();
            break;
        case "signup":
            route.signup();
            break;
        case "login":
            route.login();
            break;
    }

});
