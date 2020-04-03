package actions;

import interfaces.exceptions.PseudoDejaPrisException;
import interfaces.type.Score;

public class AttendreAdversaire extends Contexte {


    public String getToken() {
        return (String)getSession().get("token");
    }

    public String getPseudo() {
        return (String)getSession().get("pseudo");
    }



    @Override
    public String execute() throws Exception {
        String pseudo = (String)this.getSession().get("pseudo");
        if (getFacadeAlexKiddBattleOnLine().partieCommencee(pseudo)) {
            Score scoreCourant = getFacadeAlexKiddBattleOnLine().getScoreCourant(getPseudo());
            this.getSession().put("numeroOperation",scoreCourant.getNumeroOperation());
            return SUCCESS;
        }
        else
            return INPUT;
    }



}
