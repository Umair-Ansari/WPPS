$(document).ready(function() {
    $('#txtmobile').blur(function(e) {
        if (validatePhone('txtmobile')) {
             $('#spnmobileStatus').html('ok');
             $('#spnmobileStatus').css('color', 'green');
        }
        else {
            $('#spnmobileStatus').html('Invalid Contact Number');
            $('#spnmobileStatus').css('color', 'red');
        }
    });
});

function validatePhone(txtmobile) {
    var a = document.getElementById(txtmobile).value;
    var filter = /^[0-9-+]+$/;
    if (filter.test(a)) {
        return true;
    }
    else {
        return false;
    }
}

