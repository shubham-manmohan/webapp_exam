 function registerUserModal(){
     removeModal();
 var newdiv = document.createElement("div");
            newdiv.setAttribute("class", "modal fade");
            newdiv.setAttribute("id", "registerUserModal");
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
                                <input type="text" class="form-control" id="userid" placeholder="Enter user id..." maxlength="12">\n\
                            </div>\n\
                            <div class="form-group">\n\
                                <input type="password" class="form-control" id="password" placeholder="Enter password...." maxlength="15">\n\
                            </div>\n\
                            <div class="form-group">\n\
                                <input type="password" class="form-control" id="cpassword" placeholder="Confirm password...." maxlength="15">\n\
                            </div>\n\
                            <div class="form-group">\n\
                               <label for="usertype">Select User Type:</label>\n\
                                    <select id="usertype">\n\
                                    <option value="student">student</option>\n\\n\
                                    <option value="faculty">faculty</option>\n\
                                    </select>\n\
                            </div>\n\
                            <button type="button" class="btn btn-info btn-block btn-round" onclick="registerUser()">Register</button>\n\
                        </form>\n\
                    </div>\n\
                </div>\n\
            </div>\n\
        </div>';
     var newchild = $('body')[0];
            newchild.appendChild(newdiv);
            $('#registerUserModal').modal('toggle');
            $('[data-toggle="tooltip"]').tooltip();
            $("#registerUserModal").on('hidden.bs.modal',removeModal);
        }


           
function removeUserModal() {
    removeModal(); 
    var newdiv = document.createElement("div");
            newdiv.setAttribute("class", "modal fade");
            newdiv.setAttribute("id", "removeUserModal");
            newdiv.setAttribute("tabindex", "-1");
            newdiv.setAttribute("role", "modal");
            newdiv.setAttribute("aria-labelledby", "exampleModalLabel");
            newdiv.setAttribute("aria-hidden", "true");
            newdiv.innerHTML = '<div class="modal-dialog modal-dialog-centered" role="document">' + ' <div class="modal-content"><div class="modal-header border-bottom-0">\n\
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">\n\
                    <span aria-hidden="true">&times;</span>\n\
                  </button>\n\
                </div>\n\
                <div class="modal-body">\n\
                    <div class="form-title text-center">\n\
                        <h4>Remove User</h4>\n\
                    </div>\n\
                    <div class="d-flex flex-column text-center">\n\
                        <form>\n\
                            <div class="form-group">\n\
                                <input type="text" class="form-control" id="removeuserid" placeholder="Enter user id..." maxlength="12">\n\
                            </div>\n\
                            <button type="button" class="btn btn-info btn-block btn-round" onclick="removeUser()">Remove User</button>\n\
                        </form>\n\
                    </div>\n\
                </div>\n\
            </div>';
            var newchild = $('body')[0];
            newchild.appendChild(newdiv);
             $('#removeUserModal').modal('toggle',removeModal);
            $('[data-toggle="tooltip"]').tooltip();
            $("#removeUserModal").on('hidden.bs.modal',removeModal);
        }
        
function setPaperModal() {
    removeModal();
    var newdiv = document.createElement("div");
            newdiv.setAttribute("class", "modal fade");
            newdiv.setAttribute("id", "setPaperModal");
            newdiv.setAttribute("tabindex", "-1");
            newdiv.setAttribute("role", "dialog");
            newdiv.setAttribute("aria-labelledby", "exampleModalLabel");
            newdiv.setAttribute("aria-hidden", "true");
            newdiv.setAttribute("data-backdrop", "static");
            newdiv.innerHTML = '<div class="modal-dialog modal-dialog-centered" role="document">\n\
            <div class="modal-content">\n\
                <div class="modal-header border-bottom-0">\n\
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">\n\
                    <span aria-hidden="true">&times;</span>\n\
                  </button>\n\
                </div>\n\
                <div class="modal-body">\n\
                    <div class="form-title text-center">\n\
                        <h4>Set Paper</h4>\n\
                    </div>\n\
                    <div class="d-flex flex-column text-center">\n\
                        <form method="post">\n\
                            <div class="form-group">\n\
                                <label for="examid">Exam ID:<input type="text" class="form-control text-center" id="examid" maxlength="10" disabled value=""></label>\n\
                            </div>\n\
                            <div class="form-group">\n\
                               <label for="subject">Select Subject:\n\
                                    <select id="subject" class="form-select">\n\
                                    </select></label>\n\
                            </div>\n\
                            <div class="form-group">\n\
                                <input type="number" class="form-control" id="totalquestions" placeholder="Total number of questions...." min="1" max="100" maxlength="3" data-toggle="tooltip" title="please enter number between 1 and 100">\n\
                            </div>\n\
                            <div class="form-group">\n\
                                <input type="number" class="form-control" id="marks" placeholder="Marks per question...." max="99" maxlength="2" data-toggle="tooltip" title="marks per question should not be grater than 99">\n\
                            </div>\n\
                            <button type="submit" class="btn btn-info btn-block btn-round" onclick="setPaper()">Set Paper</button>\n\
                        </form>\n\
                    </div>\n\
                </div>\n\
            </div>\n\
        </div>';
            var newchild = $('body')[0];
            newchild.appendChild(newdiv);
            getExamDetails();
            $('#setPaperModal').modal('toggle');
            $('[data-toggle="tooltip"]').tooltip();
            $("#setPaperModal").on('hidden.bs.modal', removeModal);
        }
        
function getExamDetails()
{
    var data=
            {
        examid:"getexamid"
            };
            var xhr=$.post("ExamControllerServlet",data,processExamDetailsResponse);
            xhr.fail(function(){
                        swal("Error !","problem in server communication ","error");   
                });
}
function processExamDetailsResponse(responseText,responseStatus,xhr)
{
                var obj=JSON.parse(responseText);
                var newexamid=obj.newexamid;
                var subjectlist=obj.subjects;
                $("#examid").val(newexamid);
                $("#subject").empty();
                $("#subject").append(subjectlist);
            }


           
           
function editPaperModal() {
    removeModal();
    var newdiv = document.createElement("div");
            newdiv.setAttribute("class", "modal fade");
            newdiv.setAttribute("id", "editPaperModal");
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
                        <h4>Edit Paper</h4>\n\
                    </div>\n\
                    <div class="d-flex flex-column text-center">\n\
                        <form>\n\
                            <div class="form-group">\n\
                                <select id="examidoptions" class="form-select"></select>\n\
                            </div>\n\
                            <button type="button" class="btn btn-info btn-block btn-round" onclick="editQuestions()">Edit Exam</button>\n\
                        </form>\n\
                    </div>\n\
                </div>\n\
            </div>';
            var newchild = $('body')[0];
            newchild.appendChild(newdiv);
            getAllExamId();
             $('#editPaperModal').modal('toggle');
             $('[data-toggle="tooltip"]').tooltip();
             $("#editPaperModal").on('hidden.bs.modal',removeModal);
        }           
function getAllExamId()
{
    var datad1=
            {
        examid:"getexamids"
            };
            console.log(JSON.stringify(datad1));
            var xhr=$.post("EditQuestionsControllerServlet",datad1,processAllExamIdResponse);
            xhr.fail(function(){
                    swal("Error !","problem in server communication ","error");   
                    });
}
function processAllExamIdResponse(responseText,responseStatus,xhr)
{
                var obj=JSON.parse(responseText);
                var examids=obj.examid;
                $("#examidoptions").empty();
                $("#examidoptions").append(examids);
            }

           
           
function viewScores()
           {
               window.location="allperformance.jsp";
           }
            

        
function removeModal()
{
   var getDiv=$('.modal');
  getDiv.remove();
  var getDiv2=$('.modal-backdrop');
  getDiv2.remove();
}