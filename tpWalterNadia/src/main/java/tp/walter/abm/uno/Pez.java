package tp.walter.abm.uno;

public class Pez extends Mascota {
    private int vidas = 10;
    
    public Pez(String nombre, String owner) {
        super(nombre, owner, null);
    }

    @Override
    public String saludar(String owner) throws Mortis {
        vidas--; // Mortis es que el pez ripeo
        if(!this.isOwner(owner) || vidas < 0) throw new Mortis();
        return "...";
    }

    @Override
    public void alimentar() {
        this.vidas++;
    }

    @Override
    public String getTipo() {
        return "Pez";
    }
}