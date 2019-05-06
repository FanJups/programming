/* 
Activité : gestion des contacts
*/

// TODO : complétez le programme

// Création de l'objet contact 

var Contact = {
    
    nom : "",
    
    prenom : "",
    
    //Renvoie la description du contact
    
    decrire : function () {
        
        var description = "Nom : " + this.nom + ", prénom : " + this.prenom;
        
        return description;
    }
    
    
    
};

// Création du contact Carole Lévisse

var contact1 = Object.create(Contact);

contact1.nom = "Lévisse";

contact1.prenom = "Carole";


// Création du contact Mélodie Nelsonne

var contact2 = Object.create(Contact);

contact2.nom = "Nelsonne";

contact2.prenom = "Mélodie";


// Création du tableau de contacts

var tableauContacts = [];

// Ajout initial dans le tableau

tableauContacts.push(contact1);

tableauContacts.push(contact2);



// Lister les contacts

function listerContacts()
{
    
    console.log("Voici la liste de tous vos contacts :")
    
    tableauContacts.forEach(function (contactUser) {
        
        console.log(contactUser.decrire());
    });
}

// Ajouter les contacts

function ajouterContacts ()
{
    var nouveauNom = prompt("Entrez le nom du nouveau contact");
    
    var nouveauPrenom = prompt("Entrez le prénom du nouveau contact");
    
    var nouveauContact = Object.create(Contact);
    
    nouveauContact.nom = nouveauNom;
    
    nouveauContact.prenom = nouveauPrenom;
    
    tableauContacts.push(nouveauContact);
    
    console.log("Le nouveau contact a été ajouté");
    
    
}

// Supposons par défaut que l'utilisateur veut choisir une option

var choixQuitter = false;



while (choixQuitter === false)
    
       {
            
           console.log("Bienvenue dans le gestionnaire des contacts !");

           console.log("1 : Lister les contacts");

           console.log("2 : Ajouter un contact");

           console.log("0 : Quitter");
           
           var choix = Number(prompt("Choisissez une option :"));
           
           switch (choix)
               {
                   case 0 :
                       
                       console.log("Au revoir !");
                       
                       choixQuitter = true;
                       
                       break;
                       
                       
                   case 1 :
                       
                       listerContacts();
                       
                       break;
                       
                   case 2 :
                       
                       ajouterContacts();
                       
                       break;
                       
                    default :
                       
                       console.log(" Choisissez 1 pour lister les contacts \n Choisissez 2 pour ajouter un contact \n Choisissez 0 pour quitter");
                       
               }
       }

