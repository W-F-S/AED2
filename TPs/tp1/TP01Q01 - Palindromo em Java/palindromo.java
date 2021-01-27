/*
 * @author Walker
 *
 * Palindromo em Java - Crie um método iterativo que recebe uma string como parâmetro e
 * retorna true se essa é um palı́ndromo. Na saı́da padrão, para cada linha de entrada, escreva
 * uma linha de saı́da com SIM/NÃO indicando se a linha é um palı́ndromo. Destaca-se que uma
 * linha de entrada pode ter caracteres não letras. A entrada termina com a leitura de FIM.
 *
 */

class palindromo{

	/**
	 * Comparar uma palavra com 'FIM'
	 * @param palavra string a ser analisada 
	 * @return true caso seja igual a FIM
	 * @return false caso nao seja
	 *
	 * melhor caso (caso a palavra tenha mais ou menos de 3 letras): 
	 *  	1 comparacao
	 * 	
	 * pior caso (caso palavra == 'FIM'): 
	 * 	  4 comparacoes
	 */
	public static boolean fim (String palavra){
		return(palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
	}

	/**
	 * Verificar se uma palavra e´ um palindromo
	 * @param palavra string a ser analisada 
	 * @return true caso seja palindromo 
	 * @return false caso nao seja
	 *
	 * seja n o tamanho da palavra
	 *
	 * melhor caso (caso a primeira e a aultima letra sejam diferentes): 
	 * 	2 comparacoes
	 * 	
	 * pior caso (seja um palindromo)
	 *      n - 1, caso n seja impar
	 *      n,     caso n seja par
   *         ou
   *      theta(n)
	 */
	public static boolean pali (String palavra){
		boolean resp = true;
		for (int i = 0, j = (palavra.length() - 1); i < j; i++, j--){/* dois verificadores que comecan nas extremidades da palavra */
			if(palavra.charAt(i) != palavra.charAt(j)){
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
 
