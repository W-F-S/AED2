/**
	Aluno: Walker Freitas dos Santos;
	N: 698774;
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

/**
	Metodo para verificar se uma palavra é igual "FIM"

	@param: palavra a ser analisada
	@return: true caso a palavra analisada seja igual a FIM
		false caso a palavra analisada não seja igual a FIM
*/
bool fim (char *palavra)
{
	return (strlen(palavra) == 4 && (palavra[0] == 'F') && palavra[1] == 'I' && palavra[2] == 'M');
}



/**
	Função para ver se uma palavra é um palindromo 

	@param: palavra a ser analizada
		ponto de inicio
		resposta (por padrao deve ser true)	
	@return: true caso a palavra seja um palindromo
		false caso a palavra não seja um palindromo
*/
bool pali(char *palavra, int i, bool resp)
{
	int fim = strlen(palavra) - 2 - i;
	if ( i < fim )
     	{                                                            
		if(palavra[i] == palavra[fim])
        	{     
			resp = pali(palavra, i=i+1, resp);        
		}
          	else
         	{	
               		return false;                    
          	}
	}                       
	return resp;      
}                       

int main ()
{
	char *palavra = (char*) (calloc (501, sizeof(char)));
	fgets(palavra,  500, stdin);
     	while(!fim(palavra))
	{	
     		if(pali(palavra, 0, true))
          	{
     			printf("SIM\n");
     		}
          	else
          	{
     			printf("NAO\n");
          	}
          	fgets(palavra,  500, stdin);
	}
}

