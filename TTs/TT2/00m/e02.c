
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
	
     int a[10], *b;
     b = a;
     b[5] = 100;
     printf("\n%d -- %d", a[5], b[5]);
     b = (int*) malloc(10*sizeof(int));
     b[7] = 100;
     printf("\n%d -- %d", a[7], b[7]);
}



