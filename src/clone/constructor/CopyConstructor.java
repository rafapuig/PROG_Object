package clone.constructor;

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
    public Person(Person original) {
        // Aprovechamos que los objetos de la misma clase puede verse entre sí sus partes privadas
        this(original.name, original.age);
    }

}

public class CopyConstructor {
    public static void main(String[] args) {
        Person adan = new Person("Adan", 20);
        System.out.println(adan);

        //Clonamos a Adan
        Person clone = new Person(adan);
        System.out.println(clone);

        // Cambiamos el nombre y edad del clon de Adan
        clone.setName("Eva");
        clone.setAge(19);
        System.out.println(adan);
        System.out.println(clone);
    }
}
