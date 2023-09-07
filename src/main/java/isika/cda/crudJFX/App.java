package isika.cda.crudjfx;

import isika.cda.crudjfx.components.BorderPaneTable;
import isika.cda.crudjfx.components.GridPaneFormulaire;
import isika.cda.crudjfx.models.Article;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	private ArticlesDataSet articlesDS = new ArticlesDataSet();

	@Override
	public void start(Stage stage) {
		TableView<Article> table = new TableView<>();

		VBox vbMain = new VBox();
		BorderPaneTable bpTable = new BorderPaneTable(articlesDS, table);
		GridPaneFormulaire gpFormulaire = new GridPaneFormulaire(articlesDS, table);
		vbMain.getChildren().addAll(gpFormulaire, bpTable);

		table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			gpFormulaire.getTfRef().setText(newSelection.getId().toString());
			gpFormulaire.getTfNom().setText(newSelection.getNom());
			gpFormulaire.getTfArtiste().setText(newSelection.getArtiste());
			gpFormulaire.getTfPrix().setText(newSelection.getPrix().toString());
			gpFormulaire.getTfPoids().setText(newSelection.getPoids().toString());
			gpFormulaire.setToggleButton(newSelection.getType());
			gpFormulaire.getBtnAjouter().setDisable(true);
			gpFormulaire.getBtnSupprimer().setDisable(false);
			gpFormulaire.getBtnMaj().setDisable(false);
		});

		var scene = new Scene(vbMain, 1024, 768);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}