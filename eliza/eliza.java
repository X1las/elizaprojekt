package eliza;

import java.util.Scanner;
import java.util.Random;

// Jonas Wolffrom Strandgaard Clausen
// Rasmus Rosendal Nielsen
// Main code

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
            } 
            else 
            {
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

    // Method for analyzing an array of words and compare them to keywords in order to find a response
    static String analyzeWords(String[] words) {
        
        // fetching keywords from keywords.java
        String[] key_greeting = keywords.greeting;
        String[] key_reflect = keywords.reflective;
        String[] key_help = keywords.help;
        String[] key_whatWords = keywords.whatWords;

        String Response = " ";                                  // Making a response variable that is empty to keep our response if we find a match

        Random r = new Random();                                // Making random object to choose random responses from given categories for variation
        
        outerloop:
        for (int i = 0; i < words.length; i++)                                          // For loop that iterates between words array
        {
            for(int k = 0; k < key_help.length; k++)                                    // For loop that iterates between keywords array
            {
                if(key_help[k].equals(words[i]))                                        // Check to see if word equals keyword
                {
                    String[] temp_resp = responses.help_response;                   // Assigns help responses to a temporary array
                    Response = temp_resp[r.nextInt(temp_resp.length - 1)];              // Assigns a random help response to the response
                    break outerloop;                                                    // Break the entire loop
                }
            }
            for (int k = 0; k < key_greeting.length; k++)                               // For loop that iterates between greeting keywords
            {                                                                           // Same as previous loop
                if (key_greeting[k].equals(words[i]))                                   
                {                      
                    String[] temp_resp = responses.greeting_response;                   
                    Response = temp_resp[r.nextInt(temp_resp.length - 1)];              
                    break outerloop;                                                    
                }
            }
            for (int k = 0; k < key_reflect.length; k++)                                // For loop that iterates between reflective keywords
            {                                                                           // Same as previous loop, but does not break the entire code
                if (key_reflect[k].equals(words[i])) 
                {
                    Response = responses.reflective_response[0];
                }
            }
            for (int k = 0; k < key_whatWords.length; k++)                              // For loop that iterates between what keywords
            {
                if (key_whatWords[k].equals(words[i]))                                  // Same as previous loop until this point
                {
                    Response = words[i] + " do you think";                              // Making response equal to the what word user used plus "do you think"                        

                    // Switching words for grammar
                    String temp1 = words[i+1];
                    String temp2 = words[i+2];
                    words[i+1] = temp2;
                    words[i+2] = temp1;

                    for(int x = i+1; x < words.length; x++)                             // For loop for every index after i
                    {
                        if(words[x].equals("my"))                                       // Condition that changes every "my" response to "your"
                        {
                            Response = Response + " your";
                        }
                        else if(words[x].equals("me") || words[x].equals("i"))          // Condition that changes every "me" or "i" response to "you"
                        {
                            Response = Response + " you";
                        }
                        else                                                            // Else that adds every other word said to the response with space inbetween
                        {
                            Response = Response + " " + words[x];
                        }
                    }
                Response = Response + "?";                                              // Adds a question mark as finishing touch
                break outerloop;                                                        // Breaks the entire function
                }
            }
        }

        if (Response.equals(" "))                                                       // Condition that makes the response a generic one if the code doesn't get a hit
        {
            String[] temp_resp = responses.generic_response;
            Response = temp_resp[r.nextInt(temp_resp.length - 1)];
        }

        return Response;                                                                // Returns the eventual response
    }
}