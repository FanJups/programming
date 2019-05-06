<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IU</title>
</head>
<body>

<br>
<br>
<br>


<form method="post" action="<c:url value="/inscription_utilisateur"/>">
                 
                 <input type="text" value="<c:out value="${utilisateur.noms_prenoms_utilisateur }"/>" placeholder="Noms et prénoms" name="np_utilisateur" size="100" required> 

<br>
<br>
<br>

<input type="text" value="<c:out value="${utilisateur.identifiant_utilisateur }"/>" placeholder="Identifiant" name="identif_utilisateur" size="100" required>


<br>
<br>
<br>

<input type="password" value="<c:out value="${utilisateur.mdp_utilisateur }"/>" placeholder="Mot de passe" name="motdepasse_utilisateur" size="100" required>


<br>
<br>
<br>

<button type="submit">
									
									<h4>Je m'inscris.</h4>
								</button>
								
								
								
         
</form>

<c:if test="${! empty form.erreurs['identif_utilisateur'] }">

<script type="text/javascript">

var erreur = "${form.erreurs['identif_utilisateur']}";

alert(erreur);

</script>

</c:if>


</body>
</html>