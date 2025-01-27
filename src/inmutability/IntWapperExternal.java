package inmutability;

/**
 * Esta clase es internamente mutable (su estado interno puede cambiar después de la creación del objeto)
 * pero externamente inmutable (el usuario no percibe que el objeto cambia en su estado interno,
 * getValue y getHalfValue siempre le devuelven los mismos valores)
 */
public class IntWapperExternal {

    private final int value;

    // Es un valor muy costoso de calcular
    // y no queremos hacer el cálculo en el constructor ya puede ser que nunca se pida el valor
    private int halfValue = Integer.MAX_VALUE;

    public IntWapperExternal(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * El valor halfValue lo calculamos en el getter, ya que eso quiere decir que se está
     * solicitando su valor
     * Como es costoso de calcular (supongamos), vamos a guardar el valor en un campo
     * es decir, lo vamos a cachear
     * Asi, en sucesivas llamadas al getter ya no se incurre en el coste de calcular el valor
     * sino, que se devuelve el valor cacheado
     * Dado que el cálculo depende de value y value no cambia el valor calculado del que depende tampoco
     */
    public int getHalfValue() {
        // Calcular el halfValue si todavía no ha sido calculado
        if (halfValue == Integer.MAX_VALUE) {
            halfValue = value / 2;
        }
        return halfValue;
    }

}
