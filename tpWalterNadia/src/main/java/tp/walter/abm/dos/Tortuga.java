package tp.walter.abm.dos;

import java.util.Date;

public class Tortuga extends Mascota {
    public Tortuga(String nombre, Date nacimiento, String owner) {
        super(nombre, nacimiento, owner, 1);
    }

    @Override
    public String getTipo() {
        return "Tortuga";
    }
}