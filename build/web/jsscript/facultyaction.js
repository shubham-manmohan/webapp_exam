var userid,password,cpassword,usertype;
var data1;
var data2;
function registerUser()
{
    userid=$("#userid").val();
    password=$("#password").val();
    cpassword=$("#cpassword").val();
    usertype=$("#usertype").val();
    if(registervalidate()===false)
    {
        swal("error","All fields are mendatory  .......","error");
        return;
    }
    if(password!==cpassword)
    {
                swal("Error","Password do not matched  ...","error");
                return;
    }
    var data=
            {
               userid:userid,
               password:password,
               usertype:usertype
            };
     var xhr=$.post("RegistrationControllerServlet",data,registerProcessResponse);
     xhr.fail(function(xhr){
                swal("Error !","problem in server communication "+xhr.statusText,"error");
            });
}

function registerProcessResponse(responseText,textStatus,xhr)
{
    var str=responseText.trim();
    if(str.indexOf("success")!==-1)
    {
        swal("Success !","Registration done Successfully  !!!!!!","success");
        removeContent();
//        setTimeout(redirectUser,3000);
    }
    else if(str==='uap')
    {
        swal("Error !","Sorry ! user id is already present !!","error");
        removeContent();
    }
    else
    {
        swal("Error !","Registration Failure !! Try Again","error");
        removeContent();
    }
}
function removeContent()
{
    $("#userid").val("");
    $("#password").val("");
    $("#cpassword").val("");
    $("#usertype").val("");
}



function registervalidate()
{
    if(userid===""||password===""||cpassword===""||usertype==="")
    {
        return false;
    }
    return true;
}

function logout()
         {
                        var data=
                            {
                                logoutuser:"logout"
                            };
                    var xhr=$.post("LogoutControllerServlet",data,logoutProcessResponse);
                    xhr.fail(function(){
                            swal("Error !","problem in server communication ","error");
                    });
         }

        function logoutProcessResponse(responseText,textStatus,xhr)
                    {
                        var str=responseText.trim();
                        if(str.indexOf("logoutsuccess")!==-1)
                            {
                                    swal("Success !","Successfully logout !!!!!!"+str,"success");
                                    setTimeout(function (){window.location='home.html';},3000);
                            }
                        else
                                    swal("Error !","Logout Failed !!,Try Again","error");
                    }

        

function removeUser()
{
    var uid=$("#removeuserid").val();
    var data=
            {
                removeuserid:uid
            };
            var xhr=$.post("RemoveUserControllerServlet",data,removeUserProcessResponse);
            xhr.fail(function(){
                            swal("Error !","problem in server communication ","error");
                    });
}
function removeUserProcessResponse(responseText,textStatus,xhr)
{
    var str=responseText.trim();
    if(str.indexOf("usernotfound")!==-1)
    {
        swal("Error","Sorry! User not registered yet...","error");
    }
    else if(str.indexOf("success")!==-1)
    {
        swal("success","User removed successfully !!","success");
         var uid=$("#removeuserid").val("");
    }
    else if(str.indexOf("youremoved")!==-1)
    {
        swal("Success","You Removed Yourself...","success");
        setTimeout((function(){window.location="home.html";}),3000);
    }
    else
    {
         swal("Error","You Are Logged Out ...\nredirecting to login page","error");
        setTimeout((function(){window.location="home.html";}),3000);
    }
}

                    
      

function setPaper() {
            data1 = {
                subject:$("#subject option:selected").val(),
                totalquestions:$("#totalquestions").val(),
                marks:$("#marks").val()
            };
            data2 = {
                examid:$("#examid").val(),
                subject:$("#subject option:selected").val(),
                totalquestions:$("#totalquestions").val(),
                marks:$("#marks").val()
            };
            if(data1.totalquestions>100 || data1.marks>99||data1.totalquestions<1 || data1.marks<1)
            {
                swal("error","invalid input fields for total number of questions or marks per question","error");
                return;
            }   
            console.log("data1:" + JSON.stringify(data1) + "\ndata2:" + JSON.stringify(data2));
            removeModal();
            setQuestionsModal(data2);
        }

function setQuestionsModal(y) {
            // console.log(x, y);
            removeModal();
            var newdiv = document.createElement("div");
            newdiv.setAttribute("class", "modal fade");
            newdiv.setAttribute("id", "setQuestionsModal");
            newdiv.setAttribute("tabindex", "-1");
            newdiv.setAttribute("role", "dialog");
            newdiv.setAttribute("aria-labelledby", "exampleModalLabel");
            newdiv.setAttribute("aria-hidden", "true");
            newdiv.setAttribute("data-backdrop", "static");
            newdiv.innerHTML = '<div class="modal-dialog modal-dialog-centered" role="document" id="question-modal-dialog" style="max-width:90%">' +
                '<div class="modal-content container" id="question-modal-content">' +
                '<div class="modal-header border-bottom-0 row">' +
                '<h6 class="col-sm-4">Exam ID:-' + y.examid + '</h6>' +
                '<h5 class="text-center col-sm-7">Set Questions for '+y.subject+'</h5>' +
                '<button class="border-white btn-danger col-sm-1" type="button" data-dismiss="modal" aria-label="Close" data-toggle="tooltip" title="cancel operation">' +
                '<span aria-hidden="true">&times;</span>' +
                '</button></div>' +
                '<div class="modal-body">' +
                '</div><button type="button" class="btn-info rounded-circle" onclick="setQuestionPaper()">Submit</button>' +
                '</div></div>';
            var newchild = $('body')[0];
            newchild.appendChild(newdiv);
            setQuestionsPanel(y.totalquestions);
            $('#setQuestionsModal').modal('toggle');
            $('[data-toggle="tooltip"]').tooltip();
            $("#setQuestionsModal").on('hidden.bs.modal', removeModal);

        }


 function setQuestionsPanel(a) {
            // alert(a + "," + b);
            var i;
            var qchild = $(".modal-body")[0];
            var newdiv2 = document.createElement("div");
            newdiv2.setAttribute("class", "container pre-scrollable");
            newdiv2.innerHTML = null;
            for (i = 1; i <= a; i++) {
                newdiv2.innerHTML = newdiv2.innerHTML +
                    '<div class="row">' +
                    '<div class="col-sm-12"><label for="Q' + i + '" value=' + i + '>Q No:-' + i + '</label><textarea class="col-sm-12 ml-auto" rows="4" cols="100" value="" required id="Q' + i + '"></textarea></div>' +
                    '<div class="col-sm-6"><label data-toggle="tooltip" title="check for correct option">OPTION1&nbsp;<input type="radio" name="Q' + i + '" value="OPTION1" checked></label><textarea class="col-sm-12 ml-auto" row="2" cols="50" value="" id="O1' + i + '" required></textarea></div>' +
                    '<div class="col-sm-6"><label data-toggle="tooltip" title="check for correct option">OPTION2&nbsp;<input type="radio" name="Q' + i + '" value="OPTION2"></label><textarea class="col-sm-12 ml-auto" row="2" cols="50" value="" id="O2' + i + '" required></textarea></div>' +
                    '<div class="col-sm-6"><label data-toggle="tooltip" title="check for correct option">OPTION3&nbsp;<input type="radio" name="Q' + i + '" value="OPTION3"></label><textarea class="col-sm-12 ml-auto" row="2" cols="50" value="" id="O3' + i + '" required></textarea></div>' +
                    '<div class="col-sm-6"><label data-toggle="tooltip" title="check for correct option">OPTION4&nbsp;<input type="radio" name="Q' + i + '" value="OPTION4"></label><textarea class="col-sm-12 ml-auto" row="2" cols="50" value="" id="O4' + i + '" required></textarea></div>\n\
                  </div><br><br><br>\n\
            ';
            }
            qchild.appendChild(newdiv2);
            $('#setQuestionsM').modal('toggle');
            $('[data-toggle="tooltip"]').tooltip();
        }

function setQuestionPaper() {
            // console.log(data1, data2);
            var result = validateAllTextFields();
            // console.log(result);
            if (result === "failed") {
                swal("Error", "Please fill all fields . . ...", "error");
                return;
            }
        var xhr=$.post("QuestionsControllerServlet",data1,processSetPaperResponse);
        xhr.fail(function(xhr){
        swal("Error !","problem in server communication setPaper "+xhr.statusText,"error");
        });
        }
function processSetPaperResponse(responseText,responseStatus,xhr)
{
    var strg=responseText.trim();
    console.log("fffgdggsgsgsdfgsdfg"+strg);
    if(strg.indexOf("success")!==-1)
    {
//        swal("Success","Exam set of paper "+data2.subject,"success").then(setAllQuestionsInJSON(data1, data2));
        swal("Success","Exam set of paper "+data2.subject,"success");
        console.log("data1dasdsa:" + JSON.stringify(data1) + "\ndata2fasdfaf:" + JSON.stringify(data2));
        setAllQuestionsInJSON(data1, data2);
    }
    else
    {
        swal("Error","Sorry Paper cannot be set successfully.....","error");
    }
}



function validateAllTextFields() {
            var j = "success";
            var alltextarea = document.querySelectorAll("textarea");
            alltextarea = Array.from(alltextarea);
            alltextarea.forEach(function(e) {
                if (e.value.trim() === "")
                    j = "failed";
            });
            return j;
        }

function setAllQuestionsInJSON(data1, data2) {
            console.log("jsonfafasfafs1:" + JSON.stringify(data1) + "\njsonnafnafnkjn2:" + JSON.stringify(data2));
            var questionsObject =[];
            var l;
            for (l = 1; l <= data2.totalquestions; l++) {
                var questionobj = {
                        examid: data2.examid,
                        subjectid: data2.subject,
                        qno: l,
                        question: $("#Q" + l).val(),
                        option1: $("#O1" + l).val(),
                        option2: $("#O2" + l).val(),
                        option3: $("#O3" + l).val(),
                        option4: $("#O4" + l).val(),
                        correctoption: document.querySelector('input[name="Q' + l + '"]:checked').value,
                        marks: data2.marks
                    };
                    // console.log("Question details:" + l + "" + JSON.stringify(questionobj));
                questionsObject.push(questionobj);
            }
//            questionsObjects=JSON.stringify(questionsObject);
            console.log(JSON.stringify(questionsObject));
            var alldata=
                    {
                        allquestionsdata:JSON.stringify(questionsObject)
                    };
        var xhr=$.post("QuestionsControllerServlet",alldata,processSetQuestionsResponse);
        xhr.fail(function(){
                        swal("Error !","problem in server communication setQuestions","error");
                        });
        }
function processSetQuestionsResponse(responseText,responseStatus,xhr)
{
    var strg=responseText.trim();
    if(strg.indexOf("success")!==-1)
    {
        swal("Success","Questions set of paper "+data2.subject,"success").then(removeModal());
    }
    else
    {
        swal("Error","Sorry Questions cannot be set successfully.....","error");
    }
}




function editQuestions()
{
  var eqdata=
          {
              selectedexamid:$("#examidoptions option:selected").val()
           };
           console.log("this is select exam id to edit paper="+JSON.stringify(eqdata));
           var xhr=$.post("EditQuestionsControllerServlet",eqdata,processEditQuestionsResponse);
           xhr.fail(function(){
                    swal("Error !","problem in server communication editQuestionsHandleError","error");
                    });
}

var editquestionarr;

function processEditQuestionsResponse(responseText,responseStatus,xhr)
{
    editquestionarr=JSON.parse(responseText);
      removeModal();
            var newdiv = document.createElement("div");
            newdiv.setAttribute("class", "modal fade");
            newdiv.setAttribute("id", "editQuestionsModal");
            newdiv.setAttribute("tabindex", "-1");
            newdiv.setAttribute("role", "dialog");
            newdiv.setAttribute("aria-labelledby", "exampleModalLabel");
            newdiv.setAttribute("aria-hidden", "true");
            newdiv.setAttribute("data-backdrop", "static");
            newdiv.innerHTML = '<div class="modal-dialog modal-dialog-centered" role="document" id="question-modal-dialog" style="max-width:90%">' +
                '<div class="modal-content container" id="question-modal-content">' +
                '<div class="modal-header border-bottom-0 row">' +
                '<h6 class="col-sm-4">Exam ID:-' + editquestionarr[0].examid + '</h6>' +
                '<h5 class="text-center col-sm-7">Editing Questions of '+editquestionarr[0].subject+'</h5>' +
                '</div>' +
                '<div class="modal-body">' +
                '</div><button type="button" class="btn-info rounded-circle" onclick="updateQuestionPaper()">Update</button>' +
                '</div></div>';
           
//    console.log("this is from editQuestions javascript file===="+JSON.stringify(editquestionarr));
            var newdiv3 = document.createElement("div");
            newdiv3.setAttribute("class", "container pre-scrollable");
            newdiv3.innerHTML = null;
            var correctOptionArr=[];
            for (var l = 1; l <= editquestionarr.length; l++) {
                newdiv3.innerHTML = newdiv3.innerHTML +
                    '<div class="row">' +
                    '<div class="col-sm-12"><label for="Q' + l + '" value=' + l + '>Q No:-' + l + '</label><textarea class="col-sm-12 ml-auto" rows="4" cols="100" value="" required id="Q' + l + '">'+editquestionarr[l-1].question+'</textarea></div>' +
                    '<div class="col-sm-6"><label data-toggle="tooltip" title="check for correct option">OPTION1&nbsp;<input type="radio" name="Q' + l + '" value="OPTION1"></label><textarea class="col-sm-12 ml-auto" row="2" cols="50" value="" id="O1' + l + '" required>'+editquestionarr[l-1].option1+'</textarea></div>' +
                    '<div class="col-sm-6"><label data-toggle="tooltip" title="check for correct option">OPTION2&nbsp;<input type="radio" name="Q' + l + '" value="OPTION2"></label><textarea class="col-sm-12 ml-auto" row="2" cols="50" value="" id="O2' + l + '" required>'+editquestionarr[l-1].option2+'</textarea></div>' +
                    '<div class="col-sm-6"><label data-toggle="tooltip" title="check for correct option">OPTION3&nbsp;<input type="radio" name="Q' + l + '" value="OPTION3"></label><textarea class="col-sm-12 ml-auto" row="2" cols="50" value="" id="O3' + l + '" required>'+editquestionarr[l-1].option3+'</textarea></div>' +
                    '<div class="col-sm-6"><label data-toggle="tooltip" title="check for correct option">OPTION4&nbsp;<input type="radio" name="Q' + l + '" value="OPTION4"></label><textarea class="col-sm-12 ml-auto" row="2" cols="50" value="" id="O4' + l + '" required>'+editquestionarr[l-1].option4+'</textarea></div>\n\
                  </div><br><br><br>\n\
            ';
            correctOptionArr.push(editquestionarr[l-1].correctoption);
            }
             var newchild = $('body')[0];
            newchild.appendChild(newdiv);
             var qchildl = $(".modal-body")[0];
            qchildl.appendChild(newdiv3);
            $('#editQuestionsModal').modal('toggle');
             $('[data-toggle="tooltip"]').tooltip();
            $("#editQuestionsModal").on('hidden.bs.modal', removeModal);
            for(var i=0;i<correctOptionArr.length;i++)
            {
            console.log('input[name="Q'+(i+1)+'"][value="'+correctOptionArr[i]+'"]');
            $('input[name="Q'+(i+1)+'"][value="'+correctOptionArr[i]+'"]').attr("checked",true);;
            }
}



function updateQuestionPaper() {
//            console.log("jsonfafasfafs1:" + JSON.stringify(editquestionarr));
            var updatedQuestionsObject =[];
            var i;
            for (i = 0; i < editquestionarr.length; i++) {
        (editquestionarr[i].qno);
        (editquestionarr[i].question=$("#Q"+(i+1)).val());
        (editquestionarr[i].option1=$("#O1" +(i+1)).val());
        (editquestionarr[i].option2=$("#O2" +(i+1)).val());
        (editquestionarr[i].option3=$("#O3" +(i+1)).val());
        (editquestionarr[i].option4=$("#O4" +(i+1)).val());
        (editquestionarr[i].correctoption=document.querySelector('input[name="Q' + (i+1) + '"]:checked').value);
        (editquestionarr[i].examid);
        (editquestionarr[i].subject);
        (editquestionarr[i].sno);
        (editquestionarr[i].marks);  
                    // console.log("Question details:" + l + "" + JSON.stringify(questionobj));
                updatedQuestionsObject.push(editquestionarr[i]);
            }
            var alldata=
                    {
                        allquestionsdata:JSON.stringify(updatedQuestionsObject)
                    };
                console.log(JSON.stringify(alldata));
//            var questiondata=
//                    {
//                    questions:questionsObject   
//                    };
                var xhr=$.post("EditQuestionsControllerServlet",alldata,processEditQuestionsResponse2);
                xhr.fail(function(xhr){
                            swal("error","Problem in server "+xhr.statusText,"error");
                        });
        }
function processEditQuestionsResponse2(responseText,responseStatus,xhr)
{
    var returnText=responseText.trim();
    if(returnText.indexOf("success")!==-1)
    {
        swal("Success","Paper successfully updated !!!!","success");
        setTimeout(function(){
            window.location="facultyoptions.jsp";
        },3000);
    }
    else
    {
        swal("Error","Failed  !!!!!!!","error");
         setTimeout(function(){
            window.location="facultyoptions.jsp";
        },3000);
    }
}

function removeModal() {
            $('.modal').remove();
            $('.modal-backdrop').remove();
            $('.swal-overlay').remove();
        }