import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;

public class TestProxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// On crée une adresse correspondant à notre proxy (fictif)
		SocketAddress proxyAddress = new InetSocketAddress("10.10.10.10", 8080);

		// On instancie la classe Proxy avec le type souhaité
		Proxy proxy = new Proxy(Proxy.Type.SOCKS, proxyAddress);

		// On crée notre socket utilisant le proxy
		Socket s = new Socket(proxy);

		// On crée l'adresse que l'on souhaite atteindre via le proxy
		SocketAddress remote = new InetSocketAddress("www.openclassrooms.com", 80);

		try {
			// On connecte le tout !
			s.connect(remote);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
