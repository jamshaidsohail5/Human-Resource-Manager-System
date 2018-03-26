<%@ page import="java.io.OutputStream" %>
<!DOCTYPE html>
<html>
<head>
<link class="jsbin" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
<meta charset=utf-8 />


<!-- Bootstrap -->
<link href="Applicant/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--<link href="startup.css" rel="stylesheet">-->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
	
<link href = "Applicant/js/jquery-ui-1.12.1/jquery-ui.min.css" rel = "stylesheet">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  
  
<title>applicanthome</title>
<!--[if IE]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<style>
  article, aside, figure, footer, header, hgroup, 
  menu, nav, section { display: block; }
  
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
	
	p{
	padding:10px;
	line-height:30px;
	word-spacing:5px;
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
	
	
.carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
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

			</div>
			
			<div class = "collapse navbar-collapse" id = "navbar-collapse">
				<ul class = "nav navbar-nav navbar-right">
					<li class = "active"><a href = "/Applicant/applicanthome.jsp" >Home</a></li>
				<li><a href = "" data-toggle="modal" data-target="#myModal" role = "button">Notification</a></li>
				<li><a href = "" >LogOut</a></li>
					
				</ul>
			</div>
		</div>
	</nav>
	
	

			
		<div class="container">
		  
		  <!-- Modal -->
		  <div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog modal-lg">
			  <div class="modal-content">
				<div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal">&times;</button>
				  <h4 class="modal-title">Notification</h4>
				</div>
				<div class="modal-body">
<p><a href="Applicant/letter.html"> Dear User! You received a letter from hr personal! </a></p>
				  <p><a href="Applicant/interviewfromhrmanager.html"> Dear User! You received a letter from Hr Manager for interview! </a></p>
				  <p><a href="Applicant/jobofferletter.html"> Dear User! You received a job offer from Hr Manager ! </a></p>
				 				  
				</div>
				<div class="modal-footer">
				  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			  </div>
			</div>
		  </div>
		</div>
		
		<h1 style = "position: relative;display: inline;top: 0px;left: 600px;">Jobs</h1>
		
		
		<div class="container">
			  <br>
			  <div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
				  <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				  <li data-target="#myCarousel" data-slide-to="1"></li>
				  <li data-target="#myCarousel" data-slide-to="2"></li>
				  <li data-target="#myCarousel" data-slide-to="3"></li>
				</ol>


				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">

				  <div class="item active">
					<a href = "/jobsdetail">
					<img src="" alt="Web" width="460" height="345">
					</a>
					<div class="carousel-caption">
					  <h3 name  = "heading1"><%= request.getAttribute("heading1") %></h3>
					  <p name  = "para1"><%= request.getAttribute("para1") %></p>
					</div>
				  </div>

				  <div class="item">
					<a href = "/jobsdetail">
					<img src="" alt="android" width="460" height="345">
					</a>
					<div class="carousel-caption">
						<h3 name = "heading2"><%= request.getAttribute("heading2") %></h3>
						<p name = "para2"><%= request.getAttribute("para2") %></p>
					</div>
				  </div>

				  <div class="item">
					<a href = "/jobsdetail">
					<img src="" alt="IOS" width="460" height="345">
					</a>
					<div class="carousel-caption">
						<h3 name  = "heading3"><%= request.getAttribute("heading3") %></h3>
						<p name = "para3"><%= request.getAttribute("para3") %></p>
					</div>
				  </div>

				  <div class="item">
					<a href = "/jobsdetail">
					<img src="" alt="Machine learning" width="460" height="345">
					</a>
					<div class="carousel-caption">
						<h3 name = "heading4"><%= request.getAttribute("heading4") %></h3>
						<p name = "para4"><%= request.getAttribute("para4") %></p>
					</div>
				  </div>

				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
				  <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				  <span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
				  <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				  <span class="sr-only">Next</span>
				</a>
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
	
	/*function myFunction(){
		alert("Error uploading pic");





//    	if(request.getAttribute("jobimage2")!=null)
//      {
//        response.setContentType("images/jpg");
  //      img = response.getOutputStream();
    //    img.write((byte[]) request.getAttribute("jobimage2"));
      //  img.flush();
        //img.close();
     }


     }
	*/
	
	</script>
</body>
</html>
