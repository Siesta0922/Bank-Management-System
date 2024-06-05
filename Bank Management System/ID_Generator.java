import java.util.*;

public class ID_Generator {
	final static String lexicon = "12345674890";
	final static Random rand = new Random();
	final static HashSet<String> identifiers = new HashSet<String>();

	// Method to return a unique ID
	public static String randomUserID() {
		StringBuilder builder = new StringBuilder();
		while (builder.toString().length() == 0) {
			int length = 10;
			// Appends the StringBuilder using random characters from the lexicon string
			for (int i = 0; i < length; i++) {
				builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
			}
			// Checks if created ID is unique, if not resets StringBuilder to restart the loop
			if (identifiers.contains(builder.toString())) {
				builder = new StringBuilder();
			} else {
				// Adds a created ID to identifiers if unique to use for checking
				identifiers.add(builder.toString());
			}
		}
		
		return builder.toString();
	}
}