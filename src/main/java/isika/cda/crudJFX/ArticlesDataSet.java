package isika.cda.crudjfx;

import java.util.ArrayList;
import java.util.List;

import isika.cda.crudjfx.models.Article;

public class ArticlesDataSet {
	public static final String LIVRE = "Livre";
	public static final String VINYLE = "Vinyle";
	public static final String DISK = "Cd/Dvd";
	public static final String BLURAY = "BluRay";

	private List<Article> articles;

	public ArticlesDataSet() {
		this.articles = new ArrayList<>();

		this.articles.add(new Article("La maison des feuilles", "Mark Z. Danielewski", LIVRE, 29.50, 700));
		this.articles.add(new Article("L'assassin Royal - Partie 1", "Robin Hobb", LIVRE, 8.50, 350));
		this.articles.add(new Article("La Horde du Contrevent", "Alain Damasio", LIVRE, 12.30, 900));
		this.articles.add(new Article("Lost Themes", "John Carpenter", VINYLE, 29.50, 140));
		this.articles.add(new Article("The Legend", "Bob Marley", VINYLE, 19.99, 140));
		this.articles.add(new Article("Video Games Live, Volume 1", "Video Games Live", DISK, 7.50, 100));
		this.articles.add(new Article("Interstellar", "Christopher Nolan", BLURAY, 15.00, 100));
		this.articles.add(new Article("La chèvre", "Francis Veber", BLURAY, 14.99, 100));
		this.articles.add(new Article("Dune - Collector Edition", "Denis Villeneuve", BLURAY, 39.99, 600));
	}

	public List<Article> getArticles() {
		return articles;
	}

	public Article findById(int id) {
		for (Article article : articles) {
			if (article.getId().equals(id)) {
				return article;
			}
		}
		return null;
	}

	public boolean addArticle(Article article) {
		if (findById(article.getId()) == null) {
			return false;
		} else {
			return this.articles.add(article);
		}
	}

	public boolean removeArticle(Article article) {
		return this.articles.remove(article);
	}

	public boolean updateArticle(Article updatedArticle) {
		Article articleToUpdate = findById(updatedArticle.getId());

		if (articleToUpdate == null) {
			return false;
		} else {
			mapArticles(updatedArticle, articleToUpdate);
			return true;
		}
	}

	private void mapArticles(Article sourceArticle, Article destinationArticle) {
		destinationArticle.setNom(sourceArticle.getNom());
		destinationArticle.setArtiste(sourceArticle.getArtiste());
		destinationArticle.setPoids(sourceArticle.getPoids());
		destinationArticle.setPrix(sourceArticle.getPrix());
		destinationArticle.setType(sourceArticle.getType());
	}
}
