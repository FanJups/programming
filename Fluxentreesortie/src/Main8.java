import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file = new File ("testFileWriter.txt");
		FileWriter fw;
		FileReader fr;
		
		try {
			
			// Création de l'objet
			
			fw =new FileWriter(file);
			String str="Bonjour à tous, amis Zéros !\n";
			str+="\t Comment allez-vous ? \n";
			
			//On écrit la chaîne
			
			fw.write(str);
			// On ferme le flux
			
			fw.close();
			
			// Création de l'objet de lecture
			
			fr = new FileReader(file);
			str="";
			int i =0;
			
			// Lecture des données
			
			while((i=fr.read())!=-1)
				str+= (char)i;
			
			// Affichage
			
			System.out.println(str);
			
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
			
		}

	}

}
