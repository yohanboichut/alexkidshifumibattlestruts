package tools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class OutilsInternationalisation {

    public static final String CRÉER_UNE_PARTIE = "Créer une partie";
    public static final String REJOINDRE_UNE_PARTIE = "Rejoindre une partie";
    public static List<ChoixConnexion> CHOIX = Arrays.asList(new ChoixConnexion(1, CRÉER_UNE_PARTIE), new ChoixConnexion(2, REJOINDRE_UNE_PARTIE));
    public static final String CREER_UNE_PARTIE_EN = "New game";
    public static final String REJOINDRE_UNE_PARTIE_EN = "Join a game";

    public static List<ChoixConnexion> CHOIX_EN = Arrays.asList(new ChoixConnexion(1, CREER_UNE_PARTIE_EN), new ChoixConnexion(2, REJOINDRE_UNE_PARTIE_EN));
    public static final String PIERRE = "Pierre";
    public static final String CISEAUX = "Ciseaux";
    public static final String FEUILLE = "Feuille";
    public static final String PIERRE_EN = "Stone";
    public static final String CISEAUX_EN = "Scissors";
    public static final String FEUILLE_EN = "Paper";


    public static List<String> CHOIX_JOUEURS = Arrays.asList(PIERRE, CISEAUX, FEUILLE);
    public static List<String> CHOIX_JOUEURS_EN = Arrays.asList(PIERRE_EN, CISEAUX_EN,FEUILLE_EN);

    public static Map<String,List<ChoixConnexion>> ASSOCIATION_MENU = new HashMap<>();
    public static Map<String,List<String>> ASSOCIATION_CHOIX = new HashMap<>();
    public static Map<String,String> TRADUCTION = new HashMap<>();

    static {
        ASSOCIATION_MENU.put("fr",CHOIX);
        ASSOCIATION_MENU.put("en",CHOIX_EN);
        ASSOCIATION_CHOIX.put("fr",CHOIX_JOUEURS);
        ASSOCIATION_CHOIX.put("en",CHOIX_JOUEURS_EN);
        TRADUCTION.put(PIERRE,PIERRE);
        TRADUCTION.put(PIERRE_EN,PIERRE);
        TRADUCTION.put(CISEAUX,CISEAUX);
        TRADUCTION.put(CISEAUX_EN,CISEAUX);
        TRADUCTION.put(FEUILLE_EN,FEUILLE);
        TRADUCTION.put(FEUILLE,FEUILLE);

    }



}
