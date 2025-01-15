package atomer;

public class Al extends Atom {
    public Al() {
        super(13, 13, 13, 3, 13, 1.6);
    }

    @Override
    public String struktur() {
        return  ":Al: \n" +
                " .";
    }
}
