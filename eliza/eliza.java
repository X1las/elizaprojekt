package eliza;

import java.util.Scanner;

// Elizabot, a bot that communicates with a user and keeps a conversation going.
// Source: a therapist bot that is there to keep calm continuous conversation by asking what the user feels and registering key words to respond to/with

// To break the bot down, it will need the following:
// Method to scan input and break it down to words and symbols, like "hi" "hello" and "!?"
// Library of possible words and meaning, trigger words, responses and differences between sentences with ! and ? in them
// A method of connecting the responses with user input
// Failsaves in case of miscommunication or confusing input

public class eliza {
    public static void main(String args[]) {
        // Creating scanner object
        Scanner sca = new Scanner(System.in);

        // Startup message
        System.out.println("Hello! Welcome to ChatBotMK1, Remake of Eliza! \nNote that you can stop the program at any type by simply writing 'kill' \n\nHello there!");

        // Dialogue loop, stopped with "kill" command
        while (true) {
            // Getting user input with scanner object
            String text = sca.nextLine().toLowerCase();

            // Making a default response, changed inside the else statement
            String response = "Sorry, Didn't get that!";

            // Checker for 'kill' command
            if (text.equals("kill")) {
                break; // stops the while loop
            } else {
                // Fetches array of keywords from keywords.java
                String[] words = convertInput(text);
            }
            // Prints out final response
            System.out.println(response); 
        }
    }

    // Empty method for converting a string sentence into an array of words and symbols in order
    static String[] convertInput(String input) {

        String[] Output;
        return Output;
    }

    // Empty method for analyzing an array of words and compare them to keywords in order to find a response
    static String analyzeWords(String[] words) {

        for(int i = 0; i < words.lenght; i++){
            
        }

        String Response = "";
        return Response;
    }
}