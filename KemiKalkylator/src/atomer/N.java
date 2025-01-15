package atomer;

public class N extends Atom {
    public N() {
        super(7,7, 7, 2, 15 + 10, 3.0);
    }

    @Override
    public String struktur() {
        return  " .. \n" +
                ":N.";
    }
}
