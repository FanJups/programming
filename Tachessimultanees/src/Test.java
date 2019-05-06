
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println("Le nom du thread principal est "+Thread.currentThread().getName());
		
		/*TestThread t = new TestThread("A");
		TestThread t2 = new TestThread("B",t);
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		System.out.println("statut du thread "+t.getName()+"="+t.getState());
		
		System.out.println("statut du thread "+t2.getName()+"="+t2.getState());*/
		
		CompteEnBanque cb = new CompteEnBanque();
		
		
		Thread t = new Thread (new RunImpl (cb,"Cysboy"));
		Thread t2 = new Thread (new RunImpl (cb,"Zéro"));
		
		t.start();
		t2.start();
		

	}

}
