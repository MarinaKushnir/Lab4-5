package Lab4;

import java.util.ArrayList;
import java.io.Serializable;

public class Keeping implements Serializable{
    private ArrayList<Quadrangle> quadrangles =new ArrayList<Quadrangle>();
    private ArrayList<Trapezoid> trapezoids =new ArrayList<Trapezoid>();


    public void setQuadrangles(ArrayList<Quadrangle> quadrangles) {
        this.quadrangles = quadrangles;
    }
    public ArrayList<Quadrangle> getQuadrangles() {
        return quadrangles;
    }

    public Keeping() {
        //this.quadrangles();
    }

    public void addQuadrangle(Quadrangle quadrangle){
        this.quadrangles.add(quadrangle);
    }

    public void addTrapezoid(Trapezoid trapezoid){
        this.trapezoids.add(trapezoid);
    }

    public Quadrangle getQuadrangleByIndex(int index){
        Quadrangle quadrangle= this.quadrangles.get(index);
        return quadrangle;
    }

    public Quadrangle getTrapezoidByIndex(int index){
        Trapezoid trapezoid= this.trapezoids.get(index);
        return trapezoid;
    }

    public int getQuadrangleMinArea(){
        if (this.quadrangles.size()>1) {
            Quadrangle quadrangleTest = this.quadrangles.get(0);
            double areaSize = quadrangleTest.getArea();
            int quadrangleNumber = 0;
            for (int i = 0; i < this.quadrangles.size(); i++) {
                Quadrangle quadrangle = this.quadrangles.get(i);
                if (quadrangle.getArea() < areaSize) {
                    areaSize = quadrangle.getArea();
                    quadrangleNumber = i;
                }
            }
            quadrangleNumber++;
            System.out.println("Min area in " + quadrangleNumber + "’s quadrangle ");
            return quadrangleNumber;
        }else return -1;
    }

    public int getTrapezoidMaxLine(){
        if (this.trapezoids.size()>1) {
            Trapezoid trapezoidsTest = this.trapezoids.get(0);
            double averageLine = trapezoidsTest.getAverageLine();
            int trapezoidsNumber = 0;
            for (int i = 0; i < this.trapezoids.size(); i++) {
                Trapezoid trapezoid = this.trapezoids.get(i);
                if (trapezoidsTest.getAverageLine() > averageLine) {
                    averageLine = trapezoid.getAverageLine();
                    trapezoidsNumber = i;
                }
            }
            trapezoidsNumber++;
            System.out.println("Max average line in " + trapezoidsNumber + "’s trapezoid ");
            return trapezoidsNumber;
        }else return -1;
    }

    public void getInfo(){
        for (int i = 0; i < this.quadrangles.size(); i++) {
            System.out.println("Size = "+quadrangles.size());
            Quadrangle quadr= new Quadrangle(getQuadrangleByIndex(i));
            quadr.figureInformation();
        }
        for (int i = 0; i < this.trapezoids.size(); i++) {
            Quadrangle trapez= new Quadrangle(getTrapezoidByIndex(i));
            trapez.figureInformation();
        }

    }

    public ArrayList<Quadrangle> getQuadrangleList(){
        return this.quadrangles;
    }

    public int getQuadrangleNum(){
        int num=quadrangles.size();
        return num;
    }

    public int getTrapezoidNum(){
        int num=trapezoids.size();
        return num;
    }

    public void clear(){
        quadrangles.clear();
        trapezoids.clear();
    }
}
