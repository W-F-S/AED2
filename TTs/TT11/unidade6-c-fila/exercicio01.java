/**
 * @author Walker Freitas dos Santos - 698774
 * @version 1 06/10/2020
 */

/**
 * Nosso método remover remove fisicamente o nó cabeça e faz com que a
 * célula do três seja a cabeça. Como o alteramos para que ele remova
 * fisicamente a célula do três ?
 * 
 * exercicio01, pg 24, slide06c
 */

class exercicio01 {
    public static void main(String[] args){
        try{
            Fila fila = new Fila();
            fila.inserir(3);
            fila.inserir(5);
            fila.inserir(7);
            System.out.print("\n--Antes da remoção--\n");
            fila.mostrar();
            fila.remover();
            System.out.print("\n--Depois da remoção--\n");
            fila.mostrar();
        } catch (Exception e){
            System.out.print("\n"+ e +"\n");
            e.printStackTrace();
        }
    }
}
