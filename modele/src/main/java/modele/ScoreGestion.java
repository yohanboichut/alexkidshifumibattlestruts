package modele;

import interfaces.type.Score;
import interfaces.exceptions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static interfaces.facade.FacadeAlexKiddBattleOnLine.FEUILLE;
import static interfaces.facade.FacadeAlexKiddBattleOnLine.CISEAUX;
import static interfaces.facade.FacadeAlexKiddBattleOnLine.PIERRE;

/**
 * Permet de gérer une partie, son score, son évolution en fonction des choix des joueurs.
 * Chaque manche incrémentera le numeroOperation
 */
public class ScoreGestion {

    private static final int ZERO = 0;
    private static final int UN = 1;
    public static final String EMPTY = "";
    private int numeroOperation;


    private Map<String,Integer> joueurs;
    private Map<Integer,Integer> score;
    private Map<Integer,String> choix;
    private Map<Integer,String> pseudosJoueurs;


    public ScoreGestion(String joueur1, String joueur2) {
        this.joueurs = new HashMap<>();
        this.choix = new HashMap<>();
        this.pseudosJoueurs = new HashMap<>();
        this.score = new HashMap<>();
        this.joueurs.put(joueur1,ZERO);
        this.joueurs.put(joueur2,UN);
        this.pseudosJoueurs.put(ZERO, joueur1);
        this.pseudosJoueurs.put(UN,joueur2);
        this.numeroOperation = 0;
        this.score.put(ZERO,0);
        this.score.put(UN,0);
    }

    public void setChoixJoueur(String joueur, String choix) throws ChoixDejaFaitException {
        if (!Objects.isNull(this.choix.get(joueurs.get(joueur)))) {
            throw new ChoixDejaFaitException();
        }
        this.choix.put(joueurs.get(joueur),choix);
    }


    public void miseAJourScore() {
        int score1 = this.score.get(ZERO);
        int score2 = this.score.get(UN);
        String choix1 = this.choix.get(ZERO);
        String choix2 = this.choix.get(UN);

        if (choix1.equals(PIERRE)) {
            if (choix2.equals(CISEAUX)) {
                score1++;
                this.score.put(ZERO,score1);
            }
            if (choix2.equals(FEUILLE)) {
                score2++;
                this.score.put(UN,score2);
            }
        }

        if (choix1.equals(CISEAUX)) {
            if (choix2.equals(FEUILLE)) {
                score1++;
                this.score.put(ZERO,score1);
            }
            if (choix2.equals(PIERRE)) {
                score2++;
                this.score.put(UN,score2);
            }
        }

        if (choix1.equals(FEUILLE)) {
            if (choix2.equals(PIERRE)) {
                score1++;
                this.score.put(ZERO,score1);
            }
            if (choix2.equals(CISEAUX)) {
                score2++;
                this.score.put(UN,score2);
            }
        }
    }

    public boolean partieTerminee() {
        return this.score.get(ZERO)==2 || this.score.get(UN)==2;
    }

    public String getVainqueur() throws PartieNonTermineeException {
        if (partieTerminee()) {
            if (this.score.get(ZERO)>this.score.get(UN)) {
                return this.pseudosJoueurs.get(ZERO);
            }
            else {
                return this.pseudosJoueurs.get(UN);
            }
        }
        else {
            throw new PartieNonTermineeException();
        }

    }

    public Score maj() throws ChoixIncompletsException {
        if (this.choix.values().size()<2) {
            throw new ChoixIncompletsException();
        }
        this.numeroOperation ++;
        this.miseAJourScore();
        Score score = new ScoreImpl(this.numeroOperation,this.score.get(ZERO),this.score.get(UN),
                this.pseudosJoueurs.get(ZERO), this.pseudosJoueurs.get(UN),
                this.choix.get(ZERO),
                this.choix.get(UN));
        this.choix.clear();
        return score;
    }

    public Score getDefault(){
        return new ScoreImpl(ZERO,ZERO,ZERO,
                this.pseudosJoueurs.get(ZERO),
                this.pseudosJoueurs.get(UN),
                EMPTY,
                EMPTY);
    }

}
