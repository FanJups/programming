<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Affichage d'un client</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>"/>
</head>
<body>
<c:import url="/inc/menu.jsp"/>
<div id="corps">
      <%--Affichage de la chaîne "message" transmise par la servlet --%>
      <p class="info">${form.resultat }</p>
      <%--Puis affichage des données enregistrées dans le bean "client" transmis par la servlet  --%>
      
      
      <p>Nom: <c:out value="${client.nom }"/></p>
      <p>Prénom: <c:out value="${client.prenom }"/></p>
      <p>Adresse: <c:out value="${client.adresse }"/></p>
      <p>Numéro de téléphone: <c:out value="${client.telephone }"/></p>
      <p>Email: <c:out value="${client.email }"/></p>
      <p>Image: <c:out value="${client.image }"/></p>
      
      
</div>

</body>
</html>