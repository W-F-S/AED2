/*
     09. Faça um método recursivo que receba um string e retorne um número inteiro indicando a quantidade de caracteres NOT vogal AND NOT consoante maiúscula da string recebida como parâmetro(183)

     Aluno: Walker Freitas dos Santos 
     N:     698774
*/


class e09{
/**
     metodo para ver se é NAO é uma vogal e ao mesmo tempo ver se NAO é uma consoante maiuscula

     @param: let == caractere a ser analisada

     @return: 1: caso esteja dentro dos termos especificados acima
              0: caso não esta dentro dos termos especificados acima
*/
	public static int consoante(char let){
		if((let < 'A' || let > 'Z') && let != 'a' && let != 'e' && let != 'i' && let != 'o'&& let != 'u' ){
			return 1;
		}else{
			return 0;
		}
	}

/**
     metodo para contar quantos caracteres não são vogais e ao mesmo tempo não são consoantes maiusculas

     @param: <String> array == string a ser analisada
             < int >  i == ponto de partidad

     @return: true: caso esteja dentro dos termos especificados acima
              false: caso não esta dentro dos termos especificados acima
*/

	public static int recursivo(String array, int i){
		int resp = 0;
		if(i < array.length()){
			resp = consoante(array.charAt(i)) + recursivo(array, i+1);
		}
		return resp;
	}


	public static void main(String[] args){
		String array = "O Rato Roeu A Roupa Do Rei De Roma";
		int fim = recursivo(array, 0);
		System.out.println("\nfinal: " + fim);

	}

}
