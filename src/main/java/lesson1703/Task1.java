package lesson1703;

import org.example.Main;

import java.util.*;

public class Task1 {
//    Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

    public static void main(String[] args) {
        Map<String, List<String>> phoneDirectory = new HashMap<>();
        inputNewEntry(phoneDirectory);
        printPhoneDirectory(phoneDirectory);

    }

    private static void printPhoneDirectory(Map<String, List<String>> phoneDirectory) {
        for (Map.Entry<String, List<String>> listEntry : phoneDirectory.entrySet()) {
            System.out.printf("%s - %s\n", listEntry.getKey(), listEntry.getValue());
        }

    }

    private static Map inputNewEntry(Map<String, List<String>> phoneDirectory) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Если хотите сделать запись в телефонную книгу, напишите 'еще'.\n " +
                    "Если хотите выйти, напишите 'выход'. ");
            String text = scanner.nextLine();

            try {
                if (text.equalsIgnoreCase("еще")) {
                    System.out.print("Введите фамилию: ");
                    String entryKey = scanner.nextLine();
                    System.out.print("Введите номер телефона, если несколько номеров, то через ', ' : ");
                    List<String> entryValue = Arrays.stream(scanner.nextLine().split(",")).toList();
                    phoneDirectory.put(entryKey, entryValue);
                } else if (text.equalsIgnoreCase("выход")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Если хотите сделать запись в телефонную книгу, напишите 'еще'.\n " +
                        "Если хотите выйти, напишите 'выход'. ");
            }
        }
        scanner.close();
        return phoneDirectory;
    }

}
