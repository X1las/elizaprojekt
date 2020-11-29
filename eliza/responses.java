package eliza;

// Response library
// Jonas Wolffrom Strandgaard Clausen
// Rasmus Rosendal Nielsen

public class responses {
    
    // Responses, for when there's no specific response
    static String generic_response[] = {"How does that make you feel?", "Tell me more","Go on tell me more","Tell me more about what bothers you"};

    // Responses for when user asks for help
    static String help_response[] = {"I can only talk to you" , "I can not really help you, but you are free to voice your feelings"};

    // Responses for when greeting the user
    static String greeting_response[] = {"Hello " , "Hi " , "Hey " , "Greetings "};

    // Responses for when the bot is answering something about the bot
    static String reflective_response[] = {"This is not about me, what troubles you?" , "I am not important in this conversation, tell me something about yourself"};

    // Arrays are static, so that the main code can fetch them without creating an object
}
