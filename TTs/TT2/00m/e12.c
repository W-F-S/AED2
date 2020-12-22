//Faça um programa que leia n números inteiros e os mostre em ordem inversa sem usar arrays

#include <stdio.h>     // para entradas e saida
#include <stddef.h>    // para definicoes basicas
#include <stdlib.h>    // para a biblioteca padrao
#include <string.h>    // para cadeias de caracteres
#include <stdarg.h>    // para tratar argumentos
#include <stdbool.h>   // para definicoes logicas
#include <ctype.h>     // para tipos padroes
#include <math.h>      // para definicoes matematicas
#include <time.h>      // para medir tempo

void certo(int n){
     int x;

     if(n > 0){

          scanf("%i" , &x );
          print(n - 1);
          printf("%i\n" , x);
     }
}




int main (void){

     int x;
     scanf("%i" , &x);
     certo(x);
}

