public class exo2 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int result = factorielle(n);
        System.out.println("La factorielle de " + n + " est " + result);
    }

    public static int factorielle(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorielle(n - 1);
        }
    }
}
