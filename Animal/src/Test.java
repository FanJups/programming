
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Chien la= new Chien("Noir black",20);
		la.boire();
		la.manger();
		la.deplacement();
		la.crier();
		System.out.println(la.toString());
		
		System.out.println("----------------------------------------");
		
		la.faireCalin();
		la.faireLeBeau();
		la.faireLechouille();
		
		System.out.println("----------------------------------------");
		
		Rintintin r = new Chien();
		
		r.faireLeBeau();
		r.faireCalin();
		r.faireLechouille();
		
		
		
		
		
		
		
		
		
		
		

	}

}
