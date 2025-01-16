package atomer;

import java.util.Scanner;

public class Bondcalculator {
    private String bondType;
    private Atom substance1;
    private Atom substance2;

    private Scanner scanner = new Scanner(System.in);

    private Atom createAtom(String atomName) {
        switch (atomName) {
            case "h":
            case "väte":
                return new H();
            case "he":
            case "helium":
                return new He();
            case "li":
            case "litium":
                return new Li();
            case "be":
            case "beryllium":
                return new Be();
            case "b":
            case "bor":
                return new B();
            case "c":
            case "kol":
                return new C();
            case "n":
            case "kväve":
                return new N();
            case "o":
            case "syre":
                return new O();
            case "f":
            case "fluor":
                return new F();
            case "ne":
            case "neon":
                return new Ne();
            case "na":
            case "natrium":
                return new Na();
            case "mg":
            case "magnesium":
                return new Mg();
            case "al":
            case "aluminium":
                return new Al();
            case "si":
            case "kisel":
                return new Si();
            case "p":
            case "fosfor":
                return new P();
            case "s":
            case "svavel":
                return new S();
            case "cl":
            case "klor":
                return new Cl();
            case "ar":
            case "argon":
                return new Ar();
            case "k":
            case "kalium":
                return new K();
            case "ca":
            case "kalcium":
                return new Ca();
            default:
                System.out.println("Denna atom finns inte än: " + atomName);
                return null;
        }
    }

    private boolean isMetal(Atom atom) {
        return atom instanceof Na || atom instanceof Mg || atom instanceof Al || atom instanceof K || atom instanceof Ca || atom instanceof Li || atom instanceof Be;
    }

    public void substance1() {
        System.out.println("Vilket är ditt första ämne?");
        String atomName = scanner.nextLine().trim().toLowerCase();
        substance1 = createAtom(atomName);

        if (substance1 == null) {
            start();
        } else {
            substance2();
        }   
    }

    public void substance2() {
        System.out.println("Vilket är ditt andra ämne?");
        String atomName = scanner.nextLine().trim().toLowerCase();
        substance2 = createAtom(atomName);

        if (substance2 == null) {
            start();
        } else {
            calculateBond();
        }
    }

    public void calculateBond() {
        if (substance1 != null && substance2 != null) {
            if (isMetal(substance1) && isMetal(substance2)) {
                bondType = "Metalbindning";
            } else {
                double diff = Math.abs(substance1.electronNegativityValue - substance2.electronNegativityValue);

                if (diff == 0.0) {
                    bondType = "Ren kovalent bindning";
                } else if (diff > 1.7) {
                    bondType = "Jonbindning";
                } else if (0.9 <= diff && diff < 1.8) {
                    bondType = "Svag polär kovalent bindning";
                } else if (0 <= diff && diff < 0.9) {
                    bondType = "Polär Kovalent bindning";
                } else {
                    bondType = "Något blev fel";
                }
            }

            System.out.println("Bindningen mellan " + substance1.getClass().getSimpleName() + " och " + 
                               substance2.getClass().getSimpleName() + " är: " + bondType);
        } else {
            System.out.println("Något gick fel. Försök igen.");
            start();
        }
    }

    public void start() {
        substance1();
    }
}
