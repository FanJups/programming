
public class Duo<T,S> {
	
	private T valeur1;
	
	private S valeur2;
	
	public Duo(){
		this.valeur1=null;
		this.valeur2=null;
		
	}
	public Duo(T val1,S val2){
		this.valeur1=val1;
		this.valeur2=val2;
	}
	
	public void setValeur(T val1, S val2){
		this.valeur1=val1;
		this.valeur2=val2;
	}
	
	public T getValeur1(){
		return valeur1;
	}
	
	public void setValeur1(T valeur1){
		this.valeur1=valeur1;
	}
	
	public S getValeur2(){
		return valeur2;
	}
	
	public void setValeur2(S valeur2){
		this.valeur2=valeur2;
	}
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Duo<String, Boolean> dual= new Duo<String,Boolean>("toto",true);
		
		System.out.println("Valeur de l'objet dual: val1 = "+dual.getValeur1() +", val2 = "+dual.getValeur2());

		Duo<Double, Character> dual2= new Duo<Double, Character>(12.2585,'C');
		
		System.out.println("Valeur de l'objet dual2: val1 = "+dual2.getValeur1() +", val2 = "+dual2.getValeur2());
	}

}
