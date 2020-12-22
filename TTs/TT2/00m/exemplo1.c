//149


#include <stdio.h>
#include <stdlib.h>
int main(int argc, char *argv[]) {
     FILE *p = fopen (“teste.txt”, “r”);
     // testa se o arquivo foi aberto com sucesso
     if (p != NULL) {
     printf (“\nArquivo foi aberto com sucesso.");
     } else {
     printf (“\nNao foi possivel abrir o arquivo.");
     }
     return 0;
}
