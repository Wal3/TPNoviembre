package tp.walter.abm.uno;

public class Pajarito extends Mascota {
    private boolean cantor;
    
    public Pajarito(String nombre, String owner) {
        super(nombre, owner, "pio");
        this.cantor = false;
    }

    public Pajarito(String nombre, String owner, String canto) {
        super(nombre, owner, canto);
        this.cantor = true;
    }

    @Override
    public String saludar(String owner) {
        int alegria = this.getAlegria();
        if(alegria < 1 || !this.isOwner(owner)) return "...";
        String saludo = this.getSaludo();
        String ret = saludo;
        for(int i = 1; i < alegria; i++) {
            ret += " " + saludo;
        }
        this.setAlegria(alegria - 1);
        return ret; 
    }

    @Override
    public String getTipo() {
        return "Pajarito";
    }

    public boolean isCantor() {
        return cantor;
    }

    public void setCantor(boolean cantor) {
        this.cantor = cantor;
    }
}