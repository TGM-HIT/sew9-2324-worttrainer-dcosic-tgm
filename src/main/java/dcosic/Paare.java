package dcosic;

public class Paare {

	private String wort;

	private String bildURL;

	public Paare(String wort, String bildURL) {
		this.wort = wort;
		this.bildURL = bildURL;
	}

	public void Paare() {
		this.wort = getWort();
		this.bildURL = getBildURL();
	}

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
