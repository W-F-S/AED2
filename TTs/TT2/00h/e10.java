import java.util.Random;


public class rara {

	/*
	 * ordena o array recursivamente
	 * 
	 * @param int pri - posição a ser ordenada
	 *        int seg - procura no array
	 *        int array[] - array a ser ordenado
	 *
	 * @return int aray - array ordenado
	 * */                              
	public static int[] ordenar (int pri, int seg, int array[]){//begin ordenar
	
		int i = 0;

		if((prin + 1) < array.length){
    
				if(seg < array.length){
    
					if(array[pri] > array[seg]){

						i = array[pri];
						array[pri] = array[seg];
						array[seg] = i;

					}               
					array = ordenar( pri , seg + 1, array );

				}else{                 
					array = ordenar( pri +1, pri + 2, array );
                         
				}
		}	
		return array;		
	
	}//end ordenar

	/*
	 * chama a funcção recursiva de ordenação pasando menos parametros
	 * @param int c[] - array a ser ordenado
	 * @return - array ordenado
	 * */
	public static int[] ordenar(int array[]){
		return ordenar(0 , 1, array);
	}//end ordenar

	public static void main (String[] args){
	
		Random alea = new Random();

		int[] array = new int[20];
		

		System.out.println();

		for(int a = 0; a < novo.length; a++){
		
			novo[a] = alea.nextInt(20);
			System.out.print(novo[a] + ", ");	
		}

		array = ordenar(array);

		System.out.println("\n");

		for(int s = 0; s < resp.length; s++){
			
			System.out.print(resp[s] + ", ");
		}

		System.out.println();
	}
}
