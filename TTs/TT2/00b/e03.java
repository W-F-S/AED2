
/*
Faça um metodo que receba um array de interios e mostre na tela o maior e o menor elementos do array
slide 3
*/

class e03{

	public static void menorMaior(int[] array){ //x : numero a se achado
		
		int menor = array[0];
		int maior = 0;
		


		for(int i = 0; i < array.length; i++ ){
			
			if(array[i] > maior){
				maior = array[i];
				System.out.println("Numero achado: "+ array[i]);

			}else if(array[i] < menor ){
				menor = array[i];
			}
		}
		System.out.printf("\nMaio numero encontrado: " +maior+ "\nMenor numero encontrado: "+menor+"\n");
	}

	public static void main (String[] args){		
		int[] array = new int[40];
		int x = 0;

		while(x < 40){
			array[x] = MyIO.readInt();
			x++;
		}
		

		
		menorMaior(array);
	}
}
