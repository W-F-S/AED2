/**
	Author: Walker Freitas dos Santos
	n     : 698774
 */





class Booleana{
	private static String palavra; //armazenar o texto ao fazer as modificacoes
	public  static int ponteiro = 0; //usado para navegar como um seek pela funcao
	public  static int[] operadores = new int[3]; // arranjo de operandos (maximo de operando e' 3.

	/**
		Constructor da classe Booleana
	 */
	public Booleana(){ //constructor da classe
		palavra = "";
		ponteiro = 0;
	}


	static int verNot (){
		int result;
		ponteiro += 4;
		result = lerExpressao();
		if ( ponteiro == 1){ //testing the result of not
			result = 0;

		} else { 
			result = 1; 
		}
		ponteiro++;
		return result;

	}

	static int verOr(){
			int result;
		ponteiro += 3;
		result = lerExpressao(); // receiving the result from one of the operators A B C

		while( palavra.charAt(ponteiro) == ',' ) { //analynzing if have another operator

			ponteiro++; //junping to the other operator 
			int aux = lerExpressao(); 
			
			if( ( aux == 1 ) || ( result == 1) ) { //testing the result of or
				result = 1;
			} else {
				result = 0;
			}
		}		
		ponteiro++;
		return result;
	}





	/**setPalavra(String imput)
	 *
	 * Setar a string lida
	 *
	 * @param: String imput - string lida
	 * @return: nda
	 */
    void setPalavra(String imput){
		palavra = imput;
	}


	/**removeWhiteSpaces()

		Metodo para remover espacos em branco
	
		@param:  ...
		@return: ...
	 */
     static void removeWhiteSpaces(){
		String resp = ""; 
		for(int i=0; i < palavra.length(); i++ ){ 
			if(palavra.charAt(i) != ' '){ 
				resp += palavra.charAt(i);
			}
		}
		palavra = resp;
 	}


	/**int lerExpressao()

		Function used to analyze the Sting "palavra"
	
		@param:  ...
		@return: int result = the answer from the recursive analysis
	 */
	static int lerExpressao() {

		int result = 0; 
		int aux = 0; 
		char letra = palavra.charAt(ponteiro);
		//defining the variables
		for(; ponteiro < palavra.length();){
			if ( letra == 'A' ) { //first operator
				result = operadores[0];
				ponteiro++;
			
			} else if ( letra == 'B' ) { //second operator
				result = operadores[1];
				ponteiro++;
		
			} else if ( letra == 'C' ) { //third operator
				result = operadores[2];
				ponteiro++;
	
			} else if ( letra == 'n') {	// analyzing the operator NOT
				result = verNot();
			
			} else if ( letra == 'o' ) { // analynzing the operator OR
				result = verOr();
			} else if ( letra ==  'a' ) { //analynzing the operator AND
				result = verAnd();
			}				
		}
		ponteiro++;

		return (result);
	}
}

							
class algebra{	

	public static void main(String[] args){

		Booleana interpreter = new Booleana();
		int i;

		i = MyIO.readInt();
		while( i != 0 ){
			interpreter.ponteiro = 0;

			for(int n = 0; i > n; n++ ){ //passando o for para ler cada operador
				interpreter.operadores[n] = MyIO.readInt(); 
			}

			interpreter.setPalavra(MyIO.readLine());//lendo o resto da palavra ( and(or(A , B) , not(and(B , C)))

			interpreter.removeWhiteSpaces();//removendo os espacos vazios

			MyIO.println("" + interpreter.lerExpressao()); //recebendo e mostrando a resposta

			i = MyIO.readInt();
		}
	}
}