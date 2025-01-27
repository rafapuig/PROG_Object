package immutability;

/**
 * Soluciona el problema de mutabilidad de IntHolderWrapper
 * que se puede dar si el constructor recibe una referencia al IntHolder
 */
public class IntHolderWrapper3 {

    // Aunque el campo es final y no se puede modificar el valor de la variable una vez asignada
    // Al ser una variable de tipo por referencia a una clase mutable
    // No podemos cambios de objeto referenciado pero si podemos mutar el propio objeto
    private final IntHolder valueHolder;

    public IntHolderWrapper3(int value) {
        this.valueHolder = new IntHolder(value);
    }

    public IntHolderWrapper3(IntHolder holder) {
        // Se debe hacer una copia del objeto holder cuya referencia hemos recibido como parámetro
        this.valueHolder = new IntHolder(holder.getValue());

        // Esta implementación es incorrecta, el cliente puede modificar el estado del objeto
        // del cual nos ha pasado la referencia
        // this.valueHolder = holder;
    }

    // Como getValue depende del objeto mutable IntHolder
    // el valor que devuelve puede ser diferente en sucesivas llamadas
    // Lo que convierte a InHolderWrapper en una clase mutable!!!!!!!
    public int getValue() {
        return valueHolder.getValue();
    }


    /**
     * El método devuelve una referencia a una copia del objeto IntHolder original
     * Asi si, el cliente modifica el valor, lo hace sobre el objeto copia
     */
    public IntHolder getIntHolder() {
        // Hacemos una copia del objeto IntHolder
        int value = valueHolder.getValue();
        IntHolder copy = new IntHolder(value);

        // Devolvemos una referencia a la copia, en lugar del objeto original
        return copy;
    }


    public static void main(String[] args) {

        IntHolder intHolder= new IntHolder(5);
        IntHolderWrapper3 wrapper = new IntHolderWrapper3(intHolder);

        int value = wrapper.getValue(); // Devuelve un 5
        System.out.println("#1 value: " + value);

        intHolder.setValue(10); // Modificamos el objeto IntHolder
        value = wrapper.getValue(); // Devuelve un 5
        System.out.println("#2 value: " + value);
    }

}
