
/*
     Faça um método recursivo que receba um array de caracteres e retorne um
     número inteiro indicando a quantidade de vogais do mesmo(slide 180)
     
     
*/

class e08{




     /*
          metodo para descobrir se um determinado char é uma vogal
     
          @param: let == letra a ser analisada

          @return: 1 == caso seja
                   0 == caso não seja
     */
	public static int vogal(char let){
		if(let == 'a' || let == 'e' || let == 'i' || let == 'o' || let == 'u' || let == 'A' || let == 'E' || let == 'I' || let == 'O' || let == 'U' ){
			return 1;
		}else{
			return 0;
		}
	}


     /*
          metodo recursivo para contar a quantidade de vogais dentro de um array
     
          @param: array ==  cadeia de chars ;
                      i ==  ponto de partida;

          @return: numero de vogais dentro do array
     */
	public static int recursivo(char[] array, int i){
		int resp = 0;		
		
		if( i < array.length ){
			resp = vogal(array[i]) + recursivo(array, i+1);
		}
		return resp;
	}

	public static void main(String[] args){
		char[] array = {'c', 'h', 'a', 'r', 'a', 't', 'I', 'K', 'G', 'B', 'A'}; 
		
		int resposta = recursivo(array, (0));
		System.out.println("Respostafinal "+resposta);
	}
}
