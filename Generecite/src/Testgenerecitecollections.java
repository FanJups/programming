import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
public class Testgenerecitecollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Liste de String");
		
		System.out.println("--------------------");
		
		List<String> listeString= new ArrayList<String>();
		listeString.add("Une chaine");
		listeString.add("Une autre");
		listeString.add("Encore uen autre");
		listeString.add("Allez une dernière");
		
		for(String str:listeString)
			System.out.println(str);
		System.out.println("\n Liste de float");
		System.out.println("--------------------");
		
		List<Float> listeFloat= new ArrayList<Float>();
		listeFloat.add(12.25f);
		listeFloat.add(15.25f);
		listeFloat.add(2.25f);
		listeFloat.add(128764.25f);
		
		for(Float f:listeFloat)
			System.out.println(f);
		
		
		
		

	}

}
