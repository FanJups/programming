package enadchat.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import enadchat.beans.Utilisateur;
import enadchat.dao.DAOException;
import enadchat.dao.UtilisateurDao;

public final class InscriptionUtilisateurForm {

	private static final String CHAMP_NOMS_PRENOMS = "np_utilisateur";

	private static final String CHAMP_IDENTIFIANT = "identif_utilisateur";

	private static final String CHAMP_MOT_DE_PASSE = "motdepasse_utilisateur";

	private String resultat;

	private Map<String, String> erreurs = new HashMap<String, String>();

	private UtilisateurDao utilisateurDao;

	public InscriptionUtilisateurForm(UtilisateurDao utilisateurDao) {

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

	public Utilisateur inscrireUtilisateur(HttpServletRequest request) {

		Utilisateur utilisateur = new Utilisateur();

		String identifiant_utilisateur = getValeurChamp(request, CHAMP_IDENTIFIANT);

		String mdp_utilisateur = getValeurChamp(request, CHAMP_MOT_DE_PASSE);

		String noms_prenoms_utilisateur = getValeurChamp(request, CHAMP_NOMS_PRENOMS);

		try {

			traiter(identifiant_utilisateur, mdp_utilisateur, noms_prenoms_utilisateur, utilisateur);

			if (erreurs.isEmpty()) {

				utilisateurDao.creer(utilisateur);

				utilisateurDao.utilisateursConnectes(utilisateur);

				resultat = "Succès inscription";

			} else {

				resultat = "Echec inscription";

			}

		} catch (DAOException e) {

			resultat = "Echec inscription";
			e.printStackTrace();

		}

		return utilisateur;

	}

	private void traiter(String identifiant, String mdp, String np, Utilisateur utilisateur) {

		try {
			validationIdentifiant(identifiant);
		} catch (FormValidationException e) {

			setErreur(CHAMP_IDENTIFIANT, e.getMessage());

		}

		utilisateur.setIdentifiant_utilisateur(identifiant);

		utilisateur.setMdp_utilisateur(mdp);

		utilisateur.setNoms_prenoms_utilisateur(np);

	}

	private void validationIdentifiant(String identifiant) throws FormValidationException {

		if (identifiant != null && identifiant.trim().length() != 0) {

			if (utilisateurDao.trouver(identifiant) != null) {

				throw new FormValidationException("Cet identifiant est déjà utilisé, merci d'en choisir un autre.");
			}
		}
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
