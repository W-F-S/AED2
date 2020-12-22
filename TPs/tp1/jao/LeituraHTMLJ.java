import java.io.*;
import java.net.*;

class LeituraHTMLJ {
    /** Método para verificar se a string no parametro é ou não igual a fim.
    * @param ent - string a ser verificada.
    * @return    - retorna as caracteristicas da palavra fim ( tamanho e letras ).
    */
    public static boolean isFim(String ent){
        return (ent.length() >= 3 && ent.charAt(0) == 'F' && ent.charAt(1) == 'I' && ent.charAt(2) == 'M');
    }

    /** Método para contar os elementos indicados no HTML, apartir de uma url
    * @param endereco     - URL do site para contar os elementos
    * @param nomeDaPagina - Nome da página em questão ( para verificar se não é igual a fim - condição de parada ). 
    */
    public static void contarHTML(String endereco, String nomeDaPagina) throws Exception{

        // Definindo Variaveis para contar os elementos.
        int a = 0, e = 0, i = 0, o = 0, u = 0, aa = 0, ee = 0, ii = 0, oo = 0, uu = 0, acrase = 0, ecrase = 0, 
            icrase = 0, ocrase = 0, ucrase = 0, atil = 0, otil = 0, acircun = 0, ecircun = 0, icircun = 0, 
            ocircun = 0, ucircun = 0;

        int consoante = 0;
        int br = 0;
        int table = 0;
        URL url;

        String html = "", line;

        url = new URL(endereco);
        InputStream is = url.openStream();
        BufferedReader getHTML = new BufferedReader(new InputStreamReader(is));

        // Concatenando em HTML todo o conteudo da pagina lida.
        while((line = getHTML.readLine()) != null){
            html += line + "\n";
        }

        // Contando os elementos.
        for(int j = 0; j < html.length(); j++){

            if(html.charAt(j) == 'a')
                a++;

            else if(html.charAt(j) == 'e')
                e++;

            else if(html.charAt(j) == 'i')
                i++;

            else if(html.charAt(j) == 'o')
                o++;

            else if(html.charAt(j) == 'u')
                u++;

            else if(html.charAt(j) == (char) (225))
                aa++;

            else if(html.charAt(j) == (char) (233))
                ee++;

            else if(html.charAt(j) == (char) (237))
                ii++;

            else if(html.charAt(j) == (char) (243))
                oo++;

            else if(html.charAt(j) == (char) (250))
                uu++;

            else if(html.charAt(j) == (char) (224))
                acrase++;

            else if(html.charAt(j) == (char) (232))
                ecrase++;

            else if(html.charAt(j) == (char) (236))
                icrase++;

            else if(html.charAt(j) == (char) (242))
                ocrase++;

            else if(html.charAt(j) == (char) (249))
                ucrase++;

            else if(html.charAt(j) == (char) (227))
                atil++;

            else if(html.charAt(j) == (char) (245))
                otil++;

            else if(html.charAt(j) == (char) (226))
                acircun++;

            else if(html.charAt(j) == (char) (234))
                ecircun++;

            else if(html.charAt(j) == (char) (238))
                icircun++;
            
            else if(html.charAt(j) == (char) (244))
                ocircun++;

            else if(html.charAt(j) == (char) (251))
                ucircun++;

            else if(('a' <= html.charAt(j) && html.charAt(j) <= 'z'))
                consoante++; // As outras letras (vogais) ja foram checadas

            else if(html.charAt(j) == '<'){
                if(html.charAt(j + 1) == 'b' && html.charAt(j + 2) == 'r' 
                    && html.charAt(j + 3) == '>'){
                        br++;
                        j += 4; // Continuando o j.
                }

                else if(html.charAt(j + 1) == 't' && html.charAt(j + 2) == 'a' && html.charAt(j + 3) == 'b' 
                        && html.charAt(j + 4) == 'l' && html.charAt(j + 5) == 'e' 
                        && html.charAt(j + 6) == '>'){
                        
                            table ++;
                            j += 7; // Continunando o j.
                }
            }

        }

        // Printando o resultado de cada variavel e o nome da pagina ( pub.out ).
        MyIO.println("a(" +a+ ") " + "e(" +e+ ") " + "i(" +i+ ") " + "o(" +o+ ") " + "u(" +u+ ") " + "á(" +aa+ ") " 
                    + "é(" +ee+ ") " + "í(" +ii+ ") " + "ó(" +oo+ ") " + "ú(" +uu+ ") " + "à(" +acrase+ ") " + "è(" +ecrase+ ") " 
                    + "ì(" +icrase+ ") " + "ò(" +ocrase+ ") " + "ù(" +ucrase+ ") " + "ã(" +atil+ ") " + "õ(" +otil+ ") " 
                    + "â(" +acircun+ ") " + "ê(" +ecircun+ ") " + "î(" +icircun+ ") " + "ô(" +ocircun+ ") " + "û(" +ucircun+ ") " 
                    + "consoante(" +consoante+ ") " + "<br>(" +br+ ") " + "<table>(" +table+ ") " +nomeDaPagina);

    }

    public static void main(String[] args) throws Exception{
        String nomeSite;
        String url;

        do {
            nomeSite = MyIO.readLine();
            // Verificando se a palavra não é igual a fim ( condição de parada ).
            if(isFim(nomeSite) == false){
                url      = MyIO.readString();
                contarHTML(url, nomeSite);
            }
        } while(isFim(nomeSite) == false);
    }
}
