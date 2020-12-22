/**
 * @author Walker Freitas dos Santos - 698774
 * @version 1 06/10/2020
 */

/**
 * Seja nossa Fila, faça um método que retorne o maior elemento contido na
 * mesma
 * exercicio02, pg 27, slide06c
 */

class exercicio02{
    public static void main(String[] args){
        try{
            Fila fila = new Fila();
            int x;
            fila.inserir(-11);
            fila.inserir(22);
            fila.inserir(3333333);
            fila.inserir(4);
            System.out.print("\n--Fila--\n");
            fila.mostrar();
            x = fila.getMaior();
            System.out.print("\nMaior elemento: "+x+"\n"); 
        } catch(Exception e){
            System.out.print("\n"+ e +"\n");
            e.printStackTrace();
        }
    }
}
