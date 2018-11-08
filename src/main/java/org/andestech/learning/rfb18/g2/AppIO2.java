package org.andestech.learning.rfb18.g2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;


public class AppIO2 {

    public static void main(String[] args) {

        File file3 = new File("e:\\datas\\ex02.txt");


        try (FileWriter fw = new FileWriter(file3, false)) {

            fw.write("Date:" + new Date() + "\r\n");
            fw.write("TEST STR: Hi!!\r\n");
            fw.write("Привет!!\r\n");
            fw.write(new char[]{'2', 'a', '\u3eff', 'Ц'});
            fw.write("\r\n");
        } catch (IOException ex) {
            System.out.println(ex);
        }

        try (FileReader fr = new FileReader(file3)) {

            int ch;
            int count = 0;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
                count++;
            }

            long size = file3.length();
            Utils.echo("-", 75);
            System.out.println("File size (bytes): " + size);
            System.out.println("Chars: " + count);

            Utils.echo("-", 75);
//      char[] arr = new char[(int)size];
//
//      fr.read(arr);

//      System.out.println(new String(arr));

        } catch (IOException ex) {
            System.out.println(ex);
        }


// bytes

        File file4 = new File("e:\\datas\\ex04.txt");
        try (FileOutputStream fos =
                     new FileOutputStream(file4)) {


            String s1 = "Date:" + new Date() + "\r\n";
            String s2 = "TEST STR: Hi!!\r\n"+
            "Привет!!\r\n";

            fos.write(s1.getBytes("utf-8"));
            fos.write(s2.getBytes("utf-8"));



        } catch (IOException ex){
            System.out.println(ex);
        }



        try (FileInputStream fis =
                     new FileInputStream(file4)) {

            byte[] arr = new byte[(int)file4.length()];
            fis.read(arr);

            String content = new String(arr);
            System.out.println(content);




        } catch (IOException ex){
            System.out.println(ex);
        }

        // Random access file

        File file5 = new File("e:\\datas\\ex05.txt");
        try (RandomAccessFile raf = new RandomAccessFile(file5,"rw" )) {

            String s1 = "Date:" + new Date() + "\r\n";
            String s2 = "TEST STR: Hi!!\r\n"+
                    "Привет!!\r\n";

            raf.write(s2.getBytes());
            raf.write(s1.getBytes());


            raf.seek(0);
            int ch;
            while ((ch = raf.read()) != -1) {
                System.out.print((char) ch);

            }

            int pos = (int)raf.getFilePointer();
            System.out.println("POS: " + pos);

            Utils.echo("+", 75);
            raf.seek(0);
            raf.write("TOST".getBytes());
            raf.seek(0);

            byte[] arr = new byte[pos];
            raf.read(arr);

            String content = new String(arr);
            System.out.println(content);



        } catch (IOException ex){
            System.out.println(ex);
        }

        Utils.echo("=",75);

        File file6 = new File("e:\\datas\\ex06.bin");
        try (DataOutputStream dos =
                new DataOutputStream(new FileOutputStream(file6)))
        {
            dos.writeInt(31987444);
            dos.writeDouble(-1.98982374987444);



        } catch (IOException ex){
            System.out.println(ex);
        }

        try (DataInputStream dis =
                     new DataInputStream(new FileInputStream(file6)))
        {
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());


        } catch (IOException ex){
            System.out.println(ex);
        }


    }
}