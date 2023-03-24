package lesson1703;

import com.sun.jdi.Value;
import org.example.Main;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
//    Пусть дан список сотрудников:

//    Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.

    public static void main(String[] args) {
        List<String> workers = List.of("Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова",
                "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова", "Анна Владимирова",
                "Иван Мечников", "Петр Петин", "Иван Ежов");

        Map<String, Integer> nameMap = directoryNameWorker(workers);
        sortedDirectoryNameWorker(nameMap);

    }

    private static void sortedDirectoryNameWorker(Map<String, Integer> nameMap) {
        LinkedList<String> collect = new LinkedList<>(nameMap.entrySet().stream().
                sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                map(entry -> entry.getKey()).collect(Collectors.toList()));
        for (int i = 0; i < collect.size(); i++) {
            String currentName = collect.get(i);
            System.out.printf("%s - %d\n", currentName, nameMap.get(currentName));
        }
    }

    private static Map directoryNameWorker(List<String> workers) {
        List<String> namesWorkers = new ArrayList<>();
        for (String worker : workers) {
            int ind = worker.indexOf(" ");
            String nameWorker = worker.substring(0, ind);
            namesWorkers.add(nameWorker);
        }
        Collections.sort(namesWorkers);

        Map<String, Integer> nameMap = new TreeMap<>();

        int count = 1;
        String nameWorker = namesWorkers.get(0);
        for (int i = 1; i < namesWorkers.size(); i++) {
            String currentName = namesWorkers.get(i);
            if (currentName.equals(nameWorker)) {
                count++;
            } else {
                nameMap.put(nameWorker, count);
                nameWorker = currentName;
                count = 1;
            }
        }
        nameMap.put(nameWorker, count);
        return nameMap;
    }

}
