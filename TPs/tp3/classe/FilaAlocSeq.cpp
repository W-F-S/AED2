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
Jogador clone(Jogador *jogador){
	Jogador resp;
	resp.id = jogador -> id;
	strcpy(resp.nome, jogador->nome);
	resp.altura = jogador->peso;
	resp.anoNascimento = jogador->anoNascimento;
	strcpy(resp.universidade, jogador->universidade);
    	strcpy(resp.cidadeNascimento, jogador->cidadeNascimento);
    	strcpy(resp.estadoNascimento, jogador->estadoNascimento);
	return resp;
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


////////////////////////////////////////FILACIRCULARSEQ
Jogador jogador[MAXTAM];
int primeiro;
int ultimo;


void start()
{
	primeiro = ultimo = 0;
}

Jogador remover()
{
	Jogador resp = jogador[primeiro];
	primeiro = (primeiro+1) % MAXTAM;
	return resp;
}


/*
 * Insere um elemento na fila posicao da lista e move os demais
 * elementos para o fim da mesma
 * @param jogador Jogador elemento a ser inserido
 */
void inserir(Jogador ent) 
{
	if( (ultimo +1) % MAXTAM == primeiro )
	{
		remover();
	}
	jogador[ultimo] = ent; 
	ultimo = (ultimo+1) % MAXTAM;
}

double media()
{
	int resp=0, cont=0; 

	for(int i=primeiro; i != ultimo; i = (i+1)%MAXTAM)
	{
		resp+= jogador[i].altura;
		cont++;
	}
	return (double) resp/(double)cont;
}

void mostrar()
{
	int i = primeiro;
	int j = 0;
	while(i!=ultimo)
	{
		    printf("[%d] ## %s ## %d ## %d ## %d ## %s ## %s ## %s ##\n",
		    j++,
	      	      jogador[i].nome
                    , jogador[i].altura
                    , jogador[i].peso
                    , jogador[i].anoNascimento
                    , jogador[i].universidade
                    , jogador[i].cidadeNascimento
                    , jogador[i].estadoNascimento);
		i = ((i+1) % MAXTAM);
	} 
}

////////////////////////////////////////FUNCAO MAIN
int main(void)
{   //DEFININDO VARIAVEIS E ALOCANDO MEMORIA
	int n = 0, ent1 = 0 ;
	char *lido = (char*) calloc(4, sizeof(char));
	int lineN_2 = getLinhaArq();	
	
	Jogador r;
	Jogador *tudo  = (Jogador*) calloc(lineN_2, sizeof(Jogador));  ;
	ler(tudo, lineN_2);
	start();
	scanf("%s", lido);
	while(strcmp(lido, "FIM") != 0)	
	{
		inserir(tudo[atoi(lido)]);
	        scanf("%s", lido);
	        printf("%d\n", (int)round(media()));
	}

	scanf("%d", &n);
	while(n > 0)
	{
		scanf("%s", lido);//man scanf()
		if( strcmp(lido, "I")==0 )
		{
		        scanf("%d", &ent1);
		  	inserir(tudo[ent1]);    
			printf("%d\n", (int)round(media()));

		} else if( strcmp(lido, "R")==0 )
		{
	                r = remover();
		 	printf("(R) %s\n", r.nome);
		} 
		n--;
	}
	mostrar();
}
