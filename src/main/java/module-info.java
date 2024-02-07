module com.drawtree {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.drawtree to javafx.fxml;
    exports com.drawtree;
    exports drawTree.src.main.java.com.drawtree;
    opens drawTree.src.main.java.com.drawtree to javafx.fxml;
}