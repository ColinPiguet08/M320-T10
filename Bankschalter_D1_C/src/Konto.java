public class Konto {
    private String kontoNr;
    private double saldo;
    private double limite;

    public Konto(String kontoNr, double limite) {
        this.kontoNr = kontoNr;
        this.saldo = 100.0;
        this.limite = limite;
    }

    public String getKontoNr() {
        return kontoNr;
    }

    public double getSaldo() {
        return saldo;
    }

    public void einzahlen(double betrag) {
        if (betrag > 0) {
            saldo += betrag;
        } else {
            System.out.println("Limit überschritten.");
        }
    }

    public void abheben(double betrag) {
        if (betrag > 0 && (saldo - betrag) >= -limite) {
            saldo -= betrag;
        } else {
            System.out.println("Limit überschritten.");
        }
    }

    public void ueberweisen(Konto nachKonto, double betrag) {
        if (betrag > 0 && (saldo - betrag) >= -limite) {
            abheben(betrag);
            nachKonto.einzahlen(betrag);
            System.out.println(betrag + " auf Konto " + nachKonto.getKontoNr() + " überwiesen.");
        } else {
            System.out.println("Limit überschritten.");
        }
    }
}
