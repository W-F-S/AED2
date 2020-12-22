/**
 * Jogador.c     
 * 
 * Walker Freitas dos Santos 
 *
 * Programa para cadastrar jogadores usando um arquivo .csv
 *   
 * 0.2.0    20/09/2020
 *
 *  Codigo Bugando. Não está compativel com o pub.out por algum motivo
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
    FILE *arquivo = fopen("698774_shellSort.txt", "w");
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
 * Funcao para ordenar um array usando o shellsort
 *
 *  @param: Jogador *P -- array de jogadores
 *  @param: int n      -- quantidade de jogadores cadastrados em P
 *  @param: int cor    -- cor a ser ordenada
 *  @param: int h
 */
void insercaoPorCor(Jogador *P, int n, int cor, int h)
{
    bool resp;
    for (int i = (h + cor); i < n; i+=h) {
        comparacoes = comparacoes + 1;
        Jogador tmp = P[i];
        movimentacoes = movimentacoes + 1;
        int j = i - h;
        while ( j >= 0  && (P[j].peso > tmp.peso  ||   
                            P[j].peso == tmp.peso && 
                            strcmp(P[j].nome, tmp.nome) > 0) )  
        {                
            comparacoes = comparacoes + 4;
            P[j + h] = P[j];
            movimentacoes = movimentacoes + 1;
            j -= h;
        }
        movimentacoes = movimentacoes + 1;
        P[j+h] = tmp;        
    }
}

/**
 * Funcao para ordenar um array usando o shellsort
 *
 *  @param: Jogador *P -- array de jogadores
 *  @param: int n      -- quantidade de jogadores cadastrados em P
 */
void shellsort(Jogador *P, int n) 
{
    int h = 1;	
    do{ 
        h = (h * 3) + 1;
        comparacoes = comparacoes + 1;
    }while (h < n);
    do {
        comparacoes = comparacoes + 1;
        h /= 3;
        for(int cor = 0; cor < h; cor++){
            comparacoes = comparacoes + 1;
            insercaoPorCor(P, n, cor, h);
        }
    } while (h != 1);
}


int main(void)
{
    execucao = clock();
    int v;
	int lineN_2 = getLinhaArq();
	char entrada[10];

	Jogador *jogadores  = (Jogador*) calloc(lineN_2, sizeof(Jogador));
	Jogador *jogadores2 = (Jogador*) calloc(800, sizeof(Jogador));

	ler(jogadores, lineN_2);
	scanf("%s", entrada);

	for(v=0; strcmp(entrada, "FIM") != 0; v++ )
	{ 
		jogadores2[v] = jogadores[atoi(entrada)];
		scanf("%s", entrada);
	}

	shellsort(jogadores2, v);

	for(int i=0; i < v; i++)
	{
		mostrar(jogadores2[i]);
	}

//    freef(jogadores, lineN_2);
//    freef(jogadores2);
    execucao = clock() - execucao;
    makeLog();
	return 0;
}
