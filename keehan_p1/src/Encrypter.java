//This class encrypts a 4 digit user input


import java.util.Scanner; //Scanner for user input
import java.util.Arrays;
import java.util.List;

public class Encrypter {

    //Main Method
    public static void main(String[] args) {

        //Prompt user for input
        System.out.print("Give your four-digit integer: ");
        //Read in input
        String EntryCode = ReadEntry();

        //Create an instance of Encrypter class
        Encrypter myEncrypter = new Encrypter();
        //Call encrypt method with entry
        String OutputCode = myEncrypter.encrypt(EntryCode);

        //Print out encrypted integer
        System.out.print("Here is your encrypted code: ");
        System.out.println(OutputCode);

    }
    //ReadEntry Method
    public static String ReadEntry(){

        //New scanner
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    //StringToIntArray Method
    public static int[] StringToIntArray(String EntryCode){

        int[] EntryArr = new int[4];
        String[] StringArr = EntryCode.split("");
        for (int i = 0; i < 4; i++) {
            EntryArr[i] = Integer.parseInt(StringArr[i]);
        }
        return EntryArr;
    }
    //IntArrayToString Method
    public static String IntArrayToString(int[] EntryArr){

        //Turn array of ints into array of strings
        String[] StringArr = new String[4];
        for (int i = 0; i < 4; i++) {
            StringArr[i] = String.valueOf(EntryArr[i]);
        }
        //Join strings in array into single string
        String OutputCode = String.join("", StringArr);
        return OutputCode;
    }
    //Encrypt Method
    public String encrypt(String EntryCode){

        //Turn string code into an int array
        int[] EntryArr = StringToIntArray(EntryCode);

        //Perform the encryption
        for (int i = 0; i < 4; i++) {
            EntryArr[i] = EntryArr[i] + 7;
            EntryArr[i] = EntryArr[i] % 10;
        }
        int temp = EntryArr[0];
        EntryArr[0] = EntryArr[2];
        EntryArr[2] = temp;
        temp = EntryArr[1];
        EntryArr[1] = EntryArr[3];
        EntryArr[3] = temp;

        //Turn array back into string and return it
        return IntArrayToString(EntryArr);
    }
}
