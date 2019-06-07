package garage;

import java.util.List;

import garage.option.Option;
import garage.vehicule.Vehicule;

public class Garage {
	// VAR
	private List<Vehicule> voitures;

	// CONSTRUCTOR
	public Garage() {
		super();
		System.out.println("Je suis dans ton garage condtructor");
		this.voitures = SaveGestion.read();
	}

	// METHODE
	public void addVoiture(Vehicule voiture) {
		this.voitures.add(voiture);
		SaveGestion.write(voitures);
	}

	// GETTER SETTER
	public List<Vehicule> getVoitures() {
		return this.voitures;
	}

	public void setVoitures(List<Vehicule> voiture) {
		this.voitures = voiture;
	}

	@Override
	public String toString() {
		String toStr = "Garage :  \n";
		System.out.println(this.voitures.size());
		if (this.voitures.size() != 0) {
			for (Vehicule voit : this.voitures) {
				toStr += voit.getNom() + " : " + voit.getPrix() + " € \n\t" + voit.getMoteur().getCylindre() + " : "
						+ voit.getMoteur().getPrix() + "   \n\t Options : ";
				for (Option option : voit.getOptions()) {
					toStr += "\n \t\t" + option.getName() + "(" + option.getPrix() + " €)";
				}
				toStr += " \n\t Total : " + voit.totalPrix() + " € \n\n\n";
			}
		} else {
			toStr += "Le Garage est vide";
		}
		return toStr;
	}

}
