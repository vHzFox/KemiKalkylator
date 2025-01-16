package atomer;

public class Ne extends Atom {
    public Ne() {
        super(10, 10, 10, 2, 18 + 10, 0);
    }

    @Override
    public String structure() {
        return  " .. \n" +
                ":Ne: \n" +
                " ..";
    }
}
