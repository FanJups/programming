<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 



                         
                         
                         <label for="nomClient">Nom<span class="requis">*</span></label>
                         <input type="text" id="nomClient" name="nomClient" value="<c:out value="${client.nom }"/>" size="30" maxlength="30" />
                         <span class="erreur"> ${ form.erreurs['nomClient'] } </span>
                         
                         
                         <br/>
                         <br/>
                         
                         <label for="prenomClient">Prénom</label>
                         <input type="text" id="prenomClient" name="prenomClient" value="<c:out value="${client.prenom }"/>" size="30" maxlength="30" />
                         <span class="erreur"> ${ form.erreurs['prenomClient'] } </span>
                         
                         <br/>
                         <br/>
                         
                         <label for="adresseClient">Adresse de livraison<span class="requis">*</span></label>
                         <input type="text" id="adresseClient" name="adresseClient" value="<c:out value="${client.adresse }"/>" size="30" maxlength="60" />
                         <span class="erreur"> ${ form.erreurs['adresseClient'] } </span>
                         <br/>
                         <br/>
                         
                         <label for="telephoneClient">Numéro de téléphone<span class="requis">*</span></label>
                         <input type="text" id="telephoneClient" name="telephoneClient" value="<c:out value="${client.telephone }"/>" size="30" maxlength="30" />
                         <span class="erreur"> ${ form.erreurs['telephoneClient'] } </span>
                         <br/>
                         <br/>
                         
                         <label for="emailClient">Adresse email</label>
                         <input type="email" id="emailClient" name="emailClient" value="<c:out value="${client.email }"/>" size="30" maxlength="60" />
                         <span class="erreur"> ${ form.erreurs['emailClient'] } </span>
                         <br/>
                         <br/>
                         
                         <label for="imageClient">Image</label>
                         <input type="file" id="imageClient" name="imageClient"   />
                         <span class="erreur"> ${ form.erreurs['imageClient'] } </span>
                         <br/>
                         
                         
                         
               
