package GUI;

import Application.Controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartWindow extends Application {

	
	@Override
	public void init() {
		Controller.initStorage();
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("KAS");

		BorderPane borderPane = new BorderPane();
		TabPane tabTilmelding = new TabPane();

		this.initContent(borderPane);

		Scene scene = new Scene(borderPane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {
		TilmeldTab tilmeldTab = new TilmeldTab();
		AdminTab adminTab = new AdminTab();

		TabPane tabPane = new TabPane();

		Tab tab1 = new Tab("Tilmelding", new Label("Tilmelding"));
		Tab tab2 = new Tab("Admin"  , new Label("Admin"));

		tab1.setContent(tilmeldTab);
		tab2.setContent(adminTab);
		tabPane.getTabs().add(tab1);
		tabPane.getTabs().add(tab2);

		VBox vBox = new VBox(tabPane);
		Scene scene = new Scene(vBox);

		pane.setCenter(tabPane);
	}



}
