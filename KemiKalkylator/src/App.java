import java.util.Scanner;
import atomer.*;

public class App {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush(); 

        start();
    }

    private static void info() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vilken atom vill du ha info om?");


        String atomNamn = scanner.nextLine().trim().toLowerCase();
        System.out.print("\033[H\033[2J");
        System.out.flush();

        switch(atomNamn) {
            case "h":
            case "väte":
                H h = new H();
                System.out.println(h);
                break;

            case "he":
            case "helium":
                He he = new He();
                System.out.println(he);
                break;

            case "li":
            case "litium":
                Li li = new Li();
                System.out.println(li);
                break;
                
            case "be":
            case "beryllium":
                Be be = new Be();
                System.out.println(be);
                break;
    
            case "b":
            case "bor":
                B b = new B();
                System.out.println(b);
                break;
    
            case "c":
            case "kol":
                C c = new C();
                System.out.println(c);
                break;

            case "n":
            case "kväve":
                N n = new N();
                System.out.println(n);
                break;

            case "o":
            case "syre":
                O o = new O();
                System.out.println(o);
                break;

            case "f":
            case "fluor":
                F f = new F();
                System.out.println(f);
                break;
                
            case "ne":
            case "neon":
                Ne ne = new Ne();
                System.out.println(ne);
                break;

            case "na":
            case "natrium":
                Na na = new Na();
                System.out.println(na);
                break;

            case "mg":
            case "magnesium":
                Mg mg = new Mg();
                System.out.println(mg);
                break;

            case "al":
            case "aluminium":
                Al al = new Al();
                System.out.println(al);
                break;

            case "si":
            case "kisel":
                Si si = new Si();
                System.out.println(si);
                break;

            case "p":
            case "posfor":
                P p = new P();
                System.out.println(p);
                break;

            case "s":
            case "svavel":
                S s = new S();
                System.out.println(s);
                break;

            case "cl":
            case "clor":
                Cl cl = new Cl();
                System.out.println(cl);
                break;

            case "ar":
            case "argon":
                Ar ar = new Ar();
                System.out.println(ar);
                break;
            
            case "k":
            case "kalium":
                K k = new K();
                System.out.println(k);
                break;

            case "ca":
            case "kalcium":
                Ca ca = new Ca();
                System.out.println(ca);
                break;

            default:
                System.out.println("Denna atom finns inte än: " + atomNamn);
                start();
                break;
        }
        start();
        scanner.close();
    }

    private static void start() {
        Scanner scanner = new Scanner(System.in);
        

        System.out.println("Vad vill du göra? (Skriv siffran i början)");
        System.out.println ("1. info om atomer" + "\n" +
                            "2. Räkna typ av bindning" + "\n" +
                            "3. inget än" + "\n");
        int göra = scanner.nextInt();

        switch(göra) {
            case 1:
                info();
                break;
            case 2:
                Bindningskalkylator kalkylator = new Bindningskalkylator();
                kalkylator.start();
                break;
            case 3:
                System.out.println("Finns inget än");
                break;
            default:
                System.out.println("Finns inget än");
        }
    }
}
