package actions;


import interfaces.type.Score;
import tools.Menu;

import java.util.List;


public class InitialiserPartie extends Contexte implements Partie {

    private Score scoreCourant;


    private String vainqueur;

    public String getVainqueur() {
        return vainqueur;
    }

    @Override
    public String execute() throws Exception {
        String pseudo = (String) getSession().get("pseudo");
        this.scoreCourant = getFacadeAlexKiddBattleOnLine().getScoreCourant(pseudo);


        if (getFacadeAlexKiddBattleOnLine().partieTerminee(pseudo)) {
            this.vainqueur = getFacadeAlexKiddBattleOnLine().getVainqueur(pseudo);
            return "partieterminee";
        }
        else {
            return "partieencours";
        }
    }



    @Override
    public String getPseudoJoueur1() {
        return scoreCourant.getJoueur1();
    }

    @Override
    public String getPseudoJoueur2() {
        return scoreCourant.getJoueur2();
    }

    @Override
    public int getScoreJoueur1() {
        return scoreCourant.getScoreJoueur1();
    }

    @Override
    public int getScoreJoueur2() {
        return scoreCourant.getScoreJoueur2();
    }

    @Override
    public String getChoixJoueur1() {
        return scoreCourant.getChoixJoueur1()==null?"":scoreCourant.getChoixJoueur1();
    }

    @Override
    public String getChoixJoueur2() {
        return scoreCourant.getChoixJoueur2()==null?"":scoreCourant.getChoixJoueur2();

    }

    @Override
    public List<String> getChoixJoueurs() {
        return Menu.CHOIX_JOUEURS;
    }

}
