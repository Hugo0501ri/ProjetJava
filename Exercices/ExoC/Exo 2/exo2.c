#include <stdio.h>

unsigned long long factorielle(int n) {
    if (n == 0) {
        return 1;
    } else {
        return n * factorielle(n - 1);
    }
}
int main() {
    int n;
    unsigned long long result;
    
    printf("Entrez un nombre entier: ");
    scanf("%d", &n);

    if (n < 0) {
        printf("La factorielle n'est pas définie pour les nombres négatifs.\n");
    } else {

        result = factorielle(n);

        printf("La factorielle de %d est %llu\n", n, result);
    }

    return 0;
}
