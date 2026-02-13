package util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import model.BankAccount;

public class FileUtil {

    private static final String FILE_NAME = "accounts.dat";

    public static void saveAccounts(Map<String, BankAccount> accounts) {

        try (ObjectOutputStream oos
                = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(accounts);

        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, BankAccount> loadAccounts() {

        try (ObjectInputStream ois
                = new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (Map<String, BankAccount>) ois.readObject();

        } catch (Exception e) {
            return new HashMap<>();
        }
    }
}
