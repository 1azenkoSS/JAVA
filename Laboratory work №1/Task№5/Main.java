import org.example.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Task 1

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("Enter the first number:");
        double num1 = scanner.nextDouble();

        System.out.println("Enter the operation (+, -, *, /):");
        String operator = scanner.next();

        System.out.println("Enter the second number:");
        double num2 = scanner.nextDouble();

        try {
            double result = calculator.calculate(operator, num1, num2);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //Task 2

        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter a string with words separated by spaces: ");
        String input = inputScanner.nextLine();

        String[] words = input.split(" ");

        StringSorter.sortByUppercaseLetterCount(words);

        System.out.print("Sorted words: ");
        for (String word : words) {
            System.out.print(word + " ");
        }

        System.out.println();
        scanner.nextLine();

        //Task 3

        Scanner userInput = new Scanner(System.in);
        scanner.nextLine();

        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();

        boolean isValid = EmailValidating.validateEmail(email);

        if (isValid) {
            System.out.println("The email address is valid.");
        } else {
            System.out.println("The email address is not valid.");
        }

        //Task 4

        Scanner userData = new Scanner(System.in);

        System.out.print("Enter the number of rows in the first matrix: ");
        int rows1 = scanner.nextInt();
        System.out.print("Enter the number of columns in the first matrix: ");
        int cols1 = scanner.nextInt();

        System.out.print("Enter the number of columns in the second matrix: ");
        int cols2 = scanner.nextInt();

        int[][] matrix1 = new int[rows1][cols1];
        int[][] matrix2 = new int[cols1][cols2];

        System.out.println("Enter the elements of the first matrix:");

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the elements of the second matrix:");

        for (int i = 0; i < cols1; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        int[][] result = MatrixMultiplication.multiply(matrix1, matrix2);

        System.out.println("Result of matrix multiplication:");

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();

        //Task 5

        Delivery delivery = new Delivery();

        Customer customer = new Customer("Taras", "0689691591");
        Item item = new Item("Toy", 2, 9);
        ReceivePoint receivePoint = new ReceivePoint("Transkarpathian", "Khustskiy", "Mizhirya", "Shevchenka", 33);

        Customer customer1 = new Customer("Yurii", "0689691591");
        Item item1 = new Item("Joy Boy", 5, 100);
        ReceivePoint receivePoint1 = new ReceivePoint("Lvivska", "Lviv", "Zolochevo", "Franka", 56);

        System.out.println("Departure points:");
        delivery.printDeparturePoint();

        delivery.createDelivery(3, customer, item, receivePoint, ShipmentMethod.BUS);


        delivery.createDelivery(1, customer1, item1, receivePoint1, ShipmentMethod.TRACK);
        System.out.println("Shipments:");
        delivery.printShipments();

        System.out.println(" ");

        delivery.deleteDelivery(2);
        delivery.printShipments();
    }
}