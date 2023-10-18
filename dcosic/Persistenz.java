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

			String data = "";
			try (BufferedReader reader = new BufferedReader(new FileReader(filepath)) {
				String line;
            while((line = reader.readLine()) != null) {
					data += line + "\n"; // Füge die Zeile dem String hinzu
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return data;
	}
}
