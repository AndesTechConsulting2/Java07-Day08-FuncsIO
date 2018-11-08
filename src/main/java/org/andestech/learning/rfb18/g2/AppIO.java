package org.andestech.learning.rfb18.g2;

//import java.io.

//import  java.nio.

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class AppIO {

    public static void main(String[] args)
    {
        File file = new File("e:\\datas\\");
        File file3 = new File("e:\\datas\\ex01.txt");

        //1
        File file2 = new File("e:\\datas\\datas2\\datas3\\");

        if (!file2.exists()) file2.mkdirs();

        try {
            Files.copy(file3.toPath(),
            Paths.get("e:\\datas\\datas2\\res.txt"),
                    StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException ex){
            System.out.println(ex);
        }

        if(file.isDirectory())
        for(File f: file.listFiles())
        {
            System.out.println(f+"\tfile?" + f.isFile());
        }






    }
}
