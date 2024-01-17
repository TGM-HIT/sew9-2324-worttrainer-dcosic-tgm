package control;

import model.*;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.swing.*;

/**
 * Main-Klasse
 *  * @author Dunja Cosic
 */

public class Main {
    /**
     * Objekte: WortEintrag, WortTrainer und WortListe
     */
    public static void main(String[] args) {

        //Worteinträge
        WortEintrag wortEintrag1 = new WortEintrag("Hund", "https://www.zooplus.de/magazin/wp-content/uploads/2017/08/husky-welpe-beisst.jpeg");
        WortEintrag wortEintrag2 = new WortEintrag("Wolke", "https://bilder.deutschlandfunk.de/5c/38/10/be/5c3810be-684d-495e-b64c-d72fccd37ef9/kakadu-wolken-100-1920x1080.jpg");
        WortEintrag wortEintrag3 = new WortEintrag("Baum", "https://img.freepik.com/vektoren-kostenlos/getrennter-baum-auf-weissem-hintergrund_1308-26130.jpg");

        //Wortliste
        WortListe wortListe = new WortListe();
        wortListe.addWort(wortEintrag1);
        wortListe.addWort(wortEintrag2);
        wortListe.addWort(wortEintrag3);

        //Worttrainer
        WortTrainer trainer = new WortTrainer(wortListe); //Konstruktor in WortTrainer
        Persistenz sul = new Persistenz(); //Konstruktor in Persistenz
        try {
            sul.laden(trainer); //WortTrainer in laden
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fehler beim Laden");
        }

        Random r = new Random();
        boolean wortRichtig = true;
        boolean spielBeendet = false;
        ImageIcon image;
        String antwort = "";
        String VorherigerVersuch = "";
        /////////
        JOptionPane.showMessageDialog(null, "Wilkommen zu dem Besten Worttrainer <3 !!");
        while(!spielBeendet) {
            WortEintrag neuesWort = trainer.getWortListe().getListe()[r.nextInt(trainer.getWortListe().getListe().length)];

            do {
                try {
                    image = new ImageIcon(new URL(neuesWort.getUrl()));
                    JOptionPane.showMessageDialog(null, "Richtig geraten :): "+trainer.getRichtige()+"\nFalsch geraten:(: "+trainer.getFalsche()+"\nDer Versuch davor: " +VorherigerVersuch+ "\nGleich geht's los!", "Display Image", JOptionPane.INFORMATION_MESSAGE, image);
                    antwort = JOptionPane.showInputDialog(null, "Was hast du auf dem Bild gesehen?");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Ein Fehler ist aufgetreten...");
                }

                if(antwort.equals("")){
                    try {
                        sul.speichern(trainer); //nochmal WortTrainer
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Es ist ein Fehler beim Speichern aufgetreten..");
                    }
                    spielBeendet = true;
                    break;
                }
                //
                if(antwort.equals(neuesWort.getWort())) {
                    JOptionPane.showMessageDialog(null, "Richtig :)");
                    trainer.addRichtige(1);
                    wortRichtig = true;
                    VorherigerVersuch = "Richtig";
                } else {
                    JOptionPane.showMessageDialog(null, "Falsch :(");
                    trainer.addFalsche(1);
                    wortRichtig = false;
                    VorherigerVersuch = "Falsch";
                }
            } while (!wortRichtig);

        }
        JOptionPane.showMessageDialog(null, "Richtig: "+trainer.getRichtige()+" Falsch: "+trainer.getFalsche());

    }
}
