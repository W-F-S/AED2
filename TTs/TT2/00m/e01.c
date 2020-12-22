
#include <stdio.h>     // para entradas e saida
#include <stddef.h>    // para definicoes basicas
#include <stdlib.h>    // para a biblioteca padrao
#include <string.h>    // para cadeias de caracteres
#include <stdarg.h>    // para tratar argumentos
#include <stdbool.h>   // para definicoes logicas
#include <ctype.h>     // para tipos padroes
#include <math.h>      // para definicoes matematicas
#include <time.h>      // para medir tempo

int main(int argc, char *argv[]){
	
     double a; 
     double *p, *q; 
     a = 3.14; 
     printf("%f\n", a); 
     p = &a;
     *p = 2.718; 
     printf("%f\n", a); 
     a = 5;
     printf("%f\n", *p);
     p = NULL;
     p = (double*) malloc(sizeof(double));
     
     *p = 20;
     q = p;
     printf("%f\n", *p);
     printf("%f\n", a);
     free(p);
     printf("%f\n", *q);
}



