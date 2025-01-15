package atomer;

public class O extends Atom {
    public O() {
        super(8, 8, 8, 2, 16 + 10, 3.4);
    }

    @Override
    public String struktur() {
        return  " .. \n" +
                ":C:";
    }
}
