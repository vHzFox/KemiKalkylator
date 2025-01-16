package atomer;

public class Ar extends Atom {
    public Ar() {
        super(18, 18, 18, 3, 18, 0);
    }

    @Override
    public String structure() {
        return  " .. \n" +
                ":Ar: \n" +
                " ..";
    }
}
