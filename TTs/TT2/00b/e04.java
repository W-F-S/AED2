
/*
repita o exercicio acima fazendo menos comparações com os elemntos do array
slide 3
*/

class e04{

	public static void menorMaior(int[] array){ //x : numero a se achado
		
		int menor = array[0];
		int maior = 0;
		
		for(int i : array ){
			
			if(i > maior){
				maior = i;
			//	System.out.println("Numero achado: "+ i);

			}else if(i < menor ){
				menor = i;
			}
		}
		System.out.printf("\nMaio numero encontrado: " +maior+ "\nMenor numero encontrado: "+menor+"\n");
	}

	public static void main (String[] args){		
		int[] array = new int[10];
		int x = 0;

		while(x < 10){
			array[x] = MyIO.readInt();
			x++;
		}

		menorMaior(array);
	}
}
