function takeTestModal() {
    removeModal();
    var newdiv = document.createElement("div");
            newdiv.setAttribute("class", "modal fade");
            newdiv.setAttribute("id", "takeTestModal");
            newdiv.setAttribute("tabindex", "-1");
            newdiv.setAttribute("role", "modal");
            newdiv.setAttribute("aria-labelledby", "exampleModalLabel");
            newdiv.setAttribute("aria-hidden", "true");
            newdiv.setAttribute("data-backdrop", "static");
            newdiv.innerHTML = '<div class="modal-dialog modal-dialog-centered" role="document">' + ' <div class="modal-content"><div class="modal-header border-bottom-0">\n\
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">\n\
                    <span aria-hidden="true">&times;</span>\n\
                  </button>\n\
                </div>\n\
                <div class="modal-body">\n\
                    <div class="form-title text-center">\n\
                        <h4>Select Exam</h4>\n\
                    </div>\n\
                    <div class="d-flex flex-column text-center">\n\
                        <form>\n\
                            <div class="form-group">\n\
                                <select id="examidoptions" class="form-select"></select>\n\
                            </div>\n\
                            <button type="button" class="btn btn-info btn-block btn-round" onclick="takeTest()">Confirm</button>\n\
                        </form>\n\
                    </div>\n\
                </div>\n\
            </div>';
            var newchild = $('body')[0];
            newchild.appendChild(newdiv);
            getAllExamIds();
             $('#takeTestModal').modal('toggle');
             $('[data-toggle="tooltip"]').tooltip();
             $("#takeTestModal").on('hidden.bs.modal',removeModal);
        }           
function getAllExamIds()
{
    var datad1=
            {
        examid:"getexamids"
            };
            console.log(JSON.stringify(datad1));
            var xhr=$.post("StudentControllerServlet",datad1,processAllExamIdResponse);
            xhr.fail(function(xhr){
                            swal("Error !","problem in server communication "+xhr.statusText,"error");   
                            window.location.reload(true);
                            });
}
function processAllExamIdResponse(responseText,responseStatus,xhr)
{
                var obj=JSON.parse(responseText);
                var examids=obj.examid;
                $("#examidoptions").empty();
                $("#examidoptions").append(examids);
}


function takeTest()
{
    if($("#examidoptions option:selected").val()==="")
    {
        var x=$("#examidoptions option");
        if(x.length===1)
        {
            swal("Completed","No Exam Left ","info");
            return;
        }
        swal("error","Please select exam......","error");
        return;
    }
    var data=
            {
                examid:$("#examidoptions option:selected").val()
            };
     console.log(JSON.stringify(data));
     var xhr=$.post("StudentControllerServlet",data,processExamIdResponse);
     xhr.fail(function(){
    swal("Error !","problem in server communication editQuestionsHandleError","error");
    window.location.reload(true);
    });
}
var questionsarr;
function processExamIdResponse(responseText,responseStatus,xhr)
{
    questionsarr=JSON.parse(responseText);
    totalQuestions=questionsarr.length;
      removeModal();
            var newdiv = document.createElement("div");
            newdiv.setAttribute("class", "modal fade");
            newdiv.setAttribute("id", "showQuestionsModal");
            newdiv.setAttribute("tabindex", "-1");
            newdiv.setAttribute("role", "dialog");
            newdiv.setAttribute("aria-labelledby", "exampleModalLabel");
            newdiv.setAttribute("aria-hidden", "true");
            newdiv.setAttribute("data-backdrop", "static");
            newdiv.innerHTML = '<div class="modal-dialog modal-dialog-centered" role="document" id="question-modal-dialog" style="max-width:90%">' +
                '<div class="modal-content container" id="question-modal-content">' +
                '<div class="modal-header border-bottom-0 row">' +
                '<h5 class="col-sm-4">Exam ID:-' + questionsarr[0].examid + '</h5>' +
                '<h5 class="text-center col-sm-7">Subject:'+questionsarr[0].subject+'</h5>' +
                '</div>' +
                '<div class="modal-body">' +
                '</div><button type="button" class="btn-info rounded-circle" onclick="submitPaper()">Submit</button>' +
                '</div></div>';
        var newdiv3 = document.createElement("div");
            newdiv3.setAttribute("class", "container pre-scrollable");
            newdiv3.innerHTML = null;
            
            for (var l = 1; l <= questionsarr.length; l++) {
                newdiv3.innerHTML = newdiv3.innerHTML +
                    '<div class="row">' +
                    '<div class="col-sm-12"><label for="Q' + l + '" value=' + l + '>Q No:-' + l + '</label><textarea class="col-sm-12 ml-auto" rows="4" cols="100" value="" required id="Q' + l + '" style="resize: none;" readonly>'+questionsarr[l-1].question+'</textarea></div>' +
                    '<div class="col-sm-6"><label data-toggle="tooltip" title="check for your answer">OPTION1&nbsp;<input type="radio" name="Q' + l + '" value="OPTION1"></label><textarea class="col-sm-12 ml-auto" row="2" cols="50" value="" id="O1' + l + '" required style="resize: none;" readonly>'+questionsarr[l-1].option1+'</textarea></div>' +
                    '<div class="col-sm-6"><label data-toggle="tooltip" title="check for your answer">OPTION2&nbsp;<input type="radio" name="Q' + l + '" value="OPTION2"></label><textarea class="col-sm-12 ml-auto" row="2" cols="50" value="" id="O2' + l + '" required style="resize: none;" readonly>'+questionsarr[l-1].option2+'</textarea></div>' +
                    '<div class="col-sm-6"><label data-toggle="tooltip" title="check for your answer">OPTION3&nbsp;<input type="radio" name="Q' + l + '" value="OPTION3"></label><textarea class="col-sm-12 ml-auto" row="2" cols="50" value="" id="O3' + l + '" required style="resize: none;" readonly>'+questionsarr[l-1].option3+'</textarea></div>' +
                    '<div class="col-sm-6"><label data-toggle="tooltip" title="check for your answer">OPTION4&nbsp;<input type="radio" name="Q' + l + '" value="OPTION4"></label><textarea class="col-sm-12 ml-auto" row="2" cols="50" value="" id="O4' + l + '" required style="resize: none;" readonly>'+questionsarr[l-1].option4+'</textarea></div>\n\
                  </div><br><br><br>\n\
            ';
            }
            var newchild = $('body')[0];
            newchild.appendChild(newdiv);
             var qchildl = $(".modal-body")[0];
            qchildl.appendChild(newdiv3);
            $('#showQuestionsModal').modal('toggle');
             $('[data-toggle="tooltip"]').tooltip();
            $("#editQuestionsModal").on('hidden.bs.modal', removeModal);
}


function submitPaper()
{
    var choosenOptions=[];
    for(var i=0;i<questionsarr.length;i++)
            {
                var x = $("input[name='Q" + (i + 1) + "']:checked").val();
                if(x===undefined)
                {
                    choosenOptions.push("");
                }
                else
                {
                    choosenOptions.push(x);
                }
                console.log("selected option of qno"+(i+1)+" is "+x);
            }
     var response=
             {
                qexamid:questionsarr[0].examid,
                subject:questionsarr[0].subject,
                choosenoptions:JSON.stringify(choosenOptions)
             };
       var xhr=$.post("StudentControllerServlet",response,processResponse);
       xhr.fail(function(xhr){
                swal("Error ","Connection problem  "+xhr.statusText,"error");
                window.location.reload(true);
            });
}
function processResponse(responseText,responseStatus,xhr)
{
 var str=responseText.trim();
 if(str==="success")
 {
     swal("Success","Paper successfully submited........","success");
     setTimeout(function(){
         window.location.reload(true);
     },3000);
 }
 else
 {
     swal("Error","Paper not Submited .....\nTry Again","error");
 }
}



function changePasswordModal()
{
     removeModal();
     var newdiv = document.createElement("div");
            newdiv.setAttribute("class", "modal fade");
            newdiv.setAttribute("id", "changePasswordModal");
            newdiv.setAttribute("tabindex", "-1");
            newdiv.setAttribute("role", "dialog");
            newdiv.setAttribute("aria-labelledby", "exampleModalLabel");
            newdiv.setAttribute("aria-hidden", "true");
            newdiv.innerHTML='<div class="modal-dialog modal-dialog-centered" role="document">\n\
            <div class="modal-content">\n\
                <div class="modal-header border-bottom-0">\n\
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">\n\
                    <span aria-hidden="true">&times;</span>\n\
                  </button>\n\
                </div>\n\
                <div class="modal-body">\n\
                    <div class="form-title text-center">\n\
                        <h4>Register User</h4>\n\
                    </div>\n\
                    <div class="d-flex flex-column text-center">\n\
                        <form>\n\
                            <div class="form-group">\n\
                                <input type="password" class="form-control check" id="currentpassword" placeholder="Enter Current Password..." maxlength="12"><span id="currentpwderror"></span>\n\
                            </div>\n\
                            <div class="form-group">\n\
                                <input type="password" class="form-control check" id="newpassword" placeholder="Enter new password...." maxlength="15">\n\
                            </div>\n\
                            <div class="form-group">\n\
                                <input type="password" class="form-control check" id="cpassword" placeholder="Confirm password...." maxlength="15"><span id="notmatched"></span>\n\
                            </div>\n\
                            <label for="mychk"><input type="checkbox" id="mychk" onclick="showPassword()">Show Password</label>\n\
                           <button type="button" class="btn btn-info btn-block btn-round" onclick="changePassword()">Change Password</button>\n\
                        </form>\n\
                    </div>\n\
                </div>\n\
            </div>\n\
        </div>';
     var newchild = $('body')[0];
     newchild.appendChild(newdiv);
                $('#changePasswordModal').modal('toggle');
                $('[data-toggle="tooltip"]').tooltip();
                $("#changePasswordModal").on('hidden.bs.modal',removeModal);
}

function changePassword()
{
    if(!validate())
    {
        console.log("validation "+validate());
        return;
    }
    var data=
            {
                currentpassword:$("#currentpassword").val(),
                newpassword:$("#newpassword").val()
            };
            console.log("password change "+JSON.stringify(data));
            var xhr=$.post("UserControllerServlet",data,processChangePassword);
            xhr.fail(function(xhr){
                swal("Error ","Connection problem for change password  "+xhr.statusText,"error");
            });
}
function processChangePassword(responseText,responseStatus,xhr)
{
    var str=responseText.trim();
    console.log("response is "+str);
    if(str==='currentpassworderror')
    {
        $("#currentpassword").css("border-color","red");
        $("#currentpwderror").text("password not matched !!");
        $("#cpassword").css("border-color","initial");
        $("#notmatched").text("");
        return false;
    }
    if(str==='success')
    {
        swal("success","password changed \nredirecting to home page to relogging","success");
        setTimeout(logout,3000);
    }
    else
    {
     swal("Error","password not changed \nRetry","error");   
    }
}
function validate()
{
    var currentpassword=$("#currentpassword").val();
    var newpassword=$("#newpassword").val();
    var cpassword=$("#cpassword").val();
    if(currentpassword===""||newpassword===""||cpassword==="")
    {
        swal("Info...","password filed should not be blank ....","info");
        return false;
    }
    if(newpassword!==cpassword)
    {
        $("#cpassword").css("border-color","red");
        $("#notmatched").text("password not matched !!");
        return false;
    }
    return true;
}

function showPassword() {
$( ".check" ).each(function( index ) {
  var x=$(this).attr("type");
  if (x=== "password") {
            $(this).attr("type","text");
        } else {
            $(this).attr("type","password");
        }
    });
}

function viewScore()
{
    window.location="performance.jsp";
}

function logout()
                    {
                        var data=
                            {
                                logoutuser:"logout"
                            };
                    var xhr=$.post("LogoutControllerServlet",data,logoutProcessResponse);
                    xhr.fail(function()
                    {
                            swal("Error !","problem in server communication ","error");
                            window.location.reload(true);
                    });
                    }

function logoutProcessResponse(responseText,textStatus,xhr)
                    {
                        var str=responseText.trim();
                        if(str.indexOf("logoutsuccess")!==-1)
                            {
                                    swal("Success !","Successfully logout !!!!!!"+str,"success");
                                    setTimeout(function (){window.location='home.html';window.location.reload(true);},3000);
                                    
                            }
                        else
                                    swal("Error !","Logout Failed !!,Try Again","error");
                    }

 

function removeModal()
{
   var getDiv=$('.modal');
  getDiv.remove();
  var getDiv2=$('.modal-backdrop');
  getDiv2.remove();
}