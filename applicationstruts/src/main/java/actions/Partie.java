package actions;

import java.util.List;

public interface Partie {

    String getPseudoJoueur1();
    String getPseudoJoueur2();
    int getScoreJoueur1();
    int getScoreJoueur2();
    String getChoixJoueur1();
    String getChoixJoueur2();

    List<String> getChoixJoueurs();
}
