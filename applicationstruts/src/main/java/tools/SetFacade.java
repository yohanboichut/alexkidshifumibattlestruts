package tools;
import modele.FacadeAlexKiddBattleOnLineImpl;
import org.apache.struts2.dispatcher.listener.StrutsListener;

import javax.servlet.ServletContextEvent;

public class SetFacade extends StrutsListener {


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        super.contextInitialized(sce);
        sce.getServletContext().setAttribute("facade",new FacadeAlexKiddBattleOnLineImpl());

    }
}
