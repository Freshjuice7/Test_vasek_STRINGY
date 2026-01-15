//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Uzivatel uzivatel = new Uzivatel("Jan 45Karel 54212Kryštof"," N5..o,v55a..k","2008-01-02","pepanovak@gmail.com","****");
        System.out.println(uzivatel.upravPrijmeni());
        System.out.println(uzivatel.upravJmeno());


        System.out.println(uzivatel.udelejEmail());
        System.out.println("Korektnost emailu je: " + uzivatel.zkontrolujEmail());
        uzivatel.sifraEmail();



    }
    }
