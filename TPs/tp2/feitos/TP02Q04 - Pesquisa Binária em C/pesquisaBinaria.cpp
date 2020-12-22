/**
 * Jogador.c     
 * 
 * Walker Freitas dos Santos 
 *
 * Programa para ler um arquivo .vsc, cadastrar os jogadores do arquivo, ler uma quantidade de entradas, ordenar essas entradas(em funcao dos nomes) e fazer diversas pesquisas binarias.
 * 1.0.0    30/09/2020
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
double tempo;

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
    FILE *arquivo = fopen("698774_binaria.txt", "w");
    fprintf(arquivo, "698774\t%lf\t%d", tempo, comparacoes );
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
 //   free(teste);
 //   free(linha);
}

/**
 *------------------------------------------------------------------------------------------------------ALGORITMOS DE ORDENAÇÃO--------- 
*/ 
/**
 * Funcao para ordenar um arranjo de jogadores (versao Bolha) dado o numero de jogadores e usando um ponteiro para tal arranjo jogadores 
 *                                              
 * @param : Jogador *P     -- ponteiro para o arranjo de jogadores
 *          int n          -- numero de jogadores cadastrados
 */
void ordenarBolha(Jogador *P, int n)
{
	int i, j;
	for(i = (n-1); i>0; i--) 
	{
        comparacoes = comparacoes + 1;        
		for(j = 0; j<i; j++)
		{
            comparacoes = comparacoes + 1;	    
        	if(P[j].anoNascimento > (P[j+1]).anoNascimento) {
				swap(&P[j], &P[j+1]);
                movimentacoes = movimentacoes + 3;
                comparacoes = comparacoes + 1;
			}    
			else
			{
				if( (P[j].anoNascimento == (P[j+1]).anoNascimento) && (strcmp((P[j].nome), (P[j+1]).nome) > 0) )
				{
					swap(&P[j], &P[j+1]);	      
                    movimentacoes = movimentacoes + 3;       
                    comparacoes = comparacoes + 2;
				}
			}
		}
	}    
}

/**
 * Funcao para ordenar um arranjo de jogadores (versao Selecao(recursiva)) dado o numero de jogadores e usando um ponteiro para tal arranjo jogadores 
 *                                              
 * @param : Jogador *P     -- ponteiro para o arranjo de jogadores
 *          int i          -- 0 (inicio do arranjo)
 *          int n          -- numero de jogadores cadastrados
 */
void selecao(Jogador *P, int i,int n){
   
   comparacoes = comparacoes + 1; 
   if( i < (n-1) )
   {
      
      int menor = i;
      for (int j = (i + 1); j < n; j++){
        comparacoes = comparacoes + 2;  
         if ( (strcmp((P[menor].nome), (P[j]).nome) > 0) ){
            menor = j;
         }
      }
      swap(&P[menor], &P[i]);
      movimentacoes = movimentacoes + 3;  
      selecao(P, (i+1), n);
   }
}

/**
 * Funcao para ordenar um arranjo de Jogadores (versao usando insercaoParcial) dado o numero de jogadores e usando um ponteiro para tal arranjo de jogadores
 *
 * @param : Jogador *P  -- ponteiro para o arranjo de jogadores
 *          int n       -- numero de jogadores cadastrados
 *          int k       -- fatia de jogadores a ser ordenada
 */
void insercaoParcial(Jogador *P, int n, int k) 
{
    int i , j;
    for (i = 1; i < n; i++) 
    {
	comparacoes = comparacoes + 2;
        Jogador x = P[ i ]; //x = variavel temporaria
        
        if ( i > k) {
            j = k ;  
        }
        else{
            j = i - 1;
        }

        while ( (j >= 0) && ((x.anoNascimento < P[ j ].anoNascimento) || 
                ( P[j].anoNascimento == x.anoNascimento     &&     strcmp(P[j].nome, x.nome)   >    0 ) )){ // ordena pelo ano de nascimento com o desempate sendo uma ordenacao alfabetica;
		comparacoes = comparacoes + 4;
            P[j+1] = P[j]; //movendo todos os dados 
	    movimentacoes = movimentacoes + 1;
            j--;
        }
	movimentacoes = movimentacoes + 1;
        P[j + 1] = x; //inserindo o jogador a ser ordenado na lista
    }
}



/**
 * Funcao para fazer pesquisa binaria de nomes na Classe Jogador
 *
 * @param : Jogador *P  -- ponteiro para o arranjo de jogadores(ordenados pelo nome)
 *          int n       -- quantidade de jogadores cadastrados em P
 *          char *nome  -- nome a ser procurado
 *   
 * @return: bool resp -- true  = caso nome exista no arranjo
 *                       false = caos nome nao exista no arranjo
 */

bool pesquisaBinaria(Jogador *P, int n, char *nome)
{
    bool resp = false;
    int left = 0; int right = n-1; 
    int i=0;

    while(left<=right){
        int meio = ((left+right)/2);
        comparacoes += 2;
        if( strcmp(P[meio].nome, nome) < 0 )
        {   
            left = meio + 1;
        }
        else 
        {
            comparacoes += 1;
            if( strcmp(P[meio].nome, nome) > 0)
            {
                right =  meio - 1;
            }
            else
            {
                resp = true;
                left = right + 1;
            }
        }
   }
   return resp;
}



/**
 *------------------------------------------------------------------------------------------------------ALGORITMOS DE ORDENAÇÃO---------
 */ 




int main(void){
    //ALOCANDO MEMORIA E INICIALIZANDO VARIAVEIS
    tempo = clock();
    int v;
	int lineN_2 = getLinhaArq();
	char entrada[50];
	Jogador *jogadores  = (Jogador*) calloc(lineN_2, sizeof(Jogador));
	Jogador *jogadores2 = (Jogador*) calloc(500, sizeof(Jogador));

    //LENDO O ARQUIVO .CSV
	ler(jogadores, lineN_2);

    //LENDO ENTRADAS
    fgets(entrada, 48, stdin);
    entrada[strlen(entrada)-1] = '\0';
	for(v=0; strcmp(entrada, "FIM") != 0; v++ )
	{ 
		jogadores2[v] = jogadores[atoi(entrada)];
        fgets(entrada, 48, stdin);
        entrada[strlen(entrada)-1] = '\0';  
        //TRANTANDO DO ID COM '*' NO FINAL
        if(jogadores2[v].id == 2011)
            jogadores2[v].nome[strlen(jogadores2[v].nome)-1] = '\0';             
	}
	
    //ORDENANDO AS ENTRADAS
    selecao(jogadores2, 0, v);

    //LENDO AS NOVAS ENTRADAS
	fgets(entrada, 48, stdin);   
    entrada[strlen(entrada) - 1] = '\0';
 	while(strcmp(entrada, "FIM") != 0)
	{
        if(pesquisaBinaria(jogadores2, v, entrada) )
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }
		fgets(entrada, 48, stdin);   
        entrada[strlen(entrada) - 1] = '\0';   
	}
    
    //DESALOCANDO MEMORIA
    free(jogadores);
    free(jogadores2);
 
    //FAZENDO O LOG
    tempo = (clock() - tempo);
    makeLog();
	return 0;
}
