import java.util.Arrays;

public class Persona {

    private String nombre;
    private String[] apellidos = new String[2];

    public Persona(String nombre, String apellido1, String apellido2) {
        this.nombre = nombre;
        apellidos[0] = apellido1;
        apellidos[1] = apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return apellidos[0];
    }

    public String getSegundoApellido() {
        return apellidos[1];
    }

    @Override
    public String toString() {
        return "Persona{nombre=" + nombre + ", apellidos=" + apellidos[0] + " " + apellidos[1] + "}";
    }


    public static void main(String[] args) {

        Persona persona = new Persona("Jose", "Silva", "Miguel");
        Persona persona2 = new Persona("Miguel", "Silva", "Perez");

        Persona[] personas = new Persona[2];
        personas[0] = persona;
        personas[1] = persona2;

        for (int i = 0; i < personas.length; i++) {
            System.out.println(personas[i]);
        }

    }
}
