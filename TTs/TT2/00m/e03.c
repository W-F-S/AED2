
#include <stdio.h>     // para entradas e saida
#include <stddef.h>    // para definicoes basicas
#include <stdlib.h>    // para a biblioteca padrao
#include <string.h>    // para cadeias de caracteres
#include <stdarg.h>    // para tratar argumentos
#include <stdbool.h>   // para definicoes logicas
#include <ctype.h>     // para tipos padroes
#include <math.h>      // para definicoes matematicas
#include <time.h>      // para medir tempo

int main(){
	
     int *x1;
     int x2;
     int *x3;
     x1 = (int*) malloc(sizeof(int));
     *x1 = 20;
     x2 = *x1;
     *x3 = x2 * *x1;
     x3 = &x2;
     x2 = 15;
     x2 = 13 & 3;
     x2 = 13 | 3;
     x2 = 13 >> 1;
     x2 = 13 << 1;
} 

