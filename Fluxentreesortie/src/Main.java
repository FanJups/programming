import java.io.File;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Création de l'objet File
		
		File f =new File("testdf.txt");
		
		System.out.println("Chemin absolu du fichier: "+f.getAbsolutePath());
		
		System.out.println("Nom du fichier: "+f.getName());
		
		System.out.println("Est-ce qu'il existe ? "+f.exists());
		
		System.out.println("Est-ce un répertoire ? "+f.isDirectory());
		
		System.out.println("Est-ce un fichier ? "+f.isFile());
		
		System.out.println("Affichage des lecteurs à la racine du PC : ");
		
		for(File file:f.listRoots())
		{
			System.out.println(file.getAbsolutePath());
			try{
				int i=1;
				
				//On parcourt la liste des fichiers et répertoires
				
				for(File nom: file.listFiles()){
					System.out.print("\t\t"+((nom.isDirectory())? nom.getName()+"/":nom.getName()));
					
					if((i%4)==0){
						System.out.print("\n");
					}
					i++;
				}
				System.out.println("\n");
			}catch(NullPointerException e){
				
			}
		}
		

	}

}
