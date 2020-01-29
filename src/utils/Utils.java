package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
    //Loading a file

    public static String loadFileAsString(String path){
        // allows to add characters to a string
        StringBuilder builder = new StringBuilder();

        try {
            //load file
            BufferedReader br = new BufferedReader(new FileReader(path));
            //current line that we're working on
            String line;
            // there are lines(maps) to read
            while((line = br.readLine()) != null)
                builder.append(line + "\n");
            //close the file stream
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        //convert everything that we've append to the line
        return builder.toString();
    }

    //change String to Int
    public static int parseInt(String number){
        try{
            return Integer.parseInt(number);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }

}
