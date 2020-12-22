/**

    Aluno: Walker Freitas dos Santos
    n: 698774

 */



import java.io.*;
import java.net.*;

class ht{
    /**setPalavra(String imput)
	 *
	 * Setar a string lida
	 *
	 * @param: String imput - string lida
	 * @return: nda
	 */
    public static boolean fim (String imput){
        return(imput.length() >= 3 && imput.charAt(0) == 'F' && imput.charAt(1) == 'I' && imput.charAt(2) == 'M');
    }

    /**
        Metodo para contar quantos determinados caracteres especiais existem em um texto
    
        @param: string endereco: texto a ser lido e analisado
                string titulo: titulo do texto que vai ser mostrado ao final do programa

        @retun: nda
     */
    public static void vRurl( String endereco, String titulo ){
        URL url;
        int i = 0;
        int consoantes = 0;
        int br = 0, table = 0;
        int[] vogais = new int[22];
// 0       4   5        9  10        14   15 16   17       21             
// a e i o u | á é í ó  ú | à  è ì ò  ù |  ã õ |  â ê î ô  û |  
        while(endereco.length() > i){

            if(endereco.charAt(i) == 'a')
                vogais[0]++;

            else if (endereco.charAt(i) == 'e')
                vogais[1]++;
            
            else if (endereco.charAt(i) == 'i')
                vogais[2]++;
            
            else if (endereco.charAt(i) == 'o')
                vogais[3]++;
            
            else if (endereco.charAt(i) == 'u')
                vogais[4]++;

            else if (endereco.charAt(i) == (char) 225){
                vogais[5]++;

            }else if (endereco.charAt(i) == (char) 233)
                vogais[6]++;

            else if (endereco.charAt(i) == (char)  237)
                vogais[7]++;
            
            else if (endereco.charAt(i) == (char)  243)
                vogais[8]++;

            else if (endereco.charAt(i) == (char) 250)
                vogais[9]++;

            else if (endereco.charAt(i) == (char) 224)
                vogais[10]++;

            else if (endereco.charAt(i) == (char) 232)
                vogais[11]++;

            else if (endereco.charAt(i) == (char) 236)
                vogais[12]++;

            else if (endereco.charAt(i) == (char) 242)
                vogais[13]++;
        
            else if (endereco.charAt(i) == (char) 249)
                vogais[14]++;

            else if (endereco.charAt(i) == (char) 227)
                vogais[15]++;
            
            else if (endereco.charAt(i) == (char) 245)
                vogais[16]++;

            else if (endereco.charAt(i) == (char) 226)
                vogais[17]++;

            else if (endereco.charAt(i) == (char) 234)
                vogais[18]++;

            else if (endereco.charAt(i) == (char) 238)
                vogais[19]++;

            else if (endereco.charAt(i) == (char) 244)
                vogais[20]++;

            else if (endereco.charAt(i) == (char) 251)
                vogais[21]++;

            else if (endereco.charAt(i) >= 'a' && endereco.charAt(i) <= 'z' )
                consoantes++;

            else if (endereco.charAt(i) == '<' && endereco.charAt(i+2) == 'b' && endereco.charAt(i+3) == 'r' && endereco.charAt(i+4) == '>'){
                br++;
                i+=4;

            }else if(endereco.charAt(i) == '<' && endereco.charAt(i+1) == 't' && endereco.charAt(i+2) == 'a' && endereco.charAt(i+3) == 'b' 
                        && endereco.charAt(i+4) == 'l' && endereco.charAt(i+5) == 'e' 
                        && endereco.charAt(i+6) == '>'){
                table++;
                i+=6;
            }
            i++;  
        }
            // 0       4   5        9  10        14   15 16   17       21             
            // a e i o u | á é í ó  ú | à  è ì ò  ù |  ã õ |  â ê î ô  û |  
        MyIO.println("a(" + vogais[0]  + 
                    ") e(" + vogais[1]  + 
                    ") i(" + vogais[2]  + 
                    ") o(" + vogais[3]  + 
                    ") u(" + vogais[4]  +
                    ") á(" + vogais[5]  + 
                    ") é(" + vogais[6]  + 
                    ") í(" + vogais[7]  + 
                    ") ó(" + vogais[8]  +  
                    ") ú(" + vogais[9]  + 
                    ") à(" + vogais[10] +  
                    ") è(" + vogais[11] + 
                    ") ì(" + vogais[12] + 
                    ") ò(" + vogais[13] +  
                    ") ù(" + vogais[14] + 
                    ") ã(" + vogais[15] + 
                    ") õ(" + vogais[16] + 
                    ") â(" + vogais[17] + 
                    ") ê(" + vogais[18] + 
                    ") î(" + vogais[19] + 
                    ") ô(" + vogais[20] + 
                    ") û(" + vogais[21] + 
                    ") consoante(" + consoantes + 
                    ") <br>(" + br         + 
                    ") <table>(" + table      + 
                    ") " + titulo); 
        
    }




     /**
        Metodo para pegar o codigo html de um certo link passado por parametro
    
        @param: string endereco: link a ser analisado
                
        @retun: String resp: string contendo todo o codigo do html
     */
    public static String getHtml(String endereco){

        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;
        try {

            url = new URL(endereco);
            is = url.openStream();
            br = new BufferedReader (new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }

        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } 

        try {
            is.close();
        } catch (IOException ioe) {
            // nothing to see here
        }
        return resp;
    }

    public static void main(String[] args) throws Exception {
        String local, endereco, titulo;
           titulo = MyIO.readLine();
        while(!fim(titulo)){
            endereco = MyIO.readLine();
            endereco = getHtml(endereco);
            vRurl(endereco, titulo);
            titulo = MyIO.readLine();
        }
    }
} 
