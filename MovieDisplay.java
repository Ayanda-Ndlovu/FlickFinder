package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MovieDisplay extends JFrame {

    public MovieDisplay(List<Movie> movies, MovieController controller) {
        setTitle("FlickFinder - Movies");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        final MovieDisplay self = this; 


        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(34, 34, 34));

        JLabel titleLabel = new JLabel("Available Movies", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel moviesPanel = new JPanel(new GridLayout(0, 2, 15, 15));
        moviesPanel.setBackground(new Color(34, 34, 34));
        moviesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (Movie movie : movies) {
            moviesPanel.add(createMovieCard(movie));
        }

        JScrollPane scrollPane = new JScrollPane(moviesPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(34, 34, 34));
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 30));
        backButton.setBackground(new Color(6, 105, 117));
        backButton.setForeground(Color.black);
        backButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        backButton.addActionListener((ActionEvent e) -> {
            controller.returnToLandingPage(self);
        });
        bottomPanel.add(backButton);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JPanel createMovieCard(Movie movie) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(new Color(45, 45, 45));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(85, 85, 85), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JLabel title = new JLabel(movie.getTitle());
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setForeground(Color.WHITE);

        JLabel genre = new JLabel("Genre: " + movie.getGenre());
        genre.setForeground(Color.LIGHT_GRAY);

        JLabel year = new JLabel("Year: " + movie.getYear());
        year.setForeground(Color.LIGHT_GRAY);

        JTextArea description = new JTextArea(movie.getDescription());
        description.setWrapStyleWord(true);
        description.setLineWrap(true);
        description.setEditable(false);
        description.setBackground(new Color(45, 45, 45));
        description.setForeground(Color.GRAY);
        description.setFont(new Font("Arial", Font.PLAIN, 12));
        description.setBorder(null);

        card.add(title);
        card.add(Box.createVerticalStrut(5));
        card.add(genre);
        card.add(year);
        card.add(Box.createVerticalStrut(8));
        card.add(description);

        return card;
    }
}
