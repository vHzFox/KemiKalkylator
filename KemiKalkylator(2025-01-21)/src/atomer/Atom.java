package atomer;

public abstract class Atom {
    protected int protons;
    protected int neutrons;
    protected int amountOfElectrons;
    protected int atomNumber;
    protected int massNum;
    protected int electronShell;
    
    protected int period;
    protected int group;
    
    protected int[] electrons;
    protected int ionElectrons;
    protected int valenceElectrons;

    protected double electronNegativityValue;
        
    protected int k;
    protected int l;
    protected int m;
    protected int n;

    public Atom(int protons, int neutrons, int amountOfElectrons, int period, int group, double electronNegativityValue) {
        this.protons = protons;
        this.neutrons = neutrons;
        this.amountOfElectrons = amountOfElectrons;
        this.electronNegativityValue = electronNegativityValue;
        this.ionElectrons = 0;
        this.period = period;
        this.group = group;
        this.atomNumber = protons;
        this.massNum = protons + neutrons;
        setelectrons();
    }
            
    private void setelectrons() {
        electrons = new int[4]; 
        int remainingElectrons = amountOfElectrons;
    
        electrons[0] = Math.min(remainingElectrons, 2);
        k = electrons[0];
        remainingElectrons -= electrons[0];
    
        electrons[1] = Math.min(remainingElectrons, 8);
        l = electrons[1];
        remainingElectrons -= electrons[1];
    
        electrons[2] = Math.min(remainingElectrons, 8);
        m = electrons[2];
        remainingElectrons -= electrons[2];
    
        electrons[3] = remainingElectrons;
        n = electrons[3];
    
        if (n > 0) {
            valenceElectrons = n;
            electronShell = 4;
        } else if (m > 0) {
            valenceElectrons = m;
            electronShell = 3;
        } else if (l > 0) {
            valenceElectrons = l;
            electronShell = 2;
        } else {
            valenceElectrons = k;
            electronShell = 1;
        }
    }
    
    public int getCharge() {
        return protons - ionElectrons();
    }
    
    public int getValenceElectrons() {
        return valenceElectrons;
    }

    public int getGroup() {
        return valenceElectrons;
    }

    public int getPeriod() {
        return electronShell;
    }

    public int ionElectrons() {
        if (0 < amountOfElectrons && amountOfElectrons <= 6) {
            return 2;
        } else if (6 < amountOfElectrons && amountOfElectrons <= 15) {
            return 10;
        } else if (15 < amountOfElectrons && amountOfElectrons <= 18) {
            return 18;
        } else if (16 < amountOfElectrons && amountOfElectrons <= 21) {
            return 21;
        } else if (21 < amountOfElectrons && amountOfElectrons <= 23) {
            return 23;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return  "Info om " + getClass().getSimpleName() + "\n" +
                atomInfo() + "\n" +
                atomShell() + "\n" + 
                charge() + "\n" +
                "valenceElectrons: " + getValenceElectrons() + "\n" +
                "Period: " + getPeriod() + "\n" + 
                "group: " + getGroup() + "\n" +
                "ElektronFormel:" + "\n" + 
                structure();
    }

    public String atomInfo() {
        return "atomNumber: " + atomNumber + ", massNum: " + massNum + ", electrons: " + amountOfElectrons + ", electronNegativityValue: " + electronNegativityValue;
    }

    public String structure() {
        return "";
    }

    public String atomShell() {
        return  "k: " + k + "\n" + 
                "l: " + l + "\n" + 
                "m: " + m + "\n" + 
                "n: " + n;
    }

    public String charge() {
        return "charge: " + getCharge();
    }
}
