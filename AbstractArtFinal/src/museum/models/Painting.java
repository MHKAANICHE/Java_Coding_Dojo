package museum.models;

import museum.abstracts.Art;

public class Painting extends Art {
	private String paintType;

	// Full args constructor
	public Painting(String title, String author, String description, String paintType) {
		super(title, author, description);
		this.paintType = paintType;
	}

	@Override
	public void viewArt() {
		String message = "";

		message += "Title : " + this.getTitle() + "\n" + 
					"Author : " + this.getAuthor() + "\n" + 
					"Paint Type :"+ this.getPaintType() + "\n" + 
					"Description :" + this.getDescription()+ "\n" ;
		System.out.println(message);
	}

	public String getPaintType() {
		return paintType;
	}

	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

}
