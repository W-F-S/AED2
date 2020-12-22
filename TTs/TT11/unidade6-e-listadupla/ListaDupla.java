class ListaDupla{

	private CelulaDupla primeiro, ultimo;
	public ListaDupla(){
		primeiro = new CelulaDupla();
		ultimo = primeiro;
	}

	public void inserirInicio(int x){
		CelulaDupla tmp = new CelulaDupla(x);
		tmp.ant = primeiro;
		tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if(primeiro == ultimo){
			ultimo = tmp;
		} else {
			tmp.prox.ant = tmp;
		}
	}

	public void inserirFim(int x){
		ultimo.prox = new CelulaDupla(x);
		ultimo.prox.ant = ultimo;
		ultimo = ultimo.prox;
	}

	public int removerInicio() throws Exception {
		if(primeiro == ultimo){
			throw new Exception("Erro, lista vazia!");
		}
		CelulaDupla tmp = primeiro;
		primeiro = primeiro.prox;
		int resp = primeiro.elemento;
		tmp.prox = primeiro.ant = null;
		tmp = null;
		return resp;
	}

	public int removerFim() throws Exception {
		if(primeiro == ultimo){
			throw new Exception("Erro, lista vazia!");
		}
		int resp = ultimo.elemento;
		ultimo = ultimo.ant;
		ultimo.prox.ant = null;
		ultimo.prox = null;
		return resp;
	}

	public void inserir(int x, int pos) throws Exception{
		int tamanho = tamanho();
    	        if(pos < 0 || pos > tamanho){
			throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
      		} else if (pos == 0){
	        	inserirInicio(x);
      		} else if (pos == tamanho){
         		inserirFim(x);
      		} else {
         		CelulaDupla i = primeiro;
         		for(int j = 0; j < pos; j++, i = i.prox);
	       	 	CelulaDupla tmp = new CelulaDupla(x);
        	 	tmp.ant = i;
		        tmp.prox = i.prox;
		        tmp.ant.prox = tmp.prox.ant = tmp;
	        	tmp = i = null;
      	}}

	public int remover(int pos) throws Exception {
      		int resp;
	      	int tamanho = tamanho();
		if (primeiro == ultimo){
			throw new Exception("Erro ao remover (vazia)!");
		} else if(pos < 0 || pos >= tamanho){
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
      		} else if (pos == 0){
		         resp = removerInicio();
      		} else if (pos == tamanho - 1){
         		 resp = removerFim();
	        } else {
		        CelulaDupla i = primeiro.prox;
	                for(int j = 0; j < pos; j++, i = i.prox);	
	         	i.ant.prox = i.prox;
			i.prox.ant = i.ant;
		        resp = i.elemento;
		        i.prox = i.ant = null;
        		i = null;
      		}
		return resp;
	}

	public void mostrar(){
		System.out.print("\n[");
		for(CelulaDupla i = primeiro.prox; i!= null; i=i.prox){
			System.out.print(" "+i.elemento+",");
		}
		System.out.print(" ]\n");
	}

	public int tamanho(){
		int resp = 0;
		for(CelulaDupla i = primeiro.prox; i!= null; i=i.prox){
			resp++;
		}
		return resp;
	}

	public void inverter(){
		CelulaDupla i = primeiro.prox;
		CelulaDupla j = ultimo;
		while(i != j && i.prox != j ){
			int swap = i.elemento;
			i.elemento = j.elemento;
			j.elemento = swap;
			i = i.prox;
			j = j.ant;
		}
		i.ant = null;
		i = null;
		j.ant = null;
		j = null;
	}

}
