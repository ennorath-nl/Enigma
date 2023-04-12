package nl.ennorath.github.enigma.lib;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class PlugboardTest {
    static final Character[] alphabet =
            { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'X', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    @Test
    public void emptyPlugboardMapsLettersToThemselves()
    {
        /* Letters not mapped by a plugboard setting should map to themselves. Thus,
         * a plugboard without plugs should map all letters to themselves.
         */
        Plugboard emptyPlugboard = new Plugboard(new HashMap<Character, Character>());

        for (Character c : alphabet) {
            assertSame(emptyPlugboard.map(c), c);
        }
    }

    @Test
    public void plugboardMapsLettersBothWays()
    {
        /* Plugboard settings are done in pairs. Therefore, if A is mapped to B, then B maps to
         * A also.
         */
        HashMap<Character, Character> plugboardSettings = new HashMap<>();

        plugboardSettings.put('A', 'B');

        Plugboard plugboard = new Plugboard(plugboardSettings);

        assertEquals('B', (char) plugboard.map('A'));
        assertEquals('A', (char) plugboard.map('B'));
    }
}