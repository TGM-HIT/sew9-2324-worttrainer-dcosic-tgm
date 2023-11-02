package dcosic;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Paare> wortpaare = new ArrayList<>();

        Persistenz persistenz = new Persistenz();
        wortpaare = (List<Paare>) persistenz.laden("C:\\Pfad\\zu\\deiner\\Datei.txt");

        Rechtschreibung rs = new Rechtschreibung(wortpaare);
        Statistik statistik = new Statistik();

        Paare paare = null;
        boolean beenden = false;

        while (!beenden) {
            String welches = JOptionPane.showInputDialog("Geben Sie 'r' für random ein oder 'z' für Zahl.");
            if (welches == null) {
                break;
            }
            if (welches.equals("r")) {
                paare = rs.randomPaar();
                try {
                    URL imageUrl = new URL(paare.getBildURL());
                    Image image = ImageIO.read(imageUrl);
                    JOptionPane.showMessageDialog(null, new ImageIcon(image), "Aktuelles Wort", JOptionPane.PLAIN_MESSAGE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (welches.equals("z")) {
                int zahl = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie eine Zahl von 1-3 ein."));
                // Hier sollten Sie das ausgewählte Wort basierend auf der Zahl anzeigen
                // paare = wortpaare.get(zahl - 1);
                // ...
            }
            // Hier können Sie den wortCheck aufrufen und die Statistik aktualisieren
            // boolean korrekt = rs.wortCheck(paare);
            // if (korrekt) {
            //     statistik.aktualisieren(1, 0);
            // } else {
            //     statistik.aktualisieren(0, 1);
            // }
        }
    }
}
