/**
 * @author Walker Freitas dos Santos - 698774
 * @version 1 06/10/2020
 */

/**
 * Seja nossa Fila, faça um método para mostrar o terceiro elemento supondo
 * que o mesmo existe   
 * exercicio03, pg 29, slide06c
 */

class exercicio03{
    public static void main(String[] args){
        try{
            Fila fila = new Fila();
            int x;
            fila.inserir(-11);
            fila.inserir(22);
            fila.inserir(99);
            fila.inserir(4);
            System.out.print("--Fila--\n");
            fila.mostrar();
            x = fila.tercElemento();
            System.out.print("\nElemento [3]: " + x + "\n");
        } catch(Exception e){
            System.out.print("\n"+ e +"\n");
            e.printStackTrace();
        }
    }
}
