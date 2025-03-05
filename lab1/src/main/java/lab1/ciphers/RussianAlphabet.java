package lab1.ciphers;

import java.util.ArrayList;
import java.util.Collections;

public class RussianAlphabet {
    public static final int LETTERS_COUNT = 33;
    private final int Ё = 6;
    private final char[] letters = new char[LETTERS_COUNT];

    public RussianAlphabet() {
        for (int i = 0; i < Ё; i++) {
            letters[i] = (char) ('А' + i);
        }
        letters[Ё] = 'Ё';
        for (int i = Ё + 1; i < LETTERS_COUNT; i++) {
            letters[i] = (char) ('А' + i - 1);
        }
    }

    public char getLetter(int pos) {
        return letters[pos];
    }

    public int getLettersNum(char ch) {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    public char getEncodedLetter(char plainLetter, int key, boolean isEncoding) {
        int plainLetterPos = this.getLettersNum(plainLetter);
        return letters[(isEncoding ? plainLetterPos + key : plainLetterPos - key + LETTERS_COUNT) % LETTERS_COUNT];
    }
}
