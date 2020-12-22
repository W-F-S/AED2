/**
 * @author Walker Freitas dos Santos - 698774
 * @version 1 12/10/2020
 */

/**
 * Implemente o método Celula toFila(Celula topo) que recebe o endereço de memória da primeira posição de uma pilha flexível e 
 * retorna o endereço de memória do nó cabeça de uma fila flexível contendo os elementos da pilha na ordem em que os mesmos foram inseridos na pilha. 
 * Seu método deve percorrer a pilha e inserir cada elemento da mesma na nova fila a retornada. 
 * A pilha não pode ser destruída.
 *
 * exercicio08, pg 38, slide06c
 */
class exercicio08{
    public static void main(String[] args){
        try{
            Fila fila = new Fila();
        	Pilha pilha = new Pilha();
            int x;    
            pilha.inserir(5);
            pilha.inserir(10);
            pilha.inserir(15);
            pilha.inserir(20);
            pilha.inserir(25);
            System.out.print("--Pilha--\n");
            pilha.mostrar();
        	System.out.print("--Fila--\n");
        	fila.setPrimeiro(pilha.toFila());
        	fila.mostrar();        
        } catch(Exception e){
            System.out.print("\n"+ e +"\n");
            e.printStackTrace();
        }
    }
}
