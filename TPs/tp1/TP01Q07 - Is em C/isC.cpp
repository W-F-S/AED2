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
     Metodo para verificar um palavra que serve como ponto de parada

     @param: sting a ser analisada
     @return: true: caso a palavra seja igual a FIM
               else: caso não seja igual a palavra especial        
*/
bool fim(char *palavra)
{
	return ((strlen(palavra) == 4) && (palavra[0] == 'F') && (palavra[1] == 'I') && (palavra[2] == 'M'));//vendo a palavra especial
}  

     /**
          Metodo para verificar se um char é uma letra
     
          @param: sting a ser analisada
          @return: true: caso a palavra seja igual a FIM
                    else: caso não seja igual a palavra especial        
     */
bool letra(char let)
{
	return (let >='A' && let <= 'Z' || let >='a' && let <= 'z');//vendo a palavra especial
}  



  
     /**
          Metodo para printar um Sim ou não.           
     */
void simNao(bool resp){ //apenas para mover os prints do main para um local mais isolado
	if (resp){
          printf("SIM ");
	}else{
		printf("NAO ");
	}
}                                

     /**
          Metodo para ver se um char é um numero
     
          @param: char a ser analisada
          @return: true: caso o char seja um numero
                    else: caso o char não seja um numero       
     */
bool num(char letra)
{
     return( letra >= '0' && letra <= '9'); 
}

     /**
          Metodo para ver se um char é uma vogal(seja ela maiuscula ou minuscula
     
          @param: char a ser analisada
          @return: true: caso a string seja uma vogal
                    else: caso não seja uma vogal     
     */
bool vol(char let){
     return (let == 'a' || let == 'A' || let == 'e' || let == 'E' || let == 'o' || let == 'O' || let == 'i' || let == 'I' || let == 'u' || let == 'U');
}


/**
     Metodo para ver se um char é uma consoante(seja ela maiuscula ou minuscula

          @param: char a ser analisada
          @return: true: caso a string seja uma consoante
                    else: caso não seja uma consoante     
     */
bool con(char let){
     return ( (!vol(let)) && ((let >= 'A' && let <= 'Z') || (let >= 'a' && let <= 'z')) );
}

     /**
          Metodo para ver se uma string é um numero inteiro
          
          @param: string a ser analisada
          @return: true: caso a string seja um numero inteiro
                    else: caso não seja um numero inteiro
     */
bool isInt(char *palavra)
{             
     bool resp = true;
     for(int i = 0; i < (strlen(palavra)-1); i++)
     {
          if( !num(palavra[i]) )
          {
                    // printfln("\nNao e int == "+ palavra.charAt(i));
               resp = false;
               i = (strlen(palavra));
          }
     }
     return (resp);                              
}

/**
     Metodo para ver se uma string é um numero real
          
     @param: string a ser analisada
     @return: true: caso a string seja um numero real
               else: caso não seja um numero real
*/
bool isReal(char *palavra)
{
          bool resp = true;
          int garantia = 0;

          for(int i = 0; i < (strlen(palavra)-2); i++){
               char L = palavra[i];

               if(  !num(L) && (L == '.') || (L == ',') ){ //verificando se nao e' um ponto ou virgula
                    garantia++;                    

               }else if( num(L) && garantia <= 1){//verificando se nao e' um char ou se e' mais um ponto

               }else{
                    resp = false;
                    i = strlen(palavra);      
               }
          }
          return resp;
}


         


     /**
          Metodo para ver se uma string é um numero inteiro
          
          @param:  string a ser analisada
          @return: true: caso a string seja um numero inteiro
                   else: caso não seja um numero inteiro
     */
bool isConsoantes( char *palavra)
{   
      bool resp = true;  

     for(int i = 0; i <  (strlen(palavra)-1); i++)
     {
          if( !con(palavra[i]) )
          {
               // printfln("\nNao e consoante == "+ palavra.charAt(i));
               resp = false;
               i =  (strlen(palavra)-1);
          }
     }
     return (resp );
}

     /**
          Metodo para ver se uma string é composta apenas por vogais
          
          @param: string a ser analisada
          @return: true: caso a string seja composta apenas por vogais
                    else: caso a string seja composta apenas por vogais
     */
bool isVogais( char *palavra)
{
          bool resp = true;
		for(int i = 0; i < (strlen(palavra)-1); i++)
          { 
               if( !vol(palavra[i]) )
               {//ver se e' vogal maiuscula ou minuscula.
                   //  printfln("\nNao e vogal == "+ palavra.charAt(i));
                    resp = false;
                    i =  (strlen(palavra));
		     }    
      	}
          return resp;//retorna false se não for vogal
}


int main( )
{

     char* palavra = (char*) calloc(501, sizeof(char));

     fgets(palavra, 500, stdin);

     while(!fim(palavra)){
               simNao(isVogais(palavra));
               simNao(isConsoantes(palavra));
               simNao(isInt(palavra));
               simNao(isReal(palavra));
           printf("\n");

   	     fgets(palavra, 500, stdin);
     }
     return 0;
}


//em um comando de repetição quando o valor inicial do contador é A, e o mesmo é repetido emquanto ele é menor que N e icrementado de uma em uma posição, faremos N - A repetições
//no algoritmo de seleção, contabilize os numeros de movimentações e comparações entre elementos do array obtidos de forma pratica  e teorica{
               

