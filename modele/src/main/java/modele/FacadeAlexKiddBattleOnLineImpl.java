package modele;



import interfaces.facade.FacadeAlexKiddBattleOnLine;
import interfaces.exceptions.*;
import interfaces.type.*;

import modele.dataencryption.DataChiffrement;
import modele.dataencryption.Invitation;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class FacadeAlexKiddBattleOnLineImpl implements FacadeAlexKiddBattleOnLine {

    private Map<Integer,Partie> parties;
    private Map<String,Partie> associationJoueurPartie;
    DataChiffrement dataChiffrement;



    public FacadeAlexKiddBattleOnLineImpl() {
        this.parties = new HashMap<>();
        this.associationJoueurPartie = new HashMap<>();
        this.dataChiffrement = new DataChiffrement("mon super secret pour chiffrer");
    }

    @Override
    public String creerPartie(String joueur) throws PseudoDejaPrisException {
        if (this.associationJoueurPartie.containsKey(joueur))
            throw new PseudoDejaPrisException();
        Partie partie = new Partie(joueur);
        int id = partie.getIdentifiantPartie();
        this.associationJoueurPartie.put(joueur,partie);
        this.parties.put(id,partie);
        Invitation data = new Invitation();
        data.setIdPartie(id);
        data.setJoueurCreateur(joueur);
        return this.dataChiffrement.chiffrement(data);
    }


    @Override
    public void rejoindreUnePartie(String joueur, String ticket) throws PseudoDejaPrisException, TicketInvalideException, PartieDejaPleineException, TicketPerimeException {
        if (this.associationJoueurPartie.containsKey(joueur))
            throw new PseudoDejaPrisException();
        Invitation invitation = this.dataChiffrement.dechiffrement(ticket);
        Partie partie = this.parties.get(invitation.getIdPartie());
        if (Objects.isNull(partie)) {
            throw new TicketPerimeException();
        }
        partie.rejoindrePartie(joueur);
        this.associationJoueurPartie.put(joueur,this.parties.get(invitation.getIdPartie()));
    }

    @Override
    public void choixJoueur(String joueur, String choix) throws ChoixDejaFaitException {
        Partie partie = this.associationJoueurPartie.get(joueur);
        partie.choixJoueur(joueur,choix);
    }

    @Override
    public boolean partieTerminee(String joueur) {
        return this.associationJoueurPartie.get(joueur).partieTerminee();
    }

    @Override
    public String getVainqueur(String joueur) throws PartieNonTermineeException {
        return this.associationJoueurPartie.get(joueur).getVainqueur();
    }

    @Override
    public boolean partieCommencee(String joueur) {
        return this.associationJoueurPartie.get(joueur).partieCommencee();
    }

    @Override
    public Score getScoreCourant(String joueur) {
        return this.associationJoueurPartie.get(joueur).getScoreCourant();
    }

    @Override
    public void finDePartie(String nomJoueur) {

        Partie p = this.associationJoueurPartie.get(nomJoueur);
        this.parties.remove(p.getIdentifiantPartie(),p);
        this.associationJoueurPartie.remove(nomJoueur,p);

    }
}
