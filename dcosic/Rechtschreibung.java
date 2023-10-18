package dcosic;

import javax.swing.*;
import java.util.List;

public class Rechtschreibung extends Paare {

	private List<Paare> paare;

	private Paare aktuellesPaar;

	private Statistik statistik;

	private Persistenz persistenz;



	public Paare randomPaar() {

		return null;
	}

	public boolean wortCheck() {
		int counterRichtig = 0;
		int counterFalsch = 0;

		this.statistik.aktualisieren(counterRichtig, counterFalsch);

		return false;
	}

}
