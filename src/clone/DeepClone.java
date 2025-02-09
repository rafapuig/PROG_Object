package clone;

public class DeepClone implements Cloneable {

    // La clase DeepClone tiene un DoubleHolder
    // Hay uan relación entre DeepClone y DoubleHolder de tipo "tiene-un"
    // Como la clase DeepClone crea la instancia de DoubleHolder (controla su ciclo de vida)
    // la relación entre ellas es una Composición
    // DeepClone es el todo
    // DoubleHolder es la parte

    private DoubleHolder holder = new DoubleHolder(0.0);

    DeepClone(double value) {
        setValue(value);
    }

    public void setValue(double value) {
        holder.setValue(value);
    }

    public double getValue() {
        return holder.getValue();
    }

    @Override
    public DeepClone clone() {
        DeepClone copy = null;
        try {
            // El método clone de la clase Object devuelve una copia superficial del objeto ShallowClone
            // El clon y el objeto clonado comparten la misma instancia del objeto DoubleHolder
            // Se ha clonado nada más la referencia almacenada en el campo holder
            copy = (DeepClone) super.clone();

            // Para que la clonación sea de tipo profunda para los objetos de la clase DeepClone
            // necesitamos clonar los objetos inmutables que componen la clase DeepClone
            copy.holder = this.holder.clone(); // Ahora el campo holder guarda la referencia al DoubleHolder clonado

            // Que hubiera pasado si el componente (la parte) no hubiera sido Cloneable?
            // Entones se podría haber creado la copia de otra manera

            //copy.holder = new DoubleHolder(this.holder.getValue());

            // El objeto es clonar el objeto componente o parte
            // y no tiene por qué ser necesariamente a través de llamar al método clone

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return copy;
    }
}

class DeepCloneTest {
    public static void main(String[] args) {
        DeepClone original = new DeepClone(18.0);
        DeepClone clone = original.clone();

        System.out.println("Original: " + original.getValue());
        System.out.println("Clone: " + clone.getValue());

        // Cambiamos el valor en el original (esto cambiará el valor del clon
        // debido a que la clonación ha sido superficial

        original.setValue(45.0);
        System.out.println("Original: " + original.getValue());
        System.out.println("Clone: " + clone.getValue());
    }
}
