package org.andestech.learning.rfb18.g2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class AppIO2 {

    public static void main(String[] args)
    {

    File file3 = new File("e:\\datas\\ex02.txt");


    try(FileWriter fw = new FileWriter(file3)) {

        fw.write("TEST STR: Hi!!\r\n");
        fw.write("Привет!!\r\n");
    }
    catch (IOException ex){
        System.out.println(ex);
    }



    }
}
