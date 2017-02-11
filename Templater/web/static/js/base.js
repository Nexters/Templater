/**
 * Created by molmo on 2017-02-06.
 */
$(function () {
    $(document).on("click", "#js_header_profile", function () {
        if(!modules.profile) {
            $.get("../../templates/header/profile.mustache", function (profile) {
                modules.profile = $(profile);
            });
        }
    });
});
