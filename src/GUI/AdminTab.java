package GUI;

import Application.Controller.Controller;
import Application.Model.Conference;
import Application.Model.Participant;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class AdminTab extends GridPane {
    private TextArea conferenceDeltagere;
    private ComboBox conferenceBox;

    public AdminTab() {
         this.setPadding(new Insets(20));
         this.setHgap(20);
         this.setVgap(10);
         this.setGridLinesVisible(false);
        this.setStyle("-fx-border-color: black");



         /*ListView<ArrayList<Conference>> lvwConf = new ListView<ArrayList<Conference>>();
         this.add(lvwConf,0,0);
         lvwConf.getItems().add(Controller.getConferences());*/

         conferenceBox = new ComboBox<>();
         conferenceBox.getItems().add(Controller.getConferences());
         this.add(conferenceBox, 1, 1);


         conferenceDeltagere = new TextArea();
         this.add(conferenceDeltagere, 0, 1);
    }
}
