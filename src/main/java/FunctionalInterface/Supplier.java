package FunctionalInterface;

public class Supplier {
    public static void main(String[] args) {
        java.util.function.Supplier<String> mySupplier = () -> "hello World";

        System.out.println(mySupplier.get());

    }
}