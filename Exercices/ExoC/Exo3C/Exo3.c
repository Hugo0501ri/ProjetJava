#include <stdio.h>

int is_even(int number) {
    return number % 2 == 0;
}

int main() {
    int number;


    printf("Entrez un nombre pour vérifier s'il est pair : ");
    scanf("%d", &number);

    if (is_even(number)) {
        printf("%d est un nombre pair.\n", number);
    } else {
        printf("%d est un nombre impair.\n", number);
    }

    return 0;
}
