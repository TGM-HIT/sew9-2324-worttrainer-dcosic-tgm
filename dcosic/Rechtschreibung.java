package dcosic;

import java.util.List;
import java.util.Random;


public class Rechtschreibung {

	private List<Paare> paare;

	private Paare aktuellesPaar;

	public Rechtschreibung(List<Paare> wortpaare) {
		this.paare = paare;
	}


	public Paare randomPaar() {
		Random random = new Random();
		int randomIndex = random.nextInt(this.paare.size());
		this.aktuellesPaar =  paare.get(randomIndex);
		return this.aktuellesPaar;
	}

	public boolean wortCheck(String benutzerAntwort) {
		int counterRichtig = 0;
		int counterFalsch = 0;

		//this.statistik.aktualisieren(counterRichtig, counterFalsch);
		return benutzerAntwort.equalsIgnoreCase(aktuellesPaar.getWort());
	}

}
