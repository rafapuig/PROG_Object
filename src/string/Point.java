package string;

import java.util.StringJoiner;

public class Point {

    private int x;
    private int y;

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

    @Override
    public String toString() {
        return new StringJoiner(", ", "[", "]")
                .add("x=" + x)
                .add("y=" + y)
                .toString();
    }
}

class PointDemo {
    public static void main(String[] args) {
        Point point = new Point(1, 2);
        String s1 = "Punto: " + point.toString();
        String s2 = "Punto: " + point;

        System.out.println(point);
        System.out.println(point.toString());
        System.out.println(s1);
        System.out.println(s2);

        //Cuidado si la referencia apunta a null
        Point nullPoint = null;
        String s3 = "Punto: " + nullPoint;
        System.out.println(nullPoint);
        System.out.println(s3);
        try {
            System.out.println(nullPoint.toString()); // Genera una NullPointerException
        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getClass().getSimpleName());
        }
    }
}