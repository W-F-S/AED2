/**
 * Jogador.c     
 * 
 * Walker Freitas dos Santos 
 *
 * Programa para cadastrar jogadores usando um arquivo .csv
 *   
 * 0.2.0    20/09/2020
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

	(P2)->id = (P1)->id;
	(P2)->nome = strdup((P1)->nome);
	(P2)->altura = (P1)->altura;
	(P2)->peso = (P1)->peso;
    (P2)->anoNascimento = (P1)->anoNascimento;
	(P2)->universidade = (P1)->universidade;
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


//--------------PERGUNTA------------
   //pq ta mandando fazer (->) e não (.) 





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
 * -----------------------------------------------------------------------------------------------------FUNCOES AUXILIARES-------------
 */


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
		for(j = 0; j<i; j++)
		{
			if(P[j].anoNascimento > (P[j+1]).anoNascimento) {
				swap(&P[j], &P[j+1]);
			}    
			else
			{
				if( (P[j].anoNascimento == (P[j+1]).anoNascimento) && (strcmp((P[j].nome), (P[j+1]).nome) > 0) )
				{
					swap(&P[j], &P[j+1]);	
				}
			}
		}
	}
}
/**
 *------------------------------------------------------------------------------------------------------ALGORITMOS DE ORDENAÇÃO---------
 */ 




/**
 * -----------------------------------------------------------------------------------------------------FUNCOES AUXILIARES--------------
 */




int main(void){
	int lineN_2 = getLinhaArq();
	char entrada[10];
    int v;

	Jogador jogadores[lineN_2];
	Jogador jogadores2[500];

	ler(jogadores, lineN_2);
	scanf("%s", entrada);

	while( strcmp(entrada, "FIM") != 0 )
	{ 
		clone(&jogadores2[v], &jogadores[atoi(entrada)]);
		v = v+1;
		scanf("%s", entrada);
	}
	
	ordenarBolha(jogadores2, v);
	int i = 0;
	while(i < v)
	{
		mostrar(jogadores2[v]);
        i++;
	}
	return 0;
}





////////////////////////////////////////////////////////////////////////////////////////////////////////////////LIXO
/**
 * mandamos o arranjo de jogadores que desejamos ordenar junto com o numero de jogadores cadastrados
 * fazemos um for que roda numPlayers vezes 
 * pegamos P[i]->nome[0]   selecionamos o arranjo pegamos a primeira letra do nome e guardamos;
 * pegamos i-1 ;
 * emquanto j>= 0 && P[j]->.nome[0] >tmp   emquanto j >= e o nome do jogador[J], na posicao 0, for maior que o nome do jogador[i] na posicao 0 o algoritmo vai ser rodado;
 * 
 * {
 * 	
 *	
 *
 */


/**
 * funcao para comparar um nome com um certo jogador, retornando true caso o nome enviado seja compativel com a id enviada
 * @param : Jogador *P    -- ponteiro para o jogador a ser comparado.
 *          int JC        -- quantidade de jogadores cadastrados
 *          char *NomeC   -- nome a ser comparado com P
 *
 * @return: bool retornar -- resposta final, sendo true caso NomeC seja igual a algum nome de jogador em P
 *
bool comparador(Jogador *P, int JC, char *NomeC){
	bool retornar = false;
        while(int i=0; i<JC; i++){

	}

}
*/

/**
 * Funcao para ordenar um arranjo de Jogadores pelo nome
 * 
 * @param : Jogador *P -- ponteiro para o arranjo de jogadores desordenado
 * 	    int numPlayers -- numero de jogadores cadastrados em *P
 *
void ordenarNome(Jogador *P, int numPlayers ){


	int n = numPlayers;
	for (int i = 1; i < n; i++) {
		int tmp = (int) P[i];
		int j = i - 1;
		while ( (j >= 0) && strcpm() ){
			P[j + 1] = P[j];
			j--;
		}
		P[j + 1] = tmp;
	}

}*/



/*
 * como eu posso fazer a ordenação? que merdaalkjsdflkajsldjkfçlaskdjfçlajsdlçfkjasldfkjçalsjfd
 *
 * ja que para fazer a pesquisa binaria o array precisa estar ordenado
 *
 * entao eu primeiro eu pego todos os dados depois eu ordeno cada um deles
 *
 * mas e a pesquisa? eu pesquiso binariamente pelo nome? Parece que sim, ja que o enunciado fala: A chave 
 * primária de pesquisa será o atributo nome.
 *
 * mas como ordenar pelos nomes? e como fazer um pesquisa binaria usando chars? complexo para um caralho esta
 *
 * hummmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
 *
 *
 *
 *
 */
