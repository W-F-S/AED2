/*(6)
 * O que acontece quando executamos o comando java 
 * TratamentoExcecao02 palavra?
 */



class e02{
	
	public static void main (String[] args){
		try{
			Integer i = new Integer(args[0]);
			MyIO.println("A variavel i vale" + i);
		
		} catch (ArrayIndexOutOfBoundsException e){
			MyIO.println("Erro na passagem de parâmetros!!!");
		} finally {
			MyIO.println("FIM DE PROGRAMA!!!");
		}
	}
}

/*O programa vai escrever a mensagem "Erro na passagem de parametros!!!"
 * pois o catch vai substituir a mensagem de erro padrão por uma ação pre-definida
 */
