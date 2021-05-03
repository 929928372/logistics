var checkPassword = function () {
    var password1 = $("#password1").val();
    var password2 = $("#password2").val();
    if (password2 != "") {
        if (password1 != password2) {
            $("#passwordMsg").html("<font color='red'>与第一次不同</font>");
        } else {
            $("#passwordMsg").html("");
        }
    } else {
        $("#passwordMsg").html("");
    }
}

var checkUserName = function () {
    var username = $("#username").val();
    if (username !== "") {
        $.ajax({
            url: "clientServlet",
            data: {action:"newUsernameIsOK", username:username},
            dataType: "json",
            success: function (data) {
                $("#usernameMsg").html("<font color='red'>" + data.msg + "</font>");
            }
        })
    } else {
        $("#usernameMsg").html("");
    }
}
