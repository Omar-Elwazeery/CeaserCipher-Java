import java.util.Scanner;

import static java.lang.Character.*;

public class methods {
    static Scanner sc = new Scanner(System.in);
    public static String encrypt(String message, int shiftkey) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isLowerCase(chars[i])) {
                chars[i] = alphabet[(chars[i]-'a' + shiftkey) % 26];
            } else if(chars[i]!=' ') {
                chars[i] = toLowerCase(chars[i]);
                chars[i] = alphabet[(chars[i]-'a' + shiftkey) % 26];
                chars[i] = toUpperCase(chars[i]);
            }
        }

        return new String(chars);
    }

    public static String decrypt(String message, int shiftkey) {
        return encrypt(message, (26 - shiftkey) % 26);

    }
    public static String sendmessage(String encrypted) {
        return encrypted;
    }
    public static String recivemessage() {
        String message = sc.next();
        return message;
    }

    public static String[] BurteForce(String encrypt) {
        String[] plaintext = new String[26];
        for (int i = 0; i <= 25; i++) {
            plaintext[i] = decrypt(encrypt, i);
        }
        return plaintext;
    }
    public static String FrequencyAnalysis (String code) {
        int key = 0;
        final int ALPHABET_SIZE = 26;
        int[] freqs = new int[ALPHABET_SIZE];

        int highestFreq = 0;
        int highestFreqIdx = -1;
        for (int k = 0; k < code.length(); k++) {
            if (code.charAt(k) >= 'a' && code.charAt(k) <= 'z') {
                int count = freqs[code.charAt(k) - 'a']++;

                if (count > highestFreq) {
                    highestFreq = count;
                    highestFreqIdx = k;
                }
            }
        }

        key = (highestFreqIdx < 4 ? 26 - highestFreq : highestFreq) - ('e' - 'a');
        return encrypt(code, key);

    }
}
