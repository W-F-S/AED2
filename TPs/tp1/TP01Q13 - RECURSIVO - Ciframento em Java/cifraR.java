/**
     Aluno: Walker Freitas dos Santos
     N: 698774
 */


class cifraR{

     /**
          Metodo para verificar um certa palavra usada como ponto de parada
          
          @para: sring para ser analisada;
          @retur: true caso a palavra seja igual a necessitada
                  false caso a palavra não seja igual
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
     public static String cripto(String letra, int i){
          //c = (k+n) k = deslocamento, n = letra, c = texto criptografado
                                                                  
          String s   = "";
          char teste = ' '; 
                                            
          if( i < (letra.length()) ){                                
               
               teste = (char) (letra.charAt(i) + 3); //transformando na cifra
               s += (teste) + cripto(letra, i=i+1);//concatenação
          }                                                               
          return s;
	}                                          
                                                      
     public static void main(String[] args)
     {                    
     	String entrada = MyIO.readLine();
      	while(!fim(entrada)){                                                   	      
     		MyIO.println(cripto(entrada, 0));                               
               entrada = MyIO.readLine();
     	}                                                                             
     }              
}
