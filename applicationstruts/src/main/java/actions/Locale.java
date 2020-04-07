package actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import tools.OutilsInternationalisation;

import java.util.Map;

public class Locale extends ActionSupport implements SessionAware {

    private Map<String,Object> session;

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public String execute() throws Exception {
java.util.Locale ww_trans_i18N_locale = (java.util.Locale) this.getSession().get("WW_TRANS_I18N_LOCALE");
        String locale =  (ww_trans_i18N_locale == null) ? "fr":"en";



        if (!locale.equals("en")) {
            locale = "fr";
        }
        this.getSession().put(Contexte.MENU_JEU, OutilsInternationalisation.ASSOCIATION_MENU.get(locale));
        this.getSession().put(Contexte.MENU_JOUEUR,OutilsInternationalisation.ASSOCIATION_CHOIX.get(locale));
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
}
