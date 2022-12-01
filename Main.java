import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input string:");
        String input = scanner.nextLine();
        System.out.println();
        System.out.println("The result:");


        stringArray(input);


        /*
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println(inputArray[i] + " = " +
                    String.format("%7s", Integer.toBinaryString(input.charAt(i))).replace(" ", "0"));
        }
         */


    }
    public static void stringArray(String inputToEncodeDecode){


        System.out.println("//testing inputStringToEnDe");
        for (int i = 0; i < inputToEncodeDecode.length(); i++) {
            System.out.println(inputToEncodeDecode.charAt(i));
        }

        StringBuilder binaryInput = new StringBuilder();
        StringBuilder enCodedString = new StringBuilder();
        char now;
        char next;
        int counter = 0;
        /* TESTER
        System.out.println("to Test string array to char array");
        char[] toBinary = inputToEncodeDecode.toCharArray();
        for (char c : toBinary) {
            System.out.println(c);
        }
         */
        char[] toBinary = inputToEncodeDecode.toCharArray();
        for (char c : toBinary) {
            binaryInput.append(String.format("%7s", Integer.toBinaryString(c)).replace(" ", "0"));
        }
        System.out.println("//binaryInput");
        System.out.println(binaryInput);

        for (int i = 0; i < binaryInput.length() - 1; i++) {
            System.out.println("//test char at");
            System.out.println(binaryInput.charAt(i));
            if (binaryInput.charAt(i) == 0) {
                enCodedString.append("00 ");
                System.out.println("//00");
            } else if (binaryInput.charAt(i) == 1) {
                enCodedString.append("0 ");
                System.out.println("//0");
            }

            do {
                now = binaryInput.charAt(i);
                next = binaryInput.charAt(i + 1);
                enCodedString.append("0");
                i++;
            } while (now == next);

            enCodedString.append(" ");
        }


        System.out.println("test");
        System.out.println(enCodedString);
    }
}
