package clone.serialize;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;
import java.util.Objects;


@Getter
@Setter
class Name implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String firstname;
    private String lastname;

    public Name(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstname, lastname);
    }
}

@ToString
class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final Name name;
    @Setter
    @Getter
    private int age;

    public Person(String firstname, String lastname, int age) {
        this.name = new Name(firstname, lastname);
        this.age = age;
    }

    public Person deepClone() {

        try {
            //Serialización del objeto en memoria
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(this);

            //Deserialización del objeto
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bis);
            return (Person) in.readObject();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setFirstName(String firstName) {
        this.name.setFirstname(firstName);
    }

    public String getFirstName() {
        return this.name.getFirstname();
    }

    public void setLastName(String lastName) {
        this.name.setLastname(lastName);
    }

    public String getLastName() {
        return this.name.getLastname();
    }
}

public class CloneSerialization {

    public static void main(String[] args) {
        Person adan = new Person("Adan", "de Dios", 18);
        System.out.println("Original: " + adan);

        //Clonamos a Adan
        Person clone = adan.deepClone();
        System.out.println("Clon: " + clone);

        // Cambiamos el nombre y edad del clon de Adan
        clone.setFirstName("Eva");
        clone.setLastName("de Todos los Santos");
        clone.setAge(19);

        System.out.println("Original: " + adan);
        System.out.println("Clon: " + clone);
    }
}
