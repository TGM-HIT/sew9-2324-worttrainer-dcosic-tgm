package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Diese Klasse ist eine Klasse für die JSON-Persistierung.
 * @author Dunja Cosic
 */

public class JsonPersistence implements PersistenzInterface {


    @Override
    public void speichern(String filepath, WortTrainer wortTrainer) throws IOException {

    }

    @Override
    public void speichern(WortTrainer wortTrainer) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter fileWriter = new FileWriter("wortpaare.json")){
            Object wortListe = null;
            gson.toJson(wortListe,fileWriter);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void laden(String filepath, WortTrainer wortTrainer) throws IOException {

    }

    @Override
    public WortListe laden(WortTrainer wortTrainer) throws IOException {
        Gson gson = new Gson();
        try(FileReader fileReader = new FileReader("wortpaare.json")){
            return gson.fromJson(fileReader, WortListe.class);
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
