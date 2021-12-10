package Lab4;

public class Trapezoid extends Quadrangle {
    public Trapezoid(double point1X, double point1Y, double point2X, double point2Y, double point3X, double point3Y, double point4X, double point4Y) {
        super(point1X, point1Y, point2X, point2Y, point3X, point3Y, point4X, point4Y);
    }


    public boolean signOfTrapezoid(){
        double line41=Math.sqrt((getPoint1X()-getPoint4X())*(getPoint1X()-getPoint4X())+(getPoint1Y()-getPoint4Y())*(getPoint1Y()-getPoint4Y()));
        double line12=Math.sqrt((getPoint1X()-getPoint2X())*(getPoint1X()-getPoint2X())+(getPoint1Y()-getPoint2Y())*(getPoint1Y()-getPoint2Y()));
        double line23=Math.sqrt((getPoint3X()-getPoint2X())*(getPoint3X()-getPoint2X())+(getPoint3Y()-getPoint2Y())*(getPoint3Y()-getPoint2Y()));
        double line34=Math.sqrt((getPoint3X()-getPoint4X())*(getPoint3X()-getPoint4X())+(getPoint3Y()-getPoint4Y())*(getPoint3Y()-getPoint4Y()));


        double point5X=getPoint2X();
        double point5Y=getPoint1Y();
        if (point5X==getPoint1X() && point5Y==getPoint1Y()) {
            double point6X=getPoint3X();
            double point6Y=getPoint4Y();
            if (point6X==getPoint4X() && point6Y==getPoint4Y()) {
                System.out.println("It is not trapezoid");
                return false;
            }
        }
        double line15=Math.sqrt((getPoint1X()-point5X)*(getPoint1X()-point5X)+(getPoint1Y()-point5Y)*(getPoint1Y()-point5Y));
        //System.out.println("line 15 = "+line15);
        double line25=Math.sqrt((getPoint2X()-point5X)*(getPoint2X()-point5X)+(getPoint2Y()-point5Y)*(getPoint2Y()-point5Y));
        //System.out.println("line 25 = "+line25);
        //System.out.println("line 12 = "+line12);

        //double angle11 = Math.toDegrees(Math.asin(line25/line12));
        //System.out.println("line15*line15+line25*line25 = "+((line15*line15)+(line25*line25)));
        //System.out.println("line12*line12 = "+line12*line12);
        //System.out.println("Math.round line12*line12 = "+Math.round(line12*line12));

        if (Math.round(line15*line15+line25*line25)==Math.round(line12*line12)){
            System.out.println("It is trapezoid");
            return true;
        }
        else {
            System.out.println("It is not trapezoid");
            return false;
        }


        /*
        double angle1 = Math.toDegrees(Math.asin(line12/line41));
        System.out.println("angel1 = "+angle1);
        double angle2 = Math.toDegrees(Math.asin(line12/line23));
        System.out.println("angel2 = "+angle2);
        double angle3 = Math.toDegrees(Math.asin(line23/line34));
        System.out.println("angel3 = "+angle3);

        if ((angle1==angle2 && angle2!=angle3) || (angle1!=angle2 && angle2==angle3)) {
            System.out.println("It is trapezoid");
            return true;
        }
        else {
            System.out.println("It is not trapezoid");
            return false;
        }

         */

    }

    public double getAverageLine(){
        double line23=Math.sqrt((getPoint3X()-getPoint2X())*(getPoint3X()-getPoint2X())+(getPoint3Y()-getPoint2Y())*(getPoint3Y()-getPoint2Y()));
        double line41=Math.sqrt((getPoint1X()-getPoint4X())*(getPoint1X()-getPoint4X())+(getPoint1Y()-getPoint4Y())*(getPoint1Y()-getPoint4Y()));
        double size=(line23+line41)/2;
        return size;
    }
}
