package com.sdzee.tp.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;

import com.sdzee.tp.dao.ClientDao;
import com.sdzee.tp.dao.CommandeDao;
import com.sdzee.tp.dao.DAOException;
import com.sdzee.tp.entities.Client;
import com.sdzee.tp.entities.Commande;

public final class CreationCommandeForm {

	private static final String CHAMP_CHOIX_CLIENT = "choixNouveauClient";
	private static final String CHAMP_LISTE_CLIENTS = "listeClients";
	private static final String CHAMP_DATE = "dateCommande";
	private static final String CHAMP_MONTANT = "montantCommande";
	private static final String CHAMP_MODE_PAIEMENT = "modePaiementCommande";
	private static final String CHAMP_STATUT_PAIEMENT = "statutPaiementCommande";
	private static final String CHAMP_MODE_LIVRAISON = "modeLivraisonCommande";
	private static final String CHAMP_STATUT_LIVRAISON = "statutLivraisonCommande";
	private static final String ANCIEN_CLIENT = "ancienClient";
	private static final String SESSION_CLIENTS = "clients";
	private static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	private ClientDao clientDao;
	private CommandeDao commandeDao;

	public CreationCommandeForm(ClientDao clientDao, CommandeDao commandeDao) {
		this.clientDao = clientDao;
		this.commandeDao = commandeDao;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public String getResultat() {
		return resultat;
	}

	public Commande creerCommande(HttpServletRequest request, String chemin) {

		Client client;

		/*
		 * Si l'utilisateur choisit un client déjà existant, pas de validation à
		 * effectuer
		 */

		String choixNouveauClient = getValeurChamp(request, CHAMP_CHOIX_CLIENT);

		if (ANCIEN_CLIENT.equals(choixNouveauClient)) {
			/* Récupération de l'id du client choisi */

			String idAncienClient = getValeurChamp(request, CHAMP_LISTE_CLIENTS);
			Long id = null;

			try {
				id = Long.parseLong(idAncienClient);
			} catch (NumberFormatException e) {
				setErreur(CHAMP_CHOIX_CLIENT, "Client inconnu,merci d'utiliser le formulaire prévu à cet effet.");
				id = 0L;
			}

			/* Récupération de l'objet client correspondant dans la session */

			HttpSession session = request.getSession();

			client = ((Map<Long, Client>) session.getAttribute(SESSION_CLIENTS)).get(id);
		}

		else {
			/*
			 * Sinon on garde l'ancien mode, pour la validation des champs.
			 * 
			 * L'objet métier pour valider la création d'un client existe déjà,
			 * il est donc déconseillé de dupliquer ici son contenu ! A la
			 * place, il suffit de passer la requête courante à l'objet métier
			 * existant et de récupérer l'objet Client créé.
			 */

			CreationClientForm clientForm = new CreationClientForm(clientDao);
			client = clientForm.creerClient(request, chemin);

			/*
			 * Et très important, il ne faut pas oublier de récupérer le contenu
			 * de la map d'erreurs créée par l'objet métier CréationClientForm
			 * dans la map d'erreurs courante, actuellement vide.
			 */

			erreurs = clientForm.getErreurs();

		}

		/*
		 * Ensuite, il suffit de procéder normalement avec le reste des champs
		 * spécifiques à une commande.
		 */

		/*
		 * Récupération de la date dans un DateTime Joda.
		 */

		DateTime dt = new DateTime();

		String montant = getValeurChamp(request, CHAMP_MONTANT);
		String modePaiement = getValeurChamp(request, CHAMP_MODE_PAIEMENT);
		String statutPaiement = getValeurChamp(request, CHAMP_STATUT_PAIEMENT);
		String modeLivraison = getValeurChamp(request, CHAMP_MODE_LIVRAISON);
		String statutLivraison = getValeurChamp(request, CHAMP_STATUT_LIVRAISON);

		Commande commande = new Commande();

		try {
			traiterClient(client, commande);

			commande.setDate(dt);
			traiterMontant(montant, commande);
			traiterModePaiement(modePaiement, commande);
			traiterStatutPaiement(statutPaiement, commande);
			traiterModeLivraison(modeLivraison, commande);
			traiterStatutLivraison(statutLivraison, commande);

			if (erreurs.isEmpty()) {
				commandeDao.creer(commande);
				resultat = "Succès de la création de la commande.";
			} else {
				resultat = "Echec de la création de la commande.";
			}
		} catch (DAOException e) {
			setErreur("Imprévu", "Erreur imprévue lors de la création.");
			resultat = "Echec de la création de la commande : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return commande;

	}

	private void traiterClient(Client client, Commande commande) {
		if (client == null) {
			setErreur(CHAMP_CHOIX_CLIENT, "Client inconnu,merci d'utiliser le formulaire prévu à cet effet.");
		}
		commande.setClient(client);
	}

	private void traiterMontant(String montant, Commande commande) {
		double valeurMontant = -1;

		try {
			valeurMontant = validationMontant(montant);
		} catch (FormValidationException e) {
			setErreur(CHAMP_MONTANT, e.getMessage());
		}

		commande.setMontant(valeurMontant);
	}

	private void traiterModePaiement(String modePaiement, Commande commande) {
		try {
			validationModePaiement(modePaiement);
		} catch (FormValidationException e) {
			setErreur(CHAMP_MODE_PAIEMENT, e.getMessage());
		}

		commande.setModePaiement(modePaiement);
	}

	private void traiterStatutPaiement(String statutPaiement, Commande commande) {
		try {
			validationStatutPaiement(statutPaiement);
		} catch (FormValidationException e) {
			setErreur(CHAMP_STATUT_PAIEMENT, e.getMessage());
		}

		commande.setStatutPaiement(statutPaiement);
	}

	private void traiterModeLivraison(String modeLivraison, Commande commande) {
		try {
			validationModeLivraison(modeLivraison);
		} catch (FormValidationException e) {
			setErreur(CHAMP_MODE_LIVRAISON, e.getMessage());
		}

		commande.setModeLivraison(modeLivraison);
	}

	private void traiterStatutLivraison(String statutLivraison, Commande commande) {

		try {
			validationStatutLivraison(statutLivraison);
		} catch (FormValidationException e) {
			setErreur(CHAMP_STATUT_LIVRAISON, e.getMessage());
		}

		commande.setStatutLivraison(statutLivraison);
	}

	private double validationMontant(String montant) throws FormValidationException {
		double temp;
		if (montant != null) {
			try {
				temp = Double.parseDouble(montant);
				if (temp < 0) {
					throw new FormValidationException("Le montant doit être un nombre positif.");
				}
			} catch (NumberFormatException e) {
				temp = -1;
				throw new FormValidationException("Le montant doit être un nombre.");
			}
		} else {
			temp = -1;
			throw new FormValidationException("Merci d'entrer un montant.");
		}
		return temp;
	}

	private void validationModePaiement(String modePaiement) throws FormValidationException {
		if (modePaiement != null) {
			if (modePaiement.length() < 2) {
				throw new FormValidationException("Le mode de paiement doit contenir au moins 2 caractères.");
			}
		} else {
			throw new FormValidationException("Merci d'entrer un mode de paiement.");
		}
	}

	private void validationStatutPaiement(String statutPaiement) throws FormValidationException {
		if (statutPaiement != null && statutPaiement.length() < 2) {
			throw new FormValidationException("Le statut de paiement doit contenir au moins 2 caractères.");
		}
	}

	private void validationModeLivraison(String modeLivraison) throws FormValidationException {
		if (modeLivraison != null) {
			if (modeLivraison.length() < 2) {
				throw new FormValidationException("Le mode de livraison doit contenir au moins 2 caractères.");
			}
		} else {
			throw new FormValidationException("Merci d'entrer un mode de livraison.");
		}
	}

	private void validationStatutLivraison(String statutLivraison) throws FormValidationException {
		if (statutLivraison != null && statutLivraison.length() < 2) {
			throw new FormValidationException("Le statut de livraison doit contenir au moins 2 caractères.");
		}
	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs
	 */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon
	 */

	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else
			return valeur;
	}

}
