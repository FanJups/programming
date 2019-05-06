/* 
Activité 2
*/

// Liste des liens Web à afficher. Un lien est défini par :
// - son titre
// - son URL
// - son auteur (la personne qui l'a publié) 
var listeLiens = [
    {
        titre: "So Foot",
        url: "http://sofoot.com",
        auteur: "yann.usaille"
    },
    {
        titre: "Guide d'autodéfense numérique",
        url: "http://guide.boum.org",
        auteur: "paulochon"
    },
    {
        titre: "L'encyclopédie en ligne Wikipedia",
        url: "http://Wikipedia.org",
        auteur: "annie.zette"
    }
];

// TODO : compléter ce fichier pour ajouter les liens à la page web


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

// Affichage des données

for (var i=0; i<listeLiens.length; i++)
    
    {
        affichage(listeLiens[i].titre,listeLiens[i].url,listeLiens[i].auteur);
    }


 
// Début activité 2


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

form.addEventListener("submit", function(e) {
    
    var nom = form.elements.nom.value;
    
    var titreLien = form.elements.titrelien.value;
    
    var urlLien = form.elements.urllien.value;
    
    // Utile pour la Recherche de http ou https
    
    var urlLienMinuscules = urlLien.toLowerCase();
    
    
    
    // Recherche de http ou https
    
    
    
    if(  (urlLienMinuscules.startsWith("http://"))||(urlLienMinuscules.startsWith("https://"))  )
       {
            // Présence
           
           listeLiens.unshift({
                
        titre: titreLien,
        url: urlLien,
        auteur: nom
    });
           
       }
    else
        {
            var urlLienModifie = "http://"+ urlLien;
            
            listeLiens.unshift({
                
        titre: titreLien,
        url: urlLienModifie,
        auteur: nom
    });
        }
    
    
    // Je vide contenu pour afficher le nouveau tableau
    
    document.getElementById("contenu").textContent = "";
    
    
for (var i=0; i<listeLiens.length; i++)
    
    {
        affichage(listeLiens[i].titre,listeLiens[i].url,listeLiens[i].auteur);
    }
    
    

    document.getElementById("confirmation").textContent = "Le lien " + '"' + titreLien +  '"' + " a bien été ajouté."
    
    form.style.display = "none";
    
    document.getElementById("confirmation").style.display = "block";
    
    
    formVisibleElt.style.display = "block";
    
    function confirmationDeux ()
    {
        document.getElementById("confirmation").style.display = "none";
    }
    
    
    setTimeout(confirmationDeux,2000);
    
    // J'initialise les valeurs précédemment saisis
    
    
    form.elements.nom.value = "";
    
    form.elements.urllien.value ="";
    
    form.elements.titrelien.value ="";
    
        

    e.preventDefault(); // Annulation de l'envoi des données
});












