
/*
Repita o exercicio acima considerando que os elementos do array estão ordenados de uma forma crescente
slide 2
*/

class e02{

	public static boolean procurarNum(int[] array, int x){ //x : numero a se achado
		
		int i;
		boolean resp = false;
		if ((x) > (array.length/2)){
			
    		for(i = (array.length - 1); i > 0; i-- ){
    			if(array[i] == x){
    				resp = true;
    				System.out.println("Numero achado: "+ array[i]);
                    i = 0;
    			}
    		}

		}
		else{
			
    		for( i = 0; i < array.length; i++ ){
    			if(array[i] == x){
    				resp = true;
    				System.out.println("Numero achado: "+ array[i]);
                    i = array.length;
    			}
    		}

		}


		return resp;
	}

	public static void main (String[] args){		
		int[] array = new int[40];
		int x = 0, i = 0;
        
		boolean resp = false;

		do{
            x = MyIO.readInt();
            if( x != -1){
    			array[i++] = x; 
            }
		}while(x != -1 && i < 40);

		resp = procurarNum(array, 20000); //numero a se achado
		
		if (resp != false){
			System.out.printf("\nO numero foi encontrado\n");
		}else{
			System.out.printf("\nO numero não foi enconatrado\n");
		}
		
	}
}
