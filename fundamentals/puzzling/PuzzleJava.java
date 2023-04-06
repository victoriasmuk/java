import java.util.*;

public class PuzzleJava {
    Random randMachine = new Random();
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> randomTenRolls = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            randomTenRolls.add(randMachine.nextInt(20) + 1);
        }
        return randomTenRolls;
    }
    public String getRandomLetter() {
        String alphabet = "ABCDEFGHIJKMNOPQRSTUVWXYZ";
        char randomLetter = alphabet.charAt(randMachine.nextInt(alphabet.length()));
        String letter = String.valueOf(randomLetter);
        return letter;
    }
    public String generatePassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += getRandomLetter();
        }
        return password;
    }
    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> passwordArray = new ArrayList<String>();
        for (int i = 0; i < length; i++) {
            passwordArray.add(generatePassword());
        }
        return passwordArray;
    }
}