$(function () {
  var _ = new Templater();
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

    _.load.module({
      key: this.id,
      url: "./templates/header/profile.mustache",
      callback: function () {
        _.print.module_only(this.key, {
          name: "Solecita",
          email: "aboveall7035@gmail.com"
        })(x, y).addClass("pinned");
      }
    });
  });
});
