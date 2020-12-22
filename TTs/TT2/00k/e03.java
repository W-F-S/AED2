class e03{


	
		public static void main(String[] args) {
			try {
				Integer i = new Integer(args[0]);
				MyIO.println("A variável i vale " + i);
			} catch (NumberFormatException e) {
				MyIO.println("Erro de formatação!!! ");
			} catch (ArrayIndexOutOfBoundsException e){
				MyIO.println("Erro na passagem de parâmetros!!!");
			} finally {
				MyIO.println("FIM DE PROGRAMA!!!");
			}
		}
	
}

/* O programa retorna o coteudo do "try" caso passarmos um numero como parametro
 * , caso passarmos uma string por exemplo, o programa retornará  o conteudo do segundo catch
 *
 * por fim. caso não passarmos nada como parametro, será executado o algoritmo contido no segundo catch
 */
