package string;

class SmartIntHolder {

    private int value;

    public SmartIntHolder(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * Redefinición (reimplementación) del método toString heredado de la clase Object
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

class SmartIntHolderDemo {
    public static void main(String[] args) {
        SmartIntHolder holder = new SmartIntHolder(2345);
        String holderString = holder.toString();
        System.out.println(holderString);

        holder.setValue(8765);
        holderString = holder.toString();
        System.out.println(holderString);
    }
}
