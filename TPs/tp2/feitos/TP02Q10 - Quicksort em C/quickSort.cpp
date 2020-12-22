/**
 * Jogador.c     
 * 
 * Walker Freitas dos Santos 
 *
 * Programa para cadastrar jogadores usando um arquivo .csv
 *   
 * 0.3.0    24/09/2020
 */

#include <stdio.h>     // para entradas e saida
#include <stddef.h>    // para definicoes basicas
#include <stdlib.h>    // para a biblioteca padrao
#include <string.h>    // para cadeias de caracteres
#include <stdarg.h>    // para tratar argumentos
#include <stdbool.h>   // para definicoes logicas
#include <ctype.h>     // para tipos padroes
#include <math.h>      // para definicoes matematicas
#include <time.h>      // para medir tempo


typedef struct
{
	int  id;
	char *nome;
	int  altura;
	int  peso;
	int  anoNascimento;
	char *universidade;
	char *cidadeNascimento;
	char *estadoNascimento;
} Jogador;

int comparacoes   = 0;
int movimentacoes = 0;

/**
 * -----------------------------------------------------------------------------------------------------FUNCOES AUXILIARES--------------
 */


/**
 * Funcao para trocar o Jogador1 pelo Jogador2
 *
 * @param : Jogador *array -- jogador 1
 *          Jogador *array -- jogador 2 
 */
void swap(Jogador *array, Jogador *array2)
{
	Jogador temp = *array;
	*array       = *array2;    
	*array2      = temp;  
}


/**
 * fuction para pegar a quantidade de linhas dentro de um arquivo
 *
 * @return: int lineN = numero de linhas
 */
int getLinhaArq()
{
	char *linha = (char*) calloc(111, sizeof(char));
	int lineN=0;
	FILE *arquivo = fopen("/tmp/players.csv", "r");
	
	fgets(linha, 111, arquivo);
	while (fgets(linha, 111, arquivo)) 
	{
		lineN++;
	}    
	fclose(arquivo);
    free(linha);
	return lineN;

}

/**
 * Funcao para dar free na classe jogador2
 *
 * @param : Jogador *array -- jogador 1
 *          Jogador *array -- jogador 2 
 */
void makeLog(long execucao)
{
    FILE *arquivo = fopen("698774_quicksort.txt", "w");
    fprintf(arquivo, "698774\t%d\t%d\t%ld", comparacoes, movimentacoes, execucao);
    fclose(arquivo);
}






/**
 * -----------------------------------------------------------------------------------------------------FUNCOES AUXILIARES-------------
 */


         
/**
 * function para mostrar os dados jogador dado o ID dele
 *
 * @param: Jogador *P = ponteiro para a classe jogador
 * 	   int indexN = id do jogador desejado     
 */
void mostrar( Jogador P)
{
    		printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n",  
			(P).id, 
			(P).nome, 
			(P).altura, 
			(P).peso, 
			(P).anoNascimento, 
			(P).universidade,
			(P).cidadeNascimento, 
			(P).estadoNascimento);		
}

/**
 * function para clonar os dados de um jogador para outro
 *
 * @param: Jogador *P2 = ponteiro para o jogador que recebera os dados
 *         Jogador *P1 = ponteiro para o jogador que tera os dados clonados
 */
void clone(Jogador *P2, Jogador *P1){

	(P2)->id               = (P1)->id;
	(P2)->nome             = strdup((P1)->nome);
	(P2)->altura           = (P1)->altura;
	(P2)->peso             = (P1)->peso;
    (P2)->anoNascimento    = (P1)->anoNascimento;
	(P2)->universidade     = (P1)->universidade;
    (P2)->cidadeNascimento = strdup((P1)->cidadeNascimento);
	(P2)->estadoNascimento = strdup((P1)->estadoNascimento);
}

/**
 * fuction para carregar os jogadores com os dados de um arquivo .csv
 * 
 * @param: Jogador *P  = ponteiro para o array de jogadores
 *         int lineN_2 = quantidade de jogadores cadastrasdos
 */
void ler(Jogador *P, int lineN_2)
{
	char *teste = (char*) calloc(111, sizeof(char));
	char *linha = (char*) calloc(111, sizeof(char));
	char *p1;
	int  indexN  = 0;

	FILE *arquivo = fopen("/tmp/players.csv", "r");

	fgets(linha, 111, arquivo);
	
	while(indexN < lineN_2) 
	{
		fgets(linha, 111, arquivo);
		linha[strlen(linha)-1] = ',';

		p1 = strdup(linha);
		(P[indexN]).id = atoi(strsep(&p1, ","));	
		(P[indexN]).nome = strsep(&p1, ","); 

		if( strlen(P[indexN].nome)<=3 )
		{
			(P[indexN]).nome = strdup("nao informado");
		}

		(P[indexN]).altura = atoi(strsep(&p1, ","));
		(P[indexN]).peso = atoi(strsep(&p1, ","));
		(P[indexN]).universidade = strsep(&p1, ",");
		if( strlen(P[indexN].universidade)<=3 )
		{
			(P[indexN]).universidade = strdup("nao informado");
		}
		(P[indexN]).anoNascimento = atoi(strsep(&p1, ","));
		(P[indexN]).cidadeNascimento = strsep(&p1, ",");
		if( strlen(P[indexN].cidadeNascimento)<=3 )
		{
			(P[indexN]).cidadeNascimento = strdup("nao informado");
		}
		(P[indexN]).estadoNascimento = strsep(&p1, ",");
		if( strlen(P[indexN].estadoNascimento)<=3 )
		{
			(P[indexN]).estadoNascimento = strdup("nao informado");
		}
		indexN++;
	}
	fclose(arquivo);
}







/**
 *------------------------------------------------------------------------------------------------------ALGORITMOS DE ORDENAÇÃO--------- 
*/ 
/**
 * Funcao para ordenar um arranjo de jogadores dado o numero de jogadores e um ponteiro para tal
 *
 * @param : Jogador *P     -- ponteiro para o arranjo de jogadores
 *          int n          -- numero de jogadores cadastrados
 */
void ordenarBolha(Jogador *P, int n)
{
	int i, j;
	for(i = (n-1); i>0; i--) 
	{
    //    comparacoes = comparacoes + 1;        
		for(j = 0; j<i; j++)
		{
      //      comparacoes = comparacoes + 1;	    
        	if(P[j].anoNascimento > (P[j+1]).anoNascimento) {
				swap(&P[j], &P[j+1]);
        //        movimentacoes = movimentacoes + 3;
        //        comparacoes = comparacoes + 1;
			}    
			else
			{
				if( (P[j].anoNascimento == (P[j+1]).anoNascimento) && (strcmp((P[j].nome), (P[j+1]).nome) > 0) )
				{
					swap(&P[j], &P[j+1]);	      
          //                              movimentacoes = movimentacoes + 3;       
          //                              comparacoes = comparacoes + 2;
				}
			}
		}
	}    
}



//||  (P[j].estadoNascimento == pivo.estadoNascimento) && (strcmp(P[i].nome, pivo.nome) < 0 )
void quicksort(Jogador *P, int esq, int dir) {
    int i = esq, j = dir; Jogador pivo = P[(esq+dir)/2];
     comparacoes = comparacoes + 1;
    while (i <= j ) 
    {
	 comparacoes = comparacoes + 3;    
        while ((strcmp(P[i].estadoNascimento, pivo.estadoNascimento) < 0) || 
              ( strcmp(P[i].estadoNascimento, pivo.estadoNascimento) ==0) &&
              ( strcmp(P[i].nome, pivo.nome) < 0 ))
	{	
		i++;
	}
	 comparacoes = comparacoes + 3;
        while ((strcmp(P[j].estadoNascimento, pivo.estadoNascimento) > 0) || 
              ( strcmp(P[j].estadoNascimento, pivo.estadoNascimento)==0 ) && 
              ( strcmp(P[j].nome, pivo.nome) > 0 ))
	{
            	j--;
	}
	 comparacoes = comparacoes + 1;
        if ( i <= j )
        {
	    movimentacoes = movimentacoes + 3;
            swap(&P[i], &P[j]);
            i++;
            j--; 
	}
    }
    comparacoes = comparacoes + 1;
    if (esq < j)
        quicksort( P, esq, j );

    comparacoes = comparacoes + 1;
    if (i < dir)
        quicksort( P, i, dir );
}
// if (i < dir && i < k)
/**
 *------------------------------------------------------------------------------------------------------ALGORITMOS DE ORDENAÇÃO---------
 */ 

int main(void){
    	int tempo = clock();
    	int v;
	int lineN_2 = getLinhaArq();
	char entrada[10];
	Jogador *jogadores  = (Jogador*) calloc(lineN_2, sizeof(Jogador));
	Jogador *jogadores2 = (Jogador*) calloc(500, sizeof(Jogador));

	ler(jogadores, lineN_2);
	scanf("%s", entrada);
	for(v=0; strcmp(entrada, "FIM") != 0; v++ )
	{
		jogadores2[v] = jogadores[atoi(entrada)];
		scanf("%s", entrada);
	}

	quicksort(jogadores2, 0, v-1);
	
	for(int i=0; i < v; i++)
	{
		mostrar(jogadores2[i]);
	}

          tempo = clock() - tempo;
          makeLog(tempo);
	return 0;
}


