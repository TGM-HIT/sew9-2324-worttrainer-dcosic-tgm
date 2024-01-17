package model;

import java.io.IOException;

public interface PersistenzInterface {
    void speichern(String filepath, WortTrainer wortTrainer) throws IOException;

    void speichern(WortTrainer wortTrainer) throws IOException;

    void laden(String filepath, WortTrainer wortTrainer) throws IOException;

    void laden(WortTrainer wortTrainer) throws IOException;
}
