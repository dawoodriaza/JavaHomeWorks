public class Calculator {
    private static int totol_calculations = 0;
    protected static double last_result = 0.0;
    public static String calculator_name ;

    public static double add(double a, double b) {
        double sum = a + b;
        totol_calculations++;
        last_result = sum;
        return sum;
    }

    protected  static double subtract(double a, double b) {
        double result = a - b;
        totol_calculations++;
        last_result = result;
        return result;
    }

    public static double multiply(double a, double b) {
        double result = a * b;
        totol_calculations++;
        last_result = result;
        return result;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        double result = a / b;
        totol_calculations++;
        last_result = result;
        return result;
    }

    private static void resetCalculator(){
        last_result = 0.0;
    }
    public static void monthlyReset(){
        resetCalculator();
    }
    static void showTotalCalculations(){
        System.out.println("Total Calculation "+ totol_calculations);;
    }
    public static void showLastResult() {
        double last_result = 0.0;
        System.out.println("Local last_result: " + last_result);
        System.out.println("Static last_result: " + Calculator.last_result);
    }

    public static void main(String[] args) {

        double sum = add(2.5, 2.5);
        double difference = subtract(10, 4);
        double product = multiply(3, 5);
        double quotient = divide(20, 4);


        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);


        showTotalCalculations();


        showLastResult();
        monthlyReset();
        System.out.println("resting:");
        showLastResult();


    }

}