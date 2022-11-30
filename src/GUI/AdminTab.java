package GUI;

import Application.Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class AdminTab extends GridPane {
    private TextArea conferenceDeltagere;
    private ComboBox conferenceBox;

    public void adminPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        GridPane adminPane = new GridPane();
        this.add(adminPane, 0, 1);
        adminPane.setPadding(new Insets(10));
        adminPane.setHgap(10);
        adminPane.setVgap(10);
        adminPane.setStyle("-fx-border-color: black");

        conferenceBox = new ComboBox<>();
        conferenceBox.getItems().add(Controller.getConferences());
        adminPane.add(conferenceBox, 1, 1);

        conferenceDeltagere = new TextArea();
        conferenceDeltagere.setText("N");
        adminPane.add(conferenceDeltagere, 1, 1);

        TextField h = new TextField();
    }
}