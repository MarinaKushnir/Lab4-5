package Lab4;

import Labs.lab4.Triangle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MainClass {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
        System.out.println("Loading quadrangleList:");
        System.out.println("************************");
        //Serialization.load();
        System.out.println("************************");
        System.out.println("Loading trapezoidList:");
        System.out.println("************************");
        //Serialization.load();
        System.out.println("************************");
*/
        String pathName = "C:\\Users\\serge\\Desktop\\saveFile.bin";
        String fileName = "C:\\Users\\serge\\Desktop\\SaveFileJackson.json";

        Keeping quadrangleList = new Keeping();
        Keeping trapezoidList = new Keeping();

        /*
        File file = new File("C:\\Users\\serge\\Desktop\\saveFile.ser");
        SaveLoad sv1 = new SaveLoad();
        SaveLoad sv2 = new SaveLoad();
        if (!file.exists()){
            System.out.println("Creating file...");
            file.createNewFile();
        }
        else{
            System.out.println("Loading file...");
            sv1.Load();
            sv2.Load();

        }

         */
        File file = new File(pathName);
        SaveLoadBin sv = new SaveLoadBin();
        if (!file.exists()){
            System.out.println("Creating file...");
            file.createNewFile();
        }
        else{
            System.out.println("Loading file...");
            sv.Load(pathName);

        }


        Scanner in = new Scanner(System.in);

        System.out.print("Enter count quadrangles(N): ");
        int N = in.nextInt();
        if (N>0){
            for (int i = 0; i < N; i++) {
                System.out.print("Enter point1X: ");
                int point1X = in.nextInt();
                System.out.print("Enter point1Y: ");
                int point1Y = in.nextInt();
                System.out.print("Enter point2X: ");
                int point2X = in.nextInt();
                System.out.print("Enter point2Y: ");
                int point2Y = in.nextInt();
                System.out.print("Enter point3X: ");
                int point3X = in.nextInt();
                System.out.print("Enter point3Y: ");
                int point3Y = in.nextInt();
                System.out.print("Enter point4X: ");
                int point4X = in.nextInt();
                System.out.print("Enter point4Y: ");
                int point4Y = in.nextInt();
                Quadrangle quadrangleTest= new Quadrangle(point1X, point1Y, point2X, point2Y, point3X, point3Y, point4X, point4Y);
                quadrangleTest.figureInformation();

                if (quadrangleTest.isQuadrangle()==true) {
                    quadrangleTest.figureInformation();
                    quadrangleTest.signOfTrapezoid();
                    quadrangleList.addQuadrangle(quadrangleTest);
                }
                else{
                    System.out.println("It is not Quadrangle!");
                    --i;
                }
            }
            quadrangleList.getQuadrangleMinArea();
            quadrangleList.getInfo();


        }
        else{
            System.out.println("Error");

        }


        System.out.print("Enter count trapezoid(M): ");
        int M = in.nextInt();
        if (M>0) {
            for (int i = 0; i < M; i++) {
                System.out.print("Enter point1X: ");
                int point1X = in.nextInt();
                System.out.print("Enter point1Y: ");
                int point1Y = in.nextInt();
                System.out.print("Enter point2X: ");
                int point2X = in.nextInt();
                System.out.print("Enter point2Y: ");
                int point2Y = in.nextInt();
                System.out.print("Enter point3X: ");
                int point3X = in.nextInt();
                System.out.print("Enter point3Y: ");
                int point3Y = in.nextInt();
                System.out.print("Enter point4X: ");
                int point4X = in.nextInt();
                System.out.print("Enter point4Y: ");
                int point4Y = in.nextInt();
                Trapezoid trapezoidTest = new Trapezoid(point1X, point1Y, point2X, point2Y, point3X, point3Y, point4X, point4Y);
                if (trapezoidTest.isQuadrangle()==true) {
                    trapezoidTest.figureInformation();
                    trapezoidTest.signOfTrapezoid();
                    trapezoidList.addTrapezoid(trapezoidTest);
                }
                else{
                    System.out.println("It is not Quadrangle!");
                    --i;
                }
            }
            trapezoidList.getTrapezoidMaxLine();
        }
        else {
            System.out.println("Error");
        }

/*
        Serialization.save(quadrangleList);
        System.out.println("Loading quadrangleList:");
        System.out.println("************************");
        Serialization.load();
        System.out.println("************************");


        Serialization.save(trapezoidList);
        System.out.println("Loading trapezoidList:");
        System.out.println("************************");
        Serialization.load();
        System.out.println("************************");
*/

/*
        System.out.println("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
        //SaveLoad sv1 = new SaveLoad();
        //SaveLoad sv2 = new SaveLoad();
        System.out.println("Saving...");
        quadrangleList.getInfo();
        sv1.Save(quadrangleList);
        sv2.Save(trapezoidList);
        System.out.println("Saving done!");

        System.out.println("*****************quadrangleList:");
        quadrangleList.getInfo();
        System.out.println("NNNNNNNNNNNtrapezoidList:");
        trapezoidList.getInfo();

        System.out.println("Loading...");
        sv1.Load();
        sv2.Load();
        System.out.println("Loading done!");

 */

        SaveLoadBin sv1 = new SaveLoadBin();
        System.out.println("Saving.................");
        sv1.Save(quadrangleList, pathName);
        System.out.println("Saving END.................");
        System.out.println("Loading.................");
        sv1.Load(pathName);
        System.out.println("Loading END.................");



        Serialization serialization = new Serialization();
        serialization.jacksonSerialize(fileName, quadrangleList);
        quadrangleList.setQuadrangles((ArrayList<Quadrangle>) serialization.jacksonDeserialize(fileName));


        quadrangleList.clear();
        trapezoidList.clear();
    }
}
