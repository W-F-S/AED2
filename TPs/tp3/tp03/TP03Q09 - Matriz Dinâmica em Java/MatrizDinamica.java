

class Celula {
	public int elemento;
	public Celula inf, sup, esq, dir;

	public Celula(){
		this.(int elemento, null, null, null, null);
	}

	public Celula(Jogador elemento){
		this(elemento, null, null, null, null);
	}

	public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
		this.elemento = elemento;
		this.inf = inf;
		this.sup = sup;
		this.esq = esq;
		this.dir = dir;
	}
}


class Matriz {
   private Celula inicio = new Celula();
   private int linha, coluna;

   public Matriz (){
      Matriz(3, 3);
   }

   public Matriz (int linha, int coluna){
	   
        this.linha = linha;
        this.coluna = coluna;
	int contC = 1, contL=1//0 ja criado
	
	for(Celula j = inicio; contC < coluna; j = j.dir, contC++){ //fazer a primeira coluna
		j.dir = new Celula();	
		j.dir.esq = j.dir;
	}
	contC = 0;
	for(Celula i = inicio.inf; contL<linha; i = i.inf, conLt++){//fazer as linhas
		for(Celula j = i; contC < coluna; j = j.dir, contC++){//rel
			j.dir = new Celula();
			j.dir.esq = j.dir;
		}
	}
        //alocar a matriz com this.linha linhas e this.coluna colunas
   }

   public Celula getCell(int linh, int col){
   	Celula resp;
	
	for(Celula i = inicio.inf; linh>0; i = i.inf, conLt++);//fazer as linhas}
	for(Celula j = i;   col>0; j = j.dir, contC++){//rel
		j.dir = new Celula();
		j.dir.esq = j.dir;
	}

   }

   public inserirMatriz(int linh, int col, int elem){
	int contC 0; int contL = 0;
	Celula j;
   	for(Celula i = inicio; contL<linh; i = i.inf, contL++);
	for(j = i; contC < col; j = j.dir, contC++);
	j.elemento = elem;
   }

   public Matriz soma (Matriz m) {
      Matriz resp = null;
      int respL = respC = 0;
      if(this.linha == m.linha && this.coluna == m.coluna){
         resp = new Matriz(this.linha, this.coluna);
         for(){
            for(){
               //sendo c (pont em resp), a (em this) e b (em m)
               c.elemento = a.elemento + b.elemento;
            }
         }
         //...
      }
      return resp;
   }

   public Matriz multiplicacao (Matriz m) {
      Matriz resp = null;

      if(){
         //...
      }

      return resp;
   }

   public boolean isQuadrada(){
      boolean (this.linha == this.coluna);
   }

   public void mostrarDiagonalPrincipal (){
      if(isQuadrada() == true){

      }
   }

   public void mostrarDiagonalSecundaria (){
      if(isQuadrada() == true){
      }
   }
}


class MatrizDinaminca(){
	public static void main(String[] args){try{
		int n = l = c = 0;
		n = MyIO.readInt();
		while(n > 0){
			l = MyIO.readInt();	
			c = MyIO.readInt();	
					
			while(l > 0){
				while()
			
			}
			

			n--;	
		}
	}catch(Exception e){
		System.out.print("\nErro: \n");
		e.printStackTrace();
	}}
}
