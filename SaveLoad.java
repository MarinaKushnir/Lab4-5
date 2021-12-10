package Lab4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.io.*;

public class SaveLoad {
    private static final String fileName = "C:\\Users\\serge\\Desktop\\saveFile.ser";
    //private static FileOutputStream outFile;
    //private static FileInputStream inFile;
    private Keeping keeping = new Keeping();


    public SaveLoad(){

    }



    public void Save(Keeping keeping) {
        this.keeping=keeping;
        keeping.getInfo();
        try
        {

            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.keeping);
            // out.flush();
            out.close();
            //fileOut.flush();
            fileOut.close();

            System.out.print("Serialized data is saved in file: " + fileName);
            keeping.getInfo();
            System.out.println("Save.Info ended");

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }




    public void Load() {
        try
        {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.keeping = (Keeping) in.readObject();
            keeping.getInfo();
            in.close();
            fileIn.close();
        } catch (IOException ex)
        {
            ex.printStackTrace();
            return;
        } catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }
}