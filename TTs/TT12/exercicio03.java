/**
 * walker freitas dos santos
 * 698774
 * @version 1.0


/**
Faça um método que retorne o número de elementos pares existentes na
árvore.*/

class exercicio03{



	public static void main(String[] args){try{
		ArvoreBinaria tree = new ArvoreBinaria();
		int x = 0;
		tree.inserir(2);
		tree.inserir(4);
		tree.inserir(3);
		tree.inserir(8);
		x = tree.pares();
		System.out.print("\nX: "+x+"\n");
	
	
	}catch(Exception e){
		System.out.print(e);
	}}
}
