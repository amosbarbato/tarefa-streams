import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        do {
            System.out.println("Digite o nome e o sexo da pessoa separados por virgula , " +
                    "ou digite qualquer coisa para sair");

            var stringSplit = scan.next();
            String[] strings = stringSplit.split(",");
            var name = strings.length > 0 ? strings[0] : null;
            var sex = strings.length > 1 ? strings[1] : null;

            var person = new Person(name, sex);
            people.add(person);
            System.out.println(people);

            System.out.println("Gostaria de adicionar mais alguem na lista?");
        } while (scan.next().equalsIgnoreCase("Sim"));
        System.out.println("gostaria de filtrar sua lista por sexo?");
        if (scan.next().equalsIgnoreCase("sim")) {
            System.out.println("digte M para sexo masculino ou F para sexo feminino");
            String awsner = scan.next();
            if (awsner.equalsIgnoreCase("m")) {
                people.stream()
                        .filter(it -> it.sex().equalsIgnoreCase("Masculino"))
                        .toList()
                        .forEach(System.out::println);
                if (awsner.equalsIgnoreCase("f")) {
                    people.stream()
                            .filter(it -> it.sex().equalsIgnoreCase("Feminino"))
                            .toList()
                            .forEach(System.out::println);
                }
                scan.close();
            }
        }
    }
}