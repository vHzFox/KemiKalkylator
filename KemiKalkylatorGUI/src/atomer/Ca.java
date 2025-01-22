package atomer;

public class Ca extends Atom {
    public Ca() {
        super(20, 20, 20, 3, 2, 1.0);
    }

    @Override
    public String structure() {
        return "Ca:";
    }
}
