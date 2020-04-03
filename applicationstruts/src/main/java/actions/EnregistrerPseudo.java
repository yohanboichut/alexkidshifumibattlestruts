package actions;

import interfaces.exceptions.PseudoDejaPrisException;

import java.util.Map;

public class EnregistrerPseudo extends Contexte {


    private String pseudo;
    private int choix;

    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getChoix() {
        return choix;
    }

    public void setChoix(int choix) {
        this.choix = choix;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }


    @Override
    public String execute() throws Exception {
        this.getSession().put("pseudo",this.pseudo);
        if (choix == 1) {
            try {
                this.token = this.getFacadeAlexKiddBattleOnLine().creerPartie(pseudo);
                this.getSession().put("token",token);
                return "recuperertoken";
            }
            catch (PseudoDejaPrisException e) {
                this.addFieldError("pseudo","Le pseudo "+pseudo+ " est déjà pris !");
                return INPUT;
            }

        }
        else
            return "saisirtoken";
    }

}
