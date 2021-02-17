/*
created by mumakhado on 2021/02/17
*/

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;

public class consoleRoulette {

    public static void main(String [] args) throws IOException {

        File inputFile = new File("/home/makahdo/Documents/Input_file.txt");
        ArrayList<String> nameList = (ArrayList<String>) Files.readAllLines(inputFile.toPath(), Charset.defaultCharset());

        for (String s : nameList) {


        }

    }

}
