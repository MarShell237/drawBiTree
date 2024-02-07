package drawTree.src.main.java.com.drawtree;

import javafx.scene.shape.Line;

import java.util.ArrayList;

import static drawTree.src.main.java.com.drawtree.Noeud.allLine;

public class ArbreBinaireRecherche {
    public Noeud getRacine() {
        return racine;
    }
    private Noeud racine;

    public ArbreBinaireRecherche() {
        racine = null;
    }

    // Méthode pour insérer une valeur dans l'arbre
    public void inserer(int valeur) {
        racine = insererRecursive(racine, valeur);
    }

    private Noeud insererRecursive(Noeud racine, int valeur) {
        if (racine == null) {
            racine = new Noeud(valeur);
            return racine;
        }

        if (valeur <= racine.valeur) {
            racine.gauche = insererRecursive(racine.gauche, valeur);
        } else {
            racine.droit = insererRecursive(racine.droit, valeur);
        }

        return racine;
    }

    // Méthode pour effectuer un parcours en ordre croissant de l'arbre
    public void parcoursEnOrdre() {
        parcoursEnOrdreRecursive(racine);
    }

    private void parcoursEnOrdreRecursive(Noeud racine) {
        if (racine != null) {
            parcoursEnOrdreRecursive(racine.gauche);
            System.out.print(racine.valeur + " ");
            parcoursEnOrdreRecursive(racine.droit);
        }
    }

    public void fillArray() {
        fillArrayRecursif(racine);
    }

    private void fillArrayRecursif(Noeud racine) {
        if (racine != null) {
            if (racine.gauche != null) {
                racine.gauche.getC().setCenterX(racine.getC().getCenterX() - 80);
                racine.gauche.getC().setCenterY(racine.getC().getCenterY() + 80);
                racine.gauche.getT().setX(racine.getC().getCenterX() - 80-5);
                racine.gauche.getT().setY(racine.getC().getCenterY() + 80+5);
                allLine.add(new Line(racine.getC().getCenterX(),racine.getC().getCenterY(), racine.getC().getCenterX() - 80,racine.getC().getCenterY() + 80));
            }
            if (racine.droit != null) {
                racine.droit.getC().setCenterX(racine.getC().getCenterX() + 80);
                racine.droit.getC().setCenterY(racine.getC().getCenterY() + 80);
                racine.droit.getT().setX(racine.getC().getCenterX() + 80-5);
                racine.droit.getT().setY(racine.getC().getCenterY() + 80+5);
                allLine.add(new Line(racine.getC().getCenterX(),racine.getC().getCenterY(), racine.getC().getCenterX() + 80,racine.getC().getCenterY() + 80));
            }
            Noeud.allNode.add(racine);
            fillArrayRecursif(racine.gauche);
            fillArrayRecursif(racine.droit);
        }
    }



    public void drawTree(){
        drawTreeTwo(racine);
    }

    public static void drawTreeTwo(Noeud racine){

    }

//    public static void main(String[] args) {
//        ArbreBinaireRecherche arbre = new ArbreBinaireRecherche();
//
//        arbre.inserer(50);
//        arbre.inserer(30);
//        arbre.inserer(70);
//        arbre.inserer(20);
//        arbre.inserer(40);
//        arbre.inserer(60);
//        arbre.inserer(80);
//
//        System.out.println("Parcours en ordre croissant de l'arbre : ");
//        arbre.parcoursEnOrdre();
//    }
}
