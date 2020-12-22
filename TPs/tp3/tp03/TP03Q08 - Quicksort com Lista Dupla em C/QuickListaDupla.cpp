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


////////////////////////////////////////JOGADOR

#define ARRAYLENG(x)   (sizeof(x) / sizeof((x)[0]))

#define MAXTAM 6

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
void makeLog(double execucao)
{
    FILE *arquivo = fopen("698774_quicksort2.txt", "wt");
    fprintf(arquivo, "698774\t%d\t%d\t%lf", comparacoes, movimentacoes, execucao);
    fclose(arquivo);
}
         
/**
 * function para mostrar os dados jogador dado o ID dele
 *
 * @param: Jogador *P = ponteiro para a classe jogador
 * 	   int indexN = id do jogador desejado     
 */
void imprimir( Jogador *jogador)
{
    		printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n",  
			jogador->id, 
			jogador->nome, 
			jogador->altura, 
			jogador->peso, 
			jogador->anoNascimento, 
			jogador->universidade,
			jogador->cidadeNascimento, 
			jogador->estadoNascimento
		);		
}

/**
 * function para clonar os dados de um jogador para outro
 *
 * @param: Jogador *P2 = ponteiro para o jogador que recebera os dados
 *         Jogador *P1 = ponteiro para o jogador que tera os dados clonados
 */
Jogador clone(Jogador *jogador)
{
	Jogador resp;
	resp.id = jogador -> id;

	strcpy(resp.nome, jogador->nome);
	resp.altura = jogador->peso;
	resp.anoNascimento = jogador->anoNascimento;
	strcpy(resp.universidade, jogador->universidade);
	imprimir(jogador);
    	strcpy(resp.cidadeNascimento, jogador->cidadeNascimento);
    	strcpy(resp.estadoNascimento, jogador->estadoNascimento);
	return resp;
}

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

////////////////////////////////////////FILACIRCULARSEQ

typedef struct Celula
{
	Jogador elemento;
	struct Celula* ant;
	struct Celula* prox;
}Celula;
Celula* primeiro;
Celula* ultimo;


Celula *novaCelula(Jogador elemento)
{
	Celula* nova = (Celula*) malloc(sizeof(Celula));
   	nova->prox = NULL;
	nova->ant  = NULL;
   	nova->elemento = elemento;
   	return nova;
}

void start()
{
	Jogador tmp;
	primeiro = novaCelula(tmp);
	ultimo = primeiro;
}

void inserirFim(Jogador player) 
{
   	ultimo->prox = novaCelula(player);
	ultimo->prox->ant = ultimo;
	ultimo = ultimo->prox;
}


Celula* getCelula(int x)
{
	Celula* tmp = primeiro->prox;
	for(int i=0; i<x; tmp = tmp->prox, i++);
	return tmp;
}

void swap(int i, int j)
{
	Celula *pri = primeiro->prox;
	Celula *seg = primeiro->prox;
	Jogador tmp;

	for(int o = 0; o < i; pri = pri->prox, o++);

	for(int o = 0; o < j; seg = seg->prox, o++);

	tmp = pri->elemento;
	pri->elemento = seg->elemento;
	seg->elemento = tmp;
	pri = seg = NULL;
}

void mostrar()
{
	for(Celula *i = primeiro->prox; i !=NULL; i = i->prox)
	{
		imprimir(&i->elemento);
	}
}



void quickSort(int esq, int dir)
{
	int i = esq, j = dir;
	Jogador pivo = getCelula((dir + esq) / 2)->elemento;

	while (i <= j)
	{
		while (strcmp(getCelula(i)->elemento.estadoNascimento, pivo.estadoNascimento) < 0
				|| strcmp(getCelula(i)->elemento.estadoNascimento, pivo.estadoNascimento) == 0
				&& strcmp(getCelula(i)->elemento.nome, pivo.nome) < 0)
		{
			comparacoes += 3;
			i++;
		}
		while(strcmp(getCelula(j)->elemento.estadoNascimento, pivo.estadoNascimento) > 0       
				|| strcmp(getCelula(j)->elemento.estadoNascimento, pivo.estadoNascimento) == 0   
				&& strcmp(getCelula(j)->elemento.nome, pivo.nome) > 0)
		{
			comparacoes += 3;
			j--;
		}
		if (i <= j)
		{
			swap(i, j);
			movimentacoes += 3;
			i++;
			j--;
		}
	}
	if (esq < j)
		quickSort(esq, j);
	if (i < dir)
		quickSort(i, dir);	
}





////////////////////////////////////////FUNCAO MAIN
int main(void)
{   //DEFININDO VARIAVEIS E ALOCANDO MEMORIA

	int n = 0, ent1 = 0 ;
	char *lido = (char*) calloc(8, sizeof(char));

	int lineN_2 = getLinhaArq();	
	double tm1 = 0;
	Jogador r;
	Jogador *tudo  = (Jogador*) calloc(lineN_2, sizeof(Jogador));  
	ler(tudo, lineN_2);
	start();
	scanf("%s", lido);
	while(strcmp(lido, "FIM") != 0)	
	{
		inserirFim(tudo[atoi(lido)]);
		n++;
	        scanf("%s", lido);
	}
	tm1 = clock();
	quickSort( 0, (n-1) );
	tm1 = clock()-tm1;
	makeLog(tm1);
	mostrar();
}
