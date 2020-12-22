class Principal {
   public static void main (String[] args) throws Exception {
      ArvoreTrie arv = new ArvoreTrie();

      String array[] = new String[8];
      array[0] = "BBBB";
      array[1] = "AAAAA";
      array[2] = "EEEEE";
      array[3] = "FFFFF";
      array[4] = "calo";
      array[5] = "RRRRR";
      array[6] = "wato";
      array[7] = "CCCCC";

      for(int i = 0; i < array.length; i++){
         arv.inserir(array[i]);
      }
      arv.mostrar();/**
      for(int i = 0; i < array.length; i++){
         System.out.println("Pesquisar(" + array[i] + "):" + arv.pesquisar(array[i]));
         System.out.println("PesquisarI(" + array[i] + "):" + arv.pesquisarI(array[i]));
      }

      String s = "ABACA";
      System.out.println("Pesquisar(" + s + "):" + arv.pesquisar(s));
      System.out.println("PesquisarI(" + s + "):" + arv.pesquisar(s));

      s = "ABACAXIS";
      System.out.println("Pesquisar(" + s + "):" + arv.pesquisar(s));
      System.out.println("PesquisarI(" + s + "):" + arv.pesquisar(s));

      s = "gaga";
      System.out.println("Pesquisar(" + s + "):" + arv.pesquisar(s));
      System.out.println("PesquisarI(" + s + "):" + arv.pesquisar(s));*/
      
   }
}
