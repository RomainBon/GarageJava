package garage.option;

public class VitreElectrique implements Option {

	@Override
	public double getPrix() {
		return 50;
	}

	@Override
	public String getName() {
		return "Vitre_Electrique";
	}

}
