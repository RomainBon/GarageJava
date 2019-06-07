package garage.moteur;

public class MoteurElectrique extends Moteur {

	public MoteurElectrique(String cylindre, double prix) {
		super(cylindre, prix);
		this.setType(TypeMoteur.ELECTRIQUE);
	}

}
