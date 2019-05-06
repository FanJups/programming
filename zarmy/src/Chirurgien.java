import com.sdz.comportement.*;


public class Chirurgien extends Personnage {
	

    
	public Chirurgien(){
		this.soin = new Operation();
	}
		
		public Chirurgien(EspritCombatif esprit, Soin soin, Deplacement dep){
			super(esprit,soin,dep);
		}

}
