/**
     Aluno: Walker Freitas dos Santos
     N: 698774
*/


class cifra{	

     /**
          Metodo para verificar a igualdade de uma sting com uma determinada palavra
         
          @para: string a ser analisada
          @return: true caso as palavras sejam iguais
                   false caso as palavras sejam diferentes
     */
     public static boolean fim(String palavra){
		return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
	}
                         

     /** 
          Metodo para fazer a cifra de cesar em qualquer caractere

          @para: string a ser criptografada
                 ponto de início da string
     
          @return: string criptografada;   
     */                                                                                                                      
     public static String cripto(String letra){
          //c = (k+n) k = deslocamento, n = letra, c = texto criptografado
                                                                  
          String s   = "";
          char teste = ' ';
                                            
          for(int i = 0; i < (letra.length()); i++ ){
               teste = (char) (letra.charAt(i) + 3); //transformando na cifra
               s += teste;//concatenação
          }                                                                
    
          MyIO.println(s);
          return s;
	}                                          
                                                      
     public static void main(String[] args)
     {                    
     	String entrada = MyIO.readLine();                                                                                          

	     while(!fim(entrada)){                                                                                      
	     	cripto(entrada);                               
	     	entrada = MyIO.readLine();                                                                
     	}                                  
     }              
}
