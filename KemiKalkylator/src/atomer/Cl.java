package atomer;

public class Cl extends Atom {
    public Cl() {
        super(17, 17, 17, 3, 17, 3.0);
    }

    @Override
    public String struktur() {
        return  " .. \n" +
                ":Cl: \n" + 
                " .";
    }
}
