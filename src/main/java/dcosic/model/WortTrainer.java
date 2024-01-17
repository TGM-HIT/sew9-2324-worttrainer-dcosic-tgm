package model;

import java.io.IOException;
import java.util.Random;
import view.View;

/**
 * Die Klasse, die die Statistik der Eingaben verwaltet & für das Speichern & Laden zuständig ist
 * @author Dunja Cosic
 */
public class WortTrainer {
    private WortListe wortListe;
    private int fragen;
    private int richtig;
    private int falsch;
    private int ungueltig;
    PersistenzInterface persistenzInterface;
    /**
     * Konstruktor mit Parametern
     */
    public WortTrainer(WortListe wortListe, PersistenzInterface persistenzInterface){
        this.wortListe=wortListe;
        this.fragen=0;
        this.richtig=0;
        this.falsch=0;
        this.ungueltig=0;
        this.persistenzInterface = persistenzInterface;
    }

    /**
     * Konstruktor ohne Parameter
     */
    public WortTrainer(){
        this.wortListe=new WortListe();
        this.fragen=0;
        this.richtig=0;
        this.falsch=0;
        this.ungueltig=0;
        this.persistenzInterface = new Persistenz();
    }

    public WortTrainer(WortListe wortListe) {
    }

    public WortListe getWortListe() {
        return wortListe;
    }
    /**
     * returned das Zufallswort an einer zufälligen Stelle, falls kein Wort drinnen ist, wird der Wert "null" zurückgegeben
     * @return das zufällige wort, dass an ediner zuälligen Stelle ausgewählt wird
     */
    public WortEintrag getRandomWort() {
        boolean x=true;
        Random r=new Random();
        int random= r.nextInt(this.wortListe.getLength());
        while(x){
            if(this.wortListe.getWort(random)!=null){
                return this.wortListe.getWort(random);
            }
        }
        return null;
    }

    public WortEintrag getWort(int index) {
        return this.wortListe.getWort(index);
    }

    /**
     *  Überprüft, ob das Wort richtig geschrieben wurde
     * @param wort das Wort, das überprüft werden soll
     * @param index die Stelle, an der sich das Wort befindet
     * @return ob das Wort, mit dem Wort an der Stelle übereinstimmt
     */
    public boolean check(String wort,int index) {
        this.fragen++;
        if(index>wortListe.getLength()-1){
            this.ungueltig++;
            return false;
        }
        if(this.wortListe.getWort(index).getWort().equals(wort)){
            this.richtig++;
            return true;
        }
        this.falsch++;
        return false;
    }

    //-------
    /**
     * ohne Groß-Kleinschreibung
     * @param wort das Wort, dass überprüft werden soll
     * @param index die Stelle, an der sich das Wort befindet
     * @return ob das Wort, mit dem Wort an derselben Stelle übereinstimmt
     */
    public boolean checkIgnoreCase(String wort,int index) {
        this.fragen++;
        if(index>wortListe.getLength()-1){
            this.ungueltig++;
            return false;
        }
        String vorlage= this.wortListe.getWort(index).getWort().toLowerCase();
        if(vorlage.equals(wort.toLowerCase())){
            this.richtig++;
            return true;
        }else{
            this.falsch++;
            return false;
        }
    }
    /**
     * Hier werden Ausgaben für das Darstellen der Fehlerquote erstellt.
     * @return Es wird ein Text zurückgegegeben, der die Fehlerquote enthält und ausgibt.
     */
    public String getFehlerQuote(){
        String fehlerQuote= new String("Sie haben "+this.fragen+" Wörter geprüft. Davon waren "+this.richtig+" Wörter richtig und "+this.falsch+" Wörter falsch. "+this.ungueltig+" Ihrer Eingaben waren ungültig : ((");
        return fehlerQuote;
    }

    /**
     * Getter- und Setter-Methoden für die jeweiligen Attribute
     * @return
     */
    public int getFragen(){
        return this.fragen;
    }
    public int getRichtige(){
        return this.richtig;
    }
    public int getFalsche(){
        return this.falsch;
    }
    public int getUngueltig(){
        return this.ungueltig;
    }
    public void addRichtige(int richtig){
        this.richtig += richtig;
    }
    public void addFalsche(int falsch){
        this.falsch += falsch;
    }

    /**
     * Methode zum Speichern des dateipfades
     * @param filepath
     */
    public void speichern(String filepath){
        try {
            persistenzInterface.speichern(filepath,this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Laden des Dateipfads
     * @param filepath
     */
    public void laden(String filepath){
        try {
            persistenzInterface.laden(filepath,this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
/**
    //Methode zur Überprüfung, ob die Wortpaar-Liste leer ist
    public boolean isMapEmpty() {
        WortListe wortPaarList = jsonPersistence.load();
        return wortPaarList.isEmpty();
    }
 */
}


