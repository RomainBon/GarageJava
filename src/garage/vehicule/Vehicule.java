package garage.vehicule;

import java.util.ArrayList;
import java.util.List;
import garage.moteur.Moteur;
import garage.option.Option;

public class Vehicule {
	//VAR
	private double prix;
	private String nom;
	private List<Option> options;
	private Marque nomMarque;
	private Moteur moteur;
	
	//Constructor
	public Vehicule() {
		super();
		this.options= new ArrayList<Option>();
	}
	
	//METHODES
	public void addOption(Option option) {
		this.options.add(option);
	}
	public double totalPrix() {
		double prixTotal=this.getPrix()+this.getMoteur().getPrix();
		for(Option option : this.getOptions())
		{
			prixTotal+=option.getPrix();
		}
		return prixTotal;
	}
	
	//GETTER SETTER
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Marque getNomMarque() {
		return nomMarque;
	}

	public void setNomMarque(Marque nomMarque) {
		this.nomMarque = nomMarque;
	}

	public Moteur getMoteur() {
		return moteur;
	}

	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}

}
