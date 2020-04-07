package actions;

public class Deconnexion extends Contexte {


    @Override
    public String execute() throws Exception {
        String pseudo = (String) getSession().get("pseudo");
        getFacadeAlexKiddBattleOnLine().finDePartie(pseudo);
        getSession().remove("pseudo",pseudo);
        return SUCCESS;
    }
}
