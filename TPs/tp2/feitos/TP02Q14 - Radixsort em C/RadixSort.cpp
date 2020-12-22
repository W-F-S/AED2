/**
 * Jogador.c     
 * 
 * Walker Freitas dos Santos 
 *
 * Programa para cadastrar jogadores usando um arquivo .csv
 *   
 * 0.3.0    4/10/2020
 *
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


#define ARRAYLENG(x)   (sizeof(x) / sizeof((x)[0]))

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
double execucao = 0;

/**
 * -----------------------------------------------------------------------------------------------------FUNCOES AUXILIARES--------------
 */


/**
 * Funcao para dar Free no struct Jogador
 *    
 * @param : Jogador *P -- ponteiro para o array de struct a ser desalocado
 */
void freeJogador(Jogador *P)
{
    int sizeP = ARRAYLENG(P);
    for(int i=0; i<sizeP; i++)
    {
        free(P[i].nome);
        free(P[i].universidade);
        free(P[i].cidadeNascimento);
        free(P[i].estadoNascimento);
    }
    free(P);
}

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
void makeLog()
{
    FILE *arquivo = fopen("698774_radixsort.txt", "w");
    fprintf(arquivo, "698774\t%d\t%d\t%lf", comparacoes, movimentacoes, execucao);
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
 * Funcao para retornar o maior elemento(id) de um arry de Jogadores
 *   
 * @param:  Jogador *player -- ponteiro de array de jogadores a ser analisado
 *
 * @return: Jogador max -- jogador com o mair id
 */
Jogador getMax(Jogador *player, int n) 
{
  Jogador max = player[0];
  for (int i = 1; i < n; i++)
  {
    comparacoes   = comparacoes + 1;
    if (player[i].id > max.id)
    {
        comparacoes   = comparacoes + 1;
        max = player[i];
    }
  }
  return max;
}

/**
 * Funcao para ordenar um array usando o counting sort
 *   
 * @param:  Jogador *player -- ponteiro de array de jogadores a ser ordenado
 * @param:  int size        -- quantidade de jogadores cadastrados em *player 
 *
 */
void countingSort(Jogador *player, int size, int place) 
{
  Jogador output[size + 1];
  int max = (player[0].id / place) % 10;

  for (int i = 1; i < size; i++) {
    comparacoes   = comparacoes + 1;
    if (((player[i].id / place) % 10) > max)
      comparacoes   = comparacoes + 1;
      max = player[i].id;
  }
  Jogador count[max + 1];

  for (int i = 0; i < max; ++i){
    comparacoes   = comparacoes + 1;
    count[i].id = 0;
  }  

  for (int i = 0; i < size; i++){
    count[(player[i].id / place) % 10].id++;
    comparacoes   = comparacoes + 1;
  }

  for (int i = 1; i < 10; i++){
    comparacoes   = comparacoes + 1;
    count[i].id += count[i - 1].id;
  }

  for (int i = size - 1; i >= 0; i--) {
    comparacoes   = comparacoes + 1;
    output[count[(player[i].id / place) % 10].id - 1] = player[i];
    count[(player[i].id / place) % 10].id--;
  }

  for (int i = 0; i < size; i++){
    comparacoes   = comparacoes + 1;
    player[i] = output[i];
  }
}

void radixsort(Jogador *player, int size) 
{
  Jogador max = getMax(player, size);
  comparacoes   = comparacoes + 1;
  for (int place = 1; max.id / place > 0; place *= 10){
    comparacoes   = comparacoes + 1;
    countingSort(player, size, place);
  }  
}

int main(void)
{   //DEFININDO VARIAVEIS E ALOCANDO MEMORIA
    execucao = clock();
    int v;
	int lineN_2 = getLinhaArq();
	char entrada[10];
	Jogador *jogadores  = (Jogador*) calloc(lineN_2, sizeof(Jogador));
	Jogador *jogadores2 = (Jogador*) calloc(500, sizeof(Jogador));

    //LENDO O ARQUIVO E CADASTRANDO OS JOGADORES
	ler(jogadores, lineN_2);
	scanf("%s", entrada);

    //LENDO ENTRADAS
	for(v=0; strcmp(entrada, "FIM") != 0; v++ )
	{ 
		jogadores2[v] = jogadores[atoi(entrada)];
		scanf("%s", entrada);
	}
	
    //ORDENANDO ENTRADAS
    radixsort(jogadores2, v);
	
    //MOSTRANDO ENTRADAS
	for(int i=0; i < v; i++)
	{
		mostrar(jogadores2[i]);
	}

    //DESALOCANDO MEMORIA E FAZENDO O ARQUIVO DE LOG
    freeJogador(jogadores);
    freeJogador(jogadores2);
    execucao = clock() - execucao;
    makeLog();
	return 0;
}

