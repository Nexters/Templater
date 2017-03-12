$(function () {
  window._ = new Templater();
  _.router = new Router(_);

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

  var params = _.get.params();
  _.router.do(params['spa']);
});
