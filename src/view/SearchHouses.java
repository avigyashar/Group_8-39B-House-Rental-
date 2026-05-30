package view;

import database.MysqlConnector;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class SearchHouses extends javax.swing.JFrame {

    private String loggedInUsername = "User";
    private Connection conn;

    // ── Colors ────────────────────────────────────────────────────────────────
    private static final Color BG          = new Color(245, 245, 245);
    private static final Color WHITE       = Color.WHITE;
    private static final Color BLUE_NAV    = new Color(13,  71, 161);
    private static final Color TEAL_LOGO   = new Color(0,  176, 170);
    private static final Color BORDER_CLR  = new Color(218, 218, 218);
    private static final Color TEXT_DARK   = new Color(25,  25,  25);
    private static final Color TEXT_MED    = new Color(80,  80,  80);
    private static final Color TEXT_GREY   = new Color(150, 150, 150);
    private static final Color FILTER_BG   = new Color(255, 245, 245);
    private static final Color FILTER_BDR  = new Color(235, 210, 210);
    private static final Color PRICE_CLR   = new Color(13,  71, 161);
    private static final Color CARD_HOVER  = new Color(243, 247, 255);
    private static final Color RESET_HOVER = new Color(245, 245, 245);

    // ── House data ────────────────────────────────────────────────────────────
    private static final Object[][] ALL_HOUSES = {
        {"Modern Apartment", "Pokhara",   "Apartment", 55000},
        {"Luxury Villa",     "Lalitpur",  "Villa",     39990},
        {"Cozy Home",        "Birtamode", "House",     25000},
        {"Cozy Home",        "Birtamode", "House",     25000},
        {"Modern Apartment", "Pokhara",   "Apartment", 55000},
        {"Modern Apartment", "Pokhara",   "Apartment", 55000},
        {"Luxury Villa",     "Lalitpur",  "Villa",     39990},
        {"Luxury Villa",     "Lalitpur",  "Villa",     39990},
        {"Studio Flat",      "Kathmandu", "Flat",      18000},
        {"Family House",     "Bhaktapur", "House",     30000},
        {"Penthouse",        "Pokhara",   "Apartment", 75000},
        {"Garden House",     "Lalitpur",  "House",     22000},
    };

    private JPanel    cardsPanel;
    private JLabel    resultsLabel;
    private JComboBox<String> locationBox, typeBox, minPriceBox, maxPriceBox;

    public SearchHouses()                { initComponents(); }
    public SearchHouses(String username) { this.loggedInUsername = username; initComponents(); connectDB(); }

    private void connectDB() {
        try { conn = MysqlConnector.getConnection(); } catch (Exception e) { conn = null; }
    }

    private void initComponents() {
        setTitle("GharSathi - Search Houses");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(1100, 700));

        JPanel root = new JPanel(null);
        root.setBackground(BG);
        setContentPane(root);

        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) { layoutAll(root); }
        });
        layoutAll(root);
    }

    private void layoutAll(JPanel root) {
        root.removeAll();
        int W = Math.max(getWidth(), 1100);
        // UI sections will be added in future commits
        root.revalidate();
        root.repaint();
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}
        SwingUtilities.invokeLater(() -> new SearchHouses("User").setVisible(true));
    }
}