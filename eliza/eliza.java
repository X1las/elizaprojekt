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
                // Converts user input to array of words and symbols
                String[] words = convertInput(text);
                
                // Makes response equal to output of analyzeWords()
                response = analyzeWords(words);
            }
            // Prints out final response
            System.out.println(response); 
        }
        // Closing the scanner to avoid resource leak
        sca.close();
    }

    // Method for converting a string sentence into an array of words and symbols in order
    static String[] convertInput(String input) 
    {
        
        // Converting input into a temporary character array tempa
        char[] tempa = input.toCharArray();
        
        // Going through all characters of the array to find ! and ? and replacing them by space
        for (int i = 0 ; i < tempa.length ; i++)
        {
            if (tempa[i] == '!')
            {
                tempa[i] = ' ';
            }
            if (tempa[i] == '?')
            {
                tempa[i] = ' ';
            }
        }

        // Converting character array to string
        String temp = new String(tempa);

        
        // Splitting the string at each space in the sentence. If i don't add true as the second parameter, it will exclude empty spaces between doubled spaced words as array entries
        String[] Output = temp.split(" ");

        return Output; // Returns an array of whole words.
    }

    // Empty method for analyzing an array of words and compare them to keywords in order to find a response
    static String analyzeWords(String[] words) 
    {
        // fetching keywords from keywords.java
        String[] key_greeting = keywords.greeting;
        String[] key_object = keywords.object;
        String[] key_reflect = keywords.reflective;

        String Response = "";                           // Making a response variable that is empty
        boolean greeted = false;                        // Making a boolean to count whether we greeted the user or not to avoid overlapping

        Random r = new Random();                        // Making random object to choose random responses from given categories for variation

        for (int i = 0 ; i < words.length ; i++)        // For loop that iterates between words in array
        {
            if (!greeted)                               // Check to see if greeted
            {
                for (int k = 0 ; k < key_greeting.length ; k++)                         // For loop that iterates between greeting keywords
                {
                    // Code that executes if we get a match
                    if (key_greeting[k].equals(words[i]))
                    {
                        String[] temp_resp = responses.greeting_response;                   // Assigns greeting responses to a temporary array
                        Response = temp_resp[r.nextInt(temp_resp.length-1)] + Response;     // Adds a greeting message to the beginning of our response
                        greeted = true;                                                     // Ticks greeted on
                        break;                                                              // Breaks the for loop
                    }
                }
            }
            for (int k = 0 ; k < key_reflect.length ; k++)   {

                if(key_reflect[k].equals(words[i])){
                    Response = responses.reflective_response[0];   
                    break;
                }

            }
            
        }
        
        return Response; // Returns the eventual response
    }
}