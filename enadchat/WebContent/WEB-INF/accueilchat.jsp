<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil Chat</title>
</head>
<body>

<a  href="<c:url value="/deconnexion"/>">Déconnexion </a>

<br>
<br>
<br>

Bienvenue ${sessionScope.sessionUtilisateur.noms_prenoms_utilisateur }


<br>
<br>
<br>

<c:if test="${utilisateurs.size()==1 }">

Unique personne connectée:

</c:if>

<c:if test="${utilisateurs.size()>1 }">

 ${utilisateurs.size() } personnes connectées:

</c:if>


<br>
<br>
<br>

<c:forEach  items="${ utilisateurs }" var="liste" varStatus="boucle">

 <div> <c:out value="${liste.noms_prenoms_utilisateur } "/> </div>  
 
 <br>
 <br>



</c:forEach>



</body>
</html>