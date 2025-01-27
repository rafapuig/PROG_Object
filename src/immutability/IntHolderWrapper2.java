package immutability;

/**
 * Soluciona el problema de mutabilidad por vía indirecta de IntHolderWrapper *
 */
public class IntHolderWrapper2 {

    // Aunque el campo es final y no se puede modificar el valor de la variable una vez asignada
    // Al ser una variable de tipo por referencia a una clase mutable
    // No podemos cambios de objeto referenciado pero si podemos mutar el propio objeto
    private final IntHolder valueHolder;

    public IntHolderWrapper2(int value) {
        this.valueHolder = new IntHolder(value);
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
        IntHolderWrapper2 wrapper = new IntHolderWrapper2(5);

        int value = wrapper.getValue(); // Devuelve un 5
        System.out.println("#1 value: " + value);

        // No Podemos cambiar de manera indirecta el estado del objeto IntHolderWrapper
        // Modificamos la copia que nos devuelve
        wrapper.getIntHolder().setValue(10);

        value = wrapper.getValue(); // Devuelve un 5  -> el objeto es inmutable!!!!
        System.out.println("#2 value: " + value);
    }

}
