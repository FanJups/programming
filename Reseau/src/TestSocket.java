import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestSocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket soc1 = new Socket(InetAddress.getByName("www.openclassrooms.com"), 80);
			Socket soc2 = new Socket("www.openclassrooms.com", 80);
			Socket soc3 = new Socket("toto", 80);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
