package org.andestech.learning.rfb18.g2;


public class App 
{
    private static double sum(double ... d){
        //System.out.println("args: " + d.length);

        double res = 0;
        for (double r: d) res += r;
        return  res;
    }

    private static double sum2(double [] d){
        //System.out.println("args: " + d.length);

        double res = 0;
        for (double r: d) res += r;
        return  res;
    }


    public static void main( String[] args )
    {

        System.out.printf("Test... args: %d, %d, %d, %d\n",11,22,33,555,2,3,44.55);

        System.out.println(sum(new double[]{1,2,3,4,5}));

        for (String arg : args){
        System.out.println(arg);

        if(arg.startsWith("-s"))
        {
          String[] strs = arg.substring(2).split(",");
          double[] digits =
          new double[strs.length];

          for (int i = 0; i<digits.length; i++) digits[i] = Double.parseDouble(strs[i]);

          Utils.echo("-",75);
          System.out.println("Summ=" + sum2(digits));

        }

        }


    }
}
