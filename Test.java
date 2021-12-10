package Lab4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Test {
    private static final String fileName2 = "C:\\Users\\serge\\Desktop\\text.bin";
    private static FileOutputStream outFile;
    private static FileInputStream inFile;

    public static void main(String[] args) throws IOException {

        /*
        outFile = new FileOutputStream(fileName2);
        String greetings = "Привет! Добро пожаловать на JavaRush - лучший сайт для тех, кто хочет стать программистом!";
        double point=100;
        int q = 23452345;
        byte[] byteArr, byteArr2, razd;
        byte[] bytesToWrite;
        String razdelitel = ".";
        char[] fromStrToChar = greetings.toCharArray();


        byte s2 = (byte) q;
        byte pointByte=(byte) point;


         */
        Keeping quadrangleList = new Keeping();
        Keeping trapezoidList = new Keeping();


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
                    //quadrangleTest.figureInformation();
                    //quadrangleTest.signOfTrapezoid();
                    quadrangleList.addQuadrangle(quadrangleTest);
                    System.out.println("********quadrangleList Information*****************");
                    quadrangleList.getInfo();
                    System.out.println("*************************");

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

        SaveLoadBin sv = new SaveLoadBin();
        System.out.println("Saving.................");
        sv.Save(quadrangleList, "C:\\Users\\serge\\Desktop\\saveFile.ser");
        System.out.println("Saving END.................");
        System.out.println("Loading.................");
        sv.Load("C:\\Users\\serge\\Desktop\\saveFile.ser");
        System.out.println("Loading END.................");

        quadrangleList.clear();
        trapezoidList.clear();
    }
}
