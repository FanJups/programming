package enadchat.dao;

import static enadchat.dao.DAOUtilitaire.fermeturesSilencieuses;
import static enadchat.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import enadchat.beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {

	private static final String SQL_SELECT_PAR_IDENTIFIANT_UTILISATEUR = "SELECT * FROM utilisateur WHERE identifiant_utilisateur = ?";

	private static final String SQL_SELECT_UTILISATEURS_CONNECTES = "SELECT identifiant_utilisateurs_connectes FROM utilisateurs_connectes ORDER BY date_utilisateurs_connectes DESC ";

	private static final String SQL_SELECT_PAR_IDENTIFIANT_MDP_UTILISATEUR = "SELECT * FROM utilisateur WHERE identifiant_utilisateur = ? AND mdp_utilisateur = ? ";

	private static final String SQL_INSERT = "INSERT INTO utilisateur (identifiant_utilisateur,noms_prenoms_utilisateur,mdp_utilisateur,date_heure_inscription_utilisateur) VALUES(?,?,?,NOW())";

	private static final String SQL_INSERT_UTILISATEURS_CONNECTES = "INSERT INTO utilisateurs_connectes (identifiant_utilisateurs_connectes,date_utilisateurs_connectes) VALUES(?,NOW())";

	private DAOFactory daoFactory;

	UtilisateurDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;

	}

	/*
	 * Implémentation de la méthode trouverIdnetifMdp() définie dans l'interface
	 * UtilisateurDao
	 * 
	 * 
	 */

	@Override
	public Utilisateur trouverIdentifMdp(String identifiant_utilisateur, String mdp_utilisateur) throws DAOException {

		return trouver(SQL_SELECT_PAR_IDENTIFIANT_MDP_UTILISATEUR, identifiant_utilisateur, mdp_utilisateur);
	}

	/*
	 * Implémentation de la méthode trouver_utilisateurs_connectes() définie
	 * dans l'interface UtilisateurDao
	 */

	@Override

	public ArrayList<Utilisateur> trouver_utilisateurs_connectes() throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_UTILISATEURS_CONNECTES, true);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				utilisateurs.add(trouver(resultSet.getString("identifiant_utilisateurs_connectes")));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return utilisateurs;

	}

	/*
	 * Implémentation de la méthode trouver() définie dans l'interface
	 * UtilisateurDao
	 */

	@Override
	public Utilisateur trouver(String identifiant_utilisateur) throws DAOException {

		return trouver(SQL_SELECT_PAR_IDENTIFIANT_UTILISATEUR, identifiant_utilisateur);
	}

	private Utilisateur trouver(String sql, Object... objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Utilisateur utilisateur = null;

		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			/*
			 * Préparation de la requête avec les objets passés en arguments
			 * (ici,uniquement un identifiant_medecin) et exécution.
			 */

			preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
			resultSet = preparedStatement.executeQuery();

			/* Parcours de la ligne de données retournée dans le ResultSet */

			if (resultSet.next()) {
				utilisateur = map(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return utilisateur;
	}

	public void supprimerUtilisateursConnectes(Utilisateur utilisateur) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"DELETE FROM utilisateurs_connectes  WHERE identifiant_utilisateurs_connectes = '"
							+ utilisateur.getIdentifiant_utilisateur() + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de la suppression de l'utilisateur,aucune ligne supprimée dans la table. ");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}

	/*
	 * Implémentation de la méthode utilisateursConnectes() définie dans
	 * l'interface UtilisateurDao
	 */
	@Override

	public void utilisateursConnectes(Utilisateur utilisateur) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_UTILISATEURS_CONNECTES, true,
					utilisateur.getIdentifiant_utilisateur());

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de l'insertion de l'utilisateur,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {

			} else {

				throw new DAOException("Échec de l'insertion de l'utilisateur en base,aucun ID auto-généré retourné.");

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}

	/*
	 * Implémentation de la méthode creer() définie dans l'interface
	 * UtilisateurDao
	 */

	@Override

	public void creer(Utilisateur utilisateur) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true,
					utilisateur.getIdentifiant_utilisateur(), utilisateur.getNoms_prenoms_utilisateur(),
					utilisateur.getMdp_utilisateur());

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la création de l'utilisateur,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {

				utilisateur.setId_utilisateur(valeursAutoGenerees.getLong(1));

			} else {

				throw new DAOException("Échec de la création de l'utilisateur en base,aucun ID auto-généré retourné.");

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}

	private static Utilisateur map(ResultSet resultSet) throws SQLException {

		Utilisateur utilisateur = new Utilisateur();

		utilisateur.setId_utilisateur(resultSet.getLong("id_utilisateur"));

		utilisateur.setIdentifiant_utilisateur(resultSet.getString("identifiant_utilisateur"));

		utilisateur.setNoms_prenoms_utilisateur(resultSet.getString("noms_prenoms_utilisateur"));

		utilisateur.setMdp_utilisateur(resultSet.getString("mdp_utilisateur"));

		utilisateur.setDate_heure_inscription_utilisateur(resultSet.getTimestamp("date_heure_inscription_utilisateur"));

		return utilisateur;
	}

}
