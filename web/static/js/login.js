/* 检查填写信息是否为空 */
function checkNotNull(nid) {
	var nodex = document.getElementById(nid);
	var msg = document.getElementById(nid + "Msg");
	var id = document.getElementById(nid + "ID");
	var reg = /^\s*$/;
	if (reg.test(nodex.value)) {
		msg.innerHTML = "不能为空";
		id.className += " has-error";
		return false;
	} else {
		msg.innerHTML = "";
		id.className = "form-group";
		return true;
	}
}

/* 检查表单信息 */
function checkForm() {
	var flag1 = checkNotNull("username");
	var flag2 = checkNotNull("password");
	return flag1 && flag2;
}
