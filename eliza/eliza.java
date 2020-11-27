package eliza;

import java.util.Scanner;
import java.util.Random;

// Elizabot, a bot that communicates with a user and keeps a conversation going.
// Source: a therapist bot that is there to keep calm continuous conversation by asking what the user feels and registering key words to respond to/with

// To break the bot down, it will need the following:
// Method to scan input and break it down to words and symbols, like "hi" "hello" and "!?"
// Library of possible words and meaning, trigger words, responses and differences between sentences with ! and ? in them
// A method of connecting the responses with user input
// Failsaves in case of miscommunication or confusing input

public class eliza {
    public static void main(String args[]) {
        Scanner sca = new Scanner(System.in);               // Creating scanner object
        
        // Startup message
        System.out.println("Hello! Welcome to ChatBotMK1, Remake of Eliza! \nNote that you can stop the program at any type by simply writing 'kill' \n\nHello there!");

        while (true)                                        // Dialogue loop, stopped with "kill" command
        {
            String text = sca.nextLine().toLowerCase();     // Getting user input with scanner object

            String response = "Sorry, Didn't get that!";    // Making a default response, changed inside the else statement

            if (text.equals("kill"))                        // Checker for 'kill' command
            {
                break;                                      // stops the while loop
            } else {
                String[] words = convertInput(text);        // Converts user input to array of words and symbols

                response = analyzeWords(words);             // Makes response equal to output of analyzeWords()
            }
            System.out.println(response);                   // Prints out final response
        }
        sca.close();                                        // Closing the scanner to avoid resource leak
    }

    // Method for converting a string sentence into an array of words and symbols in order
    static String[] convertInput(String input) {

        char[] tempa = input.toCharArray();         // Converting input into a temporary character array tempa

        for (int i = 0; i < tempa.length; i++)      // Going through all characters of the array to find ! and ? and replacing them with spaces

        {
            if (tempa[i] == '!') {
                tempa[i] = ' ';
            }
            if (tempa[i] == '?') {
                tempa[i] = ' ';
            }
        }

        String temp = new String(tempa);            // Converting character array to string
        String[] Output = temp.split(" ");          // Splitting the string at each space in the sentence.
        return Output;                              // Returns an array of whole words.
    }

    // Empty method for analyzing an array of words and compare them to keywords in order to find a response
    static String analyzeWords(String[] words) {
        
        // fetching keywords from keywords.java
        String[] key_greeting = keywords.greeting;
        String[] key_object = keywords.object;
        String[] key_reflect = keywords.reflective;

        String Response = "";                                   // Making a response variable that is empty to keep our response if we find a match

        Random r = new Random();                                // Making random object to choose random responses from given categories for
                                                                // variation
        outerloop:
        for (int i = 0; i < words.length; i++)                  // For loop that iterates between words in array
        {
            for (int k = 0; k < key_greeting.length; k++)       // For loop that iterates between greeting keywords
            {
                if (key_greeting[k].equals(words[i])) {                                 // Code that executes if we get a match
                    String[] temp_resp = responses.greeting_response;                   // Assigns greeting responses to a temporary array
                    Response = temp_resp[r.nextInt(temp_resp.length - 1)];              // Adds a greeting message to the
                    break outerloop;                                                    // Breaks the entire for loop
                }
            }
            for (int k = 0; k < key_reflect.length; k++) {

                if (key_reflect[k].equals(words[i])) {
                    Response = responses.reflective_response[0];
                    break outerloop;
                }
            }

        }

        return Response;                                        // Returns the eventual response
    }
}