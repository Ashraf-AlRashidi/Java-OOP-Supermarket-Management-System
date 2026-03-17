public abstract class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method to demonstrate Polymorphism/Abstraction
    public abstract void displayInfo();
}
