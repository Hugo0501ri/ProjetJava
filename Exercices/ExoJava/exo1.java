public class exo1 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int result = sommeDeDeuxNombres(x, y);
        System.out.println("La somme de " + x + " et " + y + " est " + result);
    }

    public static int sommeDeDeuxNombres(int x, int y) {
        return x + y;
    }
}
