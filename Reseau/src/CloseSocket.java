import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class CloseSocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Socket sock = null;
		try {
			// On se connecte à OpenClassrooms
			sock = new Socket("www.openclassrooms.com", 80);

			// ...
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sock != null) {
				try {
					sock.close();
				} catch (IOException e) {
					e.printStackTrace();
					sock = null;
				}
			}
		}

	}

}
