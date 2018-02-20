import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        result("Andrey Natalia Serhiy Sarhiy Vova Sasha Artem Igor Sorhiy Masha Noy Arsen Neman");
    }

    public static void result(String s){

        Map<Character, List<String>>  groupedMap = Arrays.asList(s.split(" "))
                .stream()
                .collect(Collectors.groupingBy(p -> p.charAt(0)));

        groupedMap.forEach((k, v) -> v.sort((o1, o2) -> {
            if (o1.length() > o2.length())return -1;
            if (o1.length() < o2.length())return 1;
            else return o1.compareTo(o2);
        }));

        groupedMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(k -> k.getKey()))
                .filter(v -> v.getValue().size() > 1)
                .forEach(System.out::println);
    }
}
