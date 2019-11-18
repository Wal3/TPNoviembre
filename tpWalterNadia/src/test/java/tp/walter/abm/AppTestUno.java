package tp.walter.abm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tp.walter.abm.uno.*;


/**
 * Unit test for simple App.
 */
public class AppTestUno {
    /**
     * Rigorous Test.
     */
    String dueño = "Walter";
    @Test
    public void testAlegria() throws Mortis {
        Perro chicho = new Perro ("chicho", dueño);
        assertTrue(chicho.getAlegria()==3);
    }
    @Test
    public void testAlegriaSaludado() throws Mortis {
        Perro chicho = new Perro ("chicho", dueño);
        System.out.println(chicho.saludar(dueño));
        assertTrue(chicho.getAlegria()==2);
    }
    @Test
    public void testAlegriaSaludadoYComido() throws Mortis {
        Perro chicho = new Perro ("chicho", dueño);
        System.out.println(chicho.saludar(dueño));
        chicho.alimentar();
        assertTrue(chicho.getAlegria()==3);
    }
}
