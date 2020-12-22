import java.util.Random;

class aleatorio{

	public static boolean fim(String palavra){
          return (palavra.length() >= 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M'); //verificação da palavra especial
     }

	private static String alteracao(String frase, char pri, char seg){
    
     	char[] letras = new char [frase.length()];//processo para modificar a string(sem o uso da funcao toCharArray)

		for(int i = 0; i < frase.length(); i++){ //passando cada letra para o array
     			letras[i] = frase.charAt(i);	
		}

		for(int i = 0; i < letras.length; i++){//fazendo as modificações
			if(letras[i] == pri){//se alguma letra for igual a var pri
				letras[i] = seg;//substituindo a letra
			}
		}
          frase = "";       

	     for(int i = 0; i < letras.length; i++){//concantenando as novas modificações na string vazia
			frase += letras[i];
		}
		return frase;
	}

	public static void main(String[] args){

    		String s = MyIO.readLine();

 		Random gerador = new Random();//definindo o rando,
          gerador.setSeed ( 4 );//definindo a seed --------------------------------------ERRO

          char pri;
          char seg;

		while(!fim(s)){

               pri = (char)('a' + (Math.abs(gerador.nextInt())%26));//caractere que vai ser apagado [g]
               seg = (char)('a' + (Math.abs(gerador.nextInt())%26));//caractere que vai substituir o que vai se apagado [m]
	          System.out.println( alteracao(s, pri, seg) );              
               s = MyIO.readLine();

		}
	}
}



