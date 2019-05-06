<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des clients existants</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>"/>
</head>
<body>
     <c:import url="/inc/menu.jsp"/>
     
     <div id="corps">
     
     <c:choose>
     
              <%-- Si aucun client n'existe en session, affichage d'un message par défaut. --%>
              
              <c:when test="${ empty sessionScope.clients }">
              
                    <p class="erreur">Aucun client enregistré.</p>
                    
              </c:when>
              
              <%-- Sinon, affichage du tableau. --%>
              
              <c:otherwise>
              
              <table>
              
                    <tr>
                          <th>Nom</th>
                          <th>Prénom</th>
                          <th>Adresse</th>
                          <th>Téléphone</th>
                          <th>Email</th>
                          <th>Image</th>
                          <th class="action">Action</th>
                    </tr>
                    
                    <%-- Parcours de la Map des clients en session, et
                    utilisation de l'objet varStatus. --%>
                    
                    <c:forEach items="${ sessionScope.clients }" var="mapClients" varStatus="boucle">
                    
                           <%-- Simple test de parité sur l'index de parcours,
                           pour alterner la couleur de fond de chaque ligne du tableau. --%>
                           
                           <tr class="${boucle.index % 2==0 ? 'pair' : 'impair' }">
                           
                           <%-- Affichage des propriétés du bean Client, qui est stocké
                           en tant que valeur de l'entrée courante de la map --%>
                           
                                <td><c:out value="${mapClients.value.nom }"></c:out></td>
                                <td><c:out value="${mapClients.value.prenom }"></c:out></td>
                                <td><c:out value="${mapClients.value.adresse }"></c:out></td>
                                <td><c:out value="${mapClients.value.telephone }"></c:out></td>
                                <td><c:out value="${mapClients.value.email }"></c:out></td>
                                
                                <td>
                                <%-- On ne construit et affiche un lien vers l'image qu si elle existe --%>
                                
                                <c:if test="${ !empty mapClients.value.image }">
                                
                                <c:set var="image"> <c:out value="${  mapClients.value.image }"/></c:set>
                                <a href="<c:url value="/images/${image}"/>">Voir </a>
                                </c:if>
                                </td>
                                
                                <%-- Lien vers la servlet de suppression, avec passage du nom du client - c'est-à-dire la
                                clé de la Map - en paramètre grâce à la balise <c:param/>. --%>
                                
                                <td class="action"><a href="<c:url value="/suppressionClient"><c:param name="idClient" value="${mapClients.key }"/></c:url>"><img alt="Supprimer" src="<c:url value="/inc/supprimer.png"/>"/></a></td>
                           
                           </tr>
                    
                    </c:forEach>
              
              </table>
              
              </c:otherwise>
              
     </c:choose>
     
     </div>

</body>
</html>