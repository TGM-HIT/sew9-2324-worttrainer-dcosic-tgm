package dcosic;

import java.io.*;

public interface Persistenz {

	public default void speichern(Rechtschreibung rechtschreibung, String filepath) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
			writer.write(String.valueOf(rechtschreibung));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public default Rechtschreibung laden(String filepath) {

		return null;
	}
}
