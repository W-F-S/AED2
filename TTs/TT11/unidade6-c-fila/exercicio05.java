/**
 * @author Walker Freitas dos Santos - 698774
 * @version 2 12/10/2020
 */

/**
 * Seja nossa Fila, faça um método que inverta a ordem dos seus elementos
 * exercicio05, pg 33, slide06c
 */

class exercicio05{
    public static void main(String[] args){
        try{
            Fila fila = new Fila();
            int x;      
            fila.inserir(3);
            fila.inserir(5);
            fila.inserir(7);
            fila.inserir(8);
            fila.inserir(10);
            fila.inserir(2);
            fila.inserir(55);
            fila.inserir(12);
            fila.inserir(3);
            fila.inserir(5);
            fila.inserir(7);
            fila.inserir(8);
            fila.inserir(10);
            fila.inserir(22);
            System.out.print("--Fila--\n");
            fila.mostrar();
            fila.inverter();      
            System.out.print("\n--Fila--\n");
            fila.mostrar();
        } catch(Exception e){
            System.out.print("\n"+ e +"\n");
            e.printStackTrace();
        }
    }
}
