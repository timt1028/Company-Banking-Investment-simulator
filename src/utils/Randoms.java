package utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Randoms {
    private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final Set<String> usedSymbols = new HashSet<>();

    public static String nextSymbol(int length) {
        Random random = new Random();
        var stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = characters.charAt(random.nextInt(characters.length()));
            stringBuilder.append(c);
        }
        String symbol = stringBuilder.toString();
        if (usedSymbols.contains(symbol)) {
            return nextSymbol(length);
        }
        usedSymbols.add(symbol);
        return symbol;
    }
}
