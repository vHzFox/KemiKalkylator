package atomer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BondCalculatorPanel extends JPanel {

    private JComboBox<String> element1ComboBox;
    private JComboBox<String> element2ComboBox;
    private JLabel resultLabel;

    public BondCalculatorPanel() {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Bond Calculator", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        JPanel selectionPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        selectionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel element1Label = new JLabel("Select the first element:");
        element1ComboBox = new JComboBox<>(getElementOptions());
        JLabel element2Label = new JLabel("Select the second element:");
        element2ComboBox = new JComboBox<>(getElementOptions());

        JButton calculateButton = new JButton("Calculate Bond");
        calculateButton.addActionListener(new CalculateBondAction());

        selectionPanel.add(element1Label);
        selectionPanel.add(element1ComboBox);
        selectionPanel.add(element2Label);
        selectionPanel.add(element2ComboBox);
        selectionPanel.add(new JLabel());
        selectionPanel.add(calculateButton);

        add(selectionPanel, BorderLayout.CENTER);

        resultLabel = new JLabel(" ", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        resultLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(resultLabel, BorderLayout.SOUTH);
    }

    private String[] getElementOptions() {
        return new String[]{
            "H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne",
            "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca"
        };
    }

    private Atom createAtom(String symbol) {
        switch (symbol.toLowerCase()) {
            case "h": return new H();
            case "he": return new He();
            case "li": return new Li();
            case "be": return new Be();
            case "b": return new B();
            case "c": return new C();
            case "n": return new N();
            case "o": return new O();
            case "f": return new F();
            case "ne": return new Ne();
            case "na": return new Na();
            case "mg": return new Mg();
            case "al": return new Al();
            case "si": return new Si();
            case "p": return new P();
            case "s": return new S();
            case "cl": return new Cl();
            case "ar": return new Ar();
            case "k": return new K();
            case "ca": return new Ca();
            default: return null;
        }
    }

    private boolean isMetal(Atom atom) {
        return atom instanceof Na || atom instanceof Mg || atom instanceof Al || 
               atom instanceof K || atom instanceof Ca || atom instanceof Li || atom instanceof Be;
    }

    private String calculateBond(Atom atom1, Atom atom2) {
        if (isMetal(atom1) && isMetal(atom2)) {
            return "Metallic Bond";
        }

        double diff = Math.abs(atom1.electronNegativityValue - atom2.electronNegativityValue);

        if (diff == 0.0) {
            return "Pure Covalent Bond" + diff;
        } else if (0 < diff && diff < 0.9) {
            return "Weak Polar Covalent Bond" + diff;
        } else if (0.9 <= diff && diff < 1.8) {
            return "Strong Polar Covalent Bond" + diff;
        } else if (diff > 1.7) {
            return "Ionic Bond" + diff;
        } else {
            return "Error in bond calculation.";
        }
    }

    private class CalculateBondAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String element1Symbol = (String) element1ComboBox.getSelectedItem();
            String element2Symbol = (String) element2ComboBox.getSelectedItem();

            Atom atom1 = createAtom(element1Symbol);
            Atom atom2 = createAtom(element2Symbol);

            if (atom1 != null && atom2 != null) {
                String bondType = calculateBond(atom1, atom2);
                resultLabel.setText("The bond between " + element1Symbol + " and " + element2Symbol + " is: " + bondType);
            } else {
                resultLabel.setText("Invalid elements selected.");
            }
        }
    }
}
