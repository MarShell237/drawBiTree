package drawTree.src.main.java.com.drawtree;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

import static java.lang.String.valueOf;

public class Noeud {
    int valeur;
    Text t;
    Circle c;
    int cx = 400;

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    int cy = 70;
    Noeud gauche, droit;

    static ArrayList<Noeud> allNode = new ArrayList<>();

    public ArrayList<Line> getAllLine() {
        return allLine;
    }

    static ArrayList<Line> allLine = new ArrayList<>();


    public Text getT() {
        return t;
    }

    public Circle getC() {
        return c;
    }

    public ArrayList<Noeud> getAllNode() {
        return allNode;
    }
    public Noeud(int valeur) {
        this.valeur = valeur;
        gauche = droit = null;
        c = new Circle(cx,cy,20);

        if (valueOf(valeur).length() == 2)
            t = new Text(cx-10,cy+5, valueOf(valeur));
        else
            t = new Text(cx-5,cy+5, valueOf(valeur));

        t.setFill(Color.WHITE);
        t.setFont(Font.font(20));
    }
}
