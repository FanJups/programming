import com.sdz.controler.*;
import com.sdz.model.*;
import com.sdz.vue.Calculette;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Instanciation de notre modèle
		AbstractModel calc = new Calculator();
		
		//Création du contrôleur
		AbstractControler controler = new CalculetteControler(calc);
		
		//Création de notre fenêtre avec le contrôleur en paramètre
		Calculette calculette = new Calculette(controler);
		
		//Ajout de la fenêtre comme observer de notre modèle
		calc.addObserver(calculette);

	}

}
