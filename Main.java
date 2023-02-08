import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputMainMenu;
        Menu M = Menu.NOT_EXIT;

        while (M != Menu.EXIT) {
            System.out.println("Please input operation (encode/decode/exit):");
            inputMainMenu = scanner.nextLine();
            switch (inputMainMenu) {
                case "encode":
                    System.out.println("Input string:");
                    String inputToEncode = scanner.nextLine();
                    System.out.println();
                    enCode(inputToEncode);
                    break;
                case "decode":
                    System.out.println("Input encoded string:");
                    String enCodedInput = scanner.nextLine();
                    System.out.println();
                    try {
                        deCode(enCodedInput);
                    }catch (Exception e) {
                        System.out.println("Encoded string is not valid.");
                    }
                    break;
                case "exit":
                    System.out.println("Bye!");
                    M = Menu.EXIT;
                    break;
                default:
                    System.out.println("There is no '" + inputMainMenu + "' operation");

            }
        }
    }
    public static void enCode(String inputToEncode){

        //for binaryCode of the input
        StringBuilder binaryInput = new StringBuilder();
        //for Chuck Norris code
        StringBuilder enCodedString = new StringBuilder();

        //changes String input to char[] inputArray
        char[] toBinary = inputToEncode.toCharArray();
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
            //should be obvious if you are sober
            int count = 1;
            while (i + 1 < binaryInput.length() && binaryInput.charAt(i) == binaryInput.charAt(i + 1)) {
                i++;
                count++;
            }
            enCodedString.append("0".repeat(Math.max(0, count)));
            enCodedString.append(" ");
        }
        System.out.println("Encoded string:");
        System.out.println(enCodedString);
    }

    public static void deCode(String inputToDecode){

        StringBuilder toBinaryWithoutFormat = new StringBuilder();
        StringBuilder toBinaryWithFormat = new StringBuilder();
        StringBuilder deCoded = new StringBuilder();
        String[] inputArray;
        String[] binaryArray;

        //input to Array
        inputArray = inputToDecode.split(" ");

        //translate enCoded to binary without format
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].equals("0")) {
                toBinaryWithoutFormat.append(inputArray[i + 1].replaceAll("0", "1"));
            } else if (inputArray[i].equals("00")) {
                toBinaryWithoutFormat.append(inputArray[i + 1]);
            }
            i++;
        }

        //checks if the input is valid
        if (toBinaryWithoutFormat.length() % 7 == 0) {

            //makes binary with format
            for (int i = 0; i < toBinaryWithoutFormat.length(); i++) {
                if (i % 7 == 0 && i != 0) {
                    toBinaryWithFormat.append(" ");
                }
                toBinaryWithFormat.append(toBinaryWithoutFormat.charAt(i));
            }

            //another Array with formatted binary
            String s = String.valueOf(toBinaryWithFormat);
            binaryArray = s.split(" ");

            //translates binary to decimal
            for (String value : binaryArray) {
                int decimal = Integer.parseInt(value, 2);
                char temp = (char) decimal;
                deCoded.append(temp);
            }

            System.out.println("Decoded string:");
            System.out.println(deCoded);
        } else {
            System.out.println("Encoded string is not valid.");
        }
    }
}
