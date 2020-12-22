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
    static int movimentacoesLog = 0;
    static double tempoExecucao = 0;
    
    /** Metodo para pegar a maior altura do array de player.
     * @param player - Arranjo de jogadores para procurar a maior altura.
     * @param tam    - Tamanho do arranjo.
     * @return       - Maior altura.
     */
d    static int getMaior(Jogador[] player, int tam){
        int maior = player[0].getAltura();
        movimentacoesLog++;
    
        for(int i = 1; i < tam; i++){
            if(maior < player[i].getAltura()){
                maior = player[i].getAltura();
                comparacoesLog++;
            }
        }
        return(maior);
    }
    
    /** Metodo de Ordenação (CountingSort) para ordenação mediante altura.
     * @param player - Arranjo de Jogadores para ordenação.
     * @param tam    - Tamanho do Arranjo.
     */
    public void countingSort(Jogador[] player, int tam){
        int maior = (getMaior(player, tam)) + 1;
        Jogador[] array  = new Jogador[maior];
        Jogador[] output = new Jogador[tam];
        
        for(int i = 0; i < maior; i++){
            array[i] = new Jogador();
        }

        // Inicializando as posições de array.
        for(int i = 0; i < maior; array[i].setAltura(0), i++){
            movimentacoesLog++;
        }

        // array[i] contem o numero de elementos iguais a i.
        for(int i = 0; i < tam; array[player[i].getAltura()].altura++, i++){
            movimentacoesLog++;
        }

        // Agora, array[i] contem o numero de elementos menores ou iguais a i.
        for(int i = 1; i < array.length; array[i].altura += array[i - 1].getAltura(), i++);
        
        // Ordenando
        for(int i = tam - 1; i >= 0; output[array[player[i].getAltura()].altura - 1] = player[i].clonar(), array[player[i].getAltura()].altura--, i--);

        // Copiando para o array original
        for(int i = 0; i < tam; player[i] = output[i].clonar(), i++);
    }

    public void insertionSort(Jogador[] player, int n){
        for(int i = 1; i < n; i++){
            Jogador temp = player[i];
            int j = i - 1;
            while(j >= 0 &&  player[j].getAltura() == temp.getAltura() 
                         && player[j].getNome().compareTo(temp.getNome()) > 0 ){
                        player[j + 1] = player[j];
                        j--;
                  }

            player[j + 1] = temp;
        }
    }
}

class Q11CountingSort{
    public static void main(String[] args){
        Jogador[] temp;
        Jogador[] player = new Jogador[1000];
        String entrada   = " ";
        int i = 0;

        temp = Jogador.ler();

        entrada = MyIO.readLine();

        while(entrada.equals("FIM") == false){
            // Construindo Jogadores somente com valores da entrada
            player[i] = temp[Integer.parseInt(entrada)];
            entrada = MyIO.readLine();
            i++;
        }

        player[0].countingSort(player, i);
        player[0].insertionSort(player, i);

        for(int j = 0; j < i; j++){
            player[j].imprimir();
        }
    }
    
}


    

