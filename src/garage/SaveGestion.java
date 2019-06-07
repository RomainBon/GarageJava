package garage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import garage.moteur.*;
import garage.option.*;
import garage.vehicule.*;

public class SaveGestion {

	// VARIABLE
	public static final String sourceFile = "source.txt";

	// METHODE
	public static List<Vehicule> read() {
		System.out.println("On va lire le fichier");
		String ligne;
		Vehicule voiture = null;
		List<Vehicule> savedFile = new ArrayList<Vehicule>();
		File file = new File(sourceFile);
		if (file.exists() && !file.isDirectory()) {
			System.out.println("LE FICHIER EST LA");
			try {
				BufferedReader fichier = new BufferedReader(new FileReader(sourceFile));
				while ((ligne = fichier.readLine()) != null) {
					String nomModel = ligne.substring(0, ligne.indexOf(','));
					ligne = ligne.substring(ligne.indexOf(',') + 1, ligne.length());
					String typeMoteur = ligne.substring(0, ligne.indexOf(','));
					ligne = ligne.substring(ligne.indexOf(',') + 1, ligne.length());
					String cylindre = ligne.substring(0, ligne.indexOf(','));
					ligne = ligne.substring(ligne.indexOf(',') + 1, ligne.length());
					double prixMoteur = Double.parseDouble(ligne.substring(0, ligne.indexOf(',')));
					ligne = ligne.substring(ligne.indexOf(',') + 1, ligne.length());
					List<Option> options = optionRead(ligne);

					switch (nomModel) {
					case "Lagouna":
						voiture = new Lagouna();
						break;
					case "D4":
						voiture = new D4();
						break;
					case "A300B":
						voiture = new A300B();
						break;
					}
					switch (typeMoteur) {
					case "DIESEL":
						voiture.setMoteur(new MoteurDiesel(cylindre, prixMoteur));
						break;
					case "ESSENCE":
						voiture.setMoteur(new MoteurEssence(cylindre, prixMoteur));
						break;
					case "HYBRIDE":
						voiture.setMoteur(new MoteurHybride(cylindre, prixMoteur));
						break;
					case "ELECTRIQUE":
						voiture.setMoteur(new MoteurElectrique(cylindre, prixMoteur));
						break;
					}
					voiture.setOptions(options);
					savedFile.add(voiture);
				}
				fichier.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Wololololololo");
		}
		return savedFile;
	}

	private static List<Option> optionRead(String ligne) {
		List<Option> options = new ArrayList<Option>();
		while (ligne.indexOf(',') != -1) {
			String tempOption = ligne.substring(0, ligne.indexOf(','));
			switch (tempOption) {
			case "Barre_de_Toit":
				options.add(new BarreDeToit());
				break;
			case "Climatisation":
				options.add(new Climatisation());
				break;
			case "GPS":
				options.add(new GPS());
				break;
			case "Siege_Chauffant":
				options.add(new SiegeChauffant());
				break;
			}
			ligne = ligne.substring(ligne.indexOf(',') + 1, ligne.length());
		}
		return options;
	}

	public static void write(List<Vehicule> listGarage) {
		try {
			BufferedWriter fichier = new BufferedWriter(new FileWriter(sourceFile));
			for (Vehicule voiture : listGarage) {
				fichier.write(voiture.getNom() + ",");
				fichier.write(voiture.getMoteur().getType() + ",");
				fichier.write(voiture.getMoteur().getCylindre() + ",");
				fichier.write(voiture.getMoteur().getPrix() + ",");

				for (Option option : voiture.getOptions()) {
					fichier.write(option.getName() + ",");
				}
				fichier.newLine();
			}
			fichier.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
