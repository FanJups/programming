package enadchat.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import enadchat.beans.Utilisateur;
import enadchat.dao.DAOException;
import enadchat.dao.UtilisateurDao;

public final class ConnexionUtilisateurForm {

	private static final String CHAMP_IDENTIFIANT = "identif_utilisateur";

	private static final String CHAMP_MOT_DE_PASSE = "motdepasse_utilisateur";

	private String resultat;

	private Map<String, String> erreurs = new HashMap<String, String>();

	private UtilisateurDao utilisateurDao;

	private Utilisateur utilisateur_good;

	public ConnexionUtilisateurForm(UtilisateurDao utilisateurDao) {

		this.utilisateurDao = utilisateurDao;
	}

	/**
	 * @return the resultat
	 */
	public String getResultat() {
		return resultat;
	}

	/**
	 * @return the erreurs
	 */
	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Utilisateur connecterUtilisateur(HttpServletRequest request) {

		String identifiant_utilisateur = getValeurChamp(request, CHAMP_IDENTIFIANT);

		String mdp_utilisateur = getValeurChamp(request, CHAMP_MOT_DE_PASSE);

		try {

			traiter(identifiant_utilisateur, mdp_utilisateur);

			if (erreurs.isEmpty()) {

				utilisateurDao.utilisateursConnectes(utilisateur_good);

				resultat = "Succès connexion";

			} else {

				resultat = "Echec connexion";

			}

		} catch (DAOException e) {

			resultat = "Echec connexion";
			e.printStackTrace();

		}

		return utilisateur_good;

	}

	private void traiter(String identifiant, String mdp) {

		try {

			validationIdentifiantMdp(identifiant, mdp);

		} catch (FormValidationException e) {

			setErreur(CHAMP_IDENTIFIANT, e.getMessage());

		}

	}

	private void validationIdentifiantMdp(String identifiant, String Mdp) throws FormValidationException {

		utilisateur_good = utilisateurDao.trouverIdentifMdp(identifiant, Mdp);

		if (utilisateur_good == null)

			throw new FormValidationException("Echec connexion, merci de réessayer.");

	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */

	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */

	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else
			return valeur.trim();
	}

}
