$(document).ready(function() {

    $('#age').keyup(function() {
        let age = $('#age').val();
        if (!(age <= 0 || age > 120)) {
            $('#update').attr('disabled', true);
            $('#popover-age-top').addClass('hide');
        } else {
            $('#popover-age-top').removeClass('hide');
        }
    });

});