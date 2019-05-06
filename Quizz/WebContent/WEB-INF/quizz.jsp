<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="quizz">
<meta name="author" content="quizz">


<link rel="shortcut icon" type="image/png"
	href="<c:url value="/inc/favicon.png"/>">
<!-- [if IE]><link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/favicon.ico"/>"/><![endif]-->

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/font-awesome/css/font-awesome.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/style_quizz.css"/>" rel="stylesheet" />



<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!-- [if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<! [endif]-->


<title>Quizz</title>
</head>
<body>

        <div class="container" >
        
             <div id="quizContainer" class="contain">
             
                    <div class="title">Computer quiz</div>
                    
                    <div id="question" class="question"></div>
                    
                    <label class="option"><input type="radio" name="option" value="1"><span id="opt1"></span></label>
                    
                    <label class="option"><input type="radio" name="option" value="2"><span id="opt2"></span></label>
                    
                    <label class="option"><input type="radio" name="option" value="3"><span id="opt3"></span></label>
                    
                    <label class="option"><input type="radio" name="option" value="4"><span id="opt4"></span></label>
                    
                    <button id="nextButton" class="next-btn" onclick="loadNextQuestion();">Next Question</button>
             
             
             </div>
             
             <div id="result" class="contain result" style="display:none;">
             
             </div>
             
             <script src="<c:url value="/inc/question.js"/>"></script>
             
             <script src="<c:url value="/inc/quiz-script.js"/>"></script>
        
        
        </div>

</body>
</html>