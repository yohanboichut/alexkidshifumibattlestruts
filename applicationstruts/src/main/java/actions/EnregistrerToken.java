package actions;

import interfaces.exceptions.PseudoDejaPrisException;
import interfaces.exceptions.TicketInvalideException;
import interfaces.exceptions.TicketPerimeException;
import interfaces.type.Score;

public class EnregistrerToken extends Contexte {


    private String token;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public String getPseudo() {
        return (String)this.getSession().get(Contexte.PSEUDO);
    }

    @Override
    public String execute() throws Exception {
        String pseudo = (String) this.getSession().get(Contexte.PSEUDO);
        try {
            getFacadeAlexKiddBattleOnLine().rejoindreUnePartie(pseudo,token);
            Score scoreCourant = getFacadeAlexKiddBattleOnLine().getScoreCourant(getPseudo());
            this.getSession().put(Contexte.NUMERO_OPERATION,scoreCourant.getNumeroOperation());
            return SUCCESS;

        }
        catch (TicketInvalideException e) {
            this.addFieldError("token","Le token saisi est invalide !");
            return INPUT;
        }

        catch (TicketPerimeException e) {
            this.addFieldError("token","Le token n'est plus valide !");
            return INPUT;
        }

        catch (PseudoDejaPrisException e) {
            this.addFieldError("pseudo","Le pseudo est déjà pris");
            return "accueil";
        }
        catch (IllegalArgumentException e) {
            this.addFieldError("token","Le token saisi est invalide !");
            return INPUT;
        }

    }

}
