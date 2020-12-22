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

     FILE *p ;
     int s = 0;
     int f = 0;
     scanf("%d", &s);
     if ((p = fopen("teste.txt", "wr")) == NULL) 
     {
          printf ("Arquivo nao pode ser aberto!!!");
     }
     else
     {
          for (int i = 0; i < s; i++)
          {
               scanf("%d", &f);
               
               fprintf(p, "\n%d", f);
          }
          fclose(p);
          p = fopen("teste.txt", "rt");
          
          while( s>0 )
          {
               fscanf(p, "%d", &f);
               printf("\n%d", f);
               s--;
          }

     }

}
