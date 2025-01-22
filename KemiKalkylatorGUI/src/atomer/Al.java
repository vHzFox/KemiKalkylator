package atomer;

public class Al extends Atom {
    public Al() {
        super(13, 13, 13, 3, 3 + 10, 1.16);
    }

    @Override
    public String structure() {
        return ":Al.";
    }
}
