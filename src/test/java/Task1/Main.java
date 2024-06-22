package Task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
//public class PhoneNumberValidator{


public class Main {
    private static final Pattern PATTERN1 = Pattern.compile("^\\(\\d{3}\\) \\d{3}-\\d{4}$");
    private static final Pattern PATTERN2 = Pattern.compile("^\\d{3}-\\d{3}-\\d{4}$");

    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        if (file.exists()) {
            try (FileInputStream fIs = new FileInputStream(file);
                 Scanner fileScanner = new Scanner(fIs)) {
                //String line;
                while (fileScanner.hasNext()) {
                    System.out.println(fileScanner.nextLine());
                    if (isValidPhoneNumber(fileScanner.nextLine())) {
                        System.out.println(fileScanner);

                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return
                PATTERN1.matcher(phoneNumber).matches() ||
                        PATTERN2.matcher(phoneNumber).matches();
    }
}
