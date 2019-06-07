package garage.option;

public class Climatisation implements Option {

	@Override
	public double getPrix() {
		return 150;
	}

	@Override
	public String getName() {
		return "Climatisation";
	}

}
