import com.sdz.comportement.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Personnage pers = new Guerrier();
		pers.soigner();
		pers.setSoin(new Operation());
		pers.soigner();

	}

}
