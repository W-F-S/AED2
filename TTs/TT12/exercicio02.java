
/**
 * @author: Walker Freitas dos Santos 
 * Matricula: 698774
 * @version: 1.0_24/10/2020
 */

/**
 * Faça um método que retorne a soma dos elementos existentes na árvore
 */
class exercicio02{

        public static void main(String[] args){try{
                ArvoreBinaria tree = new ArvoreBinaria();
		int x = 0;
		tree.inserir(1);
		tree.inserir(2);
		tree.inserir(3);
		tree.inserir(4);
		tree.inserir(5);
		tree.inserir(6);
		tree.inserir(7);
		x = tree.soma();
		System.out.print("\nsoma: "+x+"\n");

	}catch(Exception e){
                System.out.print(e);
        }}
}

