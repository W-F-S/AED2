

class Celula {
	public int elemento;
	public Celula inf, sup, esq, dir;

	public Celula(){
		this(0, null, null, null, null);
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
	int contC = 1, contL=1;//0 ja criado
	
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
	
	for(Celula i = inicio.inf; linh>0; i = i.inf, conLt++);//{fazer as linhas}
	for(Celula j = i;   col>0; j = j.dir, contC++){//rel
		j.dir = new Celula();
		j.dir.esq = j.dir;
	}
   }


   public void inserirMatriz(int linh, int col, int elem){
	int contC = 0; int contL = 0;
	Celula j;
   	for(Celula i = inicio; contL<linh; i = i.inf, contL++);
	for(j = i; contC < col; j = j.dir, contC++);
	j.elemento = elem;
   }

   public Matriz analise(){
 	Matriz resp = new Matriz(this.linha, this.coluna);
	Celula o = resp.inicio; Celula i = inicio;
	Celula k; Celula j;
	int resp2 = 0;

	for(; contL<linha; o = o.inf, i = i.inf, conLt++){//fazer as linhas
		for(j = i, k = o; contC < coluna; k = k.dir, j = j.dir, contC++){//rel
			if(j.elemento == 1){
				o.elemento = 9;
			}
			if(j.elemento == 0){
				if(o.dir != null)
					resp2 += o.dir;   

				if(o.esq != null)
					resp2 += o.esq;   

				if(o.inf != null)
					resp2 += o.inf;   

				if(o.sup != null)
					resp2 += o.sup;   

				o.elemento = resp2;
			}
		}
	}
	return resp;
   }

   public void mostrar(Matriz foo){
	
 	for(Celula i = inicio; contL<linha; i = i.inf, conLt++){//fazer as linhas
		for(Celula j = i; contC < coluna; j = j.dir, contC++){//rel
			System.out.print(j.elemento);
		}
		System.out.print("\n");
	}  	
   }
}

class Pao {
	public static void main(String[] args){try{
		int n = l = c = 0;
		String lido;
		Matriz doo;
		lido = MyIO.readString();

		while(!lido.equals("FIM")){
			n = MyIO.readInt();
			doo = new Matriz( Integer.parseInt(lido), n );

			while(n > 0){
				l = MyIO.readInt();	
				c = MyIO.readInt();	
						
				while(l > 0){
					while(c > 0){
						doo.inserirMatriz(MyIO.readInt());
						c--;
					}
					l--;
				}
				n--;	
			}
		}
	}catch(Exception e){
		System.out.print("\nErro: \n");
		e.printStackTrace();
	}}
}
