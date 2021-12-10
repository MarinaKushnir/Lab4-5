package Lab4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class SaveLoadBin {
    private static FileOutputStream outFile;
    private static FileInputStream inFile;

    public void Save(Keeping keeping , String fileWay)throws IOException{
        byte[] bytesToWrite;
        double[] dots= new double[8];
        byte[] dotsByte = new byte[8];
        char razdelitel = '.';
        byte razd = (byte)razdelitel;
        Quadrangle quadrangleNew;

        for (int i=0; i<keeping.getQuadrangleNum(); ++i){
            quadrangleNew=keeping.getQuadrangleByIndex(i);
            dots[0]=quadrangleNew.getPoint1X();
            dotsByte[0] = (byte)dots[0];
            dots[1]=quadrangleNew.getPoint1Y();
            dotsByte[1] = (byte)dots[1];
            dots[2]=quadrangleNew.getPoint2X();
            dotsByte[2] = (byte)dots[2];
            dots[3]=quadrangleNew.getPoint2Y();
            dotsByte[3] = (byte)dots[3];
            dots[4]=quadrangleNew.getPoint3X();
            dotsByte[4] = (byte)dots[4];
            dots[5]=quadrangleNew.getPoint3Y();
            dotsByte[5] = (byte)dots[5];
            dots[6]=quadrangleNew.getPoint4X();
            dotsByte[6] = (byte)dots[6];
            dots[7]=quadrangleNew.getPoint4Y();
            dotsByte[7] = (byte)dots[7];
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
        outputStream.write( dotsByte[0] );
        outputStream.write( razd );
        outputStream.write( dotsByte[1] );
        outputStream.write( razd );
        outputStream.write( dotsByte[2] );
        outputStream.write( razd );
        outputStream.write( dotsByte[3] );
        outputStream.write( razd );
        outputStream.write( dotsByte[4] );
        outputStream.write( razd );
        outputStream.write( dotsByte[5] );
        outputStream.write( razd );
        outputStream.write( dotsByte[6] );
        outputStream.write( razd );
        outputStream.write( dotsByte[7] );
        outputStream.write( razd );


        bytesToWrite = outputStream.toByteArray( );
        outFile = null;
        boolean isOpened = false;
        try {
            outFile = new FileOutputStream(fileWay, true);
            isOpened = true;
            outFile.write(bytesToWrite); //запись в файл
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно произвести запись в файл:" + fileWay);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода:" + e);
        }
        if (isOpened) {
            outFile.close();
        }
    }

    public void Load(String fileWay) throws IOException {
        Keeping keeping = new Keeping();
        //familiars.clear();
        byte[] wert=new byte[0];
        int amount=0;
        try {

            inFile = new FileInputStream(fileWay);
            int bytesAvailable = inFile.available(); //сколько можно считать
            System.out.println("Available: " + bytesAvailable);

            byte[] bytesReaded = new byte[bytesAvailable]; //куда считываем
            int count = inFile.read(bytesReaded, 0, bytesAvailable);

            System.out.println("Было считано байт: " + count);
            System.out.println(Arrays.toString(bytesReaded));
            byte[] trap = bytesReaded;
            wert=trap;
            amount = count;
            inFile.close();

        }catch (FileNotFoundException e) {
            System.out.println("Невозможно произвести чтение из файла:" + fileWay);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода:" + e);
        }
        byte[] dannie=wert;

        int month=0;

        byte[] tochki = new byte[8];
        int q = 0;
        for (int i = 0; i < amount; i++) {
            //System.out.println("i = "+i);
            for (int g=0; g<8; g++) {
                if (dannie[i] == 46) {
                    q = i+1;
                    break;
                }
                tochki [g] = dannie[i+g];
            }
            double[] tochkiDouble= new double[8];
            tochkiDouble[0]=(double) tochki[0];
            tochkiDouble[1]=(double) tochki[1];
            tochkiDouble[2]=(double) tochki[2];
            tochkiDouble[3]=(double) tochki[3];
            tochkiDouble[4]=(double) tochki[4];
            tochkiDouble[5]=(double) tochki[5];
            tochkiDouble[6]=(double) tochki[6];
            tochkiDouble[7]=(double) tochki[7];

            Quadrangle quadrangleNew = new Quadrangle(tochkiDouble[0], tochkiDouble[1], tochkiDouble[2], tochkiDouble[3], tochkiDouble[4], tochkiDouble[5], tochkiDouble[6], tochkiDouble[7]);
            keeping.addQuadrangle(quadrangleNew);
            System.out.println("Loading quadrangle information:");
            quadrangleNew.figureInformation();
            System.out.println("Loading quadrangle information END");
            i-=1;
            if(i==amount-1)
            {
                break;
            }

            if (i==-1){
                break;
            }



        }
        inFile.close();

    }

}
