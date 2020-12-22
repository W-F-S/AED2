/*
    Aluno:     Joao Pedro Lobato de Pinho
    Matricula: 699531

    Q11 - TP02 - Ordenação por Inserção em Java.

*/

import java.util.*;

class Jogador{

    // Definindo Atributos Privados de Jogadores.
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

    // Construtor de Jogador para valores iniciais.
    Jogador(){
        setID(0);
        setNome("");
        setAltura(0);
        setPeso(0);
        setUniversidade("");
        setAnoNascimento(0);
        setCidadeNascimento("");
        setEstadoNascimento("");
    }
    
    // Construtor com parametros.
    Jogador(int id, String nome, int altura, int peso, String universidade, int anoNascimento, String cidadeNascimento, String estadoNascimento){
        setID(id);
        setNome(nome);
        setAltura(altura);
        setPeso(peso);
        setUniversidade(universidade);
        setAnoNascimento(anoNascimento);
        setCidadeNascimento(cidadeNascimento);
        setEstadoNascimento(estadoNascimento);
    }

    /**
     * Metodo para Imprimir valores de cada Jogador lido.
    */
    void imprimir(){
        MyIO.println("["
                     + this.id + " ## " 
                     + this.nome + " ## "
                     + this.altura + " ## "
                     + this.peso + " ## "
                     + this.anoNascimento + " ## "
                     + this.universidade + " ## "
                     + this.cidadeNascimento + " ## "
                     + this.estadoNascimento +
                     "]");
    }
    
    /** Metodo para ler o arquivo "/tmp/players.csv" e localizar cada variável em um split de "," gerando sub arrays.
    * Dentro de um array de "Jogadores" os atributos de cada jogador é armazenado.
    */
    static Jogador[] ler(){
        Arq arquivoCSV;
        Arq.openRead("/tmp/players.csv");

        // Variaveis para transferir os valores lidos.
        String jogador = " "; // String lida.
        String[] semVirgula; // String com split sem as virgulas.
        int contador   = 0;
        int x          = 0;

        // Descartando a primeira linha.
        Arq.readLine();

        while(Arq.hasNext()){
            Arq.readLine();
            contador++;
        }

        Arq.close();

        // Criando um arranjo de jogadores.
        Jogador[] player = new Jogador[contador];

        Arq.openRead("/tmp/players.csv");

        // Descartando a primeira linha.
        Arq.readLine();

        while(x < contador){
            player[x] = new Jogador();

            jogador = Arq.readLine();
            semVirgula = jogador.split(",", 8);

            // Atribuindo linha lida a x.
            player[x].id                  = Integer.parseInt(semVirgula[0]);
            player[x].nome                = semVirgula[1];
            player[x].altura              = Integer.parseInt(semVirgula[2]);
            player[x].peso                = Integer.parseInt(semVirgula[3]);
            player[x].universidade        = semVirgula[4];
            player[x].anoNascimento       = Integer.parseInt(semVirgula[5]);
            player[x].cidadeNascimento    = semVirgula[6];
            player[x].estadoNascimento    = semVirgula[7];

            // Verificando valores que podem não ser informados.

            //if(semVirgula[0].contains("*")){
            //    player[x].nome = semVirgula[1].replace("*", "");
            // }
            if(semVirgula[4].equals("")){
                player[x].universidade = "nao informado";
            } else {
                player[x].universidade = semVirgula[4];
            }
            if(semVirgula[6].equals("")){
                player[x].cidadeNascimento = "nao informado";
            } else {
                player[x].cidadeNascimento = semVirgula[6];
            } 
            if(semVirgula[7].equals("")){
                player[x].estadoNascimento = "nao informado";
            } else {
                player[x].estadoNascimento = semVirgula[7];
            } 
            
            x++;
        }

        Arq.close();

        return (player);
    }

    /* Metodos Setters para Jogares */ 

    void setID(int id){
        this.id = id;
    }

    void setNome(String nome){
        this.nome = nome;
    }

    void setAltura(int altura){
        this.altura = altura;
    }

    void setPeso(int peso){
        this.peso = peso;
    }

    void setAnoNascimento(int anoNascimento){
        this.anoNascimento = anoNascimento;
    }

    void setUniversidade(String universidade){
        this.universidade = universidade;
    }

    void setCidadeNascimento(String cidadeNascimento){
        this.cidadeNascimento = cidadeNascimento;
    }

    void setEstadoNascimento(String estadoNascimento){
        this.estadoNascimento = estadoNascimento;
    }

    /* FIM Metodos Setters */

    /* Metodos Getters */
    int getID(){
        return this.id;
    }

    String getNome(){
        return this.nome;
    }

    int getAltura(){
        return this.altura;
    }

    int getPeso(){
        return this.peso;
    }

    int getAnoNascimento(){
        return this.anoNascimento;
    }

    String getUniversidade(){
        return this.universidade;
    }

    String getCidadeNascimento(){
        return this.cidadeNascimento;
    }

    String getEstadoNascimento(){
        return this.estadoNascimento;
    }

    /* FIM Metodos Getters */

    /* Metodo para Clonar os Atributos de Jogadores */
    Jogador clonar(){
        Jogador clonado = new Jogador();
        clonado.setID(this.getID());
        clonado.setNome(this.getNome());
        clonado.setAltura(this.getAltura());
        clonado.setPeso(this.getPeso());
        clonado.setUniversidade(this.getUniversidade());
        clonado.setAnoNascimento(this.getAnoNascimento());
        clonado.setCidadeNascimento(this.getCidadeNascimento());
        clonado.setEstadoNascimento(this.getEstadoNascimento());

        return clonado;
    }

    /* Variaveis Globais para o Log de Comparações */
    static int comparacoesLog   = 0;

}

class Q09HeapSort{
    /**
     * 
     */
    public static void swap(Jogador[] player1, int i, int j){
        Jogador temp   = player1[i];
        player1[i]     = player1[j];
        player1[j]     = temp;
    }

    public static void constroi(Jogador[] player, int tamHeap){
        for(int i = tamHeap; (i > 1 && ((player[i].getAltura() > player[i / 2].getAltura()) || 
                                        (player[i].getAltura() == player[i / 2].getAltura() && 
                                         player[i].getNome().compareTo(player[i / 2].getNome()) > 0))); i /= 2){
                                  swap(player, i, i / 2); 
                              }
    }

    public static int getMaiorFilho(Jogador[] player, int i, int tamHeap){
        int filho;

        if((2 * i == tamHeap) || (player[2 * i].getAltura() > player[2 * i + 1].getAltura() || 
                                  ((player[2 * i].getAltura() == player[2 * i + 1].getAltura()) && 
                                   (player[i * 2].getNome().compareTo(player[i * 2 + 1].getNome()) > 0)))){
               filho = 2 * i;
           } else {
               filho = 2 * i + 1;
           }

        return filho;
    }

    public static void reconstroi(Jogador[] player, int tamHeap){
        int i = 1;
        while(i <= (tamHeap / 2)){
            int filho = getMaiorFilho(player, i, tamHeap);
            if((player[i].getAltura() < player[filho].getAltura()) || (player[i].getAltura() == player[filho].getAltura() 
                                                                   && (player[i].getNome().compareTo(player[filho].getNome()) < 0))){
                   swap(player, i, filho);
                   i = filho; 
               } else {
                   i = tamHeap;
               }
        }
    }

    public static Jogador[] heapSort(Jogador[] player, int tam){
        // Alterar o vetor ignorando a posicao zero.

        Jogador[] tmp = new Jogador[tam + 1];

        for(int i = 0; i < tam; i++){
            tmp[i + 1] = new Jogador();
            tmp[i + 1] = player[i].clonar();
        }

        player = tmp;

        // Construcao do Heap.
        for(int tamHeap = 2; tamHeap <= tam; tamHeap++){
            constroi(player, tamHeap);
        }

        // Ordenação propriamente dita.
        int tamHeap = tam;
        while(tamHeap > 1){
            swap(player, 1, tamHeap--);
            reconstroi(player, tamHeap);
        }

        // Alterar o vetor para voltar a posicao zero.
        tmp = player;
        player = new Jogador[tam];
        for(int i = 0; i < tam; i++){
            player[i] = tmp[i + 1].clonar();
        }

        return player;
    }

    public static void main(String[] args){
        Jogador[] temp;
        Jogador[] player = new Jogador[1000];
        String entrada   = " ";
        int i = 0;
        int j = 0;

        temp = Jogador.ler();

        for(int x = 0; x < 1000; x++){
            player[x] = new Jogador();
        }
        entrada = MyIO.readLine();
        while(entrada.equals("FIM") == false){
            // Construindo Jogadores somente com valores da entrada
            player[i] = temp[Integer.parseInt(entrada)];
            entrada = MyIO.readLine();
            i++;
        }

        player = heapSort(player, i);

        while(j < i){
            player[j].imprimir();
            j++;
        }
    }
    
}


    

