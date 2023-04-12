package nl.ennorath.github.enigma.lib;

import java.util.HashMap;
import java.util.Map;

class Plugboard {
    static final Character[] alphabet =
            { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'X', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    HashMap<Character, Character> plugboardSettings = new HashMap<>();
    public Plugboard(HashMap<Character, Character> pairs) {
        plugboardSettings.putAll(pairs);

        // Pairs have to be added in reverse. That is, if A maps to B, then B maps to A also
        for (Map.Entry<Character, Character> pair : pairs.entrySet()) {
            plugboardSettings.put(pair.getValue(), pair.getKey());
        }

        for (Character c : alphabet) {
            // If a letter is not mapped by a plugboard setting
            if (plugboardSettings.get(c) == null) {
                // then it maps to itself
                plugboardSettings.put(c, c);
            }
        }
    }

    // Maps a letter to its output letter
    public Character map(Character c) {
        return plugboardSettings.get(c);
    }
}
