package dcosic;

public class Paare {

	private String wort;
	private String bildURL;

	public Paare(String wort, String bildURL) {
		this.wort = wort;
		this.bildURL = bildURL;
	}

	@Override
	public String toString() {
		return "Paare{" +
				"wort='" + wort + '\'' +
				", bildURL='" + bildURL + '\'' +
				'}';
	}

	//Getter & Setter
	public String getWort() {
		return this.wort;
	}

	public String getBildURL() {
		return this.bildURL;
	}

	public void setWort(String wort) {
		this.wort = wort;
	}

	public void setBildURL(String bildURL) {
		this.bildURL = bildURL;
	}
}

