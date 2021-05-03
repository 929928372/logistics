var editPassword = function () {

    $("#password2").blur(function () {
        var tmp = $("#password1").val();
        if ($("#password2").val() != tmp) {
            $("#tip3").html("<font color=\"red\" size=\"2\">  和第一次输入不同</font>");
        } else {
            $("#tip3").html("");
        }
    });

    $("#updatePassword").modal();
}

var submitPassword = function () {
    var flag = true;
    var old = $("#oldpassword").val();
    var pass = $("#password1").val();
    var pass2 = $("#password2").val();

    var num = $("#oldpassword").val().length;
    var num1 = $("#password1").val().length;
    var num2 = $("#password2").val().length;

    if (num1 != num2 || pass != pass2) {
        flag = false;
    }
    if (flag) {
    	$.getJSON("adminServlet","action=updatePassword&newPassword="+pass,function (data) {
			console.log(data);
			alert(data.msg);
			$("#updatePassword").modal('hide');
			$("#oldpassword").val("");
			$("#password1").val("");
			$("#password2").val("");
			$("#tip3").empty();
		});

        // $.ajax({
        //     url: "adminServlet?action=updatePassword",
        //     data: {
        //         oldPassword: old,
        //         newPassword: pass
        //     },
        //     type:"POST",
        //     success: function (data) {
        //         console.log(data);
        //         alert(data);
        //         $("#updatePassword").modal('hide');
        //         $("#oldpassword").val("");
        //         $("#password1").val("");
        //         $("#password2").val("");
        //         $("#tip3").empty();
        //     },
        //     dataType:"json"
        // });
    } else {
        alert("请输入正确数据");
    }
}
// var cancel = function () {
//     $("#oldpassword").val("");
//     $("#password1").val("");
//     $("#password2").val("");
//     $("#tip3").empty();
// }
