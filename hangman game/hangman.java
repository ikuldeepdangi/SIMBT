//package simplbyte.hangman;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.attribute.standard.Finishings;
import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction;

public class hangman { 
    public static void main(String args []) throws Exception{
        System.out.println("\n      WELCOME TO HANGMAN GAME    ");
        File dictionary = new File("simplbyte_word_dictionary.txt");
        
        Scanner TextScanner = new Scanner(dictionary);
        Scanner input= new Scanner(System.in);
        
        ArrayList<String> words=new ArrayList<>();
        while(TextScanner.hasNextLine()) {
            words.add(TextScanner.nextLine());
        }
        String hidden_text = words.get((int)(Math.random()*words.size()));
        char[] textArray = hidden_text.toCharArray();
        
        char[] myAnswers = new char[textArray.length];
        for(int i=0;i<textArray.length;i++){
            myAnswers[i]='?';
        }

        boolean finished = false;
        int lives=6;

        while(finished==false){
            System.out.println("\n\n***********************");
            System.out.print("Enter -> ");

            String letter = input.next();
            while(letter.length()!=1 || Character.isDigit(letter.charAt(0))){
                System.out.println("try again...");
                letter=input.next();
            }

            boolean found=false;
            for(int i=0;i<textArray.length;i++){
                if(letter.charAt(0)== textArray[i]){
                    myAnswers[i]=textArray[i];
                    found=true;
                }
            }
            if(!found){
                lives--;
                System.out.println("wrong input");
            }

            boolean done  =true;
            for(int i=0;i<myAnswers.length;i++){
                if(myAnswers[i]=='?'){
                    System.out.print("_");
                    done=false;
        }
        else{
            //System.out.println(" Sorry you lost .\n The answer was : ");
            System.out.print(" "+myAnswers[i]);
        }
    }
    System.out.println("\n"+"Lives left : "+ lives);
    drawHangman(lives);

    if(done){
        System.out.println( "  YOU GOT IT , CONGRATULATIONS  ");
        finished=true;
    }
    if(lives<=0){
        System.out.println(" YOU ARE DEAD! ");
        System.out.println(hidden_text);
        finished =true;    
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
