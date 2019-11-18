package tp.walter.abm.uno;

public class Perro extends Mascota {
    
    public Perro(String nombre, String owner) {
        super(nombre, owner, "guau");
    }

    @Override
    public String getTipo() {
        return "Perro";
    }
}