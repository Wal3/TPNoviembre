package tp.walter.abm.dos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract public class Mascota {
    private String nombre;
    private Date nacimiento;
    private String owner;
    private int veces;
    private Map<Integer,ArrayList<Date>> controles = new HashMap<Integer,ArrayList<Date>>();

    public Mascota(String nombre, Date nacimiento, String owner, int veces) {
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.owner = owner;
        this.veces = veces;
    }

    public boolean controlesNecesarios() {
        List<Date> dates = controles.get(Calendar.getInstance().get(Calendar.YEAR));
        if(dates == null) return false;
        return dates.size() >= this.veces;
    }

    public boolean controlesNecesarios(int year) {
        List<Date> dates = controles.get(year);
        if(dates == null) return false;
        return dates.size() >= this.veces;
    }

    public boolean asistenciaPerfecta() {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(nacimiento);
        for(int i = calendario.get(Calendar.YEAR); i < Calendar.getInstance().get(Calendar.YEAR); i++) {
            if(!controlesNecesarios(i)) {
                return false;
            }
        }
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getVeces() {
        return veces;
    }

    public void setVeces(int veces) {
        this.veces = veces;
    }

    public String getTipo() {
        return null;
    }
}