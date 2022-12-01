import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input string:");
        String input = scanner.nextLine();
        System.out.println();
        System.out.println("The result:");

        stringArray(input);
    }
    public static void stringArray(String inputToEncodeDecode){

        //for binaryCode of the input
        StringBuilder binaryInput = new StringBuilder();
        //for Chuck Norris code
        StringBuilder enCodedString = new StringBuilder();

        //changes String input to char[] inputArray
        char[] toBinary = inputToEncodeDecode.toCharArray();
        //changes char[] inputArray to String binaryCode
        for (char c : toBinary) {
            binaryInput.append(String.format("%7s", Integer.toBinaryString(c)).replace(" ", "0"));
        }

        //to make everything to 0
        for (int i = 0; i < binaryInput.length(); i++) {
            //to see if it's 0 or 1
            //remember:
            //00 == 0
            //0  == 1
            if (binaryInput.charAt(i) == '0') {
                enCodedString.append("00 ");
            } else if (binaryInput.charAt(i) == '1') {
                enCodedString.append("0 ");
            }
            //should be obvious if reader is sober
            int count = 1;
            while (i + 1 < binaryInput.length() && binaryInput.charAt(i) == binaryInput.charAt(i + 1)) {
                i++;
                count++;
            }
            enCodedString.append("0".repeat(Math.max(0, count)));
            enCodedString.append(" ");
        }
        System.out.println(enCodedString);
    }
}
