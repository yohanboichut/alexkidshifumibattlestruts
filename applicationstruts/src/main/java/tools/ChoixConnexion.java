package tools;

public class ChoixConnexion {

    private int choix;
    private String libelle;

    public ChoixConnexion(int choix, String libelle) {
        this.choix = choix;
        this.libelle = libelle;
    }

    public int getChoix() {
        return choix;
    }

    public void setChoix(int choix) {
        this.choix = choix;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
