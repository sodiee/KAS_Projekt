package GUI;

import Application.Controller.Controller;
import Application.Model.Conference;
import Application.Model.Hotel;
import Application.Model.Participant;
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

    private ToggleGroup tglLecture;
    private TextField txfDeltagerNavn, txfAdresse, txfByLand, txfTlfNummer, txfAnkomstdato, txfAfrejsedato, txfFirmaNavn, txfFirmaTlfNummer;
    private ComboBox<ArrayList<Conference>> conferenceBox;
    private ComboBox<ArrayList<Hotel>> hotelBox;
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
        txfAnkomstdato = new TextField("DD / måned i String / år");
        txfAfrejsedato = new TextField();
        txfFirmaNavn = new TextField();
        txfFirmaTlfNummer = new TextField();


        participantPane.add(txfDeltagerNavn, 1, 2);
        txfDeltagerNavn.setOnKeyTyped(event -> checkNavn());
        participantPane.add(txfAdresse, 1, 3);
        participantPane.add(txfByLand, 1, 4);
        participantPane.add(txfTlfNummer, 1, 5);
        participantPane.add(txfAnkomstdato, 1, 6);
        participantPane.add(txfAfrejsedato, 1, 7);
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
        Label lblByLand = new Label("By/Land:");
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
        RadioButton rbtnLectureYes = new RadioButton("Ja");
        rbtnLectureYes.setToggleGroup(tglLecture);
        RadioButton rbtnLectureNo = new RadioButton("Nej");
        rbtnLectureNo.setToggleGroup(tglLecture);

        Label lblLecture = new Label("Foredragsholder?");
        participantPane.add(lblLecture, 0, 10);

        HBox hbxVB2 = new HBox(rbtnLectureYes, rbtnLectureNo);
        hbxVB2.setSpacing(10);
        participantPane.add(hbxVB2, 1, 10);

        ToggleGroup tglCompanion = new ToggleGroup();


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

        this.add(companionPane, 1, 1);
        companionPane.setPadding(new Insets(10));
        companionPane.setHgap(10);
        companionPane.setVgap(10);
        companionPane.setStyle("-fx-border-color: black");
        companionPane.setDisable(true);

        TextField txfLedsagerNavn = new TextField();
        TextField txfLedsagerAdresse = new TextField();
        TextField txfLedsagerByLand = new TextField();
        TextField txfLedsagerTlf = new TextField();
        txfTlfNummer.setOnKeyTyped(event -> checkTlf());


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

        TextField txfSamletPris = new TextField("Samlet pris");
        txfSamletPris.setEditable(false);
        finalPane.add(txfSamletPris, 0, 0);

        Button btnTilmeld = new Button("Tilmeld");
        finalPane.add(btnTilmeld, 1, 0);
        btnTilmeld.setStyle("-fx-background-color: limegreen");
        btnTilmeld.setOnAction(event -> tilmeldAction());

        Label lblUdflugter = new Label("Udflugter:");
        companionPane.add(lblUdflugter,0,6);

        CheckBox cbByRundtur = new CheckBox();
        companionPane.add(cbByRundtur,1,8);

        Label lblByRundtur = new Label("Byrundtur i Odense");
        companionPane.add(lblByRundtur, 0, 8);

        Label lblBrBeskriv = new Label("18/5-22. Pris: 125kr inkl. frokost");
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 14);
        lblBrBeskriv.setFont(font);
        //lblBrBeskriv.setStyle("-fx-font-style: italic; + -fx-font-size: 16;");
        companionPane.add(lblBrBeskriv, 0,9);

        CheckBox cbEgeskov = new CheckBox();
        companionPane.add(cbEgeskov,1,12);

        Label lblEgeskov = new Label("Egeskov");
        companionPane.add(lblEgeskov, 0, 12);

        Label lblEgeskovBeskriv = new Label("19/5-22. Pris: 75kr");
        Font font1 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 14);
        lblEgeskovBeskriv.setFont(font);
        companionPane.add(lblEgeskovBeskriv, 0,13);

        CheckBox cbTrapholt = new CheckBox();
        companionPane.add(cbTrapholt,1,16);

        Label lblTrapholt = new Label("Trapholt Museum, Kolding");
        companionPane.add(lblTrapholt, 0, 16);

        Label lblTrapBeskriv = new Label("20/5-22. Pris: 200kr inkl. frokost");
        Font font2 = Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 14);
        lblTrapBeskriv.setFont(font);
        companionPane.add(lblTrapBeskriv, 0,17);
    }

    private void checkNavn() {
        if (txfDeltagerNavn.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Indtast et navn");
            a.showAndWait();
            txfTlfNummer.setText("");
        } else {;}
        //hej din knallert
    }


    // -------------------------------------------------------------------------
    private void checkTlf() {
        var s = txfTlfNummer.getText();
        for (var ch : s.toCharArray()){
            if ('0' <= ch && ch <= '9')
            {}
            else
            {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Indtast kun tal");
                a.showAndWait();
                txfTlfNummer.setText("");
            }
        }
    }

    public void yesButtonSelected(){
        if (rbtnCompanionYes.isSelected()) {
            companionPane.setDisable(false);
        }
    }
    public void noButtonSelected(){
        if (rbtnCompanionNo.isSelected()) {
            companionPane.setDisable(true);
        }
    }

    public void tilmeldAction(){
        Participant p = new Participant(txfDeltagerNavn.getText(), txfAdresse.getText(), txfByLand.getText(), Integer.parseInt(txfTlfNummer.getText()));
        var idxConf = conferenceBox.getSelectionModel().getSelectedIndex();
        var conf = Controller.getConferences().get(idxConf);
        var idxHot = hotelBox.getSelectionModel().getSelectedIndex();
        var hot = Controller.getHotels().get(idxHot);
       Controller.createConferenceParticipantData(conf, p, hot, null, tglLecture.getSelectedToggle().isSelected(), 3); //((Integer.parseInt(txfAfrejsedato.getText()) - Integer.parseInt(txfAnkomstdato.getText())) + 1));
    }
}

