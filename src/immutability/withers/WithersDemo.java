package immutability.withers;

import java.security.cert.PolicyNode;
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

    public Point withX(int x) {
        return new Point(x, y);
    }

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
