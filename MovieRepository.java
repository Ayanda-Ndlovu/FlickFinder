package mvc;
import java.util.ArrayList;
import java.util.List;

public class MovieRepository {
    private List<Movie> movies;

    public MovieRepository() {
        movies = new ArrayList<>();
        movies.add(new Movie("Echoes of Tomorrow", 2025, "Sci-Fi", "A time traveler tries to prevent a global catastrophe."));
        movies.add(new Movie("Shadows of Durban", 2024, "Drama", "A young artist struggles with identity in post-apartheid South Africa."));
        movies.add(new Movie("Neon Pulse", 2025, "Action", "A rogue hacker uncovers a conspiracy in a cyberpunk city."));
        movies.add(new Movie("Iron Vengeance", 2024, "Action", "A former soldier takes on a corrupt arms dealer threatening global security."));
        movies.add(new Movie("Chasing Shadows", 2025, "Action", "An undercover agent infiltrates a ruthless cartel in Cape Town."));
        movies.add(new Movie("Urban Inferno", 2023, "Action", "A firefighter must save his family when mercenaries set the city ablaze."));
        movies.add(new Movie("Zero Hour", 2025, "Action", "An elite task force races against time to stop a nuclear attack."));
        movies.add(new Movie("Codebreaker: Uprising", 2024, "Action", "A hacker joins forces with rebels to overthrow a high-tech dictatorship."));
        movies.add(new Movie("The Forgotten Code", 2023, "Mystery", "A cryptographer deciphers a message that could change history."));
        movies.add(new Movie("Savannah Storm", 2025, "Adventure", "A wildlife biologist races against poachers in the African savannah."));
        movies.add(new Movie("Midnight Frequency", 2024, "Thriller", "A radio DJ receives chilling messages from a missing girl."));
        movies.add(new Movie("Fragments", 2025, "Psychological", "A man wakes up with no memory and pieces of someone else's life."));
        movies.add(new Movie("The Last Verse", 2023, "Romance", "Two poets fall in love through anonymous letters."));
        movies.add(new Movie("Quantum Drift", 2025, "Sci-Fi", "A physicist discovers parallel dimensions through quantum experiments."));
        movies.add(new Movie("Crimson Tide", 2024, "Horror", "A coastal town is haunted by a mysterious red tide."));
        movies.add(new Movie("The Archivist", 2025, "Fantasy", "A librarian guards magical books that rewrite reality."));
        movies.add(new Movie("Steel Horizon", 2023, "War", "A soldier must choose between duty and conscience in a futuristic conflict."));
        movies.add(new Movie("Echo Chamber", 2024, "Satire", "A social media influencer gets trapped in a virtual echo chamber."));
        movies.add(new Movie("Dust & Dreams", 2025, "Western", "A lone rider seeks justice in a forgotten desert town."));
        movies.add(new Movie("Binary Hearts", 2025, "Romance", "An AI and a human fall in love in a world where emotions are coded."));
    }

    public List<Movie> findByGenre(String genre) {
        List<Movie> genreWanted = new ArrayList<>();
        String genreLower = genre.toLowerCase();

        for (Movie movie : this.movies) {
            String movieGenre = movie.getGenre().toLowerCase();
            if (movieGenre.contains(genreLower)) { // partial + case-insensitive
                genreWanted.add(movie);
            }
        }
        return genreWanted;
    }

    public List<Movie> getAllMovies() {
        return movies;
    }
}

