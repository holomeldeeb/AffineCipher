import java.util.Scanner;

public class AffineCipher {
    static int a = 5, b = 8;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String cipheredText = ciphering();
        System.out.println("CipheredText is: " + cipheredText);
        String deCipheredText = deciphering(cipheredText);
        System.out.println("\nDecipheredText is: " + deCipheredText);
    }

    static String ciphering() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Please enter the text for ciphering: ");
        String plaintext = scn.nextLine();
        String cipheredText = "";

        for (int i = 0; i < plaintext.length(); i++) {
            char t = plaintext.charAt(i);
            int charNum = (int) t - 97;
            int c = (a * charNum + b) % 26;
            char newC = (char) (c + 97);
            cipheredText += newC;
        }
        return cipheredText;
    }

    static String deciphering(String cipher) {
        String plainText = "";
        int aInverse = modInverse(a, 26); 

        for (int i = 0; i < cipher.length(); i++) {
            char t = cipher.charAt(i);
            int charNum = (int) t - 97;
            int deciphered = (aInverse * (charNum - b + 26)) % 26;
            char newT = (char) (deciphered + 97);
            plainText += newT;
        }
        return plainText;
    }

    static int modInverse(int a, int m) {
        a = a % m;
        for (int i = 1; i < m; i++) {
            if ((a * i) % m == 1) {
                return i;
            }
        }
        return 1;
    }
}

