import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class IsoContest {

	public static void main(String[] args) {

		String fichier = "/input1.txt";
		int N = 0;
		int k = 0;
		int nbreEntrees = 0;

		String result = ""; // Initialisation du résultat

		List<Double> image = new ArrayList<>();

		List<Double> imageIteree = new ArrayList<>();

		double Nsur2;

		for (int i = 0; i < IsoContest.recupFichier(fichier).size(); i++) {

			String line = IsoContest.recupFichier(fichier).get(i);

			if (i == 0)
				N = Integer.parseInt(line);

			if (i == 1)

				image = Arrays.stream(line.split(" ")).mapToDouble(Double::valueOf).boxed()
						.collect(Collectors.toList());

			if (i == 2)
				k = Integer.parseInt(line);

		}

		Nsur2 = ((double) N) / 2;

		for (int i = 0; i < image.size(); i++) {

			double x = fonctionIteree(k, i, image);

			imageIteree.add(x);
		}

		///////////////////////

		for (int i = 0; i <= N - 1; i++) {

			double fiIteree;
			double fiplusunIteree;
			double fiItereePrec;
			double fiplusunItereePrec;

			// intervalle i < x < i+1

			int kinit = 1;

			while (kinit <= k) {

				if (kinit == 1) {

					// Les antécédents sont i et i+1

					// Etant donné que i et i+1 se suivent f est soit croissante soit décroissante

					fiIteree = fonctionIteree(kinit, i, image);

					fiplusunIteree = fonctionIteree(kinit, i + 1, image);

					// f croissante

					// fiIteree < fx < fiplusunIteree

					if (fiIteree < fiplusunIteree)

						if (k == kinit)
							if (fiIteree < Nsur2 && Nsur2 < fiplusunIteree)
								nbreEntrees++;

					// f décroissante

					// fiplusunIteree < fx < fiIteree

					if (fiplusunIteree < fiIteree)
						if (k == kinit)
							if (fiplusunIteree < Nsur2 && Nsur2 < fiIteree)
								nbreEntrees++;

				} else {

					// kinit >=2

					// Les antécédents sont fiItereePrec et fiplusunItereePrec

					fiItereePrec = fonctionIteree(kinit - 1, i, image);

					fiplusunItereePrec = fonctionIteree(kinit - 1, i + 1, image);

					/*
					 * Les images sont :
					 * 
					 * fiIteree = fonctionIteree(kinit, i, image);
					 * 
					 * fiplusunIteree = fonctionIteree(kinit, i + 1, image);
					 */

					// Comportement de f borné par les anté fiItereePrec & fiplusunItereePrec

					// f est soit croissante soit décroissante soit un mix des 2

					// 2 cas possibles

					// 0...N

					int min = (int) Math.min(fiItereePrec, fiplusunItereePrec);

					int max = (int) Math.max(fiItereePrec, fiplusunItereePrec);

					for (int j = min; j < max; j++) {

						double fj = image.get(j);

						double fjplusun = image.get(j + 1);

						// f croissante
						if (fj < fjplusun)
							if (k == kinit)
								if (fj < Nsur2 && Nsur2 < fjplusun)
									nbreEntrees++;

						// f décroissante
						if (fjplusun < fj)
							if (k == kinit)
								if (fjplusun < Nsur2 && Nsur2 < fj)
									nbreEntrees++;

					}

				} // else kinit >=2

				kinit++;

			} // while

		} // for

		nbreEntrees = nbreEntrees + Collections.frequency(imageIteree, Nsur2);

		result = nbreEntrees % 1000 + "";

		System.out.println("liste  : " + image);

		System.out.println("liste itérée : " + imageIteree);

		System.out.println(result);

		///////////////////////

	}

	public static double fonctionIteree(int k, int indice, List<Double> image) {
		if (k == 1)
			return image.get(indice);
		else {
			return image.get((int) fonctionIteree(k - 1, indice, image));
		}

	}

	// Récupération des données du fichier de base

	public static ArrayList<String> recupFichier(String urlFichier) {

		ArrayList<String> lignes = new ArrayList<String>();

		URL url = IsoContest.class.getResource(urlFichier);

		File f = new File(url.getFile());

		FileInputStream fis = null;

		if (f.exists()) {
			if (f.isFile()) {
				// Début du traitement

				try {
					fis = new FileInputStream(f);

					byte[] buf = new byte[2048];

					int count = 0;

					int n = 0;

					String ligne = "";

					while ((n = fis.read(buf)) >= 0) {
						for (int i = 0; i < n; i++) {

							if (buf[i] != '\n') {
								ligne = ligne + (char) buf[i];

								if (i == n - 1) // enregistrement dernière ligne
									lignes.add(ligne);
							}

							if (buf[i] == '\n') {

								// System.out.println(ligne);

								lignes.add(ligne);
								count++;

								ligne = "";
								/*
								 * Compter le nombre de retour à la ligne Sachant que le nombre de lignes se
								 * trouve en ajoutant 1 au nombre final de retour à la ligne
								 */
							}

						} // for

					} // while

				} catch (FileNotFoundException e) {

					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {

					try {
						if (fis != null)
							fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		} else {

			System.out.println("Fichier " + urlFichier + " introuvable");

		}
		return lignes;

	}

}
