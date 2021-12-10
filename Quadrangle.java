package Lab4;

import java.util.ArrayList;
import java.io.Serializable;


public class Quadrangle implements Serializable{
    private double point1X;
    private double point1Y;
    private double point2X;
    private double point2Y;
    private double point3X;
    private double point3Y;
    private double point4X;
    private double point4Y;

    public Quadrangle(double point1X, double point1Y, double point2X, double point2Y, double point3X,double point3Y, double point4X, double point4Y){
        this.point1X= point1X;
        this.point1Y= point1Y;
        this.point2X= point2X;
        this.point2Y= point2Y;
        this.point3X= point3X;
        this.point3Y= point3Y;
        this.point4X= point4X;
        this.point4Y= point4Y;
    }
    public Quadrangle(Quadrangle quadrangleByIndex) {

    }
    public Quadrangle(){

    }


    public void setPoint1(double point1X, double point1Y){
        this.point1X=point1X;
        this.point1Y=point1Y;
    }
    public void setPoint2(double point2X, double point2Y){
        this.point2X=point2X;
        this.point2Y=point2Y;
    }
    public void setPoint3(double point3X, double point3Y){
        this.point3X=point3X;
        this.point3Y=point3Y;
    }
    public void setPoint4(double point4X, double point4Y){
        this.point4X=point4X;
        this.point4Y=point4Y;
    }
    public double getPoint1X(){
        return point1X;
    }
    public double getPoint1Y(){
        return point1Y;
    }
    public double getPoint2X(){
        return point2X;
    }
    public double getPoint2Y(){
        return point2Y;
    }
    public double getPoint3X(){
        return point3X;
    }
    public double getPoint3Y(){
        return point3Y;
    }
    public double getPoint4X(){
        return point4X;
    }
    public double getPoint4Y(){
        return point4Y;
    }

    public void figureInformation(){
        double line12=Math.sqrt((getPoint1X()-getPoint2X())*(getPoint1X()-getPoint2X())+(getPoint1Y()-getPoint2Y())*(getPoint1Y()-getPoint2Y()));
        double line23=Math.sqrt((getPoint3X()-getPoint2X())*(getPoint3X()-getPoint2X())+(getPoint3Y()-getPoint2Y())*(getPoint3Y()-getPoint2Y()));
        double line34=Math.sqrt((getPoint3X()-getPoint4X())*(getPoint3X()-getPoint4X())+(getPoint3Y()-getPoint4Y())*(getPoint3Y()-getPoint4Y()));
        double line41=Math.sqrt((getPoint1X()-getPoint4X())*(getPoint1X()-getPoint4X())+(getPoint1Y()-getPoint4Y())*(getPoint1Y()-getPoint4Y()));
        if (line12==0 && line12==line23 && line23==line34 && line34==line41&& line41==line12){
            System.out.println("Empty quadrangle!");
        }
        else {

            System.out.println("line12: " + line12);
            System.out.println("line23 = " + line23);
            System.out.println("line34 = " + line34);
            System.out.println("line41 = " + line41);
            double diagonal13 = Math.sqrt((getPoint1X() - getPoint3X()) * (getPoint1X() - getPoint3X()) + (getPoint1Y() - getPoint3Y()) * (getPoint1Y() - getPoint3Y()));
            System.out.println("diagonal13 = " + diagonal13);
            double diagonal24 = Math.sqrt((getPoint2X() - getPoint4X()) * (getPoint2X() - getPoint4X()) + (getPoint2Y() - getPoint4Y()) * (getPoint2Y() - getPoint4Y()));
            System.out.println("diagonal24 = " + diagonal24);

            double perimeter = line12 + line23 + line34 + line41;
            System.out.println("P = " + perimeter);

            double p1 = (line12 + line23 + diagonal13) / 2;
            double areaTriangle1 = Math.sqrt(p1 * (p1 - line12) * (p1 - line23) * (p1 - diagonal13));
            double p2 = (line34 + line41 + diagonal24) / 2;
            double areaTriangle2 = Math.sqrt(p2 * (p2 - line34) * (p2 - line41) * (p2 - diagonal24));
            double area = areaTriangle1 + areaTriangle2;
            System.out.println("S = " + area);
        }
    }

    public ArrayList<Double> getLineSizes(){
        ArrayList<Double> lineSizes =new ArrayList<Double>();

        double line12=Math.sqrt((getPoint1X()-getPoint2X())*(getPoint1X()-getPoint2X())+(getPoint1Y()-getPoint2Y())*(getPoint1Y()-getPoint2Y()));
        lineSizes.add(line12);
        double line23=Math.sqrt((getPoint3X()-getPoint2X())*(getPoint3X()-getPoint2X())+(getPoint3Y()-getPoint2Y())*(getPoint3Y()-getPoint2Y()));
        lineSizes.add(line23);
        double line34=Math.sqrt((getPoint3X()-getPoint4X())*(getPoint3X()-getPoint4X())+(getPoint3Y()-getPoint4Y())*(getPoint3Y()-getPoint4Y()));
        lineSizes.add(line34);
        double line41=Math.sqrt((getPoint1X()-getPoint4X())*(getPoint1X()-getPoint4X())+(getPoint1Y()-getPoint4Y())*(getPoint1Y()-getPoint4Y()));
        lineSizes.add(line41);

        return lineSizes;
    }

    public ArrayList<Double> getdiagonals(){
        ArrayList<Double> diagonalSizes =new ArrayList<Double>();

        double diagonal13=Math.sqrt((getPoint1X()-getPoint3X())*(getPoint1X()-getPoint3X())+(getPoint1Y()-getPoint3Y())*(getPoint1Y()-getPoint3Y()));
        diagonalSizes.add(diagonal13);
        double diagonal24=Math.sqrt((getPoint2X()-getPoint4X())*(getPoint2X()-getPoint4X())+(getPoint2Y()-getPoint4Y())*(getPoint2Y()-getPoint4Y()));
        diagonalSizes.add(diagonal24);

        return diagonalSizes;
    }

    public double getPerimetr(){
        double line12=Math.sqrt((getPoint1X()-getPoint2X())*(getPoint1X()-getPoint2X())+(getPoint1Y()-getPoint2Y())*(getPoint1Y()-getPoint2Y()));
        double line23=Math.sqrt((getPoint3X()-getPoint2X())*(getPoint3X()-getPoint2X())+(getPoint3Y()-getPoint2Y())*(getPoint3Y()-getPoint2Y()));
        double line34=Math.sqrt((getPoint3X()-getPoint4X())*(getPoint3X()-getPoint4X())+(getPoint3Y()-getPoint4Y())*(getPoint3Y()-getPoint4Y()));
        double line41=Math.sqrt((getPoint1X()-getPoint4X())*(getPoint1X()-getPoint4X())+(getPoint1Y()-getPoint4Y())*(getPoint1Y()-getPoint4Y()));

        double perimeter=line12+line23+line34+line41;

        return perimeter;
    }

    public double getArea(){
        double line12=Math.sqrt((getPoint1X()-getPoint2X())*(getPoint1X()-getPoint2X())+(getPoint1Y()-getPoint2Y())*(getPoint1Y()-getPoint2Y()));
        double line23=Math.sqrt((getPoint3X()-getPoint2X())*(getPoint3X()-getPoint2X())+(getPoint3Y()-getPoint2Y())*(getPoint3Y()-getPoint2Y()));
        double line34=Math.sqrt((getPoint3X()-getPoint4X())*(getPoint3X()-getPoint4X())+(getPoint3Y()-getPoint4Y())*(getPoint3Y()-getPoint4Y()));
        double line41=Math.sqrt((getPoint1X()-getPoint4X())*(getPoint1X()-getPoint4X())+(getPoint1Y()-getPoint4Y())*(getPoint1Y()-getPoint4Y()));
        double diagonal13=Math.sqrt((getPoint1X()-getPoint3X())*(getPoint1X()-getPoint3X())+(getPoint1Y()-getPoint3Y())*(getPoint1Y()-getPoint3Y()));
        double diagonal24=Math.sqrt((getPoint2X()-getPoint4X())*(getPoint2X()-getPoint4X())+(getPoint2Y()-getPoint4Y())*(getPoint2Y()-getPoint4Y()));

        double p1=(line12+line23+diagonal13)/2;
        double areaTriangle1=Math.sqrt(p1*(p1-line12)*(p1-line23)*(p1-diagonal13));
        double p2=(line34+line41+diagonal24)/2;
        double areaTriangle2=Math.sqrt(p2*(p2-line34)*(p2-line41)*(p2-diagonal24));
        double area = areaTriangle1+areaTriangle2;

        return area;
    }

    public boolean signOfTrapezoid(){
        double line41=Math.sqrt((getPoint1X()-getPoint4X())*(getPoint1X()-getPoint4X())+(getPoint1Y()-getPoint4Y())*(getPoint1Y()-getPoint4Y()));
        double line12=Math.sqrt((getPoint1X()-getPoint2X())*(getPoint1X()-getPoint2X())+(getPoint1Y()-getPoint2Y())*(getPoint1Y()-getPoint2Y()));
        double line23=Math.sqrt((getPoint3X()-getPoint2X())*(getPoint3X()-getPoint2X())+(getPoint3Y()-getPoint2Y())*(getPoint3Y()-getPoint2Y()));
        double line34=Math.sqrt((getPoint3X()-getPoint4X())*(getPoint3X()-getPoint4X())+(getPoint3Y()-getPoint4Y())*(getPoint3Y()-getPoint4Y()));

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

    }

    public boolean isThreePointLine(double point1X, double point1Y, double point2X, double point2Y, double point3X, double point3Y){
        /*
        if ((point2X-point1X)/(point3X-point1X)%(point2Y-point1Y)/(point3Y-point1Y)==0)
        {
            //(5-0)/(10-0)%(0-0)/(0-0)==0
            //5/10%0
            //12: (5, 0)
            //13: (10, 0)
            return true;
        }
        */
        double S=0.5*((point1X*point2Y + point2X*point3Y + point3X*point1Y) - (point2X*point1Y + point3X*point2Y + point1X*point3Y));
        if (S==0){
            return true;
        }
        else return false;

    }

    public boolean isQuadrangle(){
        if (isThreePointLine(this.point1X, this.point1Y, this.point2X, this.point2Y, this.point3X, this.point3Y)==true) return false;
        if (isThreePointLine(this.point1X, this.point1Y, this.point2X, this.point2Y, this.point4X, this.point4Y)==true) return false;
        if (isThreePointLine(this.point2X, this.point2Y, this.point3X, this.point3Y, this.point4X, this.point4Y)==true) return false;
        if (isThreePointLine(this.point1X, this.point1Y, this.point3X, this.point3Y, this.point4X, this.point4Y)==true) return false;
        return true;
    }

}
