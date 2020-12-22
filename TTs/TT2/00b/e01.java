
/*
Faça um método que receba um array de inteiros e um
número inteiro x e retorne um valor booleano informando se o
elemento x está contido no array
slide 2
*/

class e01{

	public static boolean procurarNum(int[] array, int x){ //x : numero a se achado
		boolean resp = false;
		for(int i = 0; i < array.length; i++){
			if(array[i] == x ){
				resp = true;
				//System.out.println("Numero achado: "+ array[i]);
			}

		}
		return resp;
	}

	public static void main (String[] args){		
		int[] array = new int[40];
		int x = 0;
		boolean resp = false;

		do{
			array[x] = MyIO.readInt();
		}while(array[x++] != (-1) && x < 40);

		resp = procurarNum(array, 4); //numero a se achado
		
		if (resp != false){
			System.out.printf("\nO numero foi encontrado\n");
		}else{
			System.out.printf("\nO numero não foi enconatrado\n");
		}
		
	}
}
