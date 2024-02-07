package com.drawtree;

import drawTree.src.main.java.com.drawtree.ArbreBinaireRecherche;
import drawTree.src.main.java.com.drawtree.Noeud;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class DrawABRApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane root = new AnchorPane();

        Circle c = new Circle(400,70,20);
        Text t = new Text(c.getCenterX()-5,c.getCenterY()+5,"a");
        t.setFill(Color.WHITE);
        t.setFont(Font.font(20));
        Line l = new Line(c.getCenterX(),c.getCenterY(),c.getCenterX()+80,c.getCenterY()+80);
        Line l1 = new Line(c.getCenterX(),c.getCenterY(),c.getCenterX()-80,c.getCenterY()+80);

        Circle c1 = new Circle(c.getCenterX()+80,c.getCenterY()+80,20);
        Circle c2 = new Circle(c.getCenterX()-80,c.getCenterY()+80,20);


        Text t1 = new Text(c.getCenterX()-80-5,c.getCenterY()+80+5,"b");
        Text t2 = new Text(c.getCenterX()+80-5,c.getCenterY()+80+5,"c");
        t1.setFill(Color.WHITE);
        t2.setFill(Color.WHITE);
        t1.setFont(Font.font(20));
        t2.setFont(Font.font(20));
//        root.getChildren().addAll(c,c1,c2,l,l1,t,t1,t2);

        Scene scene = new Scene(root, 800, 700);
        stage.setTitle("Draw Binary Search Tree");
        ArbreBinaireRecherche arbre = new ArbreBinaireRecherche();

        arbre.inserer(5);
        arbre.inserer(3);
        arbre.inserer(7);
        arbre.inserer(2);
        arbre.inserer(4);
        arbre.inserer(8);
        arbre.inserer(18);
        arbre.inserer(12);
        arbre.inserer(1);
        arbre.inserer(13);
        arbre.inserer(31);




        System.out.println("Parcours en ordre croissant de l'arbre : ");
        arbre.parcoursEnOrdre();
        arbre.fillArray();

        ArrayList<Line> al = arbre.getRacine().getAllLine();
        for (Line li: al) {
            root.getChildren().add(li);
        }

        ArrayList<Noeud> ab = arbre.getRacine().getAllNode();
        System.out.println("\n"+ab.size());
        for (Noeud n: ab) {
            root.getChildren().addAll(n.getC(),n.getT());
            System.out.println(n.getC().getCenterX()+" "+n.getC().getCenterY());
        }
        Text title = new Text(150,ab.getLast().getC().getCenterY()+150,"Arbre Binaire de Recherche Generer a partir du tableau [5,3,7,2,4,8,18,12,1,13,31]");
        title.setFont(new Font(30));
        title.setTextAlignment(TextAlignment.CENTER);
        title.setWrappingWidth(500);
        title.setUnderline(true);
        root.getChildren().add(title);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
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
    }
}