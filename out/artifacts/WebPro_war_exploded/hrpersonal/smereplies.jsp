<!DOCTYPE html>
<html>
<head>
<link class="jsbin" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
<meta charset=utf-8 />


<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--<link href="startup.css" rel="stylesheet">-->
	
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
  
  
  
<title>Sme's Replies</title>
<!--[if IE]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<style>
  article, aside, figure, footer, header, hgroup, 
  menu, nav, section { display: block; }
  
  .background-div
{
    margin-top : 50px;
    position : relative;
    color : white;
    background-color: black;
    opacity: 0.8;
    padding-bottom : 100px;
}

.background-div  p{
		padding-bottom : 0px;
		margin-bottom : 0px;
}

  .center-block {
    width:900px;
    padding:50px;
    background-color:#eceadc;
    color:#ec8007;
	margin-top:50px;
	}
	
	.center-block > img{
	    margin:auto;
		width:400px;
	    
	}
	
	
	.cover {
   width: 100%;; /* whatever width you want for the cover div */
   height: 400px;
   background-color: white; /* optional */
   overflow: hidden;
}
.cover > img {
   width: 100%;
}
	.Profile{
	width: 15%;; /* whatever width you want for the cover div */
    height: 270px;
	background-color: white; /* optional */
	overflow: hidden;
    margin-left:150px;
	display:block;
	margin-top:-140px;
	border:solid 1px black;
	background-size:cover;
	
	}
	.Profile > img
	{
	width:50%;
	padding-top:-10px;
	}
	
	div#grid {
    width: 400px;
    height: 600px;
	margin-left:500px;
	margin-top:-50px;
}

div#grid div {
    width: 125px;
    height: 125px;
    outline: 1px solid;
    float: right;
}
	
	.headerTitle
	{
		background-color : black;
		margin-top : 100px;
		height : 100px;
		color : white;
		text-align : center;
	}
</style>



</head>
<body style = "color:purple;">


	<nav class = "navbar navbar-fixed-top navbar-inverse" >
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
					<li><a href = "hrpersonalhome.jsp" >Home</a></li>
				<li><a href = "" data-toggle="modal" data-target="#myModal" role = "button">Notifications</a></li>
				<li><a href = "" >LogOut</a></li>
					
				</ul>
			</div>
		</div>
	</nav>
	
	
		<h1 style = "padding-top:50px;padding-left:570px;">Replies</h1>
		
		<div style="width:700px;height:245px;border:1px solid orange;position:absolute;top:150px;left:300px;background-color:#ff6666;">
			<div class = "container">
				<div class = "row">
						<div class = "col-sm-3" style = "border-right:1px solid black;">
							<img src = "pavel.jpg" alt = "pavelface" class = "img-circle" style = "padding:60px;">
						</div>
						<div class = "col-sm-3">
						<ul style ="padding-top:60px; color:white;">
							<li>Name:Jamshaid Sohail</li>
							<li>CNIC:35201-0288558-9</li>
							<li>Specialization:Web</li>
							<li>Time:1:00pm</li>
							<li>Date:12-14-2017</li>
							<button id = "but1" class = "btn btn-success" style = "margin-top:20px;" onclick="javascript:sendingusersmail();" >Send Users</button>
						
						</ul>
						</div>
				</div>
			</div>		
		</div>
		
		
		
		
		<div style="width:700px;height:245px;border:1px solid orange;position:absolute;top:450px;left:300px;background-color:#cc99ff;">
			<div class = "container">
				<div class = "row">
						<div class = "col-sm-3" style = "border-right:1px solid black;">
							<img src = "EmilyFox.jpg" alt = "pavelface" class = "img-circle" style = "padding:60px;">
						</div>
						<div class = "col-sm-3">
						<ul style ="padding-top:60px; color:white;">
							<li>Name:EmilyFox</li>
							<li>CNIC:35201-0288558-9</li>
							<li>Specialization:Android</li>
								<li>Time:1:00pm</li>
							<li>Date:12-14-2017</li>
							<button id = "but2" class = "btn btn-success" style = "margin-top:20px;" onclick="javascript:sendingusersmail();" >Send Users</button>
						
						
						</ul>
						</div>
				</div>
			</div>		
		</div>
		
		<div style="width:700px;height:245px;border:1px solid orange;position:absolute;top:750px;left:300px;background-color:#99ffcc;">
			<div class = "container">
				<div class = "row">
						<div class = "col-sm-3" style = "border-right:1px solid black;">
							<img src = "guestrin-dato.jpg" alt = "pavelface" class = "img-circle" style = "padding:60px;">
						</div>
						<div class = "col-sm-3">
						<ul style ="padding-top:60px; color:white;">
							<li>Name:Guestrin Dato</li>
							<li>CNIC:35201-0288558-9</li>
							<li>Specialization:Web</li>
							<li>Time:1:00pm</li>
							<li>Date:12-14-2017</li>
							<button id = "but3" class = "btn btn-success" style = "margin-top:20px;" onclick="javascript:sendingusersmail();" >Send Users</button>
						
						</ul>
						</div>
				</div>
			</div>		
		</div>
		
	<script type="text/javascript">
	function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#blah')
                    .attr('src', e.target.result)
                    .width(1400)
                    .height(370);
            };

            reader.readAsDataURL(input.files[0]);
			document.getElementById("inpu1").style.visibility = 'hidden';
        }
    }
	
	function readurl(input)
	{
	    if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#blah1')
                    .attr('src', e.target.result)
                    .width(200)
                    .height(270);
            };

            reader.readAsDataURL(input.files[0]);
			document.getElementById("inpu").style.visibility = 'hidden';

        }
	}
	
	function checkinputs(){
		if(document.getElementById("input1").value=="" || document.getElementById("input2").value=="" || document.getElementById("input3").value=="" || document.getElementById("input4").value=="" || document.getElementById("input5").value=="")
		{
			alert("Fields missing");
		
		}
		if(document.getElementById("blah").src=="#")
		{
			alert("Please upload poster for the job");
		}
		
		
	}
	
	function disabling(){
			 
			if(	 document.getElementById("rejectionletter").innerHTML.length==0)
			{
			alert("Please Type Something in the reply");
				
			}
			else
			{
			}
	}
	$(document).ready(function () {
		$('#rejectionletter').click(function () {
			if (!$.trim($("#te").val())) {
			alert("Please type something");
			}
			else{
			
				this.disabled = true;
				location.href = "smehome.html";
			}
	
		});
	});
	
	function sendingusersmail(){
	location.href = "sendingusersthemail.html";
	}
	
	
	
	</script>
</body>
</html>
