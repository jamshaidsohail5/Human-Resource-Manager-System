<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
	<link href="startup.css" rel="stylesheet">
	 <link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

	<style type="text/css">
	
	
    .center-block {
    width:500px;
    padding:50px;
    background-color:#eceadc;
    color:#ec8007;
	margin-top:100px;
	}
	
	.center-block > img{
	    margin:auto;
		width:400px;
	    
	}
	
	
	
	.acidjs-rating-stars,
.acidjs-rating-stars label::before
{
    display: inline-block;
}
 
.acidjs-rating-stars label:hover,
.acidjs-rating-stars label:hover ~ label
{
    color: #189800;
}
 
.acidjs-rating-stars 
{
    margin-left: 80px;
    padding: 0;
}
 
.acidjs-rating-stars input
{
    display: none;
}
 
.acidjs-rating-stars
{
    unicode-bidi: bidi-override;
    direction: rtl;
}
 
.acidjs-rating-stars label
{
    color: #ccc;
}
 
.acidjs-rating-stars label::before
{
    content: "\2605";
    width: 18px;
    line-height: 18px;
    text-align: center;
    font-size: 18px;
    cursor: pointer;
}
 
.acidjs-rating-stars input:checked ~ label
{
    color: #f5b301;
}
 
.acidjs-rating-disabled
{
    opacity: .50;
     
    -webkit-pointer-events: none;
    -moz-pointer-events: none;
    pointer-events: none;
}

	
	
	
	
	
    </style>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
	
	
<div class="container">  
  
  
  <!-- Row start -->
  <div class="row" style="margin-top:60px;">
    <div class="col-md-12 col-sm-6 col-xs-12">
      <div class="panel panel-default">
        <div class="panel-heading clearfix">
          <i class="icon-calendar"></i>
          <h3 class="panel-title">Login</h3>
        </div>
       
        <div class="panel-body">
          <form class="form-horizontal row-border" action="signinservlet" method="post">

			  <div class="form-group">
				  <label class="col-md-2 control-label"></label>
				  <div class="col-md-10">
					  <p>
						  <%
						  if(request.getAttribute("accountCreation")!=null) {
					      String my= (String) request.getAttribute("accountcreation");
							  out.print(my);
					  }
					  %>
					  </p>

				  </div>
			  </div>

			  <div class="form-group">
              <label class="col-md-2 control-label">UserName</label>
              <div class="col-md-10">
                <input id = "tex" type="text" name="TextUserName" class="form-control" placeholder = "@username" required>
              </div>
            </div>
			
			
			 <div class="form-group">
              <label class="col-md-2 control-label">Password</label>
              <div class="col-md-10">
			    <input id = "tex1" type="password" name="TextPassword" class="form-control" placeholder = "password" required>
              </div>
            </div>




			  <div class="form-group">
              <label class="col-md-2 control-label"></label>
					<div class="col-md-10">
						<button class = "btn btn-danger btn-lg">Login</button>
				   
					</div>
			</div>

			  <div class="form-group">
				  <label class="col-md-2 control-label"></label>
				  <div class="col-md-10">
					  <p style="color:red;">
						  <%
							  if(request.getAttribute("message")!=null) {
								  String my= (String) request.getAttribute("message");
								  out.print(my);
							  }
						  %>
					  </p>

				  </div>
			  </div>








		  </form>
        </div>
      </div>
    </div>
  </div>
  <!-- Row end -->
  
  
  
  
  
  
  
  
</div>
  
			<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
			<!-- Include all compiled plugins (below), or include individual files as needed -->
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
				<script>
				document.getElementById("check").onclick = function () {
				if(document.getElementById("te").value == "" || document.getElementById("te1").value == "" || document.getElementById("te2").value == "" || document.getElementById("te3").value == "" || document.getElementById("te4").value == "" || document.getElementById("te5").value == "" || document.getElementById("te6").value == "" || document.getElementById("te7").value == "" || document.getElementById("te8").value == "" )
					{
					alert("Fields Missing!")			
					}	
					else
					{
					alert("Submitted Successfully!");
					location.href = "hrpersonalhome.jsp";
					}			
				}
				
				function backtohome(){
				if(document.getElementById("tex").value == "")
				{
				alert("Please give some comments!");
				}
				else{
					location.href = "smehome.jsp";
			
				}
				}
			
			</script>
			
		  </body>
</html>