package equality.identitybased;

class Point {
    private final int x;
    private final int y;

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
}

public class IdentityBasedEquality {

    public static void main(String[] args) {

        Point p1 = new Point(10, 10);
        Point p2 = new Point(10, 10); // El punto 2 tiene las mismas coordenadas x,y que el punto 1
        Point p3 = new Point(15, 12);

        Point p4 = p1; // En p4 se guarda la referencia al punto 1, p1 y p4 contienen referencias iguales (al mismo objeto)

        System.out.println("p1 == p1 ? " + (p1 == p1));
        System.out.println("p1 equals p1 ? " + p1.equals(p1));
        System.out.println("p1 == p2 ? " + (p1 == p2));
        System.out.println("p1 equals p2 ? " + p1.equals(p2));
        System.out.println("p1 == p3 ? " + (p1 == p3));
        System.out.println("p1 equals p3 ? " + p1.equals(p3));
        System.out.println("p1 == p4 ? " + (p1 == p4));
        System.out.println("p1 equals p4 ? " + p1.equals(p4));
    }
}
