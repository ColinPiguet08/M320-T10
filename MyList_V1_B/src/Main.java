public class Main {
    public static void main(String[] args) {
        MyList myList = new MyList();

        myList.add("Colin");
        myList.add("Kenneth");

        System.out.println("Element at index 1: " + myList.get(1));
        System.out.println("Index of Colin: " + myList.indexOf("Colin"));

        myList.remove(1);
        System.out.println("Size after removal: " + myList.size());

        myList.clear();
        System.out.println("Size after clear: " + myList.size());
    }
}
