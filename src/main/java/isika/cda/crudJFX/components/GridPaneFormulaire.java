package isika.cda.crudjfx.components;

import isika.cda.crudjfx.models.Article;
import isika.cda.crudjfx.ArticlesDataSet;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class GridPaneFormulaire extends GridPane {

	private TextField tfRef;
	private TextField tfNom;
	private TextField tfArtiste;
	private TextField tfPrix;
	private TextField tfPoids;

	private ToggleButton tbLivre;
	private ToggleButton tbBluRay;
	private ToggleButton tbVinyle;
	private ToggleButton tbDisque;
	
	private ToggleGroup tgType;

	private Button btnAjouter;
	private Button btnSupprimer;
	private Button btnMaj;
	private Button btnReset;

	public GridPaneFormulaire(ArticlesDataSet articlesDS, TableView<Article> table) {

		// Marge et Titre du formulaire
		this.setVgap(5);
		Label lblTitre = new Label("Entrez les informations de votre Article");
		this.add(lblTitre, 0, 0, 3, 1);
		

		// Affichage de l'ID de l'article
		Label lblRef = new Label("Référence de l'article : ");
		tfRef = new TextField();
		tfRef.setText("Référence");
		tfRef.setDisable(true);
		this.add(lblRef, 0, 1, 2, 1);
		this.add(tfRef, 2, 1);

		// Ligne de saisie du nom
		Label lblNom = new Label("Entrez le nom de l'article : ");
		tfNom = new TextField();
		tfNom.setText("Nom");
		this.add(lblNom, 0, 2, 2, 1);
		this.add(tfNom, 2, 2);

		// Ligne de saisie de l'artiste
		Label lblArtiste = new Label("Entrez l'artiste correspondant à l'article : ");
		tfArtiste = new TextField();
		tfArtiste.setText("Artiste");
		this.add(lblArtiste, 0, 3, 2, 1);
		this.add(tfArtiste, 2, 3);

		// Ligne de saisie du prix
		Label lblPrix = new Label("Entrez le prix de l'article : ");
		tfPrix = new TextField();
		tfPrix.setText("Prix");
		this.add(lblPrix, 0, 4, 2, 1);
		this.add(tfPrix, 2, 4);

		// Ligne de saisie du poids
		Label lblPoids = new Label("Entrez le poids de l'article : ");
		tfPoids = new TextField();
		tfPoids.setText("Poids");
		this.add(lblPoids, 0, 5, 2, 1);
		this.add(tfPoids, 2, 5);

		tbLivre = new ToggleButton("Livre");
		tbLivre.setUserData(ArticlesDataSet.LIVRE);
		tbBluRay = new ToggleButton("BluRay");
		tbBluRay.setUserData(ArticlesDataSet.BLURAY);
		tbVinyle = new ToggleButton("Vinyle");
		tbVinyle.setUserData(ArticlesDataSet.VINYLE);
		tbDisque = new ToggleButton("Cd/Dvd");
		tbDisque.setUserData(ArticlesDataSet.DISK);
		// tbDisque.setMaxWidth(REMAINING);

		// Ligne de saisie du type d'article
		Label lblType = new Label("Type d'article");
		tgType = new ToggleGroup();
		tgType.getToggles().addAll(tbLivre, tbBluRay, tbVinyle, tbDisque);

		HBox hbType = new HBox();
		hbType.getChildren().addAll(tbLivre, tbBluRay, tbVinyle, tbDisque);
		hbType.setMaxWidth(REMAINING);

		this.add(lblType, 0, 6);
		this.add(hbType, 2, 6, 2, 1);

		// Boutons
		HBox hbActionBtn = new HBox();

		btnAjouter = new Button("Ajouter");
		btnAjouter.setMaxWidth(REMAINING);
		btnSupprimer = new Button("Supprimer");
		btnSupprimer.setMaxWidth(REMAINING);
		btnMaj = new Button("Mettre à jour");
		btnMaj.setMaxWidth(REMAINING);
		btnReset = new Button("Reset");
		btnReset.setMaxWidth(REMAINING);
		
		hbActionBtn.getChildren().addAll(btnAjouter, btnSupprimer, btnMaj, btnReset);
		hbActionBtn.setMaxSize(REMAINING, REMAINING);
		hbActionBtn.setPrefHeight(BASELINE_OFFSET_SAME_AS_HEIGHT);
		this.add(hbActionBtn, 0, 8, 3, 1);

		btnAjouter.setOnAction(ae -> {
			Article monArticle = getArticleFromForm();
			
			articlesDS.addArticle(monArticle);
			
			System.out.println("Article ajouté au DataSet " + monArticle);
			table.refresh();
			reinitForm();
		});

		btnSupprimer.setOnAction(ae -> {
			int selectedArticleId = Integer.parseInt(tfRef.getText());
			Article monArticle = articlesDS.findById(selectedArticleId);
			
			articlesDS.removeArticle(monArticle);

			System.out.println("Article retiré du DataSet - Référence : " + monArticle);
			table.refresh();
			reinitForm();
		});

		btnMaj.setOnAction(ae -> {
			Article monArticle = getArticleFromForm();

			articlesDS.updateArticle(monArticle);
			
			System.out.println("Article mis à jour : " + monArticle);
			table.refresh();
			reinitForm();
		});
		
		btnReset.setOnAction(ae -> {
			reinitForm();
		});

	}

	private Article getArticleFromForm() {
		Toggle selectedToggle = tgType.getSelectedToggle();
		String typeArticle = (String) selectedToggle.getUserData();
		int articleId;
		Article monArticle;
		
		try {
			articleId = Integer.parseInt(tfRef.getText());
			monArticle = new Article(articleId, tfNom.getText(), tfArtiste.getText(), typeArticle,
					Double.parseDouble(tfPrix.getText()), Integer.parseInt(tfPoids.getText()));
		} catch (NumberFormatException e) {
			monArticle = new Article(tfNom.getText(), tfArtiste.getText(), typeArticle,
					Double.parseDouble(tfPrix.getText()), Integer.parseInt(tfPoids.getText()));
		}
		
		return monArticle;
	}
	
	private void reinitForm() {
		tfRef.setText("Référence");
		tfNom.setText("Nom");
		tfArtiste.setText("Artiste");
		tgType.selectToggle(null);
		tfPrix.setText("Prix");
		tfPoids.setText("Poids");
		
		btnAjouter.setDisable(false);
		btnSupprimer.setDisable(true);
		btnMaj.setDisable(true);
	}

	public void setToggleButton(String type) {
		tbLivre.setSelected(type.equals(ArticlesDataSet.LIVRE));
		tbBluRay.setSelected(type.equals(ArticlesDataSet.BLURAY));
		tbVinyle.setSelected(type.equals(ArticlesDataSet.VINYLE));
		tbDisque.setSelected(type.equals(ArticlesDataSet.DISK));
	}
		
	public TextField getTfRef() {
		return tfRef;
	}

	public TextField getTfNom() {
		return tfNom;
	}

	public TextField getTfArtiste() {
		return tfArtiste;
	}

	public TextField getTfPrix() {
		return tfPrix;
	}

	public TextField getTfPoids() {
		return tfPoids;
	}

	public Button getBtnAjouter() {
		return btnAjouter;
	}

	public Button getBtnSupprimer() {
		return btnSupprimer;
	}

	public Button getBtnMaj() {
		return btnMaj;
	}

}
