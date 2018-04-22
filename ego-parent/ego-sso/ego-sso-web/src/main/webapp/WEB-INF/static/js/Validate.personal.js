$.extend(validateFunction, {
    FORM_validate:function() {
        $("#usernameOrmail").jdValidate(validatePrompt.usernameOrmail, validateFunction.usernameOrmail, true);
        $("#pwd").jdValidate(validatePrompt.pwd, validateFunction.pwd, true);
        $("#pwd2").jdValidate(validatePrompt.pwd2, validateFunction.pwd2, true);
        return validateFunction.FORM_submit(["#usernameOrmail","#pwd","#pwd2"])
    }
});

//调用
setTimeout(function() {
    $("#usernameOrmail").get(0).focus();
}, 0);
$("#usernameOrmail").jdValidate(validatePrompt.usernameOrmail, validateFunction.usernameOrmail);
$("#pwd").bind("keyup",
    function() {
        validateFunction.pwdstrength();
    }).jdValidate(validatePrompt.pwd, validateFunction.pwd)
$("#pwd2").jdValidate(validatePrompt.pwd2, validateFunction.pwd2);
$("#referrer").bind("keydown",
    function() {
        $(this).css({"color":"#333333","font-size":"14px"});
    }).bind("keyup",
    function() {
        if ($(this).val() == "" || $(this).val() == "可不填") {
            $(this).css({ "color": "#999999", "font-size": "12px" });
        }
    }).bind("blur", function() {
        if ($(this).val() == "" || $(this).val() == "可不填") {
            $(this).css({"color":"#999999","font-size":"12px"}).jdValidate(validatePrompt.referrer, validateFunction.referrer, "可不填");
        }
    })
$("#viewpwd").bind("click", function() {
    if ($(this).attr("checked") == true) {
        validateFunction.showPassword("text");
        $("#o-password").addClass("pwdbg");
    } else {
        validateFunction.showPassword("password");
        $("#o-password").removeClass("pwdbg");
    }
});

$("#registsubmit").click(function() {
    var flag = validateFunction.FORM_validate();
    var contextPath = $("#contextPath").val();
    if (flag) {
        $(this).attr({"disabled":"disabled"}).attr({"value":"提交中,请稍等"});
        $.ajax({
            type: "POST",
            url: contextPath+"/users/reg",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            data: $("#formpersonal").serialize(),
            success: function(result) {
                if(200!=result.status){
                	alert(result.message);
                }else{
                	alert("成功");
                }
            }
        });
    }
});

function verc() {
    $("#JD_Verification1").click();
}

$("#authcode").bind('keyup', function(event) {
    if (event.keyCode == 13) {
        $("#registsubmit").click();
    }
});
$("#registsubmitframe").click(function() {
    var flag = validateFunction.FORM_validate();
    if (flag) {
        $(this).attr({"disabled":"disabled"}).attr({"value":"提交中,请稍等"});
        $.ajax({
            type: "POST",
            url: "/RegistService.php?rtype=personal",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            data: $("#formpersonal").serialize(),
            success: function(result) {
                if (result == 1) {
                    window.location = "/vipmanage";
                }
            }
        });
    }
});
$("#protocol").click(function() {
    if ($("#protocol").attr("checked") != true) {
        $("#registsubmitframe").attr({ "disabled": "disabled" });
    }
    else {
        $("#registsubmitframe").removeAttr("disabled");

    }
});