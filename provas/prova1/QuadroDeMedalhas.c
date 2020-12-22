#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stddef.h>

typedef struct{
    int ouro;
    int prata;
    int bronze;
    char *nome;
} Pais;

void swap(Pais *paises, int pri, int seg )
{
    Pais tmp = paises[pri];
    paises[pri] = paises[seg];
    paises[seg] = tmp;
}

void lerEntradas(Pais *paises, int v)
{
    char *asd = (char*) calloc(500, sizeof(char)); 
        fflush(stdin);
int ha;
    char *entrada = (char*) calloc(50, sizeof(char));
        sscanf(asd, "teste: %s", entrada);
    for(int i=0; i<(v-1); i++)
    {

        fflush(stdin);
        printf("dsa");
        sscanf(asd, "teste: %s", entrada);
//       fgets(entrada, 49, stdin);
                printf("\nentrada '%s'\n", entrada);
        entrada = strdup(entrada);

        paises[i].nome = strsep(&entrada, " ");        
    printf("\nteste1\n");
         paises[i].ouro = atoi(strsep(&entrada, " "));        
    printf("\nteste2\n");
        paises[i].prata = atoi(strsep(&entrada, " "));
    printf("\nteste\n");
        paises[i].bronze = atoi(strsep(&entrada, " "));
    printf("\nfim\n");
        //scanf("teste: %50s", entrada);
    }

}

void ordenarSelecao(Pais *paises, int i, int n)
{
    if(i < (n-1))
    {
        int menor = i;
        for(int j = (i+1); j<n; j++)
        {
            if(paises[menor].ouro > paises[j].ouro)
            {
                menor = j;
            } 
            else if(paises[menor].prata > paises[j].prata)
            {
                menor = j;
            }      
            else if(paises[menor].bronze > paises[j].bronze)
            {
                menor = j;
            }
            else if( strcmp(paises[menor].nome, paises[j].nome) > 0 )
            {
                menor = j;
            }
        }
        swap(paises, menor, i);
        ordenarSelecao(paises, (i+1), n);
    }
}


void imprimir(Pais *paises, int v)
{
    for(int i=0; i<v; i++)
    {
        printf("%s %d %d %d", paises[i].nome, paises[i].ouro, paises[i].prata, paises[i].bronze);
    }
}


int main()
{
    char *asd = (char*) calloc(500, sizeof(char));
    int *numPaises = (int*) calloc(500, sizeof(int));
  //  fgets(numPaises, 500, stdin);
    sscanf(asd, "%d", numPaises);
        fflush(stdin);
    Pais *paises = (Pais*) calloc(234234, sizeof(Pais));

    lerEntradas(paises, 234234);

    ordenarSelecao(paises, 0, 234234);
    imprimir(paises, 234234);   

    return 0;
}
