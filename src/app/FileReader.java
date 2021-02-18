package app;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class FileReader {

    /**
     * use csv file with columns containing right encoder values, left encoder values, and time.
     * @param file - full file path
     * @param list - list to write values to
     * @param pos - column number of values to read
     */
    public static void scanToList(String file, List<Float> list,int pos){
        Float x = (float) 0.0;
        Scanner sc = null; // creates scanner
        try {
            sc = new Scanner(new File(file));

            // Check if there is another line of input
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                // parse row and find desired cell
                x = Float.parseFloat(returnArg(str, pos));
                // adds cell value to list
                list.add(x);
     

            }
        } 
        catch (IOException exp) {
            // TODO Auto-generated catch block
            exp.printStackTrace();
        }
        finally {
            if (sc != null)
                System.out.println(list);
                sc.close();
        }
    }

    public static Float x_val(String file,int pos){
        Float x = (float) 0.0;
        Scanner sc = null;
        try {
            sc = new Scanner(new File(file));

            // Check if there is another line of input
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                // parse each line using delimiter
                x = Float.parseFloat(returnArg(str, pos));
     

            }
        } 
        catch (IOException exp) {
            // TODO Auto-generated catch block
            exp.printStackTrace();
        }
        finally {
            if (sc != null)
                sc.close();
        }
        return x;
    }

    private static String returnArg(String str,int pos) {
        String arg = "";
        Scanner lineScanner = new Scanner(str);
        lineScanner.useDelimiter(",");
        int i = 0;
        while (lineScanner.hasNext()) {
            if (i == pos){
                arg = lineScanner.next();
            }
            i++;
            try{
            lineScanner.next();
            }
            catch (NoSuchElementException NoSuchElementException){}

        }
        lineScanner.close();
        return arg;
    }



}
