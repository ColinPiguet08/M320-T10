public class Buch extends Medien {
    private String autor;

    public Buch(String titel, int jahr, String autor) {
        super(titel, jahr);
        this.autor = autor;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Autor: " + autor);
    }
}
