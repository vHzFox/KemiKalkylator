package atomer;

public abstract class Atom {
    protected int protoner;
    protected int neutroner;
    protected int antalElektroner;
    protected int atomNummer;
    protected int masstal;
    protected int elektronskal;
    
    protected int period;
    protected int grupp;
    
    protected int[] elektroner;
    protected int jonElektroner;
    protected int valenselektroner;

    protected double elektronegativitetsvärde;
        
    protected int k;
    protected int l;
    protected int m;
    protected int n;

    public Atom(int protoner, int neutroner, int antalElektroner, int period, int grupp, double elektronegativitetsvärde) {
        this.protoner = protoner;
        this.neutroner = neutroner;
        this.antalElektroner = antalElektroner;
        this.elektronegativitetsvärde = elektronegativitetsvärde;
        this.jonElektroner = 0;
        this.period = period;
        this.grupp = grupp;
        this.atomNummer = protoner;
        this.masstal = protoner + neutroner;
        setElektroner();
    }
            
    private void setElektroner() {
        elektroner = new int[4]; 
        int kvarvarandeElektroner = antalElektroner;
    
        elektroner[0] = Math.min(kvarvarandeElektroner, 2);
        k = elektroner[0];
        kvarvarandeElektroner -= elektroner[0];
    
        elektroner[1] = Math.min(kvarvarandeElektroner, 8);
        l = elektroner[1];
        kvarvarandeElektroner -= elektroner[1];
    
        elektroner[2] = Math.min(kvarvarandeElektroner, 8);
        m = elektroner[2];
        kvarvarandeElektroner -= elektroner[2];
    
        elektroner[3] = kvarvarandeElektroner;
        n = elektroner[3];
    
        if (n > 0) {
            valenselektroner = n;
            elektronskal = 4;
        } else if (m > 0) {
            valenselektroner = m;
            elektronskal = 3;
        } else if (l > 0) {
            valenselektroner = l;
            elektronskal = 2;
        } else {
            valenselektroner = k;
            elektronskal = 1;
        }
    }
    
    public int getLaddning() {
        return protoner - jonElektroner();
    }
    
    public int getValenselektroner() {
        return valenselektroner;
    }

    public int getGrupp() {
        return valenselektroner;
    }

    public int getPeriod() {
        return elektronskal;
    }

    public int jonElektroner() {
        if (0 < antalElektroner && antalElektroner <= 6) {
            return 2;
        } else if (6 < antalElektroner && antalElektroner <= 15) {
            return 10;
        } else if (15 < antalElektroner && antalElektroner <= 18) {
            return 18;
        } else if (16 < antalElektroner && antalElektroner <= 21) {
            return 21;
        } else if (21 < antalElektroner && antalElektroner <= 23) {
            return 23;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return  "Info om " + getClass().getSimpleName() + "\n" +
                atomInfo() + "\n" +
                atomSkal() + "\n" + 
                laddning() + "\n" +
                "Valenselektroner: " + getValenselektroner() + "\n" +
                "Period: " + getPeriod() + "\n" + 
                "Grupp: " + getGrupp() + "\n" +
                "ElektronFormel:" + "\n" + 
                struktur();
    }

    public String atomInfo() {
        return "Atomnummer: " + atomNummer + ", Masstal: " + masstal + ", Elektroner: " + antalElektroner + ", Elektronegativitetsvärde: " + elektronegativitetsvärde;
    }

    public String struktur() {
        return "";
    }

    public String atomSkal() {
        return  "k: " + k + "\n" + 
                "l: " + l + "\n" + 
                "m: " + m + "\n" + 
                "n: " + n;
    }

    public String laddning() {
        return "Laddning: " + getLaddning();
    }
}
