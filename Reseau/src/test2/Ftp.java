package test2;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

public class Ftp {

	private String user;
	private Socket socket = null, socketData = null;
	private boolean DEBUG = true;
	private String host;
	private int port;

	private BufferedWriter writer, writerData;
	private BufferedInputStream readerData, reader;
	private String dataIP;
	private int dataPort;

	public Ftp(String ipAddress, int pPort, String pUser) {
		user = pUser;
		port = pPort;
		host = ipAddress;

	}

	public Ftp(String pUser) {
		this("127.0.0.1", 21, pUser);
	}

	/**
	 * Méthode de connexion au FTP
	 * 
	 * @throws IOException
	 */

	public void connect() throws IOException {
		// Si la socket est déjà initialisée
		if (socket != null)
			throw new IOException("La connexion au FTP est déjà activée");

		// On se connecte
		socket = new Socket(host, port);

		// On crée nos objets pour pouvoir communiquer
		reader = new BufferedInputStream(socket.getInputStream());
		writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		String response = read();

		if (!response.startsWith("220")) {
			throw new IOException("Erreur de connexion au FTP : \n" + response);
		}

		send("USER " + user);
		response = read();

		if (!response.startsWith("331")) {
			throw new IOException("Erreur de connexion avec le compte utilisateur : \n" + response);
		}

		// Pas de gestion du mot de passe dans notre cas, mais vous pouvez en
		// préciser un dans le string passwd si vous le souhaitez

		String passwd = "";
		send("PASS " + passwd);
		response = read();

		if (!response.startsWith("230")) {
			throw new IOException("Erreur de connexion avec le compte utilisateur : \n" + response);
		}

		// Nous sommes maintenant connectés
	}

	public void quit() {
		try {
			send("QUIT");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					socket = null;
				}
			}
		}
	}

	/**
	 * Méthode permettant d'initialiser le mode passif et ainsi de pouvoir
	 * communiquer avec le canal dédié aux données
	 * 
	 * @throws IOException
	 */

	private void enterPassiveMode() throws IOException {
		send("PASV");
		String response = read();
		if (DEBUG)
			log(response);
		String ip = null;
		int port = -1;

		/*
		 * On décortique ici la réponse retournée par le serveur pour récupérer
		 * l'adresse IP et le port à utiliser pour le canal data
		 */

		int debut = response.indexOf('(');
		int fin = response.indexOf(')', debut + 1);

		if (debut > 0) {
			String dataLink = response.substring(debut + 1, fin);
			StringTokenizer tokenizer = new StringTokenizer(dataLink, ",");

			try {
				// L'adresse IP est séparée par des virgules
				// on les remplace par des points...
				ip = tokenizer.nextToken() + "." + tokenizer.nextToken() + "." + tokenizer.nextToken() + "."
						+ tokenizer.nextToken();

				// Le port est un entier de type int
				// mais cet entier est découpé en 2
				// la première partie correspond aux 4 premiers bits de l'octet
				// la deuxième aux 4 derniers
				// Il faut donc multiplier le premier nombre par 256 et
				// l'additionner au second
				// pour avoir le numéro de ports défini par le serveur

				port = Integer.parseInt(tokenizer.nextToken()) * 256 + Integer.parseInt(tokenizer.nextToken());
				dataIP = ip;
				dataPort = port;
			} catch (Exception e) {
				throw new IOException("Simple FTP received bad data link information: " + response);
			}
		}

	}

	/**
	 * Méthode initialisant les flux de communication
	 * 
	 * @throws UnknownHostException
	 * @throws IOException
	 */

	private void createDataSocket() throws UnknownHostException, IOException {
		socketData = new Socket(dataIP, dataPort);
		readerData = new BufferedInputStream(socketData.getInputStream());
		writerData = new BufferedWriter(new OutputStreamWriter(socketData.getOutputStream()));
	}

	/**
	 * Retourne l'endroit où nous nous trouvons sur le FTP
	 * 
	 * @return
	 * @throws IOException
	 */

	public String pwd() throws IOException {
		// On envoie la commande
		send("PWD");
		// On lit la réponse
		return read();
	}

	/**
	 * Permet de changer de répertoire (Change Working Directory)
	 * 
	 * @return
	 * @throws IOException
	 */

	public String cwd(String dir) throws IOException {
		// On envoie la commande
		send("CWD " + dir);
		// On lit la réponse
		return read();
	}

	public String list() throws IOException {
		send("TYPE ASCII");
		read();

		enterPassiveMode();
		createDataSocket();
		send("LIST");
		return readData();
	}

	/**
	 * Méthode permettant d'envoyer les commandes au FTP
	 * 
	 * @param command
	 * @throws IOException
	 */

	private void send(String command) throws IOException {
		command += "\r\n";
		if (DEBUG)
			log(command);
		writer.write(command);
		writer.flush();
	}

	/**
	 * Méthode permettant de lire les réponses du FTP
	 * 
	 * @return
	 * @throws IOException
	 */

	private String read() throws IOException {
		String response = "";
		int stream;
		byte[] b = new byte[4096];
		stream = reader.read(b);
		response = new String(b, 0, stream);

		if (DEBUG)
			log(response);
		return response;
	}

	/**
	 * Méthode permettant de lire les réponses du FTP
	 * 
	 * @return
	 * @throws IOException
	 */

	private String readData() throws IOException {
		String response = "";
		int stream;
		byte[] b = new byte[1024];

		while ((stream = readerData.read(b)) != -1) {
			response += new String(b, 0, stream);
		}

		if (DEBUG)
			log(response);
		return response;
	}

	public void debugMode(boolean active) {
		DEBUG = active;
	}

	private void log(String str) {
		System.out.println(">> " + str);
	}

}
