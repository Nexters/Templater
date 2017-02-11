$(function () {
    var _ = new Templater();

    $("img").on("error", function () {
        var defaultSrc = $(this).data("default");
        if (defaultSrc) $(this).attr("src", defaultSrc);
        else $(this).remove();
    });

    $("#js_header_profile").on("click", function () {
        var offset = $(this).offset();
        var height = $(this).height();
        var x = offset.left, y = offset.top;

        _.load.module({
            key: this.id,
            url: "./templates/header/profile.mustache",
            callback: function () {
                _.print.module_only(this.key, {
                    name: "Solecita",
                    email: "aboveall7035@gmail.com"
                })(x + 15,y + height + 15).addClass("pinned");
            }
        })
    })
});
