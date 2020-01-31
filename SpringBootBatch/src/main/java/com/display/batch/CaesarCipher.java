package com.display.batch;


public class CaesarCipher {
    private static final char LETTER_A = 'a';
    private static final char LETTER_Z = 'z';
    private static final int ALPHABET_SIZE = LETTER_Z - LETTER_A + 1;
   

    public String cipher(String message, int offset) {
        StringBuilder result = new StringBuilder();

        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - LETTER_A;
                int newAlphabetPosition = (originalAlphabetPosition + offset) % ALPHABET_SIZE;
                char newCharacter = (char) (LETTER_A + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }

    public String decipher(String message, int offset) {
        return cipher(message, ALPHABET_SIZE - (offset % ALPHABET_SIZE));
    }


}