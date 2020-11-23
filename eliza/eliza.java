package eliza;
import java.util.Scanner;

// Elizabot, a bot that communicates with a user and keeps a conversation going.
// Source: a therapist bot that is there to keep calm continuous conversation by asking what the user feels and registering key words to respond to/with

public class eliza {
    public static void main(String args[])
    {

        
        // To break the bot down, it will need the following:
        // Method to scan input and break it down to words and symbols, like "hi" "hello" and "!?"
        // Library of possible words and meaning, trigger words, responses and differences between sentences with ! and ? in them
        // A method of connecting the responses with user input
        // Failsaves in case of miscommunication or confusing input
        
        // Creating scanner object
        Scanner sca = new Scanner(System.in);

        // Startup message
        System.out.println("Hello! Welcome to ChatBotMK1, Remake of Eliza!");

        // Dialogue loop, stopped with "kill" command
        while (true)
        {
            String text = sca.nextLine().toLowerCase();
            String response = "Sorry, Didn't get that!";

            if (text.equals("kill"))
            {
                break;
            } else
            {
                System.out.println(keywords.words[1]);
            }
            System.out.println(response);
        }
    }
    static String[] convertInput(String input)
    {
        String[] Output;
        return Output;
    }
    static String analyzeWords(String[] words)
    {
        String Response = "";
        return Response;
    }
}