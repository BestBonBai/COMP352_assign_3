package com.SAAQ;

import java.util.Random;
import java.util.*;
import java.io.*;

/**
 * for test file1,2,3;
 */
public class smartTest2 {

    public smartTest2(){
        smartARImpl aSmartAR;
        aSmartAR = new smartARImpl();
        //set threshold for using method 2;
        aSmartAR.setThreshold(10000);
        aSmartAR.setKeyLength(6);//set length;
        //read file;
        Scanner input = null;
        try {
            input = new Scanner(new FileInputStream("ar_test_file1.txt"));
        }
        catch (FileNotFoundException e ){
            System.out.println("Not found file.");
        }

        System.out.println("Test file1.....");
        String key;
        String value;
        int count = 0;//for store the number of data, for set Threshold size;
        Random r = new Random();//for random value;

        while(input.hasNextLine()){
            String line = input.nextLine();
            if(!line.equals("")){
                key = line;
                //value is assigned random year from [1900,2020];
                value = String.valueOf(r.nextInt(121)+1900);
                aSmartAR.add(key, value);
                count++;
            }
        }

        //output file;
        try{
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File("output_testfile_1.txt"),true));
            writer.println("This is output of test SmartAR methods:");
            writer.println("test methods of SmartAR:");
            System.out.println("This file has " + count + " keys and threshold size.");
            writer.println("This file has " + count + " keys and threshold size.");

            //allKeys();
            System.out.println("allKeys() as a sorted sequence");
            writer.println("allKeys() as a sorted sequence");
          //  System.out.println(aSmartAR.allKeys());
            writer.println(aSmartAR.allKeys());

            //test previousCars(key);
            //need to check for each file.
            //choose a key from file 1 to test;
         /**   String cKey = "G4VL91";//"IMX85U"for testfile2;
            System.out.println("previousCars of key G4VL91 is " + aSmartAR.previousCars(cKey));
            writer.println("previousCars of key G4VL91 is " + aSmartAR.previousCars(cKey));
            ///////////////////////////////////////////////////////////////////////////////////////
            //test getValue(k), nextKey(k), prevKey(k);
            System.out.println("getValues(key) of "+ cKey +" is " + aSmartAR.getValues(cKey));
            writer.println("getValues(key) of "+ cKey + " is " + aSmartAR.getValues(cKey));
            System.out.println("nextKey(key) of " + cKey + " is " + aSmartAR.nextKey(cKey));
            writer.println("nextKey(key) of " + cKey + " is " + aSmartAR.nextKey(cKey));
            System.out.println("prevKey(key) of "+ cKey +" is " + aSmartAR.prevKey(cKey));
            writer.println("prevKey(key) of "+ cKey + " is " + aSmartAR.prevKey(cKey));
          */
            //////////////////////////////////////////////////////////////////////////////////////
            //add test special cases
           // System.out.println("add(key,value)");
            writer.println("add(key,value)");
            aSmartAR.add("QC11QQ","1909");
            aSmartAR.add("QC11QQ","1958");
            aSmartAR.add("QC11QQ","1989");
            aSmartAR.add("QC11QQ","2002");
            aSmartAR.add("QC11QQ","2008");
            aSmartAR.add("QC11QQ","2019");
            aSmartAR.add("QC00HH","2005");//test case
            aSmartAR.add("ON22FF","2005");//test case

            //test remove(k);
           // System.out.println("remove(key): ON22FF ");
            writer.println("remove(key): ON22FF ");
            aSmartAR.remove("ON22FF");
           // System.out.println("allKeys() as a sorted sequence");
            writer.println("allKeys() as a sorted sequence");
           // System.out.println(aSmartAR.allKeys());
            writer.println(aSmartAR.allKeys());

            //test getValue(k), nextKey(k), prevKey(k);
           // System.out.println("getValues(key) of QC00HH is " + aSmartAR.getValues("QC00HH"));
            writer.println("getValues(key) of QC00HH is " + aSmartAR.getValues("QC00HH"));
           // System.out.println("nextKey(key) of QC00HH is " + aSmartAR.nextKey("QC00HH"));
            writer.println("nextKey(key) of QC00HH is " + aSmartAR.nextKey("QC00HH"));
           // System.out.println("prevKey(key) of QC00HH is " + aSmartAR.prevKey("QC00HH"));
            writer.println("prevKey(key) of QC00HH is " + aSmartAR.prevKey("QC00HH"));

            //previousCars(key) of "QC11QQ";
            //System.out.println("getValues(key) of QC11QQ is " + aSmartAR.getValues("QC11QQ"));
            writer.println("getValues(key) of QC11QQ is " + aSmartAR.getValues("QC11QQ"));
            //System.out.println("previousCars(key) of QC11QQ is " + aSmartAR.previousCars("QC11QQ"));
            writer.println("previousCars(key) of QC11QQ is " + aSmartAR.previousCars("QC11QQ"));

            //generate(n)
            //System.out.println("generate a sequence with new non-existing keys");
            writer.println("generate a sequence with new non-existing keys");
            aSmartAR.generate(10);//set generate 10 new non-existing keys;


            //allKeys
            //System.out.println("allKeys() as a sorted sequence");
           // writer.println("allKeys() as a sorted sequence");
            //System.out.println(aSmartAR.allKeys());
           // writer.println(aSmartAR.allKeys());




            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }




    }

    public static void main(String[] args) { smartTest2 t = new smartTest2();}

}
