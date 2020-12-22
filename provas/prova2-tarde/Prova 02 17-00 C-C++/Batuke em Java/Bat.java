
class Celula {
	public int elemento;
	public Celula inf, sup, esq, dir;

	public Celula(){
		this(0, null, null, null, null);
	}

	public Celula(int elemento){
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


   public Matriz(int linha, int coluna){
	   
        this.linha = linha;
        this.coluna = coluna;
	int contC = 1, contL=1, cont2 = 1;//0 ja criado
	
	for(Celula j = inicio; contC < coluna; j = j.dir, contC++, cont2++){ //fazer a primeira coluna
		j.dir = new Celula(cont2);	
		j.dir.esq = j.dir;
	}
	contC = 0;
	for(Celula i = inicio.inf; contL<linha; i = i.inf, contL++){//fazer as linhas
		for(Celula j = i; contC < coluna; j = j.dir, contC++, cont2++){//rel
			j.dir = new Celula(cont2);
			j.dir.esq = j.dir;
		}
	}
        //alocar a matriz com this.linha linhas e this.coluna colunas
   }

   public void mostrar(){
	int contL = 0; int contC = 0;
 	for(Celula i = inicio; contL< linha; i = i.inf, contL++){//fazer as linhas
		for(Celula j = i; contC < coluna; j = j.dir, contC++){//rel
			System.out.print(j.elemento);
		}
		System.out.print("\n");
	}  	
   }   
   public Celula getCell(int linh, int col){
   	Celula resp;

	for(Celula i = inicio.inf; linh>0; i = i.inf, conLt++);
	for(Celula j = i;   col>0; j = j.dir, contC++);
	return resp;
   }

   public int andar(int l, int c){
	int contL = 0; int contC = 0;
	Celula i; Celula j; 
	Celula tmp;
	boolean resp;
// 	for( i = inicio; contL< linha; i = i.inf, contL++);
// 	for( j = i; contC< coluna; j = j.inf, contC++);

	while(cont > 0){

			for(int i = 0; i < dir && resp; i++){
				c++;
				tmp = getCell(l, c);
				if(tmp != null){
					MyIO.print(tmp.elemento + " ");
					cont--;
				}
				if(cont <= 0) resp = false;
				else quant++;
			}
			dir += 2;

			for(int i = 0; i < bai && resp; i++){
				l++;
				tmp = getCell(l, c);
				if(tmp != null){
					MyIO.print(tmp.elemento + " " );
					cont--;
				}
				if(cont <= 0) resp = false;
				else quant++;
			}
			bai += 2;

			for(int i = 0; i < esq && resp; i++){
				c--;
				tmp = getCell(l, c);
				if(tmp != null){
					MyIO.print(tmp.elemento + " " );
					cont--;
				}
				if(cont <= 0) resp = false;
				else quant++;
			}
			esq += 2;

			for(int i = 0; i < cim && resp; i++){
				l--;
				tmp = getCell(l, c);
				if(tmp != null){
					MyIO.print(tmp.elemento + " ");
					cont--;
				}
				if(cont <= 0) resp = false;
				else quant++;
			}
			cim += 2;
		}//end while
	}


	while (){
		k = dir
	
	
	}
	return resp
   }
}

class Bat {
	public static void main(String[] args){
		int n = 0, f = 0, c = 0;
	
		Matriz doo;
		n = MyIO.readInt();
        	doo = new Matriz( n, n );
		f = MyIO.readInt();
		c = MyIO.readInt();
		
	}
}
