/*
 *
 *  Pesquisar e implementar uma solução recursiva para o problema das Torres de Hanói, dado o número de pinos(189
 *
 * The objective of the puzzle is to move the entire stack to another rod, obeying the following simple rules:
 
    Only one disk can be moved at a time.
    Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack or on an empty rod.
    No larger disk may be placed on top of a smaller disk.


   The minimal number of moves required to solve a Tower of Hanoi puzzle is 2(n) − 1, where n is the number of disks. 
*/


class e12{




     public static void doTowers(int topN, char from, char inter, char to) {
           if (topN == 1) {
              System.out.println("Disk 1 from " + from + " to " + to);
           } else {
              doTowers(topN - 1, from, to, inter);
              System.out.println("Disk " + topN + " from " + from + " to " + to);
              doTowers(topN - 1, inter, from, to);
           }
     }


	public static void main(int arg){
		

		int resp = 2

		
		doTowers( resp, 'A', 'B', 'C' );
	
	}

}
