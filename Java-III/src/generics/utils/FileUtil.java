package generics.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil<T> {
    private T type;

    public FileUtil(T type){
        this.type = type;
    }

    public void write(String fileName){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            bufferedWriter.append(type.toString());
            bufferedWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
