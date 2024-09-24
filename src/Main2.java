import java.util.Scanner;

public class Main2 {
    public static final HorizontalParabola HP1 = new HorizontalParabola(-6, -5, -0.5);
    public static final Circle C1 = new Circle(0, 2, 2);
    public static final VerticalParabola VP1 = new VerticalParabola(4, -2, 0.25);
    public static final VerticalParabola VP2 = new VerticalParabola(0, 5, -0.25);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input X: ");
        double x = sc.nextDouble();
        System.out.print("Input Y: ");
        double y = sc.nextDouble();

        System.out.println("("+x+", "+y+") -> "+getColor(x,y));
    }

    public static SimpleColor getColor(double x, double y) {

        if (VP1.isUpperPointOfParabola(x, y)) { //in Upper Parabola?
            if (VP2.isDownerPointOfParabola(x, y)) { //in Downer Parabola?
                if (C1.isPointInCircle(x, y)) //in Circle?
                    return SimpleColor.GRAY;
                return SimpleColor.BLUE;
            }
            return SimpleColor.YELLOW;
        }


        if (VP2.isDownerPointOfParabola(x, y)) { //in Downer Parabola?
            if (C1.isPointInCircle(x, y)) //in Circle?
                return SimpleColor.BLUE;
            if (HP1.isPointRightOfParabola(x, y)) //in Left Parabola?
                return SimpleColor.ORANGE;
            return SimpleColor.YELLOW;
        }

        if (x > 0) //on the right?
            return SimpleColor.YELLOW;

        if (HP1.isPointRightOfParabola(x, y) || y > -5) //in left parabola or above?
            return SimpleColor.GREEN;

        return SimpleColor.ORANGE;
    }
}