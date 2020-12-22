import java.lang.*;

/**
 * @author: Walker Freitas dos Santos 
 * Matricula: 698774
 * @version: 1.0_24/10/2020
 */

/**
 * Faça um método que retorna a altura da árvore. 
 * Em seguida, insira vários elementos de forma aleatória. 
 * Para cada inserção, mostre na tela o número de elementos da árvore, 
 * o logaritmo (base 2) desse número e a altura
 */

class exercicio01{
	public static void mostrar(ArvoreBinaria tree){	
		int altura = 0, nElementos = 0;
		double log = 0;

	        altura = tree.altura();
		nElementos = tree.nElementos();
		log = Math.log(nElementos);
		System.out.print("\nAltura: "+altura+"\nnElementos: "+nElementos+"\nlog: "+log+"\n");
	}

	public static void main(String[] args){try{
		ArvoreBinaria tree = new ArvoreBinaria();
		int altura = 0, nElementos = 0;
		double log = 0;

		tree.inserir(5);
		System.out.print("\nnumero inserido: 5");
		mostrar(tree);

		tree.inserir(2);	
		System.out.print("\nnumero inserido: 2");
		mostrar(tree);

		tree.inserir(4);
		System.out.print("\nnumero inserido: 5");		
		mostrar(tree);

		tree.inserir(25);	
		System.out.print("\nnumero inserido: 25");
		mostrar(tree);

		tree.inserir(0);
		System.out.print("\nnumero inserido: 0");
		mostrar(tree);

		tree.inserir(7);
		System.out.print("\nnumero inserido: 7");
		mostrar(tree);
		
		tree.inserir(22);
		System.out.print("\nnumero inserido: 7");
		mostrar(tree);

		tree.inserir(89);
		System.out.print("\nnumero inserido: 89");
		mostrar(tree);
		
		tree.inserir(1);
		System.out.print("\nnumero inserido: 1\n");
		mostrar(tree);

	}catch(Exception e){
		System.out.print(e);
	}}
}
