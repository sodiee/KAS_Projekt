package GUI;

import Application.Controller.Controller;
import Application.Model.Conference;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class AdminTab extends GridPane {
    private TextField txfCompanions, txfCompanions1, txfCompanions2, txfActivities, txfActivities1, txfActivities2;
    private TextArea txaConferenceDeltagere;
    private ListView lvwHotelParticipants, lvwConference, lvwHotels, lvwActivities, lvwCompanions;
    private Label lblHotelParticipants, lblConferenceDeltagere, lblHotel, lblActivities, lblCompanions;

    public AdminTab() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);
        this.setStyle("-fx-border-color: black");
        lblConferenceDeltagere = new Label("Konference deltagere:");
        this.add(lblConferenceDeltagere, 1, 1);
        lblHotel = new Label("Hoteller tilknyttet konferencen:");
        this.add(lblHotel, 1, 2);
        lblHotelParticipants = new Label("Deltagere på hotel:");
        this.add(lblHotelParticipants, 1, 3);
        lblActivities = new Label("Aktiviteter:");
        this.add(lblActivities, 1, 4);
        lblCompanions = new Label("Ledsagere tilmeldt:");
        this.add(lblCompanions, 3, 4);

        lvwConference = new ListView<>();
        lvwConference.getItems().add(Controller.getConferences());
        this.add(lvwConference, 0, 1);

        txaConferenceDeltagere = new TextArea();
        txaConferenceDeltagere.setText(Controller.getParticipants() + "");
        System.out.println(Controller.getParticipants());
        this.add(txaConferenceDeltagere, 2, 1);

        lvwHotels = new ListView();
        lvwHotels.getItems().add(Controller.getHotels());
        this.add(lvwHotels, 2, 2);

        lvwHotelParticipants = new ListView();
        //lvwHotelParticipants.getItems().add                       fix this shit
        this.add(lvwHotelParticipants, 2, 3);

        //lvwActivities = new ListView();

        txfActivities = new TextField();
        txfActivities1 = new TextField();
        txfActivities2 = new TextField();
        txfCompanions = new TextField();
        txfCompanions1 = new TextField();
        txfCompanions2 = new TextField();
        this.add(txfActivities, 2, 4);
        this.add(txfActivities1, 2, 5);
        this.add(txfActivities2, 2, 6);
        this.add(txfCompanions, 4, 4);
        this.add(txfCompanions1, 4, 5);
        this.add(txfCompanions2, 4, 6);
            txfActivities.setText(Controller.getActivitylist().get(0) + "");
            txfActivities1.setText(Controller.getActivitylist().get(1) + "");
            txfActivities2.setText(Controller.getActivitylist().get(2) + "");
            //txfCompanions.setText(Controller.getCompanionsAtActivity());


        /*lvwCompanions = new ListView();
        lvwCompanions.getItems().add(Controller.getCompanions());
        this.add(lvwCompanions, 2, 7);*/
    }

    private void selectedConferenceChanged() {
        this.updateControls();
    }

    private void updateControls() {
        Conference conference = (Conference) lvwConference.getSelectionModel().getSelectedItem();
        if (conference != null) {
            lvwConference.getItems().add(Controller.getConferences());
            lvwHotels.getItems().add(Controller.getHotels());
            txaConferenceDeltagere.setText(Controller.getParticipants() + "");
        }
    }
}