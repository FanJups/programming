import t2s.son.LecteurTexte;

public class Test {

	public static void main(String[] args) {
		final LecteurTexte lecteur = new LecteurTexte();
		lecteur.setTexte("Bonjour je m'appelle AXIV et vous ?");
		lecteur.playAll();
	}

}
