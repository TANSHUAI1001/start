$(function(){
    $("#inputPassword").on("input",function(){
        var md51 = CryptoJS.MD5($("#inputPassword").val()).toString();
        $("#password").val(md51);
     })
    $("#inputNewPassword").on("input",function(){
        var md52 = CryptoJS.MD5($("#inputNewPassword").val()).toString();
        $("#newPassword").val(md52);
    })
    $("#inputConfirmPassword").on("input",function(){
        var md53 = CryptoJS.MD5($("#inputConfirmPassword").val()).toString();
        $("#confirmPassword").val(md53);
    })

    $("input.form-control").click(function(){
     $("input.form-control").removeClass("form-error");
    })
})

$("#resetPasswordForm").submit(function(e){
    e.preventDefault();
    console.log("reset")
    if($("#inputNewPassword").val() != $("#inputConfirmPassword").val()){
       $("#inputNewPassword").addClass("form-error");
       $("#inputConfirmPassword").addClass("form-error");
       return;
    }else{
        $.ajax({
        url:"/user/resetPassword",
        data:$("#resetPasswordForm").serialize(),
        type:"POST"
        }).then(function(response){
         console.log(response);
         if(response.code == 1){
           $("#success-msg").html(response.msg);
           $("#modal-info").modal();
           document.getElementById("resetPasswordForm").reset();
           setTimeout(function(){
             $('#modal-info').modal('hide')
           },1500);
         }else{
           $("#danger-msg").html(response.msg)
           $("#modal-danger").modal();
         }
        },function(error){
         console.log(error);
         $("#danger-msg").html(error)
         $("#modal-danger").modal();
        })
    }

})

$("#modifyUserInfoForm").submit(function(e){
    e.preventDefault();
    var previous = $("#preEmail").val().trim();
    var present = $("#inputEmail").val().trim();
    if(previous != "" &&  previous == present){
      return;
    }
    $.post("user/modify",$("#modifyUserInfoForm").serialize()).then(
    function(response){
      console.log(response);
      if(response.code == 1){
        $("#success-msg").html(response.msg);
        $("#modal-info").modal();
        setTimeout(function(){
          $('#modal-info').modal('hide')
        },1500);
      }else{
        $("#danger-msg").html(response.msg)
        $("#modal-danger").modal();
      }
     },
     function(error){
      console.log(error);
      $("#danger-msg").html(error)
      $("#modal-danger").modal();
     }
    )
})