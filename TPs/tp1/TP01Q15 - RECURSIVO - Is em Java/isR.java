class isR{


    
    /**setPalavra(String imput)
	 *
	 * Setar a string lida
	 *
	 * @param: String imput - string lida
	 * @return: nda
	 */     
	public static boolean fim(String palavra){
		return ((palavra.length() == 3) && (palavra.charAt(0) == 'F') && (palavra.charAt(1) == 'I') && (palavra.charAt(2) == 'M'));//vendo a palavra especial
	}  

    /**
          Metodo para verificar se um determinado char e' uma letra

          @param: char let: char a ser analizado
          @return: true: caso seja uma letra
                    false: caso nao seja uma letra
     */
	public static boolean letra(char let){
		return (let >='A' && let <= 'Z' || let >='a' && let <= 'z');//vendo a palavra especial
	}

     /**
          Metodo para escrever na tela um Sim ou Nao

          @param: boolean resp;
                    true: caso resp seja true
                    false: caso nao seja uma letra
          
          @return: ...
     */
	public static void simNao(boolean resp){ //apenas para mover os prints do main para um local mais isolado
		if (resp){
			System.out.printf("SIM ");
		}else{
			System.out.printf("NAO ");
		}
	}                                

     /**
          Metodo para ver se um certo char e um numero


          @param: char let: char a ser analizado
          @return: true: caso seja um numero
                   false: caso nao seja um numero
     */
     public static boolean num(char letra){
          return( letra >= '0' && letra <= '9'); 
     }

     /**
        Function to see if a char is a vowel
//
          @param: char let: char a ser analizado
          @return: true: caso seja uma vogal
                   false: caso nao seja uma vogal
     */
     public static boolean vol(char let){
          return (let == 'a' || let == 'A' || let == 'e' || let == 'E' || let == 'o' || let == 'O' || let == 'i' || let == 'I' || let == 'u' || let == 'U');
     }


     /**
        metodo para ver se e uma consoante

          @param: char let: char a ser analizado
          @return: true: caso seja uma consoante
                   false: caso nao seja uma consoante

     */
     public static boolean con(char let){
          return ( (!vol(let)) && ((let >= 'A' && let <= 'Z') || (let >= 'a' && let <= 'z')) );
     }


     /**
        metodo para ver se e um numero real

          @param: string palavra: string a ser analisada
                    int i : usado para a recursividade, sempre igual a zero 
                    int garantia : usado para garantir que so exista uma , ou .

          @return: true: caso seja um numero real
                   false: caso nao seja um numero real
     */         
    public static boolean isReal(String palavra, int i, int garantia){
        boolean resp = true;
        if( i < palavra.length()){
            char L = palavra.charAt(i);
            
             if(!(num(L))  ){
                    if ( (L == '.' || L == ',') && garantia < 1 ){
                         garantia++;
                         i++;
                         resp = isReal(palavra, i, garantia);
                    }else{
                         resp = false;
                    }
             }else{
                  i++;
                  resp = isReal(palavra, i, garantia);
             }
            
        }
        return resp;
     }


     /**
        metodo para ver se e um numero inteiro

          @param: string palavra: string a ser analisada
                    int i : usado para a recursividade, sempre igual a zero 

          @return: true: caso seja um numero inteiro
                   false: caso nao seja um numero inteiro
     */         
     public static boolean isInt(String palavra, int i){//funcionando d boa            
          boolean resp = true;
          if(i < palavra.length()){
               if( !num(palavra.charAt(i)) ){
                    //MyIO.println("\nNao e int == "+ palavra.charAt(i));
                    resp = false;
               } else {
                    resp = isInt(palavra, i+1);
               }
          }
          return (resp);                              
    } 

     /**
        metodo para ver se e uma consoante

          @param: string palavra: string a ser analisada
                    int i : usado para a recursividade, sempre igual a zero 

          @return: true: caso seja uma consoante
                   false: caso nao seja uma consoante
     */         

	public static boolean isConsoantes(String palavra, int i){//funcionando de boa 
          boolean resp = true;  
          if(i < palavra.length()){
               if( !con(palavra.charAt(i)) ){
                    //MyIO.println("\nNao e consoante == "+ palavra.charAt(i));
                    resp = false;
               } else {
                    resp = isConsoantes(palavra, i+1);
               }
          }
	     return (resp );
     }



     /**
        metodo para ver se e uma vogal

          @param: string palavra: string a ser analisada
                    int i : usado para a recursividade, sempre igual a zero 

          @return: true: caso seja uma vogal
                   false: caso nao seja uma vogal
     */         
	public static boolean isVogais(String palavra, int i){//ver se  vogao
          boolean resp = true;
		if(i < palavra.length()){ 
               if( !vol(palavra.charAt(i)) ){//ver se e' vogal maiuscula ou minuscula.
                   // MyIO.println("\nNao e vogal == "+ palavra.charAt(i));
                    resp = false;
               } else {
                    resp = isVogais(palavra, i+1);
               }
		         
      	}
          return resp;//retorna false se nao for vogal
	}

    public static void main(String[] args){
 		String palavra = MyIO.readLine();

          while(!fim(palavra)){
               simNao(isVogais(palavra, 0));
               simNao(isConsoantes(palavra, 0));
               simNao(isInt(palavra, 0 ));
               simNao(isReal(palavra, 0 , 0));
               
               MyIO.print("\n");

        	     palavra = MyIO.readLine();;
          }
    }
} 
