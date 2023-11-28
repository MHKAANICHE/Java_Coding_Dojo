package museum.models;

import museum.abstracts.Art;

public class Sculpture extends Art {
	private String material;

	// Full args constructor
	public Sculpture(String title, String author, String description, String material) {
		super(title, author, description);
		this.material = material;
	}

	// implement abstract method
	public void viewArt() {
		String message = "";
		message = "Title"+this.getTitle()+"\n"+
					"Author"+this.getAuthor()+"\n"+
					"Material :"+this.getMaterial() +"\n"+
					"Description :"+this.getDescription()+ "\n" ;
		System.out.println(message);
	}

	// Getters and setters
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
