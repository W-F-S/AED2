/**
     . Faça um método recursivo que receba um array de números inteiros e um
     número inteiro n indicando o tamanho do array e retorne o maior elemento

*/


class e07{



/**
     metodo recursivo que retorna o maior elemento de um array 

     @param: array   == cadeia de numeros inteiros
             tamanho == tamanho do array

     @return: maior numero do array
*/
	public static int recursivo(int[] array, int tamanho){
		int resp = 0;		

		if(tamanho <= 0){
			resp = array[tamanho+1];
		}else{
			resp = recursivo(array, (tamanho-1));
			if(resp < array[tamanho]){
				resp = array[tamanho];
			}
		}
		return resp;
	}


	public static void main(String[] args){
		int[] array = {4, 2, -90, 200, 0, 444, 404, -2, 7};
		int teste = recursivo(array, (array.length-1));
		System.out.println(teste);
	}

}
