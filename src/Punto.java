import java.util.StringJoiner;

public class Punto {
    private int x;
    private int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Punto.class.getSimpleName() + "{", "}")
                .add("x=" + x)
                .add("y=" + y)
                .toString();
    }

    public static void main(String[] args) {

        Punto p = new Punto(3, 5);
        System.out.println(p);

        Punto p2 = new Punto(4, 8);
        System.out.println(p2);



    }
}
