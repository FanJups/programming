package searchFile;

import java.io.File;

public class Search {

	public static String searchEngine(String path, String fileName) {
		File name = new File(path);

		String absolutePath = null;

		boolean validator = false;

		if (name.exists()) {
			System.out.println(name.getName() + " exists.");

			if (name.isFile()) {
				if (name.getName().equals(fileName)) {
					absolutePath = path + "\\" + fileName;

				} else {

				}
			}

			if (name.isDirectory()) {
				String[] directory = name.list();

				for (String directoryName : directory) {

					// searchEngine(path + "\\" + directoryName, fileName)

					File subName = new File(path + "\\" + directoryName);

					if (subName.isFile()) {

						if (subName.getName().equals(fileName)) {
							absolutePath = path + "\\" + fileName;

						} else {

						}

					}
					if (subName.isDirectory()) {

					}
				}

			}

		} else {
			System.out.println(path + " doesn't exist.");

		}

		return absolutePath;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String test = searchEngine("C:\\Users\\Admin\\Desktop\\Learn DESIGN", "chien blanc.png");

		System.out.println("Chemin complet : " + test);

	}

}
