package model;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Worteinträge
 * @author Dunja Cosic
 */
public class WortEintrag {
    private String wort;

    private String url;

    /**
     * erstellt einen Worteintrag
     * @param wort das Wort
     * @param url die Url
     */
    public WortEintrag(String wort, String url) {
        this.wort=wort;
        this.url=url;
    }

    /**
     * checkt die URL nach Gültigkeit
     * @param url die URL die überprüft werden soll
     * @return ob die URL gültig ist
     */
    public static boolean checkUrl(String url) {                    //Methode um die URL zu checken
        try {
            URL url1 = new URL(url);
            url1.toURI();
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (URISyntaxException e) {
            return false;
        }
    }

    public void setWort(String wort) {
        if(wort.length()>=2){
            this.wort=wort;
        }
    }

    public void setUrl(String url) {
        if(checkUrl(url)){
            this.url=url;
        }
    }

    public String getWort() {
        return this.wort;
    }

    public String getUrl() {
        return this.url;
    }

    @Override
    public String toString() {
        return new String(this.wort+"; "+this.url);

    }
}
