package com.SAAQ;

import java.io.*;
import java.util.Random;

public class smartTest1 {

    public smartTest1(){
        int threshold=0;//threshold;
        int length=0;//length
        smartARImpl aSmartAR;
        aSmartAR = new smartARImpl();

        try{
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File("outSmartAR_1.txt"),true));
            writer.println("This is output of test method1 and 2:");
            writer.println("test methods of SmartAR:");


            Random r = new Random();
            System.out.println("set a threshold");
            writer.println("set a threshold");
            threshold = (int)r.nextInt(80)+10;//random threshold[10,100);
            aSmartAR.setThreshold(threshold);
            System.out.println(threshold);
            writer.println(threshold);
            //set length
            System.out.println("set a length");
            writer.println("set a length");
            length = (int) r.nextInt(7) + 6;//random length [6, 12];
            aSmartAR.setKeyLength(length);
            System.out.println(length);
            writer.println(length);
            //generate(n);
            int n = 10;
            aSmartAR.generate(n); // can choose any number to test;
            System.out.println("generate(n): randomly generates a non-existing keys sequence, n is "+ n);
            writer.println("generate(n): randomly generates a non-existing keys sequence, n is "+ n);

            //add test special cases
            System.out.println("add(key,value)");
            writer.println("add(key,value)");
            aSmartAR.add("QC11QQ","1950");
            aSmartAR.add("QC11QQ","1978");
            aSmartAR.add("QC11QQ","1990");
            aSmartAR.add("QC11QQ","2000");
            aSmartAR.add("QC11QQ","2012");
            aSmartAR.add("QC11QQ","2019");
            aSmartAR.add("QC00HH","2005");//test case
            aSmartAR.add("ON22FF","2005");//test case


            System.out.println("allKeys() as a sorted sequence");
            writer.println("allKeys() as a sorted sequence");
            System.out.println(aSmartAR.allKeys());
            writer.println(aSmartAR.allKeys());
            //test remove(k);
            System.out.println("remove(key): ON22FF ");
            writer.println("remove(key): ON22FF ");
            aSmartAR.remove("ON22FF");
            System.out.println("allKeys() as a sorted sequence");
            writer.println("allKeys() as a sorted sequence");
            System.out.println(aSmartAR.allKeys());
            writer.println(aSmartAR.allKeys());
            //test getValue(k), nextKey(k), prevKey(k);
            System.out.println("getValues(key) of QC00HH is " + aSmartAR.getValues("QC00HH"));
            writer.println("getValues(key) of QC00HH is " + aSmartAR.getValues("QC00HH"));
            System.out.println("nextKey(key) of QC00HH is " + aSmartAR.nextKey("QC00HH"));
            writer.println("nextKey(key) of QC00HH is " + aSmartAR.nextKey("QC00HH"));
            System.out.println("prevKey(key) of QC00HH is " + aSmartAR.prevKey("QC00HH"));
            writer.println("prevKey(key) of QC00HH is " + aSmartAR.prevKey("QC00HH"));
            //getValues(key) of "qc11qq"
            System.out.println("Current value: getValues(key) of QC11QQ is " + aSmartAR.getValues("QC11QQ"));
            writer.println("getValues(key) of QC11QQ is " + aSmartAR.getValues("QC11QQ"));

            //previousCars(key) of "qc11qq";
            System.out.println("previousCars(key) of QC11QQ is " + aSmartAR.previousCars("QC11QQ"));
            writer.println("previousCars(key) of QC11QQ is " + aSmartAR.previousCars("QC11QQ"));

            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }



    }

    public static void main(String[] args){ smartTest1 t = new smartTest1();}

}
