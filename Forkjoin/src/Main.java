import java.nio.file.Path;
import java.nio.file.Paths;
public class Main {
	
	public static void main (String[] args) {
		
		Path chemin= Paths.get("C:\\Users");
		String filtre="*.jpg";
		FolderScanner fs= new FolderScanner(chemin,filtre);
		
		try {
			Long start= System.currentTimeMillis();
			Long resultat= fs.sequentialScan();
			Long end=System.currentTimeMillis();
			System.out.println("Il y a "+resultat+" fichier(s) portant l'extension "+filtre);
			
			System.out.println("Temps de traitement : " + (end-start));
		}catch(ScanException e){
			e.printStackTrace();
		}
	}

}
