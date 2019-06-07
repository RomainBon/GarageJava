package garage.moteur;

public class Moteur {
	
	//VAR
	private TypeMoteur type;
	private String cylindre;
	private double prix;
	
	//CONSTRUCTOR
	public Moteur (String cylindre, double prix) {
		this.setCylindre(cylindre);
		this.setPrix(prix);
	}

	//GETTER / SETTER
	public TypeMoteur getType() {
		return type;
	}

	public void setType(TypeMoteur type) {
		this.type = type;
	}

	public String getCylindre() {
		return cylindre;
	}

	public void setCylindre(String cylindre) {
		this.cylindre = cylindre;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Moteur [type=" + type + ", cylindre=" + cylindre + ", prix=" + prix + "]";
	}
	//To String
	
}
