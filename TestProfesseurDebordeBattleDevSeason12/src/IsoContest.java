import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class IsoContest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fichier = "/input2.txt";
		int N = 0;
		List<Etudiant> listeEtudiants = new ArrayList<Etudiant>();
		Set<Integer> listeSizes = new HashSet<Integer>();

		for (int i = 0; i < IsoContest.recupFichier(fichier).size(); i++) {
			String line = IsoContest.recupFichier(fichier).get(i);
			// System.err.println(line);

			if (i == 0)
				N = Integer.parseInt(line);
			else {

				System.err.println(Arrays.asList(line.split(" ")));

				int creneau1 = Integer.parseInt(line.split(" ")[0]);
				int creneau2 = Integer.parseInt(line.split(" ")[1]);

				String identifiant = UUID.randomUUID().toString();
				Etudiant elt = new Etudiant(creneau1, creneau2, identifiant);
				listeEtudiants.add(elt);
			}

		} // for

		final int finalN = N;

		listeEtudiants.stream().parallel().forEach(et1 -> {

			listeEtudiants.stream().parallel().forEach(et2 -> {

				if (!et1.equals(et2))
					et1.traitementListeCreneaux(et2);
			});
		});

		listeEtudiants.stream().parallel().forEach(etudiant -> {

			listeSizes.add(etudiant.getListeEtudiantsCompatiblesCreneau1().size());

			listeSizes.add(etudiant.getListeEtudiantsCompatiblesCreneau2().size());
		});

		// System.out.println("MAX ---> " + Collections.max(listeSizes));

		// System.out.println("N ---> " + N);

		if (Collections.max(listeSizes) == N) {

			LinkedHashMap<Etudiant, Integer> newList = new LinkedHashMap<>(); // liste size == N

			listeEtudiants.stream().parallel().forEach(etudiant -> {

				if (etudiant.getListeEtudiantsCompatiblesCreneau1().size() == finalN) {

					newList.putAll(etudiant.getListeEtudiantsCompatiblesCreneau1());

					return;

				}

				if (etudiant.getListeEtudiantsCompatiblesCreneau2().size() == finalN) {

					newList.putAll(etudiant.getListeEtudiantsCompatiblesCreneau2());

					return;

				}

			});

			LinkedHashMap<Etudiant, Integer> newList2 = new LinkedHashMap<>(); // Etudiant + type créneau

			newList.forEach((k, v) -> {

				if (v == k.getCreneau1())
					if (!newList2.containsKey(k))
						newList2.put(k, 1);

				if (v == k.getCreneau2())
					if (!newList2.containsKey(k))
						newList2.put(k, 2);
			});

			/// Ordre d'entrée

			LinkedHashMap<Etudiant, Integer> finalList = new LinkedHashMap<>();

			listeEtudiants.stream().parallel().forEachOrdered(etudiant -> {

				newList2.forEach((k, v) -> {

					if (etudiant.equals(k))
						if (!finalList.containsKey(k))
							finalList.put(k, v);
				});
			});

			// Affichage

			finalList.forEach((k, v) -> {
				System.out.println(v);
			});

		} else {

			System.out.println("KO");

		}

	}

	static class Etudiant {
		private int creneau1;
		private int creneau2;

		private String idEtudiant;
		private LinkedHashMap<Etudiant, Integer> listeEtudiantsCompatiblesCreneau1 = new LinkedHashMap<>();
		private LinkedHashMap<Etudiant, Integer> listeEtudiantsCompatiblesCreneau2 = new LinkedHashMap<>();

		public Etudiant(int creneau1, int creneau2, String idEtudiant) {
			this.creneau1 = creneau1;
			this.creneau2 = creneau2;

			this.idEtudiant = idEtudiant;

			this.listeEtudiantsCompatiblesCreneau1.put(this, this.creneau1);
			this.listeEtudiantsCompatiblesCreneau2.put(this, this.creneau2);

		}

		public int getCreneau1() {
			return creneau1;
		}

		public int getCreneau2() {
			return creneau2;
		}

		public String getIdEtudiant() {
			return idEtudiant;
		}

		public LinkedHashMap<Etudiant, Integer> getListeEtudiantsCompatiblesCreneau1() {
			return listeEtudiantsCompatiblesCreneau1;
		}

		public LinkedHashMap<Etudiant, Integer> getListeEtudiantsCompatiblesCreneau2() {
			return listeEtudiantsCompatiblesCreneau2;
		}

		@Override
		public boolean equals(Object object) {
			if (object == null) {
				return false;
			} else if (!(object instanceof Etudiant)) {
				return false;
			} else {
				Etudiant etudiant = (Etudiant) object;
				if (idEtudiant == etudiant.getIdEtudiant() && creneau1 == etudiant.getCreneau1()
						&& creneau2 == etudiant.getCreneau2()) {
					return true;
				}
			}
			return false;
		}

		public static boolean siCreneauxCompatibles(int creneauDeCetEtudiant, int creneauAutreEtudiant) {
			boolean test = false;

			int finCreneauDeCetEtudiant = creneauDeCetEtudiant + 60;

			int finCreneauAutreEtudiant = creneauAutreEtudiant + 60;

			if ((finCreneauAutreEtudiant > finCreneauDeCetEtudiant && finCreneauAutreEtudiant > creneauDeCetEtudiant
					&& creneauAutreEtudiant > finCreneauDeCetEtudiant && creneauAutreEtudiant > creneauDeCetEtudiant)
					|| (finCreneauAutreEtudiant < finCreneauDeCetEtudiant
							&& finCreneauAutreEtudiant < creneauDeCetEtudiant
							&& creneauAutreEtudiant < finCreneauDeCetEtudiant
							&& creneauAutreEtudiant < creneauDeCetEtudiant)) {
				test = true;

			}

			return test;
		}

		public void traitementListeCreneaux(Etudiant autreEtudiant) {

			// idée : créer liste 1 & 2 simultanément multithreading

			// Creneau 1 de cet étudiant this

			if (Etudiant.siCreneauxCompatibles(this.creneau1, autreEtudiant.getCreneau1())
					&& Etudiant.siCreneauxCompatibles(this.creneau1, autreEtudiant.getCreneau2())) {

				Etudiant.ajouterEtudiantDansUneListe(this.listeEtudiantsCompatiblesCreneau1, autreEtudiant,
						autreEtudiant.getCreneau1());

				Etudiant.ajouterEtudiantDansUneListe(this.listeEtudiantsCompatiblesCreneau1, autreEtudiant,
						autreEtudiant.getCreneau2());

			}

			if (Etudiant.siCreneauxCompatibles(this.creneau1, autreEtudiant.getCreneau1()) == true
					&& Etudiant.siCreneauxCompatibles(this.creneau1, autreEtudiant.getCreneau2()) == false) {
				Etudiant.ajouterEtudiantDansUneListe(this.listeEtudiantsCompatiblesCreneau1, autreEtudiant,
						autreEtudiant.getCreneau1());

			}

			if (Etudiant.siCreneauxCompatibles(this.creneau1, autreEtudiant.getCreneau1()) == false
					&& Etudiant.siCreneauxCompatibles(this.creneau1, autreEtudiant.getCreneau2()) == true) {
				Etudiant.ajouterEtudiantDansUneListe(this.listeEtudiantsCompatiblesCreneau1, autreEtudiant,
						autreEtudiant.getCreneau2());
			}

			// Creneau 2 de cet étudiant this

			if (Etudiant.siCreneauxCompatibles(this.creneau2, autreEtudiant.getCreneau1())
					&& Etudiant.siCreneauxCompatibles(this.creneau2, autreEtudiant.getCreneau2())) {
				Etudiant.ajouterEtudiantDansUneListe(this.listeEtudiantsCompatiblesCreneau2, autreEtudiant,
						autreEtudiant.getCreneau1());

				Etudiant.ajouterEtudiantDansUneListe(this.listeEtudiantsCompatiblesCreneau2, autreEtudiant,
						autreEtudiant.getCreneau2());

			}

			if (Etudiant.siCreneauxCompatibles(this.creneau2, autreEtudiant.getCreneau1()) == true
					&& Etudiant.siCreneauxCompatibles(this.creneau2, autreEtudiant.getCreneau2()) == false) {
				Etudiant.ajouterEtudiantDansUneListe(this.listeEtudiantsCompatiblesCreneau2, autreEtudiant,
						autreEtudiant.getCreneau1());

			}

			if (Etudiant.siCreneauxCompatibles(this.creneau2, autreEtudiant.getCreneau1()) == false
					&& Etudiant.siCreneauxCompatibles(this.creneau2, autreEtudiant.getCreneau2()) == true) {
				Etudiant.ajouterEtudiantDansUneListe(this.listeEtudiantsCompatiblesCreneau2, autreEtudiant,
						autreEtudiant.getCreneau2());

			}

		}

		public static void sortingAscendingOrder(LinkedHashMap<Etudiant, Integer> list) {
			LinkedHashMap<Etudiant, Integer> newList = new LinkedHashMap<>();

			list.entrySet().stream().sorted(Map.Entry.comparingByValue())
					.forEachOrdered(x -> newList.put(x.getKey(), x.getValue()));

			list.clear();

			list.putAll(newList);

		}

		public static void ajouterEtudiantDansUneListe(LinkedHashMap<Etudiant, Integer> list, Etudiant autreEtudiant,
				int creneau) {

			if (list.containsKey(autreEtudiant) == false && list.containsValue(creneau) == false) {

				if (list.size() == 1) {

					list.put(autreEtudiant, creneau);

				} else {

					// size > 1

					// Object maxEntry = Collections.max(sortedEncheresMap.entrySet(),
					// Map.Entry.comparingByValue()).getKey();

					// int min = Collections.min(list.entrySet(),
					// Map.Entry.comparingByValue()).getValue();

					int min = list.values().stream().parallel().min(Integer::compare).get();

					// int max = Collections.max(list.entrySet(),
					// Map.Entry.comparingByValue()).getValue();

					int max = list.values().stream().parallel().max(Integer::compare).get();

					if (creneau < min) {
						if (Etudiant.siCreneauxCompatibles(min, creneau) == true) {
							list.put(autreEtudiant, creneau);

						}
					}

					if (creneau > max) {
						if (Etudiant.siCreneauxCompatibles(max, creneau) == true) {
							list.put(autreEtudiant, creneau);

						}

					}

					if (!(creneau < min || creneau > max)) {
						List<Integer> smallerThan = new ArrayList<Integer>();

						List<Integer> biggerThan = new ArrayList<Integer>();

						/*
						 * for (Map.Entry<Etudiant, Integer> entry : list.entrySet()) {
						 * 
						 * 
						 * 
						 * if(creneau > entry.getValue()) { smallerThan.add(entry.getValue()); }
						 * 
						 * if(creneau < entry.getValue()) { biggerThan.add(entry.getValue()); }
						 * 
						 * }
						 */

						smallerThan = list.values().stream().parallel().filter(value -> value < creneau)
								.collect(Collectors.toList());

						biggerThan = list.values().stream().parallel().filter(value -> value > creneau)
								.collect(Collectors.toList());

						if (Etudiant.siCreneauxCompatibles(Collections.max(smallerThan), creneau) == true
								&& Etudiant.siCreneauxCompatibles(Collections.min(biggerThan), creneau) == true) {
							list.put(autreEtudiant, creneau);
						}

					}

				}

			}

		}

	} // class etudiant

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
