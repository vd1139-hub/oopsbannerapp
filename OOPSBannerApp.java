import java.util.HashMap;
import java.util.Map;

public class OOPSBannerApp {

    // 1. CharacterPattern Class (Same as UC7)
    private static class CharacterPattern {
        private final String[] pattern;

        public CharacterPattern(String[] pattern) {
            this.pattern = pattern;
        }

        public String getLine(int index) {
            return (index >= 0 && index < pattern.length) ? pattern[index] : "         ";
        }
    }

    public static void main(String[] args) {
        // 2. Initialize the Registry (Map)
        Map<Character, CharacterPattern> patternMap = new HashMap<>();
        
        // Populating the registry
        patternMap.put('O', new CharacterPattern(new String[]{
            "  *** ", " * * ", " * * ", " * * ", " * * ", " * * ", "  *** "
        }));
        
        patternMap.put('P', new CharacterPattern(new String[]{
            " ***** ", " * * ", " * * ", " ***** ", " * ", " * ", " * "
        }));
        
        patternMap.put('S', new CharacterPattern(new String[]{
            "  **** ", " * ", " * ", "  *** ", "      *", "      *", " **** "
        }));

        // 3. Render the word "OOPS"
        renderBanner("OOPS", patternMap);
    }

    /**
     * Dynamically renders a word as a banner using the provided pattern map.
     */
    public static void renderBanner(String word, Map<Character, CharacterPattern> map) {
        // We assume a 7-line height for all characters
        for (int i = 0; i < 7; i++) {
            StringBuilder lineBuilder = new StringBuilder();
            
            // Loop through each character in the input word
            for (char c : word.toUpperCase().toCharArray()) {
                CharacterPattern cp = map.get(c);
                if (cp != null) {
                    lineBuilder.append(cp.getLine(i));
                } else {
                    // Fallback for missing characters (empty space)
                    lineBuilder.append("         "); 
                }
            }
            // Print the assembled line
            System.out.println(lineBuilder.toString());
        }
    }
}