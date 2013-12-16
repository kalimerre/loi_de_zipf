import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;

public class Document {
	String source;
	static ArrayList<Pair> liste = new ArrayList<Pair>();

	public Document() {
		// liste.add(new Pair("Toto",3));
		// liste.add(new Pair("Tata", 2));
		Collections.sort(liste);

	}

	public static String versMin(String s) {

		StringBuffer ch = new StringBuffer(s);

		for (int i = 0; i < s.length(); i++) {
			if (ch.charAt(i) >= 'A' && ch.charAt(i) <= 'Z') {
				ch.setCharAt(i, (char) (ch.charAt(i) - 'A' + 'a'));

			}
		}

		return ch.toString();
	}

	public static void tokenisation(String ch) {
		// String ch = "Java, ça dechire";
		String[] resultatSplit = ch.split("[^a-zA-Z0-9]+");
		int nombreOccurences = 0;
		// liste.add(new Pair(resultatSplit));
		String valeurOccurence = "";
		int valeur = 0;
		for (int i = 0; i < resultatSplit.length; i++) {
			valeurOccurence = resultatSplit[i];
			while (valeurOccurence == resultatSplit[valeur]) {
				nombreOccurences++;
				valeur++;
			}
			liste.add(new Pair(resultatSplit[i], nombreOccurences));
		}

	}

	public static String supprimentAccent(String s) {
		String chaineSansAccent = Normalizer.normalize(s, Normalizer.Form.NFD)
				.replaceAll("[^\\p{ASCII}]", "");
		return chaineSansAccent;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println(versMin("Coucou Je SUIS lE"));
		// System.out.println(supprimentAccent("Tééést des àccênts"));

		String testFilepath = "C:/monRep";

		String resFilePath = "C:/monRep/test.csv";
		File folder = new File(testFilepath);
		File[] listOfFiles = folder.listFiles();
		for (File f : listOfFiles) {
			if (f.isFile()) {

				String parsedText = parse(f.getAbsolutePath());
				System.out.println(parsedText);
				ecrire(resFilePath, parsedText);

			}
		}
		// ecrire(resFilePath, "tototo");
	}

	public static String parse(String filePath) {

		String result = "";

		File file = new File(filePath);

		if (file.exists()) {
			try {

				BufferedReader reader = new BufferedReader(new FileReader(file));
				StringBuffer sbuf = new StringBuffer();
				String line = reader.readLine();
				while (line != null) {
					line = supprimentAccent(line);
					line = versMin(line);
					sbuf.append(line);
					line = reader.readLine();

				}

				reader.close();

				result = sbuf.toString();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return result;

	}

	public static void ecrire(String filePath, String content) {
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
					filePath)));
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
