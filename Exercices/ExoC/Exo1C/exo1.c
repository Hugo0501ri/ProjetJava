#include <stdio.h>

int sommeDeDeuxNombres(int x, int y) {
    return x + y;
}

int main() {
    printf("%d %d %d", sommeDeDeuxNombres(2, 2), sommeDeDeuxNombres(7, 3), sommeDeDeuxNombres(1, 6));
    return 0;
}

