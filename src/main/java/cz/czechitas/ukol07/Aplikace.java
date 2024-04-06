package cz.czechitas.ukol07;

import java.io.IOException;

/**
 * Spouštěcí třída aplikace
 */
public class Aplikace {
    /**
     * Spouštěcí metoda celé aplikace.
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        new Aplikace().run();
    }

    /**
     * Hlavní metoda obsahující výkonný kód.
     */
    public void run() throws IOException {
        KnihaSluzba knihaSluzba = new KnihaSluzba();
        //Vypiše do konzole celkový počet knížek v databázi
        System.out.println(knihaSluzba.vratVsechnyKnihy().size());
        //Vypište do konzole názvy všech knížek, které napsal Karel Čapek
        knihaSluzba.vratKnihyAutora("Karel Čapek").forEach(System.out::println);
        //Vypište všechny knížky vydané poprvé v roce 1845. Výpis bude ve tvaru jméno autora: název knihy.
        knihaSluzba.vratKnihyRok(1845).forEach(kniha -> System.out.println(kniha));
    }
}

