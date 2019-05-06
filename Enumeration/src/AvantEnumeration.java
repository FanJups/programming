
public class AvantEnumeration {
	
	
	
	public void fait (Langage param){
		if(param.equals(Langage.JAVA))
			System.out.println("Fait à la façon N°1");
		if(param.equals(Langage.PHP))
			System.out.println("Fait à la façon N°2");
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AvantEnumeration ae =new AvantEnumeration();
		ae.fait(Langage.JAVA);
		ae.fait(Langage.PHP);
		

	}

}
