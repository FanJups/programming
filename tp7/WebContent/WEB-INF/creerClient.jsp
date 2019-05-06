<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Création d'un client</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>"/>
</head>
<body>
      <c:import url="/inc/menu.jsp"/>
      <div>
      
          <form method="post" action="<c:url value="/creationClient"/>" enctype="multipart/form-data">
               <fieldset>
                         <legend>Informations client</legend>
                         <c:import url="/inc/inc_client_form.jsp"/>
                         
               </fieldset>
               <p class="info">${form.resultat}</p>
               <input type="submit" value="Valider"/>
               <input type="reset" value="Remettre à zéro"/>
               <br/>
          </form>
          
      </div>

</body>
</html>