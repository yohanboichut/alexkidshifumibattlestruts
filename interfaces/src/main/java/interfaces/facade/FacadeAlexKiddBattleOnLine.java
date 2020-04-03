package interfaces.facade;

import interfaces.type.Score;
import interfaces.exceptions.*;

public interface FacadeAlexKiddBattleOnLine {


    /**
     * Constantes utilisées dans l'application
     */
    String PIERRE="Pierre";
    String FEUILLE="Feuille";
    String CISEAUX = "Ciseaux";


    /**
     * Permet de créer une partie
     * @param joueur : nom du créateur
     * @return token à partager avec la personne que l'on veut inviter
     */

    String creerPartie(String joueur) throws PseudoDejaPrisException;

    /**
     * Permet de rejoindre une partie
     * @param joueur : nom du joueur qui veut rejoindre la partie
     * @param ticket : token transmis par le créateur
     * @throws TicketInvalideException : Le token n'est pas de la forme attendue
     * @throws PartieDejaPleineException : Le token a déjà été utilisé pour rejoindre une partie
     * @throws TicketPerimeException : Le token n'est plus valide, la partie concernée n'existe plus
     */
    void rejoindreUnePartie(String joueur, String ticket) throws PseudoDejaPrisException, TicketInvalideException, PartieDejaPleineException, TicketPerimeException;

    /**
     * Permet à un joueur de déterminer son choix : Pierre, Ciseaux ou Feuille
     * @param joueur : nom du joueur faisant le choix
     * @param choix : choix du joueur
     * @throws ChoixDejaFaitException : le joueur a déjà fait un choix pour cette manche
     */
    void choixJoueur(String joueur, String choix) throws ChoixDejaFaitException;


    /**
     * Permet de savoir si la partie à laquelle le joueur participe est terminée ou non
     * @param joueur
     * @return
     *  - vrai : la partie est terminée
     *  - faux : la partie n'est pas encore terminée
     */
    boolean partieTerminee(String joueur);


    /**
     * Permet d'avoir le vainqueur de la partie où joueur est impliqué
     * @param joueur
     * @return : le pseudo du vainqueur
     * @throws PartieNonTermineeException : la partie n'est pas terminée, donc il n'y a pas encore de vainqueur
     */
    String getVainqueur(String joueur) throws PartieNonTermineeException;

    /**
     * Permet de savoir si la partie à laquelle le joueur participe est commencée ou non (l'invité a rejoint la partie)
     * @param joueur
     * @return
     *  - vrai : la partie peut commencer
     *  - faux : le joueur invité n'a pas encore rejoint la partie
     */
    boolean partieCommencee(String joueur);

    /**
     * Permet d'avoir le score courant (l'état de la partie) de la partie du joueur concerné
     * @param joueur
     * @return
     */
    Score getScoreCourant(String joueur);

    /**
     * La partie est terminée, le joueur quitte l'application
     * @param nomJoueur
     */
    void finDePartie(String nomJoueur);
}
