package tp.walter.abm.dos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Dos {
    private static List<Mascota> mascotas = new ArrayList<Mascota>();
    private Dos() {
    }

    public static List<String> razasNoCumplieron() {
        List<String> razas = new ArrayList<String>();
        for(Mascota mascota : mascotas) {
            if(!(mascota instanceof Perro)) continue;
            Perro perro = (Perro) mascota;
            if(razas.contains(perro.getRaza())) continue;
            if(!perro.controlesNecesarios()) razas.add(perro.getRaza());
        }
        return razas;
    }

    public static String mejorAsistencia() {
        Map<String,Integer> tiposControlados = new HashMap<String,Integer>();
        for(Mascota mascota : mascotas) {
            Integer tipoControlado = tiposControlados.get(mascota.getTipo());
            if(tipoControlado == null) tipoControlado = 0;
            if(mascota.controlesNecesarios()) tipoControlado++;
            tiposControlados.put(mascota.getTipo(), tipoControlado);
        }
        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> entry : tiposControlados.entrySet())
        {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }
}