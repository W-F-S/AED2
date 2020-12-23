

class Doidona{
	private int []tabT1;
	private int []tabT2;
	private int []tabT3;
	private Alvinegra []tabT4 = new Alvinegra[areaT4];
	private AVL arvore = new AVL();
	int areaT1;
	int areaT2;
	int areaT3;

	int areaT4;

	public Doidona(){
		for(int x = 0; x < areaT1; x++){
			tabT1[x] = -1;
		}

		for(int x = 0; x < areaT2; x++){
			tabT2[x] = -1;
		}

		for(int x = 0; x < areaT3; x++){
			tabT3[x] = -1;
		}

		for(int x = 0; x < areaT4; x++){
			tabT4[x] = new Alvinegra();
		}
	}

          public void mostrarArvore(ALV no){
                    
 		if(no != null){
			if(no.esq != null){
				mostrarArvore(no.esq);
			}	
			MyIO.println(no.elemento);
			if(no.dir != null){
				mostrarArvore(no.dir);
			}
		}
          }

          public void mostrarArvore(Alvinegra no){
                    
 		if(no != null){
			if(no.esq != null){
				mostrarArvore(no.esq);
			}	
			MyIO.println(no.elemento);
			if(no.dir != null){
				mostrarArvore(no.dir);
			}
		}
          }

          public void mostrar{
                    for(int i = 0; i < areaT1; i++){
                              MyIO.println(tabT1[i]);
                    }

                    for(int i = 0; i < areaT2, i++){
                              MyIO.println(tabT2[i]);
                    }

                    mostrarArvore(arvore.raiz); 
                    
                    for(int i = 0; i < areaT3 + 3, i++){
                              MyIO.println(tabT3[i]);
                    }

                    for(int i = 0; i < areaT4, i++){
                              mostrarArvore(tabT4[i].raiz);
                    }
          }

}
