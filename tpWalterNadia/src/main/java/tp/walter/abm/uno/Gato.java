package tp.walter.abm.uno;

public class Gato extends Mascota {
    
    public Gato(String nombre, String owner) {
        super(nombre, owner, "miau");
    }

    @Override
    public String getTipo() {
        return "Gato";
    }
}