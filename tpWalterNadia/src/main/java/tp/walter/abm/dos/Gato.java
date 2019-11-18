package tp.walter.abm.dos;

import java.util.Date;

public class Gato extends Mascota implements Racial {
    private String raza;

    public Gato(String nombre, Date nacimiento, String owner, String raza) {
        super(nombre, nacimiento, owner, 2);
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String getTipo() {
        return "Gato";
    }
}