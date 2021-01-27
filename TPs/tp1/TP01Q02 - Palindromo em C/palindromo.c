/* 
 * Author: Walker
 * Date: 27/01/2021
 *
 * Programm to analize a word and 
 *
 */

#include <stdio.h>     // para entradas e saida
#include <stddef.h>    // para definicoes basicas
#include <stdlib.h>    // para a biblioteca padrao
#include <string.h>    // para cadeias de caracteres
#include <stdarg.h>    // para tratar argumentos
#include <stdbool.h>   // para definicoes logicas
#include <ctype.h>     // para tipos padroes

/**
 *
 */
bool fim (char *palavra)
{
  return (strlen(palavra) == 4 && (palavra[0] == 'F') && palavra[1] == 'I' && palavra[2] == 'M');
}


/**
 *
 */
bool pali (char *palavra)
{
  bool resp = true;
  for (int i = 0, j = (strlen(palavra) - 2); i < j; i++, j--)
  {
    if(palavra[i] != palavra[j])
    {
      resp = false; 
      i = j; 
    }
  }
  return resp;
}

/**
 *
 */
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
