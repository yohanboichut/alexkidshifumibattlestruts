package actions;

import com.opensymphony.xwork2.ActionSupport;
import interfaces.facade.FacadeAlexKiddBattleOnLine;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import tools.ChoixConnexion;
import tools.Menu;

import java.util.List;
import java.util.Map;

public  abstract class Contexte extends ActionSupport implements ApplicationAware, SessionAware {


    private FacadeAlexKiddBattleOnLine facadeAlexKiddBattleOnLine;

    private Map<String, Object> session;


    public Map<String, Object> getSession() {
        return session;
    }

    public FacadeAlexKiddBattleOnLine getFacadeAlexKiddBattleOnLine() {
        return facadeAlexKiddBattleOnLine;
    }

    public List<ChoixConnexion> getMenu(){
        return Menu.CHOIX;
    }

    @Override
    public void setApplication(Map<String, Object> map) {
        this.facadeAlexKiddBattleOnLine = (FacadeAlexKiddBattleOnLine)map.get("facade");
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
