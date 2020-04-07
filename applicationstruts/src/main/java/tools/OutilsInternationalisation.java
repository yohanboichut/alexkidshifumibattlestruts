package tools;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class OutilsInternationalisation {

    public static List<ChoixConnexion> CHOIX = Arrays.asList(new ChoixConnexion(1,"Créer une partie"), new ChoixConnexion(2,"Rejoindre une partie"));
    public static List<ChoixConnexion> CHOIX_EN = Arrays.asList(new ChoixConnexion(1,"New game"), new ChoixConnexion(2,"Join a game"));
    public static List<String> CHOIX_JOUEURS = Arrays.asList("Pierre", "Ciseaux","Feuille");
    public static List<String> CHOIX_JOUEURS_EN = Arrays.asList("Stone", "Scissors","Paper");

    public static Map<String,List<ChoixConnexion>> ASSOCIATION_MENU = new HashMap<>();
    public static Map<String,List<String>> ASSOCIATION_CHOIX = new HashMap<>();
    public static Map<String,String> TRADUCTION = new HashMap<>();

    static {
        ASSOCIATION_MENU.put("fr",CHOIX);
        ASSOCIATION_MENU.put("en",CHOIX_EN);
        ASSOCIATION_CHOIX.put("fr",CHOIX_JOUEURS);
        ASSOCIATION_CHOIX.put("en",CHOIX_JOUEURS_EN);
        TRADUCTION.put("Pierre","Pierre");
        TRADUCTION.put("Stone","Pierre");
        TRADUCTION.put("Ciseaux","Ciseaux");
        TRADUCTION.put("Scissors","Ciseaux");
        TRADUCTION.put("Paper","Feuille");
        TRADUCTION.put("Feuille","Feuille");

    }



}
