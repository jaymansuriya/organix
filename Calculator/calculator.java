package Calculator;

import java.util.Scanner;

class InvalidInput extends Exception {
    @Override
    public String toString() {
        return "Invalid Input!";
    }

    @Override
    public String getMessage() {
        return "Invalid Input!";
    }
}

class DivideByZero extends Exception {
    @Override
    public String toString() {
        return "Can not divide by 0";
    }

    @Override
    public String getMessage() {
        return "Can not divide by 0";
    }
}

class Calculator {
    static double num1;
    static double num2;

    private static double addition(double num1, double num2) {
        return num1 + num2;
    }

    private static double subtraction(double num1, double num2) {
        return num1 - num2;
    }

    private static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    private static double division(double num1, double num2) {
        double ans = 0;
        try {
            if (num2 == 0.0) {
                throw new DivideByZero();
            }
            ans = num1 / num2;

        } catch (DivideByZero e) {
            System.out.println(e.getMessage());
            ;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }

    private static double getNum1() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number 1:");
            num1 = sc.nextDouble();

        } catch (Exception e) {
            System.out.println("Please enter a number");
            getNum1();
        }
        return num1;
    }

    private static double getNum2() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number 2:");
            num2 = sc.nextDouble();
        } catch (Exception e) {
            System.out.println("Please enter a number");
            getNum2();
        }

        return num2;
    }

    private static void calculate(int choice) throws InvalidInput {
        double ans = 0;

        switch (choice) {

            case 1:
                ans = addition(getNum1(), getNum2());
                System.out.println("Answer : " + ans);
                break;
            case 2:
                ans = subtraction(getNum1(), getNum2());
                System.out.println("Answer : " + ans);
                break;
            case 3:
                ans = multiply(getNum1(), getNum2());
                System.out.println("Answer : " + ans);
                break;
            case 4:
                ans = division(getNum1(), getNum2());
                System.out.println("Answer : " + ans);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                throw new InvalidInput();
        }
    }

    private static void choice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 for Addition");
        System.out.println("Press 2 for Subtraction");
        System.out.println("Press 3 for Multiply");
        System.out.println("Press 4 for Division");
        System.out.println("Press 5 for Exit");
        System.out.println("Please enter your choice");

        try {
            int choice = sc.nextInt();
            calculate(choice);
        } catch (Exception e) {
            System.out.println("Please enter a number");
            choice();
        }
    }

    public static void main(String[] args) throws InvalidInput {

        while (true) {
            choice();
        }
    }

}
