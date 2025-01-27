package immutability;

public class IntHolderWrapper {

    // Aunque el campo es final y no se puede modificar el valor de la variable una vez asignada
    // Al ser una variable de tipo por referencia a una clase mutable
    // No podemos cambios de objeto referenciado pero si podemos mutar el propio objeto
    private final IntHolder valueHolder;

    public IntHolderWrapper(int value) {
        this.valueHolder = new IntHolder(value);
    }

    // Como getValue depende del objeto mutable IntHolder
    // el valor que devuelve puede ser diferente en sucesivas llamadas
    // Lo que convierte a InHolderWrapper en una clase mutable!!!!!!!
    public int getValue() {
        return valueHolder.getValue();
    }

    public IntHolder getIntHolder() {
        return this.valueHolder;
    }


    public static void main(String[] args) {
        IntHolderWrapper wrapper = new IntHolderWrapper(5);

        int value = wrapper.getValue(); // Devuelve un 5
        System.out.println("#1 value: " + value);

        // Podemos cambiar de manera indirecta el estado del objeto IntHolderWrapper
        wrapper.getIntHolder().setValue(10);
        value = wrapper.getValue(); // Devuelve un 10  -> el objeto es mutable!!!!
        System.out.println("#2 value: " + value);
    }

}
