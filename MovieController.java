package mvc;

import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.JFrame; 

public class MovieController {

    private final MovieRepository repository;
    private final LandingPageSwing view;

    public MovieController(MovieRepository repository, LandingPageSwing view) {
        this.repository = repository;
        this.view = view;
        this.view.addSearchButtonListener(e -> handleSearchRequest());
    }

    private void handleSearchRequest() {

        String genre = view.getSearchInput();
        
        if (genre.isEmpty()) {
            view.showMessage("Please enter a genre.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Movie> results = repository.findByGenre(genre);

        if (results.isEmpty()) {
            view.showMessage("No movies found for genre: " + genre, "Not Found", JOptionPane.WARNING_MESSAGE);
        } else {
             MovieDisplay display = new MovieDisplay(results, this);
             display.setVisible(true);    
             view.setVisible(false);
        }
    }
    
    public void showLandingPage() {
        view.setVisible(true);
    }
    
    public void returnToLandingPage(JFrame currentView) {
       this.view.setVisible(true); 
       currentView.dispose();     
    }
}