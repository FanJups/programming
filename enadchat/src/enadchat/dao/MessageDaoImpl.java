package enadchat.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import enadchat.beans.Message;

public class MessageDaoImpl implements MessageDao {

	private DAOFactory daoFactory;

	MessageDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;

	}

	private static Message map(ResultSet resultSet) throws SQLException {

		Message message = new Message();

		message.setId_message(resultSet.getLong("id_message"));

		message.setTexte_message(resultSet.getString("texte_message"));

		message.setIdentifiant_emetteur(resultSet.getString("identifiant_emetteur"));

		message.setIdentifiant_destinataire(resultSet.getString("identifiant_destinataire"));

		message.setDate_heure_creation_message(resultSet.getTimestamp("date_heure_creation_message"));

		return message;

	}

}
