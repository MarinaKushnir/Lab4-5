package Lab4;

import Labs.lab4.Storage;
import Labs.lab4.Triangle;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Serialization implements Serializable{
    private ArrayList<Quadrangle> db;
    private static String fileName ="C:\\Users\\serge\\Desktop\\save.ser";
    public static void save(Keeping keeping) throws IOException{
        //создаем 2 потока для сериализации объекта и сохранения его в файл
        FileOutputStream outputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // сохраняем игру в файл
        objectOutputStream.writeObject(keeping);

        //закрываем поток и освобождаем ресурсы
        objectOutputStream.close();
    }

    public static void load() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);


        Keeping keeping1 = (Keeping) objectInputStream.readObject();

        //System.out.println(keeping1);

        keeping1.getInfo();

    }

    public void setList(Keeping keeping){
        this.db = keeping.getQuadrangles();
    }

    public void jacksonSerialize(String fileName, Keeping keeping) throws IOException {
        ObjectMapper objectMapperList = new ObjectMapper();
        setList(keeping);
        objectMapperList.writeValue(new File(fileName), keeping);
    }

    public List<Quadrangle> jacksonDeserialize(String fileName) throws IOException {
        ObjectMapper objectMapperList = new ObjectMapper();
        Keeping keeping = new Keeping();
        objectMapperList.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        keeping = objectMapperList.readValue(new File(fileName), Keeping.class);
        //this.db = storage.getList();
        return keeping.getQuadrangles();
        //return storage;
    }
}
