package eliza;

// Keyword library
// Jonas Wolffrom Strandgaard Clausen
// Rasmus Rosendal Nielsen

public class keywords {

    // Question keywords or keywords that are asking things
    static String[] whatWords = {"why", "what", "who", "whom", "which", "when", "where" , "how"};

    // Greetings keywords, for when the user says a greeting
    static String[] greeting = {"hello","hey","hi"};

    // Reflective keywords, for when the user talks about the bot
    static String[] reflective = {"you", "your"};

    // Help keywords, for when the user asks for help
    static String[] help = {"help"};

    // Arrays are static, so that the main code can fetch them without creating an object
}
