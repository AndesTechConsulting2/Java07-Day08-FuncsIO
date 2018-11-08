package org.andestech.learning.rfb18.g2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

public class AppIO2 {

    public static void main(String[] args)
    {

    File file3 = new File("e:\\datas\\ex02.txt");


    try(FileWriter fw = new FileWriter(file3,false)) {

        fw.write("Date:" + new Date() + "\r\n");
        fw.write("TEST STR: Hi!!\r\n");
        fw.write("Привет!!\r\n");
        fw.write(new char[]{'2','a','\u3eff', 'Ц'});
        fw.write("\r\n");
    }
    catch (IOException ex){
        System.out.println(ex);
    }

    try(FileReader fr = new FileReader(file3)){

      int ch;
      int count =0;
      while ( (ch=fr.read()) != -1  ){
          System.out.print((char)ch);
          count++;
      }

      long size = file3.length();
      Utils.echo("-",75);
      System.out.println("File size (bytes): " + size);
      System.out.println("Chars: " + count);

      Utils.echo("-",75);
//      char[] arr = new char[(int)size];
//
//      fr.read(arr);

//      System.out.println(new String(arr));



    }catch (IOException ex){
        System.out.println(ex);
    }



    }
}
