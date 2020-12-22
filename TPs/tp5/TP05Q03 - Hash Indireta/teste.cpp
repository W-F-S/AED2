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
	int  id;
	char *nome;
	int  altura;
	int  peso;
	int  anoNascimento;
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

//------------------------------------------------------------------------------------------

typedef struct No{
	Jogador* elemento;
	int nivel;
	struct No *esq, *dir;
} No;

No* novoNo(Jogador* elemento) {
	No* novo = (No*) malloc(sizeof(No));
	novo->elemento = elemento;
	novo->esq = NULL;
	novo->dir = NULL;
	novo->nivel = 1;
	return novo;
}

int mathMax(int x1, int x2){
	return (x1 > x2) ? x1 : x2;
}

int getNivel(No* elemento){
	return (elemento == NULL) ? 0 : elemento->nivel;
}

void setNivel(No* elemento){
	elemento->nivel = 1 + mathMax(getNivel(elemento->esq), getNivel(elemento->dir));
}

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

bool pesquisarRec(char* x, No* i);
No* inserirRec(Jogador* x, No* i);
No* rotacionarDir(No* no);
No* rotacionarEsq(No* no);
No* balancear(No* no);

No* raiz;

void AVL(){
	raiz = NULL;
}

/**
 * Metodo  iterativo para pesquisar elemento.
 * @param x Elemento que sera procurado.
 * @return <code>true</code> se o elemento existir,
 * <code>false</code> em caso contrario.
 */
bool pesquisar(char* x) {
	printf("%s raiz ", x);
	return pesquisarRec(x, raiz);
}

/**
 * Metodo  recursivo para pesquisar elemento.
 * @param x Elemento que sera procurado.
 * @param i No em analise.
 * @return <code>true</code> se o elemento existir,
 * <code>false</code> em caso contrario.
 */
bool pesquisarRec(char* x, No* i) {
	bool resp;
	comparacoes++;
	if (i == NULL) {
		printf("NAO\n");
		resp = false;

	} else if (strcmp(x, i->elemento->nome) == 0) {
		comparacoes++;
		printf("SIM\n");   
		resp = true;

	} else if (strcmp(x, i->elemento->nome) < 0) {
		comparacoes++;
		printf("esq ");
		resp = pesquisarRec(x, i->esq);

	} else {
		comparacoes++;
		printf("dir ");
		resp = pesquisarRec(x, i->dir);
	}
	return resp;
}

/**
 * Metodo  iterativo para inserir elemento.
 * @param x Elemento a ser inserido.
 */
void inserir(Jogador* x) {	
	raiz = inserirRec(x, raiz);
}

/**
 * Metodo  recursivo para inserir elemento.
 * @param x Elemento a ser inserido.
 * @param i No** endereco do ponteiro No
 */
No* inserirRec(Jogador* x, No* i) {
	comparacoes++;
	if (i == NULL) {
		i = novoNo(x);
	} else if ( strcmp(x->nome, i->elemento->nome)<0 ) {
		comparacoes++;
		i->esq = inserirRec(x, i->esq);
	} else if ( strcmp(x->nome, i->elemento->nome)>0 ) {
		comparacoes++;
		i->dir = inserirRec(x, i->dir);
	} else {
		printf("\ninserir mesmo");
	}
	return balancear(i);
}

No* balancear(No* no){
	comparacoes++;
	if(no != NULL){
		int fator = getNivel(no->dir) - getNivel(no->esq);
		comparacoes++;
		if (fator <= 1 && fator >= -1){//fator aceitavel
			setNivel(no);
		}else if (fator == 2){//rotacao dupla
			comparacoes++;
			int fatorFilhoDir = getNivel(no->dir->dir) - getNivel(no->dir->esq);
			comparacoes++;
			if (fatorFilhoDir == -1) {//balancear o filho da direita caso precise
				no->dir = rotacionarDir(no->dir);
			}
			no = rotacionarEsq(no);
		}else if (fator == -2){//rotacao dupla
			comparacoes++;
			int fatorFilhoEsq = getNivel(no->esq->dir) - getNivel(no->esq->esq);
			comparacoes++;
			if (fatorFilhoEsq == 1) {//balancear o filho da esquerda caso precise
				no->esq = rotacionarEsq(no->esq);
			}
			no = rotacionarDir(no);
		}
	}
	return no;
}

No* rotacionarDir(No* no) {//rotacao simples
	No* noEsq = no->esq;
	No* noEsqDir = noEsq->dir;

	noEsq->dir = no;
	(no)->esq = noEsqDir;

	setNivel(no);
	setNivel(noEsq);

	return noEsq;
}

No* rotacionarEsq(No* no) {//rotacao simpores
	No* noDir = no->dir;
	No* noDirEsq = noDir->esq;

	noDir->esq = no;
	no->dir = noDirEsq;

	setNivel(no);
	setNivel(noDir);
	return noDir;
}

//------------------------------------------------------------------------------------------

int main()
{
	char *lido = (char*) calloc(50, sizeof(char));
	int l = 0; double tempo = 0;
	int line = getLinhaArq();
	Jogador *tudo = (Jogador*) calloc(line, sizeof(Jogador));
	AVL();
	ler(tudo, line);// lendo jogadores
	//inserindo jogadores
	fgets(lido, 50, stdin);
	lido[strlen(lido) - 1] = '\0';//trantando o fgets
	while(strcmp(lido, "FIM") != 0)
	{
		inserir(&tudo[atoi(lido)]);
		fgets(lido, 50, stdin);
		lido[strlen(lido) - 1] = '\0';
	}
	//pesquisando jogadores
	fgets(lido, 50, stdin);
	lido[strlen(lido) - 1] = '\0';
	tempo = clock();//reginstrando o tempo
	while(strcmp(lido, "FIM") != 0)
	{
		pesquisar(lido);
		fgets(lido, 50, stdin);
		lido[strlen(lido) - 1] = '\0';
	}          
	tempo = clock() - tempo;
	makeLog(tempo, comparacoes);//fazendo o arquivo de log
}


