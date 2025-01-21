package atomer;

public class P extends Atom {
    public P() {
        super(15, 15, 15, 3, 15, 2.1);
    }

    @Override
    public String structure() {
        return  " .. \n" +
                ":P.";
    }
}
