package tp.walter.abm;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import tp.walter.abm.dos.*;


/**
 * Unit test for simple App.
 */
public class AppTestDos {
    /**
     * Rigorous Test.
     */
    Date nacimiento = new Date();
    Tortuga manuelita = new Tortuga("manuelita", nacimiento, "walter");
    @Test
    public void testControles(){
        assertTrue(manuelita.getVeces()==1);
    }
    @Test
    public void testControlesNecesarios(){        
        assertTrue(manuelita.controlesNecesarios()==false);
    }
}
