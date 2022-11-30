package GUI;

import Application.Controller.Controller;
import Application.Model.Conference;
import Application.Model.Hotel;
import Application.Model.Participant;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class AdminTab extends GridPane {
    private TextArea txaConferenceDeltagere;
    private ListView lvwHotelParticipants, lvwConference, lvwHotels;
    private Label lblHotelParticipants, lblConferenceDeltagere, lblHotel;
    private Hotel hotel;

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




        lvwConference = new ListView<>();
        lvwConference.getItems().add(Controller.getConferences());
        this.add(lvwConference, 0, 1);

        lvwHotels = new ListView();
        lvwHotels.getItems().add(Controller.getHotels());
        this.add(lvwHotels, 2, 2);

        lvwHotelParticipants = new ListView();
        //lvwHotelParticipants.getItems().add                       fix this shit
        this.add(lvwHotelParticipants, 2, 3);

        txaConferenceDeltagere = new TextArea();
        txaConferenceDeltagere.setText(Controller.getParticipants() + "");
        System.out.println(Controller.getParticipants());
        this.add(txaConferenceDeltagere, 2, 1);
    }

    /*private void selectedConferenceChanged() {
        this.updateControls();
    }

    private void updateControls() {
        Conference conference = (Conference) lvwConference.getSelectionModel().getSelectedItem();
        if (conference != null) {
            txaConferenceDeltagere.setText(Controller.getListOfParticipant(conference) + "");
            lvwHotels.getItems().setAll(Controller.getHotels());

            /*StringBuilder sb2 = new StringBuilder();
            for (Customer cu : company.getCustomers()) {
                sb2.append(cu + "\n");
            }
            txaCustomers.setText(sb2.toString());
        } else {
            txfName.clear();
            txfHours.clear();
            txaEmps.clear();
        }*/
}
