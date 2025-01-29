package immutability.withers.lombok;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@With
@EqualsAndHashCode
class Point {
    private int x = 0;
    private int y = 0;
}

public class WithersLombokDemo {

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
