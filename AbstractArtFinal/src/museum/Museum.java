package museum;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import museum.abstracts.Art;
import museum.models.Painting;
import museum.models.Sculpture;

public class Museum {
	public static void main(String[] args) {
		// Museum store 
		ArrayList<Art>museum = new ArrayList<Art>();

		museum.add(new Painting("Title 1", "Author 1", "description 1", "painting type 1"));
		museum.add(new Painting("Title 2", "Author 2", "description 2", "painting type 2"));
		museum.add(new Painting("Title 3", "Author 3", "description 3", "painting type 3"));
		

		museum.add(new Sculpture("Title 4", "Author 4", "description 4", "material 1"));
		museum.add(new Sculpture("Title 5", "Author 5", "description 5", "material 2"));
		
		Collections.shuffle(museum, new Random());
			
		for (Art art : museum) {
			art.viewArt();
		}
		
	}
}
