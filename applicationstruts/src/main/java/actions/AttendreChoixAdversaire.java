package actions;

import interfaces.type.Score;
import tools.OutilsInternationalisation;

import java.util.List;

public class AttendreChoixAdversaire extends Contexte implements Partie{


    public String getToken() {
        return (String)getSession().get(Contexte.TOKEN);
    }

    public String getPseudo() {
        return (String)getSession().get(Contexte.PSEUDO);
    }


    private Score scoreCourant;



    @Override
    public String execute() throws Exception {
        String pseudo = (String)this.getSession().get(Contexte.PSEUDO);
        int idCourant = (Integer) this.getSession().get(Contexte.NUMERO_OPERATION);
        scoreCourant = getFacadeAlexKiddBattleOnLine().getScoreCourant(pseudo);
        if (scoreCourant.getNumeroOperation() != idCourant) {
            this.getSession().put(Contexte.NUMERO_OPERATION,scoreCourant.getNumeroOperation());
            return SUCCESS;
        }
        else
            return INPUT;
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


        return (List<String>) getSession().get(Contexte.MENU_JEU);
    }


}
