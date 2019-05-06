package com.sdzee.tp.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class DAOFactory {

	private static final String FICHIER_PROPERTIES = "/com/sdzee/tp/dao/dao.properties";
	private static final String PROPERTY_URL = "url";
	private static final String PROPERTY_DRIVER = "driver";
	private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
	private static final String PROPERTY_MOT_DE_PASSE = "motdepasse";

	static /* package */BoneCP connectionPool = null;

	/* package */ DAOFactory(BoneCP connectionPool) {
		this.connectionPool = connectionPool;
	}

	private String url;
	private String username;
	private String password;

	DAOFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	/*
	 * Méthode chargée de récuperer les informations de connexion à la base de
	 * données, charger le driver JDBC et retourner une instance de la Factory
	 */

	public static DAOFactory getInstance() throws DAOConfigurationException

	{
		Properties properties = new Properties();
		String url;
		String driver;
		String nomUtilisateur;
		String motDePasse;

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream fichierProperties = classLoader.getResourceAsStream(FICHIER_PROPERTIES);

		if (fichierProperties == null) {
			throw new DAOConfigurationException("Le fichier properties " + FICHIER_PROPERTIES + " est introuvable.");

		}
		try {
			properties.load(fichierProperties);
			url = properties.getProperty(PROPERTY_URL);
			driver = properties.getProperty(PROPERTY_DRIVER);
			nomUtilisateur = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
			motDePasse = properties.getProperty(PROPERTY_MOT_DE_PASSE);
		} catch (FileNotFoundException e) {
			throw new DAOConfigurationException("Le fichier properties " + FICHIER_PROPERTIES + " est introuvable.", e);
		}

		catch (IOException e) {
			throw new DAOConfigurationException("Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e);
		}

		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			throw new DAOConfigurationException("Le driver est introuvable dans le classpath.", e);
		}

		try {
			/*
			 * Création d'une configuration de pool de connexions via l'objet
			 * BoneCPConfig et les différents setters associés.
			 */

			BoneCPConfig config = new BoneCPConfig();
			/* Mise en place de l'URL,du nom et du mot de passe */
			config.setJdbcUrl(url);
			config.setUsername(nomUtilisateur);
			config.setPassword(motDePasse);
			/* Paramétrage de la taille du pool */
			config.setMinConnectionsPerPartition(5);
			config.setMaxConnectionsPerPartition(10);
			config.setPartitionCount(2);
			/*
			 * Création du pool à partir de la configuration,via l'objet BoneCP
			 */
			connectionPool = new BoneCP(config);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOConfigurationException("Erreur de configuration du pool de connexions.", e);
		}

		/*
		 * Enregistrement du pool créé dans une variable d'instance via un appel
		 * au constructeur de DAOFactory
		 */

		DAOFactory instance = new DAOFactory(connectionPool);
		return instance;
	}

	/* Méthode chargée de fournir une connexion à la base de données */
	/* package */Connection getConnection() throws SQLException {
		return connectionPool.getConnection();
	}

	/*
	 * Méthode de récupération de l'implémentation des différents DAO
	 * (uniquement deux dans le cadre de ce TP
	 */

	public ClientDao getClientDao() {
		return new ClientDaoImpl(this);
	}

	public CommandeDao getCommandeDao() {
		return new CommandeDaoImpl(this);
	}

}
