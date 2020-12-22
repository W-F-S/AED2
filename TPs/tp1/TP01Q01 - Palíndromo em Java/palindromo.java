/*
    Aluno: walker freitas dos santos
    N: 698774
*/

class palindromo{

     /**
          Metodo para verificar um certa palavra usada como ponto de parada
          
          @para: sring para ser analisada;
          @retur: true caso a palavra seja igual a necessitada
                  false caso a palavra não seja igual
     */
	public static boolean fim (String palavra){ //ver se é a palavra chave
		return(palavra.length() >= 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
	}

     /**
          Metodo para verificar um certa palavra é um palindromo
          
          @para: sring para ser analisada;
          @retur: true caso a palavra seja um palindromo
                  false caso a palavra não seja um palindromo
     */
	public static boolean pali (String palavra){
		boolean resp = true;
	
		for (int i = 0, j = (palavra.length() - 1); i < j; i++, j--){//dois verificadores que vão comparando cada letra
			if(palavra.charAt(i) != palavra.charAt(j)){//se forem diferentes o codigo ja para e retorna
				resp = false; 
				i = j; 
			}
		}
		return resp;
	}

	public static void main(String[] args){
		 	
		String resp = MyIO.readLine();	
		
		while(!(fim(resp))){

			if(pali(resp)){
				System.out.printf("SIM\n");
			}else{
				System.out.printf("NAO\n");
			}
          	resp = MyIO.readLine(); 
     	}
	}	
}
