/**
 * Created by lytte on 7/22/2016.
 * the comments below are more or less unreliable as to what's happening, this is my first time working with files
 *
 *
 */

import java.io.*;

public class countMain {
    public static void main(String[] args) throws IOException{
        int count = 0; //default value
        try(
                DataInputStream input = new DataInputStream(new FileInputStream("count.dat"));
        ) {
            count = input.readInt(); //pulls value if it exists, if not hits the catch
        } catch(EOFException e) {

        }
        try(
                DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("count.dat"));
        ) {
            System.out.println("This is the " + (count + 1) + "th Iteration"); //tells the user which iteration they're on
            if(count == 0) {
                //if the file had no values within, then count is equal to zero, and will be set to 1 in the file
                count+=1;
                outputStream.writeInt(count);
            } else {
                //if the count is larger then (Or less I suppose) zero, adds 1 and writes count to file
                count+= 1;
                outputStream.writeInt(count);
            }
        }
    }
}