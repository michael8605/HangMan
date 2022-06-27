import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) throws Exception{

        System.out.println("Welcome to Hangman");

        File dictionary = new File("C:\\Users\\brefo\\Documents\\IdeaProjects\\HangMan\\src\\dictionary.txt");
        Scanner textScanner = new Scanner(dictionary);
        Scanner input = new Scanner(System.in);

        ArrayList<String> words= new ArrayList<>();
        while (textScanner.hasNextLine()){
            words.add(textScanner.nextLine());
        }

        String hidden_text = words.get((int)(Math.random()*words.size()));
        char[] textArray = hidden_text.toCharArray();

        char[] myAnwers = new char[textArray.length];
        for(int i=0; i< textArray.length; i++){
            myAnwers[i]= '?';
        }

        boolean gameOn = true;
        while (gameOn== true){
            boolean finished = false;
            int lives = 6;
            ArrayList <String> test = new ArrayList<>();

            while(finished == false){
                System.out.println("**********************");
                String letter= input.next();

                while (test.contains(letter)){
                    System.out.println("You already choose "+ letter + ". Try a new letter");
                    letter = input.next();
                }

                test.add(letter);

                while(letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
                    System.out.println("Error Input - Try Again");
                    letter = input.next();
                }

                boolean found = false;
                for ( int i = 0; i <textArray.length; i++) {
                    if(letter.charAt(0) == textArray[i]){
                        myAnwers[i] = textArray[i];
                        found = true;
                    }
                }

                if(found == false){
                    lives--;
                    System.out.println("wrong Letter");
                }

                boolean done = true;
                for(int i = 0; i< myAnwers.length; i++){
                    if(myAnwers[i] == '?') {
                        System.out.print("_");
                        done = false;
                    }else {
                        System.out.print(" "+ myAnwers[i]);
                    }
                }

                System.out.println("\n" + "Lives left: " +lives);
                drawHangman(lives);

                if(done){
                    System.out.println("Congrats You found the word");
                    finished = true;
                }
                if (lives <= 0){
                    System.out.println("You are dead! Learn more Words");
                    finished = true;
                }

            }
            System.out.println(hidden_text);
            System.out.println("Do you want to Pay Again? (Y or N)");
            String restart = input.next();

            if(restart.equals("Y") || restart.equals("y")){
                gameOn = true;
            }else {
                gameOn = false;
            }
        }


    }
    public static void drawHangman(int l) {
        if(l == 6) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 5) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 4) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 3) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 1) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else{
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }
}
