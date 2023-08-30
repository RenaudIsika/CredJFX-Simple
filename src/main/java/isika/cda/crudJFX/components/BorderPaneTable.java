package isika.cda.crudJFX.components;

import isika.cda.crudJFX.ArticlesDataSet;
import isika.cda.crudJFX.models.Article;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class BorderPaneTable extends BorderPane {
	
	private static final int COL_WIDTH = 100;
	
	public BorderPaneTable(ArticlesDataSet articlesDS, TableView<Article> table) {
		super();
		
		table.setEditable(false);
		
		// Création des colonnes
		TableColumn<Article, Integer> idCol = new TableColumn<>("Id");		
		idCol.setMinWidth(COL_WIDTH);
		
		// On précise avec quelle donnée on remplit la colonne
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		
		
		TableColumn<Article, String> nomCol = new TableColumn<>("Nom");		
		nomCol.setMinWidth(COL_WIDTH);
		nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
		
		TableColumn<Article, String> artistCol = new TableColumn<>("Artiste");		
		artistCol.setMinWidth(COL_WIDTH);
		artistCol.setCellValueFactory(new PropertyValueFactory<>("artiste"));
		
		TableColumn<Article, String> typeCol = new TableColumn<>("Type");		
		typeCol.setMinWidth(COL_WIDTH);
		typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
		
		TableColumn<Article, Double> prixCol = new TableColumn<>("Prix");		
		prixCol.setMinWidth(COL_WIDTH);
		prixCol.setCellValueFactory(new PropertyValueFactory<>("prix"));
		
		TableColumn<Article, Integer> poidsCol = new TableColumn<>("Poids");		
		poidsCol.setMinWidth(COL_WIDTH);
		poidsCol.setCellValueFactory(new PropertyValueFactory<>("poids"));
		
		table.getColumns().addAll(idCol, nomCol, artistCol, typeCol, prixCol, poidsCol);
		
		table.setItems(FXCollections.observableList(articlesDS.getArticles()));
		
		this.setCenter(table);
	}
}
