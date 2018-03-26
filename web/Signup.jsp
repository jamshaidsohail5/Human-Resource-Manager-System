<%--
  Created by IntelliJ IDEA.
  User: jamsh
  Date: 3/18/2017
  Time: 8:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Signup Page</title>
  <!-- Bootstrap -->
  <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="startup.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <link href = "js/jquery-ui-1.12.1/jquery-ui.min.css" rel = "stylesheet">
  <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>





</head>
<body>
<nav class = "navbar navbar-fixed-top navbar-inverse" style = "background:rgba(0,0,0,1);">
  <div class = "container">
    <div class = "navbar-header">
      <button type = "button" class = "navbar-toggle collapsed"
              data-toggle = "collapse" data-target ="navbar#collapse">
        <span class = "sr-only">Toggle Navigation</span>
        <span class = "icon-bar"></span>
        <span class = "icon-bar"></span>
        <span class = "icon-bar"></span>

      </button>
      <a class = "navbar-brand" href ="index.html" style = "color:orange;">Orange HR</a>

    </div>

    <div class = "collapse navbar-collapse" id = "navbar-collapse">
      <ul class = "nav navbar-nav navbar-right">
        <li><a href = "bootstrapproject.jsp" >Home</a></li>
        <li><a href = "" >About</a></li>

        <li><a href = "" >Our Team</a></li>

        <li><a href = "" >Contact</a></li>

      </ul>
    </div>
  </div>
</nav>


<!-- Row start -->
<div class="row" style="margin-top:60px;">
  <div class="col-md-12 col-sm-6 col-xs-12">
    <div class="panel panel-default">
      <div class="panel-heading clearfix">
        <i class="icon-calendar"></i>
        <h3 class="panel-title">Fill the below fields!</h3>
      </div>

      <div class="panel-body">
        <form class="form-horizontal row-border" action="signupservlet" method  = "post">


          <div class="form-group">
            <label class="col-md-2 control-label">Name</label>
            <div class="col-md-10">
              <input id = "textname" type="text" name="textName" class="form-control" placeholder = "Type Name Here" required>
              ${id}
            </div>
          </div>

          <div class="form-group">
            <label class="col-md-2 control-label">Second Name</label>
            <div class="col-md-10">
              <input id = "textsecondname" type="text" name="textSecondname" class="form-control" placeholder = "Type SecondName Here" required>
            </div>
          </div>

          <div class="form-group">
            <label class="col-md-2 control-label">Username</label>
            <div class="col-md-10">
              <input id = "textusername" type="text" name="textUsername" class="form-control" placeholder = "@username" required>
              <label id = "successorfailure"></label>
            </div>
          </div>



          <div class="form-group" id = "tobehidden">
            <p class="col-md-2 control-label" style = "color:red;"><%if(request.getAttribute("message")!=null) {request.getAttribute("message");}%></p>
            <div class="col-md-10">
            </div>
          </div>

          <div class="form-group">
            <label class="col-md-2 control-label">Password</label>
            <div class="col-md-10">
              <input id = "textpassword" type="password" name="textPassword" class="form-control" placeholder = "Type Password Here!" required>
            </div>
          </div>

          <div class="form-group">
            <label class="col-md-2 control-label">Specialization</label>
            <div class="col-md-10">
              <input id = "textspecialization" type="text" name="textSpecialization" class="form-control" placeholder = "Type Specialization Here!" required>
            </div>
          </div>



          <div class="form-group">
            <label class="col-md-2 control-label">CNIC</label>
            <div class="col-md-10">
              <input id = "textcnic" type="text" name="textCnic" class="form-control" placeholder = "Type CNIC here!" required>
            </div>
          </div>

          <div class="form-group">
            <label class="col-md-2 control-label">Cell no</label>
            <div class="col-md-10">
              <input id = "textcellno" type="text" name="textCellno" class="form-control" placeholder = "Type Cell No here!" required>
            </div>
          </div>


          <div class="form-group">
            <label class="col-md-2 control-label">Postal Code</label>
            <div class="col-md-10">
              <input id = "textpostalcode" type="text" name="textPostalcode" class="form-control" placeholder = "Type PostalCode here!" required>
            </div>
          </div>



          <div class="form-group">
            <label class="col-md-2 control-label">City</label>
            <div class="col-md-10">
              <input id = "textcity" type="text" name="textCity" class="form-control" placeholder = "Type City here!" required>
            </div>
          </div>




          <div class="form-group">
            <label class="col-md-2 control-label">Address</label>
            <div class="col-md-10">
              <input id = "textaddress" type="text" name="textAdress" class="form-control" placeholder = "Type Address here!" required>
            </div>
          </div>

          <div class="form-group">
            <label class="col-md-2 control-label">Email</label>
            <div class="col-md-10">
              <input id = "textemail" type="email" name="textEmail" class="form-control" placeholder = "username@domain.com" required>
            </div>
          </div>




          <div class="form-group">
            <label class="col-md-2 control-label">Press this button after you are done!</label>
            <div class="col-md-10">
              <button class = "btn btn-danger btn-lg">Signup</button>
            </div>
          </div>


        </form>
      </div>
    </div>
  </div>
</div>
<!-- Row end -->










<script>
    function checkfields()
    {
        if(document.getElementById("textname").value =="" || document.getElementById("textsecondname").value =="" ||  document.getElementById("textusername").value =="" || document.getElementById("textpassword").value =="" || document.getElementById("textpostalcode").value =="" || document.getElementById("textcellno").value =="" || document.getElementById("textcity").value =="" || document.getElementById("textcnic").value =="" || document.getElementById("textaddress").value =="" || document.getElementById("textemail").value =="" )

        {
            alert("Fields missing");
        }
    }
</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!--Adding jquery cdn-->
<script src="//code.jquery.com/jquery-3.1.1.min.js"></script>
<!--Adding jquery in case cdn is not available-->
<script src="js/jquery-3.1.1.js"></script>


<script type="text/javascript">

    $(document).ready(function(){


        $('#textusername').on('input',function(e){

            var data = $('#textusername').val();
              //  alert( data );

            $.ajax({

                type : 'POST',
                data : {aj_username : data},
                url : 'signupservlet',
                success  : function(result){
                    $('#successorfailure').html(result);
                }
            });
        });
    });

</script>




</body>
</html>
