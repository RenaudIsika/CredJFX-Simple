package isika.cda.crudJFX.models;

public class Article {
	
	static int idIncrement = 0;
	
	private Integer id;
	private String nom;
	private String artiste;
	private String type;
	private Double prix;	
	private Integer poids;
	
	public Article() {
		
	}
	
	public Article(String nom, String artiste, String type, Double prix, Integer poids) {
		super();
		this.id = idIncrement++;
		this.nom = nom;
		this.artiste = artiste;
		this.type = type;
		this.prix = prix;
		this.poids = poids;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getArtiste() {
		return artiste;
	}

	public void setArtiste(String artiste) {
		this.artiste = artiste;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Integer getPoids() {
		return poids;
	}

	public void setPoids(Integer poids) {
		this.poids = poids;
	}

	public Integer getId() {
		return id;
	}	
}
