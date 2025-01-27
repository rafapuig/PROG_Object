package inmutability;

public class IntWrapper {

    // El campo se declara como final para que el compilador fuerce la inmutabilidad en la compilación
    private final int value;

    public IntWrapper(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /*public void setValue(int value) {
        this.value = value;
    }*/
}
