/**
 * Walker Freitas dos Santos
 * 698774
 * @version 2 16/10/2020
 */

/**
 * Faça um método que inverta a ordem dos elementos da lista dupla. 
 * No exemplo abaixo, após a inversão, os elementos ficarão na ordem crescente
 *
 * exercicio01, pg 32, unidade: 6e
 */
class exercicio01{
	public static void main(String[] args){
		ListaDupla listaDupla = new ListaDupla();
		listaDupla.inserirFim(5);
		listaDupla.inserirFim(4);
		listaDupla.inserirFim(3);
		listaDupla.inserirFim(2);
		listaDupla.inserirFim(1);
		System.out.print("\n--Lista Antes--");
		listaDupla.mostrar();
		System.out.print("--Lista Invertida--");
		listaDupla.inverter();
		listaDupla.mostrar();
	}
}
