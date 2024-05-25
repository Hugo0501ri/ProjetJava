#include <stdio.h>

double sommeDeDeuxNombres(double x, double y) {
    return x + y;
}

int main() {
    double a, b, result;
    
    printf("Entrez le premier nombre: ");
    scanf("%lf", &a);
    
    printf("Entrez le deuxième nombre: ");
    scanf("%lf", &b);

    result = sommeDeDeuxNombres(a, b);

    printf("La somme de %lf et %lf est %lf\n", a, b, result);
    
    return 0;
}
