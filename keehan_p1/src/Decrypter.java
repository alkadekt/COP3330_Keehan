//This class decrypts a 4 digit user input
import java.util.Scanner; //Scanner for user input

public class Decrypter {

    //Main Method
    public static void main(String[] args) {

        //Prompt user for input
        System.out.print("Give your encrypted integer: ");
        //Read in input
        String EntryCode = ReadEntry();

        //Create an instance of Decrypter class
        Decrypter myDecrypter = new Decrypter();
        //Call decrypt method with entry
        String OutputCode = myDecrypter.decrypt(EntryCode);

        //Print out decrypted integer
        System.out.print("Here is your decrypted code: ");
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
    //Decrypt Method
    public String decrypt(String EntryCode){

        //Turn string code into an int array
        int[] EntryArr = StringToIntArray(EntryCode);

        //Perform the decryption
        int temp = EntryArr[0];
        EntryArr[0] = EntryArr[2];
        EntryArr[2] = temp;
        temp = EntryArr[1];
        EntryArr[1] = EntryArr[3];
        EntryArr[3] = temp;
        for (int i = 0; i < 4; i++) {
            if (EntryArr[i] > 7) {
            }
            else {
                EntryArr[i] = EntryArr[i] + 10;
            }
            EntryArr[i] = EntryArr[i] - 7;
        }


        //Turn array back into string and return it
        return IntArrayToString(EntryArr);
    }
}