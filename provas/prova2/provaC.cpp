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


