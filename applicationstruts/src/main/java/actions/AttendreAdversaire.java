package actions;

import interfaces.exceptions.PseudoDejaPrisException;
import interfaces.type.Score;

public class AttendreAdversaire extends Contexte {


    public String getToken() {
        return (String)getSession().get(Contexte.TOKEN);
    }

    public String getPseudo() {
        return (String)getSession().get(Contexte.PSEUDO);
    }



    @Override
    public String execute() throws Exception {
        String pseudo = (String)this.getSession().get(Contexte.PSEUDO);
        if (getFacadeAlexKiddBattleOnLine().partieCommencee(pseudo)) {
            Score scoreCourant = getFacadeAlexKiddBattleOnLine().getScoreCourant(getPseudo());
            this.getSession().put(Contexte.NUMERO_OPERATION,scoreCourant.getNumeroOperation());
            return SUCCESS;
        }
        else
            return INPUT;
    }



}
