package isika.cda.crudJFX;

import isika.cda.crudJFX.components.BorderPaneTable;
import isika.cda.crudJFX.models.Article;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

	private ArticlesDataSet articlesDS = new ArticlesDataSet();
	
    @Override
    public void start(Stage stage) {
        TableView<Article> table = new TableView<>();
        
        BorderPaneTable bpTable = new BorderPaneTable(articlesDS, table);
        
        var scene = new Scene(bpTable, 1024, 768);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}