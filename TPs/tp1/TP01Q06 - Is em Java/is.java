//usar a classe Compare

class is{
	
     /**
     
     */
	public static boolean fim(String palavra){
		return ((palavra.length() == 3) && (palavra.charAt(0) == 'F') && (palavra.charAt(1) == 'I') && (palavra.charAt(2) == 'M'));//vendo a palavra especial
	}  

     /**
     
     */
	public static boolean letra(char let){
		return (let >='A' && let <= 'Z' || let >='a' && let <= 'z');//vendo a palavra especial
	}
     /**
     */
	public static void simNao(boolean resp){ //apenas para mover os prints do main para um local mais isolado
		if (resp){
			System.out.printf("SIM ");
		}else{
			System.out.printf("NAO ");
		}
	}                                

     /**
     */
     public static boolean num(char letra){
          return( letra >= '0' && letra <= '9'); 
     }

     /**
     */
     public static boolean vol(char let){
          return (let == 'a' || let == 'A' || let == 'e' || let == 'E' || let == 'o' || let == 'O' || let == 'i' || let == 'I' || let == 'u' || let == 'U');
     }


     /**
     */
     public static boolean con(char let){
          return ( (!vol(let)) && ((let >= 'A' && let <= 'Z') || (let >= 'a' && let <= 'z')) );
     }


     /**
    */
     public static boolean isReal(String palavra){
          boolean resp = true;
          int garantia = 0;

          for(int i = 0; i < palavra.length(); i++){
               char L = palavra.charAt(i);

               if(  !num(L) && (L == '.') || (L == ',') ){ //verificando se nao e' um ponto ou virgula
                    garantia++;                    

               }else if( num(palavra.charAt(i)) && garantia <= 1){//verificando se nao e' um char ou se e' mais um ponto

               }else{
                    resp = false;
                    i = palavra.length();      
               }
          }
          return resp;
     }


     /**
    */
     public static boolean isInt(String palavra){//confirmando se um numero inteiro             
          boolean resp = true;
          for(int i = 0; i < palavra.length(); i++){
               if( !num(palavra.charAt(i)) ){
                    //MyIO.println("\nNao e int == "+ palavra.charAt(i));
                    resp = false;
                    i = palavra.length();
               }
          }
          return (resp);                              
     }         


     /**
    */
	public static boolean isConsoantes(String palavra){   
          boolean resp = true;  

          for(int i = 0; i < palavra.length(); i++){
               if( !con(palavra.charAt(i)) ){
                    //MyIO.println("\nNao e consoante == "+ palavra.charAt(i));
                    resp = false;
                    i = palavra.length();
               }
          }
	     return (resp );
     }

     /**
    */
	public static boolean isVogais(String palavra){//ver se  vogao
          boolean resp = true;
		for(int i = 0; i < palavra.length(); i++){ 
               if( !vol(palavra.charAt(i)) ){//ver se e' vogal maiuscula ou minuscula.
                   // MyIO.println("\nNao e vogal == "+ palavra.charAt(i));
                    resp = false;
                    i = palavra.length();
		     }    
      	}
          return resp;//retorna false se nao for vogal
	}


	public static void main(String[] args){

		String palavra = MyIO.readLine();

          while(!fim(palavra)){
               simNao(isVogais(palavra));
               simNao(isConsoantes(palavra));
               simNao(isInt(palavra));
               simNao(isReal(palavra));
               
               MyIO.print("\n");

        	     palavra = MyIO.readLine();;
          }
	}
}


