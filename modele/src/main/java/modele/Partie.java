package modele;

import interfaces.type.*;
import interfaces.exceptions.*;

public class Partie {

    private int idPartie;
    private String joueur1;
    private String joueur2;
    private EtatPartie etatPartie;

    public int getIdentifiantPartie() {
        return idPartie;
    }

    private enum EtatPartie {ATTENTE,EN_COURS,FIN};
    private static int IDS = 0;

    private ScoreGestion scoreGestionCourant;

    private Score scoreCourant;
    public Partie(String joueur1) {
        this.idPartie = IDS++;
        this.joueur1 = joueur1;
        this.etatPartie = EtatPartie.ATTENTE;
    }

    public boolean partieCommencee() {
        return this.etatPartie == EtatPartie.EN_COURS;
    }

    public void rejoindrePartie(String joueur2) throws PartieDejaPleineException {
        if (etatPartie != EtatPartie.ATTENTE)
            throw new PartieDejaPleineException();
        this.joueur2 = joueur2;
        this.scoreGestionCourant = new ScoreGestion(this.joueur1,this.joueur2);
        this.scoreCourant = this.scoreGestionCourant.getDefault();
        this.etatPartie = EtatPartie.EN_COURS;

    }


    public void choixJoueur(String joueur, String choix) throws ChoixDejaFaitException {
        this.scoreGestionCourant.setChoixJoueur(joueur,choix);
        try {
            this.scoreCourant = this.scoreGestionCourant.maj();
            if (this.scoreGestionCourant.partieTerminee()) {
                this.etatPartie = EtatPartie.FIN;
            }
        } catch (ChoixIncompletsException e) {

        }
    }

    public String getVainqueur() throws PartieNonTermineeException {
        return this.scoreGestionCourant.getVainqueur();
    }

    public boolean partieTerminee(){
        return EtatPartie.FIN == this.etatPartie;
    }

    public Score getScoreCourant() {
        return scoreCourant;
    }
}
