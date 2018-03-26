<html>
<head>
    <title>Notifications</title>


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
                <li class = "active"><a href = "" >Home</a></li>
                <li><a href = "" >LogOut</a></li>

            </ul>
        </div>
    </div>
</nav>


${requestScope.APP}


<!--
<div style="width:600px;height:200px;border:1px solid #000;margin-left:450px;margin-top:100px;">

    <p style = "padding-top:10px;padding-left:10px;"><%=request.getAttribute("user1")%> has applied for this <%=request.getAttribute("job1")%></p>


    <input type="file" name="file3" size="40" src = "<%=request.getAttribute("cv1")%>" style = "padding-top:30px;padding-left:20px;">
    <form action = "/confirmingemailsfromsme" method = "post">
        <input type="submit"  name = "accept1" value = "Accept" class="btn btn-danger" style = "margin-left:20px;margin-top:0px;"></input>
        <input type = "text" name = "username1" style = "margin-top:20px;" placeholder = "Enter username here">
        <input type = "text" name = "jobtitle1" placeholder = "Enter jobtitle here">

    </form>


    <form action = "/sendingrejectiontoapplicant" method = "post">
        <input type="submit" name = "reject1" value = "Reject" class="btn btn-danger" style = "margin-left:20px;"></input>
        <input type = "text" name = "username2" placeholder = "Enter username here" >
        <input type = "text" name = "jobtitle2" placeholder = "Enter jobtitle here">

    </form>

</div>


<div style="width:600px;height:200px;border:1px solid #000;margin-left:450px;margin-top:100px;">

    <p style = "padding-top:10px;padding-left:10px;"><%=request.getAttribute("user2")%> has applied for this <%=request.getAttribute("job2")%></p>


    <input type="file" name="file3" size="40" src = "<%=request.getAttribute("cv2")%>" style = "padding-top:30px;padding-left:20px;">


    <form action = "/confirmingemailsfromsme" method = "post">
        <input type="submit" name = "accept2" value = "Accept" class="btn btn-danger" style = "margin-left:20px;margin-top:0px;"></input>
        <input type = "text" name = "username3" style = "margin-top:20px;" placeholder = "Enter username here">
        <input type = "text" name = "jobtitle3" placeholder = "Enter jobtitle here">

    </form>


    <form action = "/sendingrejectiontoapplicant" method = "post">
        <input type="submit" name = "reject2" value = "Reject" class="btn btn-danger" style = "margin-left:20px;"></input>
        <input type = "text" name = "username4" placeholder = "Enter username here" >
        <input type = "text" name = "jobtitle4" placeholder = "Enter jobtitle here">

    </form>

</div>

<div style="width:600px;height:200px;border:1px solid #000;margin-left:450px;margin-top:100px;">

    <p style = "padding-top:10px;padding-left:10px;"><%=request.getAttribute("user3")%> has applied for this <%=request.getAttribute("job3")%></p>


    <input type="file" name="file3" size="40" src = "<%=request.getAttribute("cv3")%>" style = "padding-top:30px;padding-left:20px;">
    <form action = "/confirmingemailsfromsme" method = "post">
        <input type="submit" name = "accept3"  value = "Accept" class="btn btn-danger" style = "margin-left:20px;margin-top:0px;"></input>
        <input type = "text" name = "username5" style = "margin-top:20px;" placeholder = "Enter username here">
        <input type = "text" name = "jobtitle5" placeholder = "Enter jobtitle here">

    </form>


    <form action = "/sendingrejectiontoapplicant" method = "post">
        <input type="submit" name = "reject3" value = "Reject" class="btn btn-danger" style = "margin-left:20px;"></input>
        <input type = "text" name = "username6" placeholder = "Enter username here" >
        <input type = "text" name = "jobtitle6" placeholder = "Enter jobtitle here">

    </form>

</div>

<div style="width:600px;height:200px;border:1px solid #000;margin-left:450px;margin-top:100px;">

    <p style = "padding-top:10px;padding-left:10px;"><%=request.getAttribute("user4")%> has applied for this <%=request.getAttribute("job4")%></p>


    <input type="file" name="file3" size="40" src = "<%=request.getAttribute("cv4")%>" style = "padding-top:30px;padding-left:20px;">
    <form action = "/confirmingemailsfromsme" method = "post">
        <input type="submit" name = "accept4" value = "Accept" class="btn btn-danger" style = "margin-left:20px;margin-top:0px;"></input>
        <input type = "text" name = "username7" style = "margin-top:20px;" placeholder = "Enter username here">
        <input type = "text" name = "jobtitle7" placeholder = "Enter jobtitle here">

    </form>


    <form action = "/sendingrejectiontoapplicant" method = "post">
        <input type="submit" name = "reject4" value = "Reject" class="btn btn-danger" style = "margin-left:20px;" name = ""></input>
        <input type = "text" name = "username8" placeholder = "Enter username here" >
        <input type = "text" name = "jobtitle8" placeholder = "Enter jobtitle here">
    </form>
</div>

-->
</body>
</html>
