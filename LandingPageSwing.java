package mvc;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;import java.io.File;
import java.io.IOException;

public class LandingPageSwing extends JFrame {

    private final JTextField searchField;
    private final JButton searchBtn;

    public LandingPageSwing() {
        setTitle("FlickFinder - Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(715, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Left branding panel
        JPanel leftPanel = new RoundedPanel(30, new Color(111, 78, 55));
        leftPanel.setPreferredSize(new Dimension(360, 0));
        leftPanel.setLayout(new GridBagLayout());
        leftPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
        GridBagConstraints lc = new GridBagConstraints();
        lc.gridx = 0; lc.gridy = 0; lc.weightx = 1;
        lc.anchor = GridBagConstraints.CENTER;
        lc.insets = new Insets(10, 10, 10, 10);
        try {
            Image logoImg = ImageIO.read(getClass().getResource("logo.png"));
            Image scaled = logoImg.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            JLabel logoLabel = new JLabel(new ImageIcon(scaled));
            leftPanel.add(logoLabel, lc);
        } catch (IOException e) {
            JLabel placeholder = new JLabel("\u25B2\u25C6");
            placeholder.setForeground(Color.WHITE);
            placeholder.setFont(new Font("SansSerif", Font.BOLD, 60));
            leftPanel.add(placeholder, lc);
        }
        lc.gridy++;
        JLabel companyLabel = new JLabel("FlickFinder");
        companyLabel.setForeground(Color.WHITE);
        companyLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        leftPanel.add(companyLabel, lc);
        lc.gridy++; lc.weighty = 1.0;
        leftPanel.add(Box.createVerticalStrut(10), lc);
        lc.gridy++; lc.anchor = GridBagConstraints.SOUTH;
        JLabel copyLabel = new JLabel("copyright © FlickFinder");
        copyLabel.setForeground(new Color(220, 240, 240, 200));
        copyLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        leftPanel.add(copyLabel, lc);
        add(leftPanel, BorderLayout.WEST);

        // Right form panel (code is mostly unchanged)
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(new EmptyBorder(40, 40, 40, 60));
        GridBagConstraints rc = new GridBagConstraints();
        rc.gridx = 0; rc.insets = new Insets(8, 0, 8, 0);
        rc.anchor = GridBagConstraints.WEST;
        rc.fill = GridBagConstraints.HORIZONTAL;
        rc.weightx = 1;

        JLabel title = new JLabel("FIND YOUR MOVIE");
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        title.setForeground(new Color(40, 40, 40));
        rc.gridy = 0; rc.gridwidth = 2; rc.insets = new Insets(0, 0, 20, 0);
        rightPanel.add(title, rc);

        rc.gridy++; rc.insets = new Insets(12, 0, 2, 0);
        JLabel genreLabel = new JLabel("Enter Genre");
        genreLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        genreLabel.setForeground(Color.DARK_GRAY);
        rightPanel.add(genreLabel, rc);

        rc.gridy++;
        searchField = new JTextField(); 
        searchField.setPreferredSize(new Dimension(300, 28));
        rightPanel.add(searchField, rc);

        rc.gridy++; rc.insets = new Insets(20, 0, 0, 0);
        searchBtn = new JButton("Search"); 
        searchBtn.setPreferredSize(new Dimension(120, 34));
        searchBtn.setFocusPainted(false);
        searchBtn.setBackground(new Color(6, 105, 117));
        searchBtn.setForeground(Color.BLACK);
        searchBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
        searchBtn.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        rightPanel.add(searchBtn, rc);

        add(rightPanel, BorderLayout.CENTER);
    }
    
    // --- methods for the Controller to use ---

    public String getSearchInput() {
        return searchField.getText().trim();
    }

    public void addSearchButtonListener(ActionListener listener) {
        searchBtn.addActionListener(listener);
    }

    public void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    public void close() {
        dispose();
    }

    // RoundedPanel inner class 
    private static class RoundedPanel extends JPanel {
        private int cornerRadius;
        private Color backgroundColor;
        public RoundedPanel(int radius, Color bg) {
            super(); cornerRadius = radius; backgroundColor = bg; setOpaque(false);
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth(); int height = getHeight();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(backgroundColor);
            g2.fillRoundRect(0, 0, width, height, arcs.width, arcs.height);
        }
    }
}