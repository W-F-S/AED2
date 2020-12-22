/*
     walker freitas dos santos
     698774
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
     Função para verificar se a cadeia de caracteres é igual a fim

     @param: string a ser analisada
     @return: true caso a string seja igual a procurada
               false caso a string nao seja igual a procurada
*/
bool fim (char *palavra)
{
	return (strlen(palavra) == 4 && (palavra[0] == 'F') && palavra[1] == 'I' && palavra[2] == 'M');
}


/**
     Função para verificar se a cadeia de caracteres é um palindromo

     @param: string a ser analisada
     @return: true caso a string seja igual um palindromo
               false caso a string nao seja igual a um palindromo
*/
bool pali (char *palavra)
{
     bool resp = true;

     for (int i = 0, j = (strlen(palavra) - 2); i < j; i++, j--)
     {//dois verificadores que vão comparando cada letra
    
     	if(palavra[i] != palavra[j])
          {//se forem diferentes o codigo ja para e retorna
     		resp = false; 
     		i = j; 
     	}
     }
     return resp;
}


int main ()
{
	char *palavra = (char*) (calloc (1000, sizeof(char)));
     fgets(palavra, 999, stdin);

     while(!fim(palavra))
     {       
     	if(pali(palavra))
          {
     		printf("SIM\n");    
     	}
          else
          {
     		printf("NAO\n");
     	}
          fgets(palavra, 999, stdin);
	}
 
}
