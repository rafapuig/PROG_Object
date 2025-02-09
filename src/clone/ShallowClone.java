package clone;

public class ShallowClone implements Cloneable {

    // La clase ShallowClone tiene un DoubleHolder
    // Hay uan relación entre ShallowClone y DoubleHolder de tipo "tiene-un"
    // Como la clase ShallowClone crea la instancia de DoubleHolder (controla su ciclo de vida)
    // la relación entre ellas es una Composición
    // ShallowClone es el todo
    // DoubleHolder es la parte

    private final DoubleHolder holder = new DoubleHolder(0.0);

    ShallowClone(double value) {
        setValue(value);
    }

    public void setValue(double value) {
        holder.setValue(value);
    }

    public double getValue() {
        return holder.getValue();
    }

    @Override
    public ShallowClone clone() {
        try {
            // El método clone de la clase Object devuelve una copia superficial del objeto ShallowClone
            // El clon y el objeto clonado comparten la misma instancia del objeto DoubleHolder
            return (ShallowClone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class ShallowCloneTest {
    public static void main(String[] args) {
        ShallowClone original = new ShallowClone(18.0);
        ShallowClone clone = original.clone();

        System.out.println("Original: " + original.getValue());
        System.out.println("Clone: " + clone.getValue());

        // Cambiamos el valor en el original (esto cambiará el valor del clon
        // debido a que la clonación ha sido superficial

        original.setValue(45.0);
        System.out.println("Original: " + original.getValue());
        System.out.println("Clone: " + clone.getValue());
    }
}
