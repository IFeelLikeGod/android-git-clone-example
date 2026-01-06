import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 3;


        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Введите название машины №" + (i + 1) + ":");
            String name = scanner.nextLine();

            double velocity;
            while (true) {
                System.out.println("— Введите скорость машины №" + (i + 1) + ":");
                velocity = scanner.nextDouble();
                scanner.nextLine();

                if (velocity >= 0 && velocity <= 250) break;
                System.out.println("Неправильная скорость");
            }

            cars[i] = new Car(name, velocity);
        }

        Car winner = Race.winner(cars);

        if (winner == null) {
            System.out.println("Нет машин с допустимой скоростью. Допустимая скорость от 0 до 250");
        } else {
            System.out.println("Самый быстрый автомобиль: " + winner.name);

        }

        scanner.close();
    }
}

class Car {
    String name;
    double velocity;

    Car(String name, double velocity) {
        this.name = name;
        this.velocity = velocity;
    }
}

class Race {
    static Car winner(Car[] cars) {
        Car winner = null;

        for (Car c : cars) {
            if (c.velocity >= 0 && c.velocity <= 250) {
                if (winner == null || c.velocity * 24 > winner.velocity * 24) {
                    winner = c;
                }
            }
        }
        return winner;
    }
}