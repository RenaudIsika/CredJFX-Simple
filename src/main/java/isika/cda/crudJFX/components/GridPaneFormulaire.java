package isika.cda.crudJFX.components;

import isika.cda.crudJFX.ArticlesDataSet;
import isika.cda.crudJFX.models.Article;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class GridPaneFormulaire extends GridPane {
	
	private TextField tfNom;
	private TextField tfArtiste;
	private TextField tfType;
	private TextField tfPrix;
	private TextField tfPoids;
	
	private ToggleButton tbLivre;
	private ToggleButton tbBluRay;
	private ToggleButton tbVinyle;
	private ToggleButton tbDisque;
	
	private Button btnAjouter = new Button("Ajouter");
	private Button btnSupprimer = new Button("Supprimer");
	private Button btnMaj = new Button("Mettre à jour");
	
	public GridPaneFormulaire(ArticlesDataSet articlesDS, TableView<Article> table) {
		this.setVgap(5);
		
		Label lblTitre = new Label("Entrez les informations de votre Article");
		this.add(lblTitre, 0, 0, 3, 1);
		
		Label lblNom = new Label("Entrez le nom de l'article : ");
		tfNom = new TextField();
		tfNom.setText("Nom");
		this.add(lblNom, 0, 1, 2, 1);
		this.add(tfNom, 2, 1);
		
		Label lblArtiste = new Label("Entrez l'artiste correspondant à l'article : ");
		tfArtiste = new TextField();
		tfArtiste.setText("Artiste");
		this.add(lblArtiste, 0, 2, 2, 1);
		this.add(tfArtiste, 2, 2);
		
		Label lblPrix = new Label("Entrez le prix de l'article : ");
		tfPrix = new TextField();
		tfPrix.setText("Prix");
		this.add(lblPrix, 0, 3, 2, 1);
		this.add(tfPrix, 2, 3);
		
		Label lblPoids = new Label("Entrez le poids de l'article : ");
		tfPoids = new TextField();
		tfPoids.setText("Poids");
		this.add(lblPoids, 0, 4, 2, 1);
		this.add(tfPoids, 2, 4);
		
		// Type (Toggle Buttons)
		tbLivre = new ToggleButton("Livre");
		tbBluRay = new ToggleButton("BluRay");
		tbVinyle = new ToggleButton("Vinyle");
		tbDisque = new ToggleButton("Cd/Dvd");
		//tbDisque.setMaxWidth(REMAINING);
		
		Label lblType = new Label("Type d'article");
		ToggleGroup tgTbType = new ToggleGroup();
		tgTbType.getToggles().addAll(tbLivre, tbBluRay, tbVinyle, tbDisque);
		
		HBox hbType = new HBox();
		hbType.getChildren().addAll(tbLivre, tbBluRay, tbVinyle, tbDisque);
		hbType.setMaxWidth(REMAINING);
		
		this.add(lblType, 0,  5);
		this.add(hbType, 2, 5, 2, 1);
	
	}
}
