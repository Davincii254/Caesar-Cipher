package Caesar;

import java.util.Scanner;

class Caesar {


    private final String message;
    private final int shift;

    public String getMessage() {
        return message;
    }

    public int getShift() {
        return shift;
    }

    public Caesar(String message, int shift) {
        this.message = message;
        this.shift= shift;

    }


    // Encrypting the Code
    public static String encrypt(String plainText, int shift) {

        if (shift > 26) {
            shift = shift % 26;
        } else if (shift < 0) {
            shift = (shift % 26) + 26;
        }

        String cipherText = "";
        int length = plainText.length();
        for (int i = 0; i < length; i++) {    //for loop to change position of the letters
            char ch = plainText.charAt(i);
            if (Character.isLetter(ch)) {  //makes sure the words are i the uppercase
                if (Character.isLowerCase(ch)) {
                    char c = (char) (ch + shift);
                    if (c > 'z') {
                        cipherText += (char) (ch - (26 - shift));
                    } else {
                        cipherText += c;
                    }
                } else if (Character.isUpperCase(ch)) {
                    char c = (char) (ch + shift);
                    if (c > 'Z') {
                        cipherText += (char) (ch - (26 - shift));
                    } else {
                        cipherText += c;
                    }
                }
            } else {
                cipherText += ch;
            }
        }
        return cipherText;
    }


    // Decrypt the code

    public static String decrypt(String plainText, int shift) {
        if (shift > 26) {
            shift = shift % 26;
        } else if (shift < 0) {
            shift = (shift % 26) + 26;
        }

        String cipherText = "";
        int length = plainText.length();
        for (int i = 0; i < length; i++) {
            char ch = plainText.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    char c = (char) (ch - shift);
                    if (c < 'a') {
                        cipherText += (char) (ch + (26 - shift));
                    } else {
                        cipherText += c;
                    }
                } else if (Character.isUpperCase(ch)) {
                    char c = (char) (ch - shift);
                    if (c < 'A') {
                        cipherText += (char) (ch + (26 - shift));
                    } else {
                        cipherText += c;
                    }
                }
            } else {
                cipherText += ch;
            }
        }
        return cipherText;
    }


    public static void main(String[] args) {
        System.out.println("Welcome!");
        while (true) {
            System.out.println("Do you want to decrypt(D) or encrypt(E)");
            Scanner input = new Scanner(System.in);
            String userChoice = input.nextLine().toUpperCase();
            if (userChoice.equals("E")) {


                // encrypt
                Scanner myScanner = new Scanner(System.in);
                System.out.println(">| Enter Message");
                String text = myScanner.nextLine();
                System.out.println(">| Enter Key ");
                int shift = Integer.parseInt(myScanner.nextLine());
                String cipher = encrypt(text, shift);
                System.out.println("your encrypted word is is:" + " " + cipher);
                System.exit(0);

            } else if (userChoice.equals("D")) {


                // decrypt
                System.out.println(" Enter Message to decrypt");
                Scanner myScanner = new Scanner(System.in);
                String text = myScanner.nextLine();
                System.out.println(" Enter Key");
                int shift = Integer.parseInt(myScanner.nextLine());
                String cipher = decrypt(text, shift);
                System.out.println("your decrypted word is: " + " " + cipher);
                System.out.println("Press any key to exit");
                System.exit(0);
                break;

            } else {
                System.out.println("404");
            }

        }
    }
}


