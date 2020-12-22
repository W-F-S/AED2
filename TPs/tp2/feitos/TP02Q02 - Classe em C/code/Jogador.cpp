/**
 * Jogador.c     
 * 
 * Walker Freitas dos Santos 
 *
 * Programa para cadastrar jogadores usando um arquivo .csv
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
	return lineN;
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
 * function para mostrar os dados jogador dado o ID dele
 *
 * @param: Jogador *P = ponteiro para a classe jogador
 * 	   int indexN = id do jogador desejado     
 */
void mostrar( Jogador *P, int indexN)
{
    		printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n",  
			(P[indexN]).id, 
			(P[indexN]).nome, 
			(P[indexN]).altura, 
			(P[indexN]).peso, 
			(P[indexN]).anoNascimento, 
			(P[indexN]).universidade,
			(P[indexN]).cidadeNascimento, 
			(P[indexN]).estadoNascimento);		
}

int main(void){
	int lineN_2 = getLinhaArq();
	char entrada[10];

	Jogador jogadores[lineN_2];
	ler(jogadores, lineN_2);
	scanf("%s", entrada);

	while( strcmp(entrada, "FIM") != 0 ){
		mostrar( jogadores, atoi(entrada));
		scanf("%s", entrada);

	}
	return 0;
}
