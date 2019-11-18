package tp.walter.abm.uno;

abstract public class Mascota {
    private String nombre;
    private int alegria = 3;
    private String owner;
    private String saludo;

    public Mascota(String nombre, String owner, String saludo) {
        this.nombre = nombre;
        this.owner = owner;
        this.saludo = saludo;
    }

    public void alimentar() {
        this.alegria++;
    }

    public String saludar(String owner) throws Mortis {
        int alegria = this.getAlegria();
        if(alegria < 1) return "...";
        String ret = this.saludo;
        for(int i = 1; i < alegria; i++) {
            ret += " " + this.saludo;
        }
        this.setAlegria(alegria - 1);
        return this.isOwner(owner) ? ret : ret.toUpperCase() + "!"; 
    }

    public boolean isOwner(String owner) {
        return this.owner.equals(owner);
    }

    public String getTipo() {
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAlegria() {
        return alegria;
    }

    public void setAlegria(int alegria) {
        this.alegria = alegria;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }
}