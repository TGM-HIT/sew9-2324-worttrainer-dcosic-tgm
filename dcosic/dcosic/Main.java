package dcosic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Main {
    private static void main(String[] args) {
        //Paare erstellen
        Paare paar1 = new Paare("Hund", "https://www.ruv.de/dam/ratgeber/images/rest/supernase-hund-nase.jpg");
        Paare paar2 = new Paare("Baum", "https://img.freepik.com/vektoren-kostenlos/baum_1308-36471.jpg");
        Paare paar3 = new Paare("Wolke","https://bilder.deutschlandfunk.de/5c/38/10/be/5c3810be-684d-495e-b64c-d72fccd37ef9/kakadu-wolken-100-1920x1080.jpg?t=1652942778728");
        Rechtschreibung rs = new Rechtschreibung();
        Persistenz persistenz = null;
        persistenz.laden("C:\\Users\\dunja\\IdeaProjects\\sew9-2324-worttrainer-dcosic-tgm\\src\\main\\java");
        //Variablen
        Paare paare = null;
        boolean beenden = false;

        //Spiel starten
        while(!beenden) {
            String welches = JOptionPane.showInputDialog("Geben Sie r für random ein oder z für Zahl.");
            if(welches.equals("r")) {
                paare = rs.randomPaar();
                try {
                    URL imageUrl = new URL(paare.getBildURL());
                    Image image = ImageIO.read(imageUrl);
                    JOptionPane.showMessageDialog(null, new ImageIcon(image), "Aktuelles Wort", JOptionPane.PLAIN_MESSAGE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if(welches.equals("z")) {
                int zahl = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie eine Zahl von 1-3 ein."));
                paare =
                try {
                    URL imageUrl = new URL(paare.getBildURL());
                    Image image = ImageIO.read(imageUrl);
                    JOptionPane.showMessageDialog(null, new ImageIcon(image), "Aktuelles Wort", JOptionPane.PLAIN_MESSAGE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }


        }
      //  int zahl = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie für ein Wortpaar eine Zahl ein."));

    }

