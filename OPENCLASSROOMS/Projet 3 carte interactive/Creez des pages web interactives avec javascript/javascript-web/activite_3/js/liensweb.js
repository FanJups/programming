/* 
Activité 3
*/

// Fonction qui affiche les données du tableau d'objets 

function affichage(titre, url, auteur) 

{
    
    var divElt = document.createElement("div"); // Création d'un élément div

    divElt.classList.add("lien"); // Ajout de la classe lien

    document.getElementById("contenu").appendChild(divElt); // Ajout dans le DOM



    var aElt = document.createElement("a"); // Création d'un élément a

    aElt.href = url;// Ajout de l'URL

    aElt.style.textDecoration = "none";

    var spanElt = document.createElement("span"); // Création du span


    spanElt.style.color = "#428bca"; // Ajout de la couleur du texte

    spanElt.style.fontWeight = "bolder";

    spanElt.style.fontSize = "200%";

    spanElt.appendChild(document.createTextNode(titre)); // Définition du contenu textuel du span

    aElt.appendChild(spanElt); // Ajout du span dans le DOM

    divElt.appendChild(aElt); // Ajout du lien dans le DOM

    divElt.appendChild(document.createTextNode("  " + url)); // Ajout de l'url
    
    

    var pElt = document.createElement("p"); // Création d'un élément p

    pElt.appendChild(document.createTextNode("Ajouté par " + auteur)); // Ajout de l'auteur

    divElt.appendChild(pElt); // Ajout de l'élément dans le DOM


    
}


// Récupération des liens à afficher depuis le serveur

ajaxGet("https://oc-jswebsrv.herokuapp.com/api/liens" , function (reponse) {
    
    
    // Transforme la réponse en un tableau 
    
    var liens = JSON.parse(reponse);
    
    // Affichage des données

    for (var i=0; i<liens.length; i++)
    
        {
            affichage(liens[i].titre,liens[i].url,liens[i].auteur);
        }
    
   
    
});

// Ajout de liens 

var formVisibleElt = document.getElementById("formVisible"); // Bouton qui affiche le formulaire

var form = document.querySelector("form");

function formVisibleClic ()
{
    form.style.display = "block";
    
    formVisibleElt.style.display = "none";
    
    
}

// Ajout d'un gestionnaire pour l'événement click sur Ajouter lien

formVisibleElt.addEventListener("click", formVisibleClic);

// Ajout d'un gestionnaire pour l'événement submit sur le formulaire

form.addEventListener("submit",function (e) {
    
     e.preventDefault();
    
    var nom = form.elements.auteur.value;
    
    var titreLien = form.elements.titre.value;
    
    var urlLien = form.elements.url.value;
    
    // Objet lien à envoyer au serveur
    
    var lienPourServeur = {
                
                titre : "",
                url : "" ,
                auteur : "" 
            };
    
    
    
    // Utile pour la Recherche de http ou https
    
    var urlLienMinuscules = urlLien.toLowerCase();
    
    // Recherche de http ou https
    
    if(  (urlLienMinuscules.startsWith("http://"))||(urlLienMinuscules.startsWith("https://"))  )
        {
            
            lienPourServeur.titre = titreLien;
            
            lienPourServeur.url = urlLien;
            
            lienPourServeur.auteur = nom;
            
            
            
        }
    else
        {
            
            var urlLienModifie = "http://"+ urlLien;
            
            lienPourServeur.titre = titreLien;
            
            lienPourServeur.url = urlLienModifie;
            
            lienPourServeur.auteur = nom;
            
        }
    
    
    
    // Envoi des données du formulaire au serveur
    
    ajaxPost("https://oc-jswebsrv.herokuapp.com/api/lien",lienPourServeur,function () {
        
        
        // En cas de succès d'ajout du lien, faire ceci :
        
        console.log("Lien envoyé au serveur");
        
        // Je vide contenu pour afficher la nouvelle liste de  liens
        
        document.getElementById("contenu").textContent = "";
        
        // Récupération des liens à afficher depuis le serveur
        
        ajaxGet("https://oc-jswebsrv.herokuapp.com/api/liens" , function (reponse) {
            
            // Transforme la réponse en un tableau 
    
            var liens = JSON.parse(reponse);
    
            // Affichage des données

            for (var i=0; i<liens.length; i++)
    
                {
                    affichage(liens[i].titre,liens[i].url,liens[i].auteur);
                }
            
        });
        
        
        // Formulaire dispparaît
        
        form.style.display = "none";
        
        // Confirmation du lien apparaît puis disparraît après 2s
        
        document.getElementById("confirmation").textContent = "Le lien " + '"' + titreLien +  '"' + " a bien été ajouté."
    
        document.getElementById("confirmation").style.display = "block";
        
        function confirmationDeux ()
        {
            
            document.getElementById("confirmation").style.display = "none";
        }
        
        setTimeout(confirmationDeux,2000);
        
        // Le bouton ajouter lien apparaît
        
        formVisibleElt.style.display = "block";
        
        
        // J'initialise les valeurs précédemment saisis
        
        form.elements.auteur.value = "";
        
        form.elements.url.value ="";
    
        form.elements.titre.value ="";
        
    
    },true);
    
    
});