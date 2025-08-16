
# FlickFinder - Movie Genre Finder

FlickFinder is a Java Swing desktop application that allows users to search for movies by genre. Users can enter a genre, view all matching movies, and explore their details such as title, year, genre, and description. The app provides a clean, modern GUI with a landing page and movie display interface.


## Features

* **Landing Page** with branding and a genre input field.
* **Search Movies by Genre** (supports partial and case-insensitive matches).
* **Movie Display** window showing all movies of the searched genre.
* **Back Button** to return to the landing page without restarting the application.
* **Scrollable Movie List** with movie cards showing title, year, genre, and description.


## Requirements

* Java JDK 8 or higher
* IDE such as IntelliJ IDEA or Eclipse
* (Optional) Logo image placed at `H:\gui\src\gui\logo.png` or update path in code.



## Project Structure

```
gui/
 ├── LandingPageSwing.java   # Main landing page GUI
 ├── MovieDisplay.java      # Movie listing GUI
 ├── Movie.java             # Movie data model
 └── MovieRepository.java   # Hardcoded movie repository
```

---

## How to Run

1. Clone or download the repository.
2. Open the project in your IDE.
3. Compile and run `LandingPageSwing.java`.
4. Enter a genre in the input field and click **Search**.
5. The `MovieDisplay` window will show all matching movies.
6. Click **Back** to return to the landing page.

---

## Movie Searching

* **Partial Matches:** Typing part of a genre will return all movies containing it.

  * Example: `"sci"` → returns `"Sci-Fi"` movies.
* **Case-Insensitive:** Uppercase or lowercase input works.
* **Error Handling:** Shows a warning dialog if no movies match the input or if the input is empty.

---

## Example Movies in Repository

* Echoes of Tomorrow – Sci-Fi
* Shadows of Durban – Drama
* Neon Pulse – Action
* The Forgotten Code – Mystery
* Savannah Storm – Adventure
* Midnight Frequency – Thriller
* Fragments – Psychological
* The Last Verse – Romance
* Quantum Drift – Sci-Fi
* Crimson Tide – Horror

*(Full list available in `MovieRepository.java`)*

---

## Future Enhancements

* Load movie data from a file or database instead of hardcoding.
* Add movie poster images in the movie cards.
* Include additional movie details such as rating or director.
* Allow multiple genre search.

---

## Author

**Ayanda Ndlovu** – Computer Science Graduate
[GitHub Profile](https://github.com/Ayanda-Ndlovu)

