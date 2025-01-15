package atomer;

public class F extends Atom {
    public F() {
        super(9, 9, 9, 2, 17 + 10, 4.0);
    }

    @Override
    public String struktur() {
        return  " .. \n" +
                ":F: \n" +
                " .";
    }
}
