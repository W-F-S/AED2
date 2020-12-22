class e07{


     public static String cripto(String letra){
          //c = (k+n) k = deslocamento, n = letra, c = texto criptografado

          String s = "";
          int cript = 0;
        
          for(int i = 0; i < (letra.length()); i++ ){//peguei o tamanho do array -1 
               char teste = letra.charAt(i); //pegando o char o array atual                   
               
               if(teste == 10){//ver se ele tem um espaco
                    s += "\n";          

               }else if(teste == 32){//ver se ele tem um espaco
                    s += ' ';
           
               }else if( 'A' <= teste && teste <= 'Z'){//ver se e' maiuscula e escrever em mauiculo
                    cript = (teste+3);
                    if (cript>90)
                         cript = (90 - cript);

                    s += (char)cript;
 
               }else if( 'a' <= teste && teste <= 'z'){                   
                    cript = (teste+3);
                    if (cript> 122)
                         cript = (122 - cript);

                    s += (char)cript;
               }               
          }          
          s += "\n";
          return s;
     }

 	public static void lerArq(String FILE){
	
		Arq.openRead(FILE);
          String ent = "";

		while(Arq.hasNext() == true)
			ent = ent + Arq.readLine() + '\n';                    
		
          System.out.print("\n"+ent+"\n");
          ent = cripto(ent);
          System.out.print("\n"+ent+"\n");
	     //Arq.print(ent.toString());
		Arq.close();
	}

     public static void main(String[] args){
          lerArq(MyIO.readLine());
     }
}

