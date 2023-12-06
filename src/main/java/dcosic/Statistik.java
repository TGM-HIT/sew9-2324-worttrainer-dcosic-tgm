package dcosic;

public class Statistik {

	private int richtig = 0;

	private int falsch = 0;

	private int insgesamt;

	public void Statistik() {
		this.richtig = richtig;
		this.falsch = falsch;
		this.insgesamt = insgesamt;
	}

	public void aktualisieren(int richtig, int falsch) {
			this.richtig = richtig;
			this.falsch = falsch;
			this.insgesamt = this.richtig + this.falsch;
	}

}
