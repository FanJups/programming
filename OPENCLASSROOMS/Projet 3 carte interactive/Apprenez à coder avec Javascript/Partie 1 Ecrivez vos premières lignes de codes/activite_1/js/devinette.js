/* 
Activité : jeu de devinette
*/

// NE PAS MODIFIER OU SUPPRIMER LES LIGNES CI-DESSOUS
// COMPLETEZ LE PROGRAMME UNIQUEMENT APRES LE TODO

console.log("Bienvenue dans ce jeu de devinette !");

// Cette ligne génère aléatoirement un nombre entre 1 et 100
var solution = Math.floor(Math.random() * 100) + 1;

// Décommentez temporairement cette ligne pour mieux vérifier le programme
//console.log("(La solution est " + solution + ")");

// TODO : complétez le programme





var compteur = 1;

//Supposons que la solution n'a pas encore été trouvée

var solutionTrouvee = false;

while(compteur<=6 && (solutionTrouvee===false))
{

	var nombre = Number(prompt("Entrez un nombre :"));

	if(nombre>solution)
	{
		console.log(nombre+" est trop grand");
	}

	if(nombre<solution)
	{
		console.log(nombre+" est trop petit");
	}

	if(nombre===solution)
	{
		solutionTrouvee =true;
	}


	compteur++;
}

if(solutionTrouvee===false) // Les 6 essais ont été infructueux
{
	console.log("Perdu... La solution était "+solution);
}
else // Solution trouvée
{
	console.log("Bravo ! La solution était "+solution);

	// La valeur de compteur a augmenté à la fin donc je diminue de 1 pour avoir le nombre d'essais

	var nombreEssais = compteur - 1;

	console.log("Vous avez trouvé en "+nombreEssais+" essai(s)");
}
