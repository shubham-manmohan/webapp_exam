var userid,password,usertype;

function connectUser()
{
    userid=$("#userid").val();
    password=$("#password").val();
    console.log(userid+","+password+","+usertype);
    if(validate()===false)
    {
        swal("Error","Please enter userid/password/user type..........","error");
        return;
    }
    var data=
                {
                    userid:userid,
                    password:password,
                    usertype:usertype
                };
     var xhr=$.post("LoginControllerServlet",data,processResponse);
     xhr.fail(handleError);
}
function userTypeFunction(result)
{
    usertype=result;
}
function processResponse(responseText,textStatus,xhr)
{
    var res=responseText.trim();
    if(res==="error")
    {
        swal("Error","Login Failed ....\nUserId/password or userType may be incorrect!","error");
//        setTimeout(redirectUser,3000);
        return;
    }
    if(res.trim().indexOf("jsessionid")!=-1)
    {
        swal("Accepted!","Login Accepted !!!","success");
        window.location=res.trim();
    }
    else
    {
        swal("Exception!!","Exception occured !"+res,"error");
    }
}

function handleError(xhr)
{
    swal("Error !","problem in server communication "+xhr.statusText,"error");
}

function validate()
{
    if(userid===""||password===""||usertype===undefined)
    {
        return false;
    }
    return true;
}

function redirectUser()
{
    window.location="home.html";
}

function showPassword() {
  var x = document.getElementById("password");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}