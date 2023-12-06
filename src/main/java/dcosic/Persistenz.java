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

	public default Rechtschreibung laden(String filepath) throws FileNotFoundException {
		try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
			StringBuilder content = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line);
			}
			return null;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
