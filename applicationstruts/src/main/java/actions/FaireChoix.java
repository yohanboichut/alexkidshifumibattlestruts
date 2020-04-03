package actions;

import interfaces.type.Score;

public class FaireChoix extends Contexte {

    private String choix;

    public String getChoix() {
        return choix;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }


    @Override
    public String execute() throws Exception {
        String pseudo = (String)this.getSession().get("pseudo");
        getFacadeAlexKiddBattleOnLine().choixJoueur(pseudo,choix);
        return SUCCESS;
    }

}
