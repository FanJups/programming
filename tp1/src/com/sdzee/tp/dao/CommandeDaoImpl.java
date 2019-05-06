package com.sdzee.tp.dao;

import static com.sdzee.tp.dao.DAOUtilitaire.fermeturesSilencieuses;
import static com.sdzee.tp.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.sdzee.tp.beans.Commande;

public class CommandeDaoImpl implements CommandeDao {

	private static final String SQL_SELECT = "SELECT id,id_client,date,montant,mode_paiement,statut_paiement,mode_livraison,statut_livraison FROM Commande ORDER BY id";
	private static final String SQL_SELECT_PAR_ID = "SELECT id,id_client,date,montant,mode_paiement,statut_paiement,mode_livraison,statut_livraison FROM Commande WHERE id = ?";
	private static final String SQL_INSERT = "INSERT INTO Commande (id_client,date,montant,mode_paiement,statut_paiement,mode_livraison,statut_livraison) VALUES (?,?,?,?,?,?,?)";
	private static final String SQL_DELETE_PAR_ID = "DELETE FROM Commande WHERE id = ?";

	private DAOFactory daoFactory;

	CommandeDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	/* Implémentation de la méthode définie dans l'interface CommandeDao */

	@Override
	public Commande trouver(long id) throws DAOException {
		return trouver(SQL_SELECT_PAR_ID, id);
	}

	/* Implémentation de la méthode définie dans l'interface CommandeDao */

	@Override
	public void creer(Commande commande) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true, commande.getClient().getId(),
					new Timestamp(commande.getDate().getMillis()), commande.getMontant(), commande.getModePaiement(),
					commande.getStatutPaiement(), commande.getModeLivraison(), commande.getStatutLivraison());

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Echec de la création de la commande,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {
				commande.setId(valeursAutoGenerees.getLong(1));
			} else {
				throw new DAOException("Echec de la création de la commande  en base,aucun ID auto-généré retourné.");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}

	/* Implémentation de la méthode définie dans l'interface ClientDao */
	@Override

	public List<Commande> lister() throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Commande> commandes = new ArrayList<Commande>();

		try {
			connection = daoFactory.getConnection();
			preparedStatement = connection.prepareStatement(SQL_SELECT);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				commandes.add(map(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connection);
		}

		return commandes;
	}

	/* Implémentation de la méthode définie dans l'interface CommandeDao */
	@Override

	public void supprimer(Commande commande) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_DELETE_PAR_ID, true, commande.getId());

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Echec de la suppression de la commande ,aucune ligne supprimée de la table.");
			} else {
				commande.setId(null);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(preparedStatement, connexion);
		}
	}

	/*
	 * Méthode générique utilisée pour retourner une commande depuis la base de
	 * données, correspondant à la requête SQL donnée en prenant en paramètre
	 * les objets passés en argument.
	 */

	private Commande trouver(String sql, Object objets) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Commande commande = null;

		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			/*
			 * Préparation de la requête avec les objets passés en arguments
			 * (ici,uniquement un id) et exécution.
			 */

			preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
			resultSet = preparedStatement.executeQuery();

			/* Parcours de la ligne de données retournée dans le ResultSet */
			if (resultSet.next()) {
				commande = map(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return commande;
	}

	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des commandes (un ResultSet)
	 * et un bean Commande.
	 */

	private Commande map(ResultSet resultSet) throws SQLException {
		Commande commande = new Commande();
		commande.setId(resultSet.getLong("id"));

		/*
		 * Petit changement ici: pour récupérer un client,il nous faut faire
		 * appel à la méthode trouver() du DAO Client,afin de récupérer un bean
		 * Client à partir de l'id présent dans la table Commande.
		 */

		ClientDao clientDao = daoFactory.getClientDao();
		commande.setClient(clientDao.trouver(resultSet.getLong("id_client")));

		commande.setDate(new DateTime(resultSet.getTimestamp("date")));
		commande.setMontant(resultSet.getDouble("montant"));

		commande.setModePaiement(resultSet.getString("mode_paiement"));
		commande.setStatutPaiement(resultSet.getString("statut_paiement"));
		commande.setModeLivraison(resultSet.getString("mode_livraison"));
		commande.setStatutLivraison(resultSet.getString("statut_livraison"));

		return commande;
	}

}
