<!DOCTYPE html>
<html>
<head>
<link class="jsbin" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
<meta charset=utf-8 />


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
  
  
  
<title>Job Description</title>
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
	padding:30px;
	line-height:30px;
	word-spacing:5px;
	
</style>



</head>
<body>


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
					<li><a href = "" >LogOut</a></li>
					
				</ul>
			</div>
		</div>
	</nav>
	
	
<form  action = "/storingjobinfo" method = "post" enctype="multipart/form-data">
			<div class="container">
				<div class="row">
					<div class="center-block">
					<h1>Job Title</h1>
						<input type = "text" placeholder="Enter title here" name = "title">

					<hr>
					<h1>Requirements</h1>
					<textarea  name="requirements" placeholder = 'Write Requirements here 'cols="40" rows="5" required></textarea>
					<hr>
					<button class = "btn btn-danger">Submit</button>
					</div>
				</div>
			</div>
</form>

	
	
	
	<script type="text/javascript">
	function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#blah')
                    .attr('src', e.target.result)
                    .width(460)
                    .height(345);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }
	</script>
</body>
</html>
