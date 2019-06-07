package garage.option;

public class BarreDeToit implements Option {

	@Override
	public double getPrix() {
		return 75;
	}

	@Override
	public String getName() {
		return "Barre_de_Toit";
	}

}
