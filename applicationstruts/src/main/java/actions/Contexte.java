package actions;

import com.opensymphony.xwork2.ActionSupport;
import interfaces.facade.FacadeAlexKiddBattleOnLine;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import tools.ChoixConnexion;

import java.util.List;
import java.util.Map;

public  abstract class Contexte extends ActionSupport implements ApplicationAware, SessionAware {


    public static final String PSEUDO = "pseudo";
    public static final String MENU_JEU="menuJeu";
    public static final String MENU_JOUEUR="menuJoueur";
    public static final String FACADE = "facade";
    protected static final String TOKEN = "token";
    protected static final String NUMERO_OPERATION = "numeroOperation";

    private FacadeAlexKiddBattleOnLine facadeAlexKiddBattleOnLine;

    private Map<String, Object> session;


    public Map<String, Object> getSession() {
        return session;
    }

    public FacadeAlexKiddBattleOnLine getFacadeAlexKiddBattleOnLine() {
        return facadeAlexKiddBattleOnLine;
    }


    public List<ChoixConnexion> getMenu(){
        return (List<ChoixConnexion>) getSession().get(MENU_JEU);
    }

    @Override
    public void setApplication(Map<String, Object> map) {
        this.facadeAlexKiddBattleOnLine = (FacadeAlexKiddBattleOnLine)map.get(FACADE);
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
