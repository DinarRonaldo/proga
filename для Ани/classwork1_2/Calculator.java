package proga.classwork1_2;

public class Calculator<T extends Number> {
    public double add(T a, T b) {
        return a.doubleValue()+b.doubleValue();
    }
    public double subtract(T a, T b) {
        return a.doubleValue()-b.doubleValue();
    }
    public double multiply(T a, T b) {
        return a.doubleValue()*b.doubleValue();
    }
    public double divide(T a, T b) {
        if (b.doubleValue() == 0) {
            System.out.println("Деление на ноль - нельзя))))))))))))))))))))");
            return 0;
        }
        return a.doubleValue()/b.doubleValue();
    }

    public static void main(String[] args) {
        Calculator<Integer> intC = new Calculator<>();
        System.out.println("2+5=" + intC.add(10, 5));
        System.out.println("7/0=" + intC.divide(10, 0));
        Calculator<Double> doubleC = new Calculator<>();
        System.out.println("7.5+3.7=" + doubleC.add(2.5, 3.5));
        System.out.println("7.2/2.5=" + doubleC.divide(7.0, 2.0));
    }
}
