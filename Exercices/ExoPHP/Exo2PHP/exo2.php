<?php
// Fonction de calcul de la factorielle
function factorielle($n) {
    if ($n == 0) {
        return 1;
    } else {
        return $n * factorielle($n - 1);
    }
}
?>

