package interfaces.type;

public interface Score {

    /**
     *
     * @return le score du joueur 1
     */
    int getScoreJoueur1();

    /**
     *
     * @return le score du joueur 2
     */
    int getScoreJoueur2();

    /**
     *
     * @return : pseudo du joueur 1
     */
    String getJoueur1();

    /**
     *
     * @return : peseudo du joueur 2
     */
    String getJoueur2();

    /**
     *
     * @return : le choix du joueur 1
     */
    String getChoixJoueur1();

    /**
     *
     * @return : le choix du joueur 2
     */
    String getChoixJoueur2();

    /**
     *
     * @return : le numéro de l'opération. Ce numéro évolue quand les joueurs ont chacun fait leur choix.
     * 0 : initialisation de la partie
     * 1 : les deux joueurs ont fait leur choix
     * 2 : les deux joueurs ont fait leur choix pour la deuxième manche
     * 3 : les deux joueurs ont fait leur choix pour la troisième manche si celle ci a lieu
     */
    int getNumeroOperation();
}
