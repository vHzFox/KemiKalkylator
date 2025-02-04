import javax.swing.*;
import java.awt.*;
import atomer.*;

public class PeriodicTableApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Periodic Table App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 600);

            // Main container with CardLayout
            JPanel mainPanel = new JPanel(new CardLayout());

            // Panels for "Info" and "Calculator"
            InfoPanel infoPanel = new InfoPanel();
            atomer.BondCalculatorPanel calculatorPanel = new atomer.BondCalculatorPanel();

            mainPanel.add(infoPanel, "Info");
            mainPanel.add(calculatorPanel, "Calculator");

            // Create a menu bar
            JMenuBar menuBar = new JMenuBar();
            JMenu menu = new JMenu("Options");

            // Menu items
            JMenuItem infoMenuItem = new JMenuItem("Info");
            JMenuItem calculatorMenuItem = new JMenuItem("Calculator");

            // Add action listeners to switch panels
            infoMenuItem.addActionListener(e -> {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Info");
            });

            calculatorMenuItem.addActionListener(e -> {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.show(mainPanel, "Calculator");
            });

            // Add menu items to the menu and menu bar
            menu.add(infoMenuItem);
            menu.add(calculatorMenuItem);
            menuBar.add(menu);

            // Set up the frame
            frame.setJMenuBar(menuBar);
            frame.add(mainPanel);
            frame.setVisible(true);
        });
    }
}
