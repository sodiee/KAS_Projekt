package GUI;

import Application.Controller.Controller;
import Application.Model.*;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AdminTab extends GridPane {
    private TextField txfCompanions, txfCompanions1, txfCompanions2, txfActivities, txfActivities1, txfActivities2;
    private ListView<Hotel> lvwHotels;
    private ListView<Conference> lvwConference;
    private ListView<CompanionActivity> lvwActivities;
    private ListView<Companion> lvwCompanion;
    private ListView<Participant> lvwHotelParticipants, lvwConferenceDeltagere;
    private Label lblConference, lblHotelParticipants, lblConferenceDeltagere, lblHotel, lblActivities, lblCompanions;

    public AdminTab() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);
        this.setStyle("-fx-border-color: black");
        lblConference = new Label("Konference:");
        this.add(lblConference,0,0);
        lblConferenceDeltagere = new Label("Konference deltagere:");
        this.add(lblConferenceDeltagere, 1, 1);
        lblHotel = new Label("Hoteller tilknyttet konferencen:");
        this.add(lblHotel, 1, 2);
        lblHotelParticipants = new Label("Deltagere på hotellet:");
        this.add(lblHotelParticipants, 3, 2);
        lblActivities = new Label("Aktiviteter:");
        this.add(lblActivities, 1, 3);
        lblCompanions = new Label("Ledsagere tilmeldt:");
        this.add(lblCompanions, 3, 3);

        lvwConference = new ListView<>();
        lvwConference.getItems().setAll(Controller.getConferences());
        lvwConference.getSelectionModel().selectedItemProperty().addListener((ov, oldValue, newValue) -> this.selectedConferenceChanged(newValue));
        this.add(lvwConference, 0, 1);

        lvwConferenceDeltagere = new ListView<>();
        this.add(lvwConferenceDeltagere, 2, 1);

        lvwHotels = new ListView<>();
        this.add(lvwHotels, 2, 2);
        lvwHotels.getSelectionModel().selectedItemProperty().addListener((ov, oldValue, newValue) -> this.selectedHotelChanged(newValue));

        lvwHotelParticipants = new ListView<>();
        this.add(lvwHotelParticipants, 4, 2);

        lvwActivities = new ListView<>();
        this.add(lvwActivities, 2, 3);
        lvwActivities.getSelectionModel().selectedItemProperty().addListener((ov, oldValue, newValue) -> this.selectedActivityChanged(newValue));

        lvwCompanion = new ListView<>();
        this.add(lvwCompanion, 4, 3);
    }

    private void selectedActivityChanged(CompanionActivity newValue) {
        if (newValue != null) {
            lvwCompanion.getItems().setAll(newValue.getCompanionAtActivity());
        }
    }

    private void selectedHotelChanged(Hotel newValue) {
        if (newValue != null) {
           lvwHotelParticipants.getItems().setAll(newValue.getParticipantsInHotel());
        }
    }

    private void selectedConferenceChanged(Conference newValue) {
        if (newValue != null) {
            lvwHotels.getItems().setAll(newValue.getListOfHotels());
            lvwConferenceDeltagere.getItems().setAll(Controller.getParticipants());
            System.out.println("TxaConfDeltager" + Controller.getParticipants());
            lvwActivities.getItems().setAll(Controller.getActivitylist());
        }
    }

    private void updateControls() {
        Conference conference = (Conference) lvwConference.getSelectionModel().getSelectedItem();
        if (conference != null) {
            lvwConference.getItems().setAll(Controller.getConferences());
            lvwHotels.getItems().setAll(Controller.getHotels());
            lvwConferenceDeltagere.getItems().setAll(Controller.getParticipants());
        }
    }
}