package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Klasse für die Persistenz
 * @author Dunja Cosic
 */
public class Persistenz implements PersistenzInterface{

    //Konstruktor
    public Persistenz(WortTrainer trainer) {
    }

    /**
     * speichert die Worteinträge und die Statistik dazu in der angegebenen Datei
     * @param filepath Das File in dem alles gespeichert werden soll
     * @throws IOException
     */
    public void speichern(String filepath, WortTrainer wortTrainer) throws IOException {
        File file = new File(filepath);
        BufferedWriter writer = null;
        int richtige = wortTrainer.getRichtige();
        int falsche = wortTrainer.getFalsche();
        writer = new BufferedWriter(new FileWriter(file));
        writer.write(richtige + System.lineSeparator() + falsche + System.lineSeparator());
        writer.close();
    }
    /**
     * speichert die Worteintraege und die Statistik dazu in der angegebenen Datei im Projekt Ordner
     * @param wortTrainer Die Worteintraege und die Statistik
     */
    public void speichern(WortTrainer wortTrainer) throws IOException {
        speichern("WortTrainer.txt", wortTrainer);
    }
    /**
     * lädt die Worteinträge und die Statistik in der angegebenen Datei
     * @param filepath Der Pfad zur Datei
     * @return Den Worttrainer mit den Daten aus der Datei
     */
    public void laden(String filepath, WortTrainer wortTrainer) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        int richtige = Integer.parseInt(reader.readLine());
        int falsche = Integer.parseInt(reader.readLine());
        wortTrainer.addRichtige(richtige);
        wortTrainer.addFalsche(falsche);
        reader.close();
    }
    /**
     * lädt die Worteinträge und die Statistik in der angegebenen Datei im Projekt Ordner
     * @return Den Worttrainer mit den Daten aus der Datei
     */
    public void laden(WortTrainer wortTrainer) throws IOException {
        laden("Worttrainer.txt", wortTrainer);
    }
}