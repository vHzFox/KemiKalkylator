package atomer;

public class S extends Atom {
    public S() {
        super(16, 16, 16, 3, 16, 2.5);
    }

    @Override
    public String structure() {
        return  " .. \n" + 
                ":S:";
    }
}
