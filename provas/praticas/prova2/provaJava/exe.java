import java.util.Scanner;


//--------------------------------------------------------------------------
class No {
	public String elemento; // Conteudo do no.
          public int num;
	public No esq, dir;  // Filhos da esq e dir.
          public boolean assacinado;

	
	public No(String elemento) {
		this(elemento, null, null);
	}

	public No(String elemento, No esq, No dir) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
                num = 1;
		assacinado = false;
               
	}
}

//--------------------------------------------------------------------------
class Arvore {
	private No raiz; 

	public Arvore() {
		raiz = null;
	}

	public void pesquisar(String x) {
		pesquisar(x, raiz);
	}

	private void pesquisar(String x, No i) {
		if (i == null) {//String nao existe
                        inserir(x, 0);
	
		} else if (x.equals(i.elemento) && !(i.assacinado)) {
			i.num++;
				
		}else if (x.compareTo(i.elemento) < 0) {//arvore a esquerda
			pesquisar(x, i.esq);

		} else {
		        pesquisar(x, i.dir);
		}
	}

	public void pesquisarAssacinado(String x) {
		pesquisar(x, raiz);
	}

	private void pesquisarAssacinado(String x, No i) {
		if (i == null) {//String nao existe
	           	            
		} else if (x.equals(i.elemento) && i.assacinado == false) {
			i.assacinado = true;
			
		} else if (x.compareTo(i.elemento) < 0) {//arvore a esquerda
			pesquisarAssacinado(x, i.esq);

		} else {
			pesquisarAssacinado(x, i.dir);
		}
	}

	public void inserir(String x) {
		raiz = inserir(x, raiz);
	}

	private No inserir(String x, No i) {
		if (i == null) {//insere caso nao exista
			i = new No(x);
			if(d != 0){
				i.assacinado = false;	
			}

		} else if (x.compareTo(i.elemento) < 0) {//proxima arvore a esquerda
			i.esq = inserir(x, i.esq, d);

		} else if (x.compareTo(i.elemento) > 0) {
			i.dir = inserir(x, i.dir, d);

		} 
		return i;
	}

	public void mostrar(){
		mostrar(raiz);
	}

	private void mostrar(No no){
		if(no != null){
			if(no.esq != null){
				mostrar(no.esq);
			}	

                       	if(no.assacinado == false){
                        	System.out.println(no.elemento + " " + no.num );
			}

			if(no.dir != null){
				mostrar(no.dir);
			}
		}
	}
}



class exe{
         	public static void main(String[] args){
		String l = new String();
		Arvore arvore = new Arvore();

                MyIO.println("HALL OF MURDERERS");
		

		//inserindo jogadores
		
		l = MyIO.readString();
                while(!l.equals("FIM")){
			MyIO.println(l);
			arvore.pesquisar(l);
          		l = MyIO.readString();
			MyIO.println(l);
			arvore.pesquisarAssacinado(l);
          		l = MyIO.readString();
		}
		
		arvore.mostrar();

	}

}

