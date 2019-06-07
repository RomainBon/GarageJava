package garage.option;

public class GPS implements Option {

	@Override
	public double getPrix() {
		return 100;
	}

	@Override
	public String getName() {
		return "GPS";
	}

}
