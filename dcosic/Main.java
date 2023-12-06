package dcosic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Paare> wortpaare = new ArrayList<>();

        wortpaare.add(new Paare("Hund", "https://p6.focus.de/img/fotos/id_11808484/gettyimages-1140456384.jpg?im=Crop%3D%28442%2C0%2C1414%2C1414%29%3BResize%3D%28548%29&impolicy=perceptual&quality=mediumHigh&hash=8dec471f716de97643449dcf8814180e0c90f3651a34d958e33a4569e88afb48"));
        wortpaare.add(new Paare("Baum", "https://img.freepik.com/vektoren-kostenlos/baum_1308-36471.jpg"));
        wortpaare.add(new Paare("Wolke", "https://bilder.deutschlandfunk.de/5c/38/10/be/5c3810be-684d-495e-b64c-d72fccd37ef9/kakadu-wolken-100-1920x1080.jpg?t=1652942778728%22"));
        //Persistenz persistenz = new Persistenz();
        // wortpaare = (List<Paare>) persistenz.laden("C:\\Pfad\\zu\\deiner\\Datei.txt");

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
                    Image image = Toolkit.getDefaultToolkit().getImage(imageUrl);
                    // Image image = ImageIO.read(imageUrl);
                    JOptionPane.showMessageDialog(null, new ImageIcon(image), "Aktuelles Wort", JOptionPane.PLAIN_MESSAGE);

                    //Antwort des Benutzers abfragen
                    String benutzerAntwort = JOptionPane.showInputDialog("Geben Sie das passende Wort ein:");
                    if (benutzerAntwort != null) {
                        boolean korrekt = rs.wortCheck(benutzerAntwort);
                        if (korrekt) {
                            statistik.aktualisieren(1, 0);
                            JOptionPane.showMessageDialog(null, "Richtig!", "Ergebnis", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            statistik.aktualisieren(0, 1);
                            JOptionPane.showMessageDialog(null, "Falsch! Das richtige Wort ist: " + paare.getWort(), "Ergebnis", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (welches.equals("z")) {

            }
        }
    }
}