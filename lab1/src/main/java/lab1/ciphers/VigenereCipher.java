package lab1.ciphers;

import lab1.services.StringParser;

public class VigenereCipher extends Cipher {

    @Override
    public String encode(String input, String key) throws EmptyKeyException {
        super.encode(StringParser.parseRussianString(input), StringParser.parseRussianString(key));
        return null;
    }

    @Override
    public String decode(String input, String key) throws EmptyKeyException {
        super.decode(StringParser.parseRussianString(input), StringParser.parseRussianString(key));
        return null;
    }
}
