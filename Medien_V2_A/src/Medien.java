public class Medien {
    protected String titel;
    protected int jahr;

    public Medien(String titel, int jahr) {
        this.titel = titel;
        this.jahr = jahr;
    }
    public void printInfo() {
        System.out.println("Titel: " + titel + ", Jahr: " + jahr);
    }
}

