/*
    Aluno: walker freitas dos santos
    N: 698774
*/

class palindromoR{

     /**
          Metodo para verificar um certa palavra usada como ponto de parada
          
          @para: sring para ser analisada;
          @retur: true caso a palavra seja igual a necessitada
                  false caso a palavra não seja igual
     */
	public static boolean fim (String palavra){
		return (palavra.length() == 3 && (palavra.charAt(0) == 'F') && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
	}


     /**
          Metodo para verificar um certa palavra é um palindromo
          
          @para: sring para ser analisada;
          @retur: true caso a palavra seja um palindromo
                  false caso a palavra não seja um palindromo
     */
	public static boolean pali(String palavra, int i, boolean resp){
		int fim = palavra.length() - 1 - i;
		if ( i < fim ){                                                            
			if(palavra.charAt(i) == palavra.charAt(fim)){     
				resp = pali(palavra, i=i+1, resp);        
			}else return false;                    
		}                       
		return resp;      
	}                       

	public static void main (String[] args){
		
		String palavra = MyIO.readLine();
		
		while(!fim(palavra)){
			
			if(pali(palavra, 0, true)){
				MyIO.println("SIM");
		
			}else{
				MyIO.println("NAO");
			}
			palavra = MyIO.readLine();
		}

	}
}
