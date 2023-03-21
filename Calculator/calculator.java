import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String operator;
			double num1, num2;
			Calculator calculator = new Calculator();

			while (true) {
				System.out.println("Enter an operator (+, -, *, /) or 'q' to quit:");
				operator = scanner.nextLine();

				if (operator.equals("q")) {
					break;
				}

				try {

					if (operator.equals("-") || operator.equals("+") || operator.equals("/") || operator.equals("*")) {
						System.out.println("Enter the first number:");
						num1 = Double.parseDouble(scanner.nextLine());

						System.out.println("Enter the second number:");
						num2 = Double.parseDouble(scanner.nextLine());

						double result = calculator.calculate(operator, num1, num2);
						System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
					}

				} catch (NumberFormatException e) {
					System.out.println("Invalid number format");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public double calculate(String operator, double num1, double num2) throws Exception {
		switch (operator) {
			case "+":
				return new Addition().operate(num1, num2);
			case "-":
				return new Subtraction().operate(num1, num2);
			case "*":
				return new Multiplication().operate(num1, num2);
			case "/":
				return new Division().operate(num1, num2);
			default:
				throw new Exception("Invalid operator");
		}
	}
}

interface Operation {
	double operate(double num1, double num2) throws Exception;
}

class Addition implements Operation {
	public double operate(double num1, double num2) throws Exception {
		return num1 + num2;
	}
}

class Subtraction implements Operation {
	public double operate(double num1, double num2) throws Exception {
		return num1 - num2;
	}
}

class Multiplication implements Operation {
	public double operate(double num1, double num2) throws Exception {
		return num1 * num2;
	}
}

class Division implements Operation {
	public double operate(double num1, double num2) throws Exception {
		if (num2 == 0) {
			throw new Exception("Can not divide by zero");
		}
		return num1 / num2;
	}
}