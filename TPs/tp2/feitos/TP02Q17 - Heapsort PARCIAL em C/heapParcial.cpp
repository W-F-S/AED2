/**
 * Jogador.c     
 * 
 * Walker Freitas dos Santos 
 *
 * Programa para cadastrar jogadores usando um arquivo .csv
 *   
 * 0.3.0    4/10/2020
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
double execucao;

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
    FILE *arquivo = fopen("698774_heapSortParcial.txt", "w");
    fprintf(arquivo, "698774\t%d\t%d\t%lf", comparacoes, movimentacoes, execucao);
    fclose(arquivo);
}
         
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
 * Funcao usada pelo hepasort para ordenar o array
 *
 * @param: Jogador *player -- array de jogadores
 * @param: int tamHeap
 */
void constroi(Jogador *player, int tamHeap)
{
    for(int i = tamHeap; (i > 1  && player[i].altura > player[i / 2].altura) 
                                 || (player[i].altura == player[i / 2].altura 
                                 && strcmp(player[i].nome, player[i / 2].nome) > 0); i /= 2)
    {
        swap(&player[i], &player[i / 2]);
    }
}

/**
 *  Funcao usada pelo hepasort para 
 *
 *  @param: Jogador *player -- array de jogadores
 *  @param: int tamHeap
 */
int getMaiorFilho(Jogador *player, int i, int tamHeap)
{
    int filho;

    if((2 * i == tamHeap  || player[2 * i].altura > player[2 * i + 1].altura)
                          || (player[2 * i].altura == player[2 * i + 1].altura
                          && strcmp(player[i * 2].nome, player[i * 2 + 1].nome) > 0))
    {
        filho = 2 * i;
    }
    else
    {
        filho = 2 * i + 1;
    }
    return filho;
}

/**
 *  Funcao usada pelo heapsort para ordenar um array
 *
 *  @param: Jogador *player -- array de jogadores
 *  @param: int tamHeap
 */
void reconstroi(Jogador *player, int tamHeap)
{
    int i = 1;
    while(i <= (tamHeap / 2))
    {
        int filho = getMaiorFilho(player, i, tamHeap);
        if((    player[i].altura < player[filho].altura) 
            || (player[i].altura == player[filho].altura 
            &&  strcmp(player[i].nome, player[filho].nome) < 0))
        {
            swap(&player[i], &player[filho]);
            i = filho;
        }
        else
        {
            i = tamHeap;
        }
    }
}


/**
 * funcao para ordenar um array parcialmente 
 *
 * @param: Jogador *player -- array de jogadores a ser ordenados
 * @param: int tam         -- quantidade de jogadores cadastrados em tam
 * @param: int k    
 */
void heapSort2(Jogador *player, int tam, int k)
{
    comparacoes = comparacoes + 1;
    for(int i = 2; i <= k; i++)
    {
        comparacoes = comparacoes + 1;
        constroi(player, i);
    }
    
    comparacoes = comparacoes + 1;
    for(int i = k + 1; i <= tam; i++)
    {   
        comparacoes = comparacoes + 1;
        if((player[i].altura < player[1].altura) 
            || (player[i].altura == player[1].altura 
            && strcmp(player[i].nome, player[1].nome) < 0))
        {
            comparacoes = comparacoes + 1;
            comparacoes = comparacoes + 3;
            swap(&player[i], &player[1]);
            reconstroi(player, k);
        }
    }

    int tamHeap = tam;

    comparacoes = comparacoes + 1;
    while(tamHeap > 1)
    {
        movimentacoes = movimentacoes + 3;
        comparacoes = comparacoes + 1;
        swap(&player[1], &player[tamHeap--]);
        reconstroi(player, tamHeap);
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

    // Ordenando mediante ao ID e calculando tempo.
    heapSort2(jogadores2, v, 12);

    //MOSTRANDO ENTRADAS
	for(int i=2; i < 12; i++)
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

