package atomer;

public class B extends Atom {
    public B() {
        super(5, 5, 5, 2, 3 + 10, 2.0);
    }

    @Override
    public String structure() {
        return ":B.";
    }
}
