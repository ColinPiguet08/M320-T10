public class Attribute {
    private String name;
    private int value;
    private int cap;

    public Attribute(String name, int value, int cap) {
        this.name = name;
        this.value = value;
        this.cap = cap;
    }

    public String getName() { return name; }
    public int getValue() { return value; }
    public int getCap() { return cap; }
    public void setValue(int value) {
        this.value = Math.min(value, cap);
    }

    public void setCap(int cap) {
        this.cap = cap;
        if (this.value > this.cap) {
            this.value = this.cap;
        }
    }
}
