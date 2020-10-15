function validEmail(email) {
  var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(email);
}

function validateEmail() {

	var $email = $("#reg_email");
	var $error_text = $("#error_email")
	if ($email.val() == ""){
		fieldRequired($email, $error_text)
	}else if (validEmail($email.val())) {
		ok($email, $error_text)
	} else {
		error($email, $error_text, "Este email no es valido.")
	}
	return false;
}

function validatePassword() {
	var $pss = $("#reg_password");
	var $error_text = $("#error_password");
	if ($pss.val() == ""){
		fieldRequired($pss, $error_text);
	}else if ($pss.val().length < 8){
		error($pss, $error_text, "La contraseña debe tener un minimo de 8 caracteres.");
	}else{
		ok($pss, $error_text);

	}
	return validateConfPassword();
}

function validateConfPassword() {
	var $pss = $("#reg_password");
	var $pssConf = $("#reg_password_confirm");
	var $error_text = $("#error_password_confirm");
	if ($pss.val() != ""){
		if ($pss.val() == $pssConf.val()){
			ok($pssConf, $error_text);
		}else{
			error($pssConf, $error_text, "La contraseña no coincide.")
		}
	}
	return false;
}

function validateName() {
	var $name = $("#reg_fullname");
	var $error_text = $("#error_fullname");
	if ($name.val() == ""){
		fieldRequired($name, $error_text);
	}else{
		ok($name, $error_text);
	}
}
function validateUserName() {
	var $name = $("#lg_username");
	var $error_text = $("#error_username");
	if ($name.val() == ""){
		fieldRequired($name, $error_text);
	}else{
		ok($name, $error_text);
	}
}
function validateLgPassword() {
	var $name = $("#lg_password");
	var $error_text = $("#error_password");
	if ($name.val() == ""){
		fieldRequired($name, $error_text);
	}else{
		ok($name, $error_text);
	}
}

function fieldRequired(field, error_field) {
	error(field, error_field, "Este campo es obligatorio.");
}

function error(field, error_field, msg) {
	error_field.text(msg);
	error_field.css("color", "red");
	field.css("border-color", "red");
}
function ok(field, error_field) {
	error_field.text("");
	field.css("border-color", "green");
}