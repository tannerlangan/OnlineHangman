package ca.cmpt213.a4.onlinehangman;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class GetWord {

    public String returnRandomWord() throws IOException {
        Random rand = new Random();
        int count = 0;
        ArrayList<String> wordList = new ArrayList<String>();


        try{
            File files = new File("commonWords.txt");
            Scanner scanner = new Scanner(files);
            while (scanner.hasNextLine()) {
                wordList.add(scanner.nextLine());
                count++;
            }
        }catch (FileNotFoundException e) {
            System.out.println("No file found");
        }

        int randNum = rand.nextInt(wordList.size());
        String word = wordList.get(randNum);

        return word;
    }

}
