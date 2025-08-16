package mvc;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            // 1. Create the Model (the data)
            MovieRepository repository = new MovieRepository();

            // 2. Create the View (the UI)
            LandingPageSwing view = new LandingPageSwing();

            // 3. Create the Controller, linking the Model and the View
            new MovieController(repository, view);

            // 4. Make the UI visible to the user
            view.setVisible(true);
        });
    }
}