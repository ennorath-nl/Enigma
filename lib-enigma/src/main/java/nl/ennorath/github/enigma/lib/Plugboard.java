package nl.ennorath.github.enigma.lib;

import java.util.HashMap;

class Plugboard {
    static final Character[] alphabet =
            { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'X', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    HashMap<Character, Character> plugboardSettings = new HashMap<>();
    public Plugboard(HashMap<Character, Character> pairs) {
        plugboardSettings.putAll(pairs);

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
