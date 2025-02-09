package clone.factory;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Person createFrom(Person original) {
        if (original == null) return null;
        return new Person(original.name, original.age);

        // O si delegamos en el método de instancia
        //return original != null ? original.cloneMe() : null;
    }

    public Person cloneMe() {
        return new Person(this.name, this.age);
    }


}

public class FactoryMethod {

    public static void main(String[] args) {
        Person adan = new Person("Adan", 20);
        System.out.println(adan);

        //Clonamos a Adan mediante el método factoría (version método de instancia)
        Person clone = adan.cloneMe();
        System.out.println(clone);

        // Cambiamos el nombre y edad del clon de Adan
        clone.setName("Eva");
        clone.setAge(19);
        System.out.println(adan);
        System.out.println(clone);

        //Clonamos a Adan mediante el método factoría (version método estático)
        Person otherClone = Person.createFrom(adan);
        System.out.println(otherClone);
    }
}
