package model;
/**
 * Wortliste für alle Worteinträge
 * @author Dunja Cosic
 */
public class WortListe {

    private WortEintrag[] wortListe;

    public WortListe() {
        this.wortListe= new WortEintrag[1];
    }
    /**
     * Fügt ein Wort in die Liste ein
     * @param wort Das Wort, das in die Liste hinzugefügt werden soll
     */
    public void addWort(WortEintrag wort) {                                     //added das Wort in die WortListe
        boolean abfrage=false;
        while(!abfrage){
            for(int zaehler=0;zaehler<this.wortListe.length;zaehler++){         //checkt ob ein Platz im Array ist
                if(this.wortListe[zaehler]==null){
                    this.wortListe[zaehler]=wort;
                    abfrage=true;
                }
            }
            if(!abfrage){                                                           //added das Wort in die WortListe
                WortEintrag[] xy=new WortEintrag[this.wortListe.length+1];
                for(int x=0;x<this.wortListe.length;x++){
                    xy[x]=this.wortListe[x];
                }
                this.wortListe= xy;
                for(int zaehler2=0;zaehler2<this.wortListe.length;zaehler2++){      //added das Wort am ersten Platz
                    if(this.wortListe[zaehler2]==null){
                        this.wortListe[zaehler2]=wort;
                        abfrage=true;
                    }
                }
            }
        }
    }
    public WortEintrag[] getListe() {
        return wortListe;
    }
    public WortEintrag getWort(int index) {
        return this.wortListe[index];
    }

    public int getLength(){
        return this.wortListe.length;
    }
    /**
     * löscht ein Wort aus der Wortliste
     * @param wort das Wort, das gelöscht werden soll
     * @return gibt Bescheid, ob Wort gelöscht wurde oder nicht
     */
    public boolean deleteWort(String wort) {                                        //deletet das Wort
        for(int index=0;index<this.wortListe.length;index++){
            if(this.wortListe[index].getWort().equals(wort)){
                this.wortListe[index]=null;
                return true;
            }
        }

        return false;
    }
    /**
     * macht Liste, die als String gespeichert wird
     * @return returned die Liste als String
     */
    @Override
    public String toString() {                                                      //macht WortListe zu String
        String zurück= new String("");
        for(int index=0;index<this.wortListe.length;index++){
            if(this.wortListe[index]!=null){
                zurück=zurück+this.wortListe[index].toString()+"\n";
            }
        }
        return zurück;
    }
}

