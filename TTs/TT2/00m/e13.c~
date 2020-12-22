#include <stdio.h>     // para entradas e saida
#include <stddef.h>    // para definicoes basicas
#include <stdlib.h>    // para a biblioteca padrao
#include <string.h>    // para cadeias de caracteres
#include <stdarg.h>    // para tratar argumentos
#include <stdbool.h>   // para definicoes logicas
#include <ctype.h>     // para tipos padroes
#include <math.h>      // para definicoes matematicas
#include <time.h>      // para medir tempo

int main()
{

     FILE *p = fopen("t.txt", "wb");
	int i = 0;
     int f = 0;
     int j = 0;
	scanf("%d", &i);


     for(int s=0; i > s; s++){
          scanf("%d", &f);
          fwrite(&f, sizeof(int), 1, p);
                    
     }

     fclose(p);

     p = fopen("t.txt", "rb");
     
     

     for(int s=0; s < (i/2)  ; s++ ){
          fseek(p, s*sizeof(int), SEEK_SET);          
          fread(&f, sizeof(int), 1, p);
          
          fseek(p, -(s+1)*sizeof(int), SEEK_END);          
          fread(&j, sizeof(int), 1, p);
  //        printf("\n\nS==%d\n\n", (s));
//          printf("\n\nS==%d\n\n", (f));
          
          printf("\n\n%d\n\n", (f+j));
     }
     fclose(p);
     return 0;
}
