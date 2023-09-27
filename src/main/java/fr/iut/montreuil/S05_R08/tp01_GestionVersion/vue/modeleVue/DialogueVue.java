package fr.iut.montreuil.S05_R08.tp01_GestionVersion.vue.modeleVue;

import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.Joueur;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.acteurs.Acteur;
import fr.iut.montreuil.S05_R08.tp01_GestionVersion.modele.acteurs.Pnj;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class DialogueVue {
    private Label label;
    private Pane pane;
    private Joueur joueur;
    public static long tempsDebutDialogue;

    public DialogueVue(Label label, Pane pane, Joueur joueur) {
        this.label = label;
        this.pane = pane;
        this.joueur = joueur;
    }

    public void debutDialogueTimeSetter(long temps) {
        tempsDebutDialogue = temps;
    }

    public void checkDialogueTimerOut(long tempsActuel) {
        //si on reste 5 seconde la fenetre de dialogue disparait.
        if (tempsActuel == tempsDebutDialogue + 2000)
            pane.setVisible(false);
    }

    public void afficherDialogue(Acteur a) {
        //partie visibilité
        this.pane.setVisible(!this.pane.isVisible());

        //partie set text
        Pnj pnj = (Pnj) a;
        if (!joueur.getListeQuetes().getQueteActuelle().getTitre().startsWith("Felicitation")) {
            this.label.setText(pnj.getNextRepliques());
            if (pnj.getNom().equals("panneau"))
                this.joueur.sawAdd = true;
        } else this.label.setText(pnj.getRepliquesFinDuJeu().get(0));
    }
}

