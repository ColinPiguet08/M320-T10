public class Film extends Medien {
    private String regisseur;

    public Film(String titel, int jahr, String regisseur) {
        super(titel, jahr);
        this.regisseur = regisseur;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Regisseur: " + regisseur);
    }
}