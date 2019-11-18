package tp.walter.abm;

import java.util.Scanner;

import tp.walter.abm.uno.Uno;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Uno.run(scan);
        scan.close();
    }
}
