package com.Musee;

import java.util.ArrayList;
import java.util.List;

public class Museum {

	public static void main(String[] args) {
				
		// Painting Instantiation 
		Painting paint1 = new Painting();
		paint1.setAuthor("Artiste 1 ");
		paint1.setTitle("Tableau 1 ");
		paint1.setDescription("description tableau 1 ");
		paint1.setPaintType("Oil");
		Painting paint2 = new Painting();
		paint2.setAuthor("Artiste 2 ");
		paint2.setTitle("Tableau 2 ");
		paint2.setDescription("description tableau 2 ");
		paint2.setPaintType("Watercolor");
		Painting paint3 = new Painting();
		paint3.setAuthor("Artiste 3 ");
		paint3.setTitle("Tableau 3 ");
		paint3.setDescription("description tableau 3 ");
		paint3.setPaintType("Acrylic");
		
		// Sculpture Instaltiation 
		Sculpture scuplture1 = new Sculpture();
		scuplture1.setAuthor("Artiste 4 ");
		scuplture1.setTitle("scupture 1 ");
		scuplture1.setDescription("description sculpture 1 ");
		scuplture1.setMaterial("Marble");
		Sculpture scuplture2 = new Sculpture();
		scuplture2.setAuthor("Artiste 5 ");
		scuplture2.setTitle("scupture 2 ");
		scuplture2.setDescription("description sculpture 2 ");
		scuplture2.setMaterial("Bronze");

		
		// Ninja Bonus: Store paintings and sculptures in a Museum class
		 List<Art> museumList = new ArrayList();			
		 museumList.add(paint1);
		 museumList.add(paint2);
		 museumList.add(paint3);
		 museumList.add(scuplture1);
		 museumList.add(scuplture2);
		 
		 //Ninja Bonus: Shuffle and print the information for each artwork in the museum
		 System.out.println("******************************");
		 System.out.println("Museum is happy to present : ");
		 for(Art art : museumList) {
			 System.out.println("******************************");
			 System.out.println(art.getAuthor());
			 System.out.println(art.getTitle());
			 System.out.println(art.getDescription());
			 if (art instanceof Painting)		
			 System.out.println(art.getPaintType());
			 if (art instanceof Sculpture)
			 System.out.println(art.getMaterial());			 
		 } 			
		 System.out.println("******************************");
	}
	
		
		
		
			

}
