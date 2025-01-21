import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import atomer.*;

public class PeriodicTableApp {

    private static JFrame frame;
    private static JPanel tablePanel;
    private static JLabel infoLabel;

    public static void main(String[] args) {
        frame = new JFrame("Periodic Table");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        infoLabel = new JLabel("Click an element to see its details.");
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(infoLabel, BorderLayout.SOUTH);

        tablePanel = new JPanel();
        tablePanel.setLayout(new GridLayout(10, 18, 5, 5));
        createTable();
        mainPanel.add(tablePanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private static void createTable() {
        Object[][] elements = {
            {"H", "Hydrogen", new H()},
            {"He", "Helium", new He()},
            {"Li", "Lithium", new Li()}, 
            {"Be", "Beryllium", new Be()},
            {"B", "Boron", new B()}, 
            {"C", "Carbon", new C()},
            {"N", "Nitrogen", new N()}, 
            {"O", "Oxygen", new O()},
            {"F", "Fluorine", new F()}, 
            {"Ne", "Neon", new Ne()},
            {"Na", "Sodium", new Na()}, 
            {"Mg", "Magnesium", new Mg()},
            {"Al", "Aluminum", new Al()}, 
            {"Si", "Silicon", new Si()},
            {"P", "Phosphorus", new P()}, 
            {"S", "Sulfur", new S()},
            {"Cl", "Chlorine", new Cl()}, 
            {"Ar", "Argon", new Ar()},
            {"K", "Potassium", new K()}, 
            {"Ca", "Calcium", new Ca()}
        };

        for (Object[] element : elements) {
            String symbol = (String) element[0];
            String name = (String) element[1];
            Atom atom = (Atom) element[2];

            JButton button = new JButton(symbol);
            button.setToolTipText(name);
            button.setFont(new Font("Arial", Font.BOLD, 12));
            button.setBackground(new Color(200, 200, 255));
            button.setFocusPainted(false);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayElementInfo(atom);
                }
            });

            tablePanel.add(button);
        }

        for (int i = elements.length; i < 180; i++) {
            tablePanel.add(new JPanel());
        }
    }

    private static void displayElementInfo(Atom atom) {
        infoLabel.setText("<html><pre>" + atom.toString().replace("\n", "<br>") + "</pre></html>");
    }
}
