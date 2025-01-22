import javax.swing.*;
import java.awt.*;
import atomer.*;

public class InfoPanel extends JPanel {
    private JLabel infoLabel;

    public InfoPanel() {
        setLayout(new BorderLayout());

        infoLabel = new JLabel("Click an element to see its details.");
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(infoLabel, BorderLayout.SOUTH);

        JPanel tablePanel = new JPanel(new GridLayout(10, 18, 5, 5));
        createTable(tablePanel);
        add(tablePanel, BorderLayout.CENTER);
    }

    private void createTable(JPanel tablePanel) {
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
    
        // Set GridLayout with larger gaps
        tablePanel.setLayout(new GridLayout(10, 18, 2, 2)); // 10 rows, 18 columns, with 10px gaps
    
        for (Object[] element : elements) {
            String symbol = (String) element[0];
            String name = (String) element[1];
            Atom atom = (Atom) element[2];
    
            JButton button = new JButton(symbol);
            button.setToolTipText(name);
    
            // Set larger button size and font
            button.setPreferredSize(new Dimension(400, 400));   // Set button size
            button.setBackground(new Color(200, 200, 255));
            button.setFocusPainted(false);
    
            button.addActionListener(e -> displayElementInfo(atom));
    
            tablePanel.add(button);
        }
    
        // Fill remaining grid cells with empty panels
        for (int i = elements.length; i < 180; i++) {
            tablePanel.add(new JPanel());
        }
    }
    
    

    private void displayElementInfo(Atom atom) {
        infoLabel.setText("<html><pre>" + atom.toString().replace("\n", "<br>") + "</pre></html>");
    }
}
