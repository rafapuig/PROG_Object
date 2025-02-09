package clone;

/**
 * La clase DoubleHolder debe implementar el método cloneable
 * si va a hacer una llamada a la implementación del método clone de la clase Object
 * para que no se lance la excepción CloneNotSupportedException y se realice la copia bit a bit del estado del objeto
 */
public class DoubleHolder implements Cloneable {
    private double value;

    public DoubleHolder(double value) {
        this.value = value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    /* Asi no lo queremos
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/

    @Override
    public DoubleHolder clone() {
        DoubleHolder copy = null;
        try {
            // Llama el metodo clone de la clase Object, el cual realiza la copia bit a bit
            // de la memoria utilizada para almacenar el estado del objeto
            // devuelve la referencia al clon
            // IMPORTANTE: Si la clase no implementa el interface Clonable el método clone
            // lanzará la excepción CloneNotSupportedException
            // En este caso este método devolverá el valor inicial de la variable copy, es decir, null
            copy = (DoubleHolder) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return copy;
    }
}

/**
 * Prueba a borrar 'implements Cloneable' de la declaración de la clase DoubleHolder
 * y ejecutar el main para ver como se produce la excepción
 */
class DoubleHolderCloneDemo {
    public static void main(String[] args) {
        DoubleHolder doubleHolder = new DoubleHolder(15.0);

        // Clonamos el objeto
        DoubleHolder doubleHolderClone = doubleHolder.clone();

        // Imprimimos el valor del objeto original y el del clon
        System.out.println("Original: " + doubleHolder.getValue());
        System.out.println("Clonado: " + doubleHolderClone.getValue());

        //Cambiamos el valor del objeto original y el del clon
        doubleHolder.setValue(200.0);
        doubleHolderClone.setValue(300.0);

        //Imprimimos los valores del objeto original y del clon de nuevo
        System.out.println("Original: " + doubleHolder.getValue());
        System.out.println("Clonado: " + doubleHolderClone.getValue());
    }
}
