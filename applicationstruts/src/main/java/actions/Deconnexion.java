package actions;

public class Deconnexion extends Contexte {


    @Override
    public String execute() throws Exception {
        String pseudo = (String) getSession().get(Contexte.PSEUDO);
        getFacadeAlexKiddBattleOnLine().finDePartie(pseudo);
        getSession().remove(Contexte.PSEUDO,pseudo);
        return SUCCESS;
    }
}
