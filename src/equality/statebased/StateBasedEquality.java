package equality.statebased;

import java.util.Objects;

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

    @Override
    public boolean equals(Object other) {
        // Es el mismo?
        if (this == other) return true; // Un objeto se considera igual a si mismo

        // El otro objeto es null?
        if (other == null) return false; // No se puede ser igual que null

        // Pertenecen a la misma clase? other podría ser de cualquier clase dado que la referencia es de tipo Object
        if(getClass() != other.getClass()) return false;

        // Si no hemos retornado todavía de la llamada sabemos que:
        // - other contiene una referencia a un objeto de tipo Point (distinto de this, y no es nulo)

        // Convertir la referencia en la variable other a una referencia de tipo Point (downcasting)
        Point otherPoint = (Point) other;
        // Son iguales sin sus campos x e y son iguales
        return x == otherPoint.x && y == otherPoint.y;
    }

    /**
     * Reimplementación de hashCode basándose en los mismos campos que se usan para determinar la igualdad
     * Requisito: si m.equals(n) devuelve true --> m.hasCode() debe devolver lo mismo que n.hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class StateBasedEquality {

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
