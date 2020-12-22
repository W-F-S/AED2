/**
 * @author Walker Freitas dos Santos - 698774
 * @version 1 06/10/2020
 */

/**
 * Seja nossa Fila, faça um método que soma o conteúdo dos elementos
 * contidos na mesma
 * exercicio04, pg 31, slide06c
 */

class exercicio04{
    public static void main(String[] args){
        try{
            Fila fila = new Fila();
            int x;
            fila.inserir(-11);
            fila.inserir(22);
            fila.inserir(3333);
            fila.inserir(4);
            System.out.print("--Fila--\n");
            fila.mostrar();
            x = fila.somElementos();
            System.out.print("\nSoma dos elementos: " + x + "\n");
        } catch(Exception e){
            System.out.print("\n"+ e +"\n");
            e.printStackTrace();
        }
    }
}
