package atomer;

import java.util.Scanner;

public class Bindningskalkylator {
    private String typAvBindning;
    private Atom ämne1;
    private Atom ämne2;

    private Scanner scanner = new Scanner(System.in);

    private Atom skapaAtom(String atomNamn) {
        switch (atomNamn) {
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
                System.out.println("Denna atom finns inte än: " + atomNamn);
                return null;
        }
    }

    private boolean ärMetall(Atom atom) {
        return atom instanceof Na || atom instanceof Mg || atom instanceof Al || atom instanceof K || atom instanceof Ca || atom instanceof Li || atom instanceof Be;
    }

    public void ämne1() {
        System.out.println("Vilket är ditt första ämne?");
        String atomNamn = scanner.nextLine().trim().toLowerCase();
        ämne1 = skapaAtom(atomNamn);

        if (ämne1 == null) {
            start();
        } else {
            ämne2();
        }   
    }

    public void ämne2() {
        System.out.println("Vilket är ditt andra ämne?");
        String atomNamn = scanner.nextLine().trim().toLowerCase();
        ämne2 = skapaAtom(atomNamn);

        if (ämne2 == null) {
            start();
        } else {
            räknaBindning();
        }
    }

    public void räknaBindning() {
        if (ämne1 != null && ämne2 != null) {
            if (ärMetall(ämne1) && ärMetall(ämne2)) {
                typAvBindning = "Metalbindning";
            } else {
                double diff = Math.abs(ämne1.elektronegativitetsvärde - ämne2.elektronegativitetsvärde);

                if (diff == 0.0) {
                    typAvBindning = "Ren kovalent bindning";
                } else if (diff > 1.7) {
                    typAvBindning = "Jonbindning";
                } else if (0.9 <= diff && diff < 1.8) {
                    typAvBindning = "Svag polär kovalent bindning";
                } else if (0 <= diff && diff < 0.9) {
                    typAvBindning = "Polär Kovalent bindning";
                } else {
                    typAvBindning = "Något blev fel";
                }
            }

            System.out.println("Bindningen mellan " + ämne1.getClass().getSimpleName() + " och " + 
                               ämne2.getClass().getSimpleName() + " är: " + typAvBindning);
        } else {
            System.out.println("Något gick fel. Försök igen.");
            start();
        }
    }

    public void start() {
        ämne1();
    }
}
