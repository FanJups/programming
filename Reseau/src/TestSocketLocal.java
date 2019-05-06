import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestSocketLocal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 1; i <= 1024; i++) {
			try {
				Socket soc = new Socket("127.0.0.1", i);
				System.out.println("La machine autorise les connexions sur le port : " + i);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// Si une connexion de ce type est levée
				// c'est que le port n'est pas ouvert ou n'est pas autorisé
			}
		}

	}

}
