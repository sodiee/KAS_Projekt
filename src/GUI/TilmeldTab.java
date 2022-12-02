package GUI;

import Application.Controller.Controller;
import Application.Model.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class TilmeldTab extends GridPane {
    private GridPane companionPane = new GridPane();
    private RadioButton rbtnCompanionYes = new RadioButton("Ja");
    private RadioButton rbtnCompanionNo = new RadioButton("Nej");

    private RadioButton rbtnLectureYes, rbtnLectureNo;

    private ToggleGroup tglLecture, tglCompanion;
    private TextField txfDeltagerNavn, txfAdresse, txfByLand, txfTlfNummer, txfAnkomstdato, txfAfrejsedato, txfFirmaNavn, txfFirmaTlfNummer, txfLedsagerNavn, txfLedsagerAdresse, txfLedsagerByLand, txfLedsagerTlf, txfSamletPris;
    private ComboBox<ArrayList<Conference>> conferenceBox;
    private ComboBox<ArrayList<Hotel>> hotelBox;
    private Button btnTilmeld;
    private CheckBox chkHotelBox, chkTrapholt, chkEgeskov, chkByRundtur, chkWifi, chkMorgenmad, chkBad;

    public TilmeldTab() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblComp = new Label("Konference");
        this.add(lblComp, 0, 0);

        GridPane participantPane = new GridPane();
        this.add(participantPane, 0, 1);
        participantPane.setPadding(new Insets(10));
        participantPane.setHgap(10);
        participantPane.setVgap(10);
        participantPane.setStyle("-fx-border-color: black");

        HBox hbxButtons = new HBox(40);
        participantPane.add(hbxButtons, 0, 5, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        conferenceBox = new ComboBox<>();
        conferenceBox.getItems().add(Controller.getConferences());
        participantPane.add(conferenceBox, 1, 1);

        txfDeltagerNavn = new TextField();
        txfAdresse = new TextField();
        txfByLand = new TextField();
        txfTlfNummer = new TextField();
        txfAnkomstdato = new TextField("Eks. 18 november 2023");
        txfAfrejsedato = new TextField();
        txfFirmaNavn = new TextField();
        txfFirmaTlfNummer = new TextField();


        participantPane.add(txfDeltagerNavn, 1, 2);
        txfDeltagerNavn.setOnAction(event -> checkNavn());
        participantPane.add(txfAdresse, 1, 3);
        txfAdresse.setOnAction(event -> checkAdresse());
        participantPane.add(txfByLand, 1, 4);
        txfByLand.setOnAction(event -> checkLand());
        participantPane.add(txfTlfNummer, 1, 5);
        txfTlfNummer.setOnAction(event -> checkTlf());
        participantPane.add(txfAnkomstdato, 1, 6);
        txfAnkomstdato.setOnAction(event -> checkAnkomst());
        participantPane.add(txfAfrejsedato, 1, 7);
        txfAfrejsedato.setOnAction(event -> checkAfrejse());
        participantPane.add(txfFirmaNavn, 1, 8);
        participantPane.add(txfFirmaTlfNummer, 1, 9);

        Label lblinfo = new Label("Deltagerinfo");
        participantPane.add(lblinfo, 1, 0);
        Label lblKonference = new Label("Konference:");
        participantPane.add(lblKonference, 0, 1);
        Label lblNavn = new Label("Deltagernavn:");
        participantPane.add(lblNavn, 0, 2);
        Label lblAdresse = new Label("Adresse:");
        participantPane.add(lblAdresse, 0, 3);
        Label lblByLand = new Label("Land:");
        participantPane.add(lblByLand, 0, 4);
        Label lblTlfNummer = new Label("Tlf.nummer:");
        participantPane.add(lblTlfNummer, 0, 5);
        Label lblAnkomstdato = new Label("Ankomstdato:");
        participantPane.add(lblAnkomstdato, 0, 6);
        Label lblAfrejseDato = new Label("Afrejsedato:");
        participantPane.add(lblAfrejseDato, 0, 7);
        Label lblFirmanavn = new Label("Firmanavn:");
        participantPane.add(lblFirmanavn, 0, 8);
        Label lblFirmaTlf = new Label("Firma Tlf.nr:");
        participantPane.add(lblFirmaTlf, 0, 9);


        tglLecture = new ToggleGroup();
        rbtnLectureYes = new RadioButton("Ja");
        rbtnLectureYes.setToggleGroup(tglLecture);
        rbtnLectureNo = new RadioButton("Nej");
        rbtnLectureNo.setToggleGroup(tglLecture);

        Label lblLecture = new Label("Foredragsholder?");
        participantPane.add(lblLecture, 0, 10);

        HBox hbxVB2 = new HBox(rbtnLectureYes, rbtnLectureNo);
        hbxVB2.setSpacing(10);
        participantPane.add(hbxVB2, 1, 10);

        tglCompanion = new ToggleGroup();


        rbtnCompanionYes.setToggleGroup(tglCompanion);
        rbtnCompanionYes.setUserData("Yes");
        rbtnCompanionYes.setOnAction(event -> yesButtonSelected());


        rbtnCompanionNo.setToggleGroup(tglCompanion);
        rbtnCompanionNo.setUserData("No");
        rbtnCompanionNo.setOnAction(event -> noButtonSelected());

        Label lblCompanion = new Label("Ledsager?");
        participantPane.add(lblCompanion, 0, 11);

        HBox hbxVB1 = new HBox(rbtnCompanionYes, rbtnCompanionNo);
        hbxVB1.setSpacing(10);
        participantPane.add(hbxVB1, 1, 11);

        hotelBox = new ComboBox<>();
        hotelBox.getItems().add(Controller.getHotels());
        participantPane.add(hotelBox, 1, 12);

        Label lblHotel = new Label("Hotel:");
        participantPane.add(lblHotel, 0, 12);

        Label lblNoHotel = new Label("Intet hotel:");
        participantPane.add(lblNoHotel, 0, 13);
        chkHotelBox = new CheckBox();
        participantPane.add(chkHotelBox, 1, 13);

        chkBad = new CheckBox();
        participantPane.add(chkBad, 1, 14);
        Label lblBad = new Label("Ekstra tilvalg Bad:");
        participantPane.add(lblBad, 0, 14);
        chkMorgenmad = new CheckBox();
        participantPane.add(chkMorgenmad, 1, 15);
        Label lblMorgenmad = new Label("Ekstra tilvalg Morgenmad:");
        participantPane.add(lblMorgenmad, 0, 15);
        chkWifi = new CheckBox();
        participantPane.add(chkWifi, 1, 16);
        Label lblWifi = new Label("Ekstra tilvalg Wifi:");
        participantPane.add(lblWifi, 0, 16);

        this.add(companionPane, 1, 1);
        companionPane.setPadding(new Insets(10));
        companionPane.setHgap(10);
        companionPane.setVgap(10);
        companionPane.setStyle("-fx-border-color: black");
        companionPane.setDisable(true);

        txfLedsagerNavn = new TextField();
        txfLedsagerAdresse = new TextField();
        txfLedsagerByLand = new TextField();
        txfLedsagerTlf = new TextField();


        companionPane.add(txfLedsagerNavn, 1, 1);
        companionPane.add(txfLedsagerAdresse, 1, 2);
        companionPane.add(txfLedsagerByLand, 1, 3);
        companionPane.add(txfLedsagerTlf, 1, 4);

        Label linfo = new Label("Ledsagerinfo");
        companionPane.add(linfo, 1, 0);
        Label lbllNavn = new Label("Navn:");
        companionPane.add(lbllNavn, 0, 1);
        Label lbllAdresse = new Label("Adresse:");
        companionPane.add(lbllAdresse, 0, 2);
        Label lbllByLand = new Label("By/Land:");
        companionPane.add(lbllByLand, 0, 3);
        Label lbllTlfNummer = new Label("Tlf.nummer:");
        companionPane.add(lbllTlfNummer, 0, 4);


        GridPane finalPane = new GridPane();
        this.add(finalPane, 0, 2, 2, 2);
        finalPane.setPadding(new Insets(10));
        finalPane.setHgap(300);
        finalPane.setVgap(10);
        finalPane.setStyle("-fx-border-color: black");

        txfSamletPris = new TextField("Samlet pris");
        txfSamletPris.setEditable(false);
        finalPane.add(txfSamletPris, 0, 0);

        btnTilmeld = new Button("Tilmeld");
        finalPane.add(btnTilmeld, 1, 0);
        btnTilmeld.setStyle("-fx-background-color: limegreen");
        btnTilmeld.setOnAction(event -> tilmeldAction());

        Label lblUdflugter = new Label("Udflugter:");
        companionPane.add(lblUdflugter, 0, 6);

        chkByRundtur = new CheckBox();
        companionPane.add(chkByRundtur, 1, 8);

        Label lblByRundtur = new Label("Byrundtur i Odense");
        companionPane.add(lblByRundtur, 0, 8);

        Label lblBrBeskriv = new Label("18/5-22. Pris: 125kr inkl. frokost");
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 14);
        lblBrBeskriv.setFont(font);
        //lblBrBeskriv.setStyle("-fx-font-style: italic; + -fx-font-size: 16;");
        companionPane.add(lblBrBeskriv, 0, 9);

        chkEgeskov = new CheckBox();
        companionPane.add(chkEgeskov, 1, 12);

        Label lblEgeskov = new Label("Egeskov");
        companionPane.add(lblEgeskov, 0, 12);

        Label lblEgeskovBeskriv = new Label("19/5-22. Pris: 75kr");
        Font font1 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 14);
        lblEgeskovBeskriv.setFont(font);
        companionPane.add(lblEgeskovBeskriv, 0, 13);

        chkTrapholt = new CheckBox();
        companionPane.add(chkTrapholt, 1, 16);

        Label lblTrapholt = new Label("Trapholt Museum, Kolding");
        companionPane.add(lblTrapholt, 0, 16);

        Label lblTrapBeskriv = new Label("20/5-22. Pris: 200kr inkl. frokost");
        Font font2 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 14);
        lblTrapBeskriv.setFont(font);
        companionPane.add(lblTrapBeskriv, 0, 17);
    }


    // -------------------------------------------------------------------------
    private void checkAdresse() {
        if (txfAdresse.getText().isEmpty()) {
            alertError("en adresse");
            txfAdresse.setText("");
        }
    }

    private void checkLand() {
        if (txfByLand.getText().isEmpty()) {
            alertError("et land");
            txfByLand.setText("");
        }
    }

    private void checkAnkomst() {
        if (txfAnkomstdato.getText().isEmpty()) {
            alertError("en ankomstdato");
            txfAnkomstdato.setText("");
        }
    }

    private void checkAfrejse() {
        if (txfAfrejsedato.getText().isEmpty()) {
            alertError("en afrejsedato");
            txfAfrejsedato.setText("");
        }
    }

    private void checkNavn() {
        if (txfDeltagerNavn.getText().isEmpty()) {
            alertError("et navn");
            txfDeltagerNavn.setText("");
        }
    }

    private void checkTlf() {
        String s = txfTlfNummer.getText();
        for (var ch : s.toCharArray()) {
            if ('0' <= ch && ch <= '9') {
                ;
            } else {
                alertError("et tal");
                txfTlfNummer.setText("");
            }
        }
    }

    private void checkLecture() {
        if (!tglLecture.getSelectedToggle().isSelected()) {
            alertError("/vælg om du er foredragsholder");
        }
    }

    private void checkCompanion() {
        if (!tglCompanion.getSelectedToggle().isSelected()) {
            alertError("/vælg om du har en ledsager med");
        }
    }

    public void alertError(String string) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Indtast " + string);
        a.showAndWait();
    }

    public void yesButtonSelected() {
        if (rbtnCompanionYes.isSelected()) {
            companionPane.setDisable(false);
        }
    }

    public void noButtonSelected() {
        if (rbtnCompanionNo.isSelected()) {
            companionPane.setDisable(true);
        }
    }

    public boolean tglLectureSelection() {
        boolean lecture = false;
        if (rbtnLectureYes.isSelected()) {
            lecture = true;
        }
        return lecture;
    }

    public Companion tglCompanionSelection() {
        Companion c = null;
        if (rbtnCompanionYes.isSelected()) {
            c = new Companion(txfLedsagerNavn.getText(), txfLedsagerAdresse.getText(), txfLedsagerByLand.getText(), Integer.parseInt(txfLedsagerTlf.getText()));
            Controller.addCompanion(c);
        } if (rbtnCompanionYes.isSelected()) {
            CompanionActivity cA0 = Controller.getActivitylist().get(0);
            CompanionActivity cA1 = Controller.getActivitylist().get(1);
            CompanionActivity cA2 = Controller.getActivitylist().get(2);
            if (chkEgeskov.isSelected()) {
                cA0.addCompanionToActivity(c);
                c.addCompanionActivity(cA0);
            }
            if (chkTrapholt.isSelected()) {
                cA1.addCompanionToActivity(c);
                c.addCompanionActivity(cA1);
            }
            if (chkByRundtur.isSelected()) {
                cA2.addCompanionToActivity(c);
                c.addCompanionActivity(cA2);
            }
        }
        return c;
    }

    public void seSamletPris(ConferenceParticipantData conferenceParticipantData) {
        txfSamletPris.setText(String.valueOf(Controller.getPris(conferenceParticipantData)));
    }

    public void createCompanion() {
        Companion c = new Companion(txfLedsagerNavn.getText(), txfLedsagerAdresse.getText(), txfLedsagerByLand.getText(), Integer.parseInt(txfLedsagerTlf.getText()));
        Controller.addCompanion(c);
    }


    public void checkChkBoxes() {
        if (rbtnCompanionYes.isSelected()) {
            Companion c = new Companion(txfLedsagerNavn.getText(), txfLedsagerAdresse.getText(), txfLedsagerByLand.getText(), Integer.parseInt(txfLedsagerTlf.getText()));
            CompanionActivity cA0 = Controller.getActivitylist().get(0);
            CompanionActivity cA1 = Controller.getActivitylist().get(1);
            CompanionActivity cA2 = Controller.getActivitylist().get(2);
            if (chkEgeskov.isSelected()) {
                cA0.addCompanionToActivity(c);
            }
            if (chkTrapholt.isSelected()) {
                cA1.addCompanionToActivity(c);
            }
            if (chkByRundtur.isSelected()) {
                cA2.addCompanionToActivity(c);
            }
        }
    }

    public void tilmeldAction() {

        Hotel hotel = null;
        ArrayList<HotelExtraChoices> hotelExtraChoices = new ArrayList<>();
        if (!chkHotelBox.isSelected()) {
            hotel = hotelBox.getValue().get(0);
            System.out.println(hotel);
            if (chkBad.isSelected()) {
                HotelExtraChoices bad = hotel.getExtraChoices().get(0);
                hotelExtraChoices.add(bad);
            }
            if (chkMorgenmad.isSelected()) {
                HotelExtraChoices morgenmad = hotel.getExtraChoices().get(1);
                hotelExtraChoices.add(morgenmad);
            }
            if (chkWifi.isSelected()) {
                HotelExtraChoices wifi = hotel.getExtraChoices().get(2);
                hotelExtraChoices.add(wifi);
            }
        } else {
            hotelBox.getSelectionModel().clearSelection();
            chkMorgenmad.setSelected(false);
            chkBad.setSelected(false);
            chkWifi.setSelected(false);
        }
        boolean lecture = false;
        if (rbtnLectureYes.isSelected()) {
            lecture = true;
        }
        checkNavn();
        checkTlf();
        checkAdresse();
        checkAfrejse();
        checkAnkomst();
        checkLand();
        checkLecture();
        checkCompanion();
        Participant p = new Participant(txfDeltagerNavn.getText(), txfAdresse.getText(), txfByLand.getText(), Integer.parseInt(txfTlfNummer.getText()));
        var idxConf = conferenceBox.getSelectionModel().getSelectedIndex();
        var conf = Controller.getConferences().get(idxConf);
        ConferenceParticipantData cPD = Controller.createConferenceParticipantData(conf, p, hotel, tglCompanionSelection(), tglLectureSelection(), 3, hotelExtraChoices); //((Integer.parseInt(txfAfrejsedato.getText()) - Integer.parseInt(txfAnkomstdato.getText())) + 1));
        seSamletPris(cPD);
    }


    public Hotel chosenHotel() {
        if (hotelBox.getSelectionModel().getSelectedIndex() == 0) {
            return null;
        } else {
            var idxHot = hotelBox.getSelectionModel().getSelectedIndex();
            return Controller.getHotels().get(idxHot);
        }
    }
}

