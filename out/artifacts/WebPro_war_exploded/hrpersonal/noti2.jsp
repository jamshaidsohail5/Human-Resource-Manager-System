<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.smeemails" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
            <a class = "navbar-brand" href ="index.html" style = "color:orange;">Orange HR</a>

        </div>

        <div class = "collapse navbar-collapse" id = "navbar-collapse">
            <ul class = "nav navbar-nav navbar-right">
                <li class = "active"><a href = "applicanthome.html" >Home</a></li>
                <li><a href = "" >LogOut</a></li>

            </ul>
        </div>
    </div>
</nav>

${requestScope.REP}

</body>
</html>
