#include <stdio.h>     // para entradas e saida
#include <stddef.h>    // para definicoes basicas
#include <stdlib.h>    // para a biblioteca padrao
#include <string.h>    // para cadeias de caracteres
#include <stdarg.h>    // para tratar argumentos
#include <stdbool.h>   // para definicoes logicas
#include <ctype.h>     // para tipos padroes
#include <math.h>      // para definicoes matematicas
#include <time.h>      // para medir tempo
#include <err.h>

#define ARRAYLENG(x)   (sizeof(x) / sizeof((x)[0]))

#define MAXTAM 6

typedef struct
{
	int  id = -1;
	char *nome;
	int  altura = -1;
	int  peso = -1;
	int  anoNascimento = -1;
	char *universidade;
	char *cidadeNascimento;
	char *estadoNascimento;
} Jogador;


int comparacoes = 0;
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
 * Funcao para dar free na classe jogador2
 *
 * @param : Jogador *array -- jogador 1
 *          Jogador *array -- jogador 2 
 */
void makeLog(long execucao, int comparacoes)
{
	FILE *arquivo = fopen("698774_avl.txt", "w");
	fprintf(arquivo, "698774\t%ld\t%d", execucao, comparacoes);
	fclose(arquivo);
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

//------------------------------------------------------------------------------

typedef struct Hash
{
	Jogador elemento;
	struct Hash* topo;
	struct Hash* prox;
	struct Hash* ultimo;
} Hash;

int posicao = 0;
Hash *tabela = (Hash*) calloc(25, sizeof(Hash));//sizeof(Hash*);

int h(int x)
{
	return x % 25;
}

Hash* novaHash(Jogador elemento)
{ 
	Hash* nova = (Hash*) malloc(sizeof(Hash));
	nova->prox = NULL;
	nova->topo = nova;
	nova->elemento = elemento;

	return nova;
}


void inserir(Jogador x)
{
	int pos = h(x.altura);
	
	imprimir(&(tabela[pos].elemento));
	printf("\nantsif\n");
	if(tabela[pos].elemento.altura == 0){
		printf("\ncai if\n");
		tabela[pos].elemento = x;		 
	}else{
		tabela[pos].ultimo = novaHash(x);
	}
}

bool pesquisar(char* x){
	bool resp = false;
	Hash* i;

	for(int j = 0; j < 25; j++){
		i = tabela[j].topo;
		for(; i != NULL; i = i->prox){
			if(strcmp(i->elemento.nome, x) == 0){
				resp = true;
			}
		}
	}
	return resp;
}


void mostrar(){
	Hash* i;
	for(int j = 0; j<25; j++){
		printf("\n----------------Tabela%d----------------\n", j);
		imprimir(&(tabela[j].elemento));
		i = tabela[j].prox;
		for( ; i != NULL; i = i->prox){
			imprimir(&(i->elemento));
		}
	}
}


int main(){
	char* lido = (char*) calloc(50, sizeof(char));
	int line_n1 = getLinhaArq();	
	Jogador* tudo = (Jogador*) calloc(line_n1, sizeof(Jogador));
	ler(tudo, line_n1);

	fgets(lido, 50, stdin);
	lido[strlen(lido) - 1] = '\0';
	while(strcmp(lido, "FIM") != 0)
	{
		inserir(tudo[atoi(lido)]);
		fgets(lido, 50, stdin);
		lido[strlen(lido) - 1] = '\0';
	}

	fgets(lido, 50, stdin);
	lido[strlen(lido) - 1] = '\0';
	scanf("%s", lido);
	while(strcmp(lido, "FIM") != 0)
	{
		if(pesquisar(lido)){
			printf("%s SIM\n", lido);
		} else {
			printf("%s NAO\n", lido);
		}
		fgets(lido, 50, stdin);
		lido[strlen(lido) - 1] = '\0';
	}
		
	free(tabela);
	//free jogador
}




