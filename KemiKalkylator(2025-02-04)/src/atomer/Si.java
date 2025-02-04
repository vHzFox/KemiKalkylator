package atomer;

public class Si extends Atom {
    public Si() {
        super(14, 14, 14, 3, 14, 1.8);
    }

    @Override
    public String structure() {
        return ":Si:";
    }
}
