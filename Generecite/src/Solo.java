
public class Solo<T> {
	
	private T valeur;
	
	public Solo(){
		
		this.valeur=null;
		
	}
	
    public Solo(T val){
    	
    	this.valeur=val;
		
	}
    
    public void setValeur(T val){
    	this.valeur=val;
    }
    
    public T getValeur(){
    	return this.valeur;
    }

}
