package HashMap;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        //создание хеш-мапы
        Map<String, Integer> costPerAdress = new HashMap<>();
        Address ad1 = new Address("Россия", "Казань");
        costPerAdress.put(ad1.getCountry() + ad1.getCity(), 100);
        ad1 = new Address("Россия", "Москва");
        costPerAdress.put(ad1.getCountry() + ad1.getCity(), 150);
        ad1 = new Address("Украина", "Киев");
        costPerAdress.put(ad1.getCountry() + ad1.getCity(), 240);
        ad1 = new Address("Беларусь", "Минск");
        costPerAdress.put(ad1.getCountry() + ad1.getCity(), 300);
        Scanner scanner = new Scanner(System.in);
        System.out.println(costPerAdress);
        Set<String> set = new HashSet<>();
        int summary = 0;
        //расчет суммы доставки
        while (true) {
            System.out.println("Заполнение нового заказа:");
            System.out.print("Введите страну:");
            String country = scanner.next();
            if (country.equalsIgnoreCase("end")) break;
            System.out.print("Введите город: ");
            String city = scanner.next();
            if (city.equalsIgnoreCase("end")) break;
            System.out.print("Введите вес (кг): ");
            int m = scanner.nextInt();
            if (!costPerAdress.containsKey(country + city)) {
                System.out.println("Такой адрес не обслуживается");
            } else {
                summary += costPerAdress.get(country + city) * m;
                System.out.println("Стоимость доставки составит: " + costPerAdress.get(country + city));
                System.out.println("Общая стоимость доставки составит: " + summary);
                set.add(country);
                System.out.println("Общее число уникальных стран, в которые доставлены посылки: " + set.size());
            }
            System.out.println();


        }

    }
}