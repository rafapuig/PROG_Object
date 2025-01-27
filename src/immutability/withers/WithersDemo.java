package immutability.withers;

import java.util.StringJoiner;

class Point {

    private int x;
    private int y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Método wither crea una copia del Point con el nuevo valor proporcionado para la x
     * @param x nuevo valor para la x de la copia del punto
     * @return una copia modificada del objeto punto con la nueva coordenada x
     */
    public Point withX(int x) {
        return new Point(x, y);
    }

    /**
     * Método wither crea una copia del Point con el nuevo valor proporcionado para la y
     * @param y nuevo valor para la x de la copia del punto
     * @return una copia modificada del objeto punto con la nueva coordenada y
     */
    public Point withY(int y) {
        return new Point(x, y);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "Point[", "]");
        sj.add("x=" + x);
        sj.add("y=" + y);
        return sj.toString();
    }
}

public class WithersDemo {

    public static void main(String[] args) {

        Point p1 = new Point(1, 2);
        System.out.println(p1);

        p1 = p1.withX(3);
        System.out.println(p1);

        Point p2 = new Point().withX(5).withY(8);
        System.out.println(p2);

        Point p3 = p2.withY(10);
        System.out.println(p3);
        System.out.println(p2);
    }
}
