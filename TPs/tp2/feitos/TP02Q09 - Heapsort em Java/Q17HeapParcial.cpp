/*
    Aluno:     João Pedro Lobato
    Matricula: 699531

    Q14 - TP02 - Ordenação por Radixsort, sendo a chave de pesquisa o ID.
*/

// Lista de Dependencias
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

#define MAX_SIZE 120
#define PLAYER_SIZE 4000

/* Struct com atributos de Jogadores */
typedef struct
{
    int id;
    char *nome;
    int altura;
    int peso;
    int anoNascimento;
    char *universidade;
    char *cidadeNascimento;
    char *estadoNascimento;
} Jogador;

/* Variaveis Globais para o Arquivo de Logs */
int comparacoesLog = 0;
int movimentacoesLog = 0;

/** Metodo para Ler do arquivo "/tmp/players.csv" e atribuir valores as variaveis da struct, mediante uso de strsep.
 * @param player   - Struct para acessar os atributos dos jogadores.
 * @param linhas   - Contador de Linhas (Ou tamanho de um array).
 */
void ler(Jogador *player, int linhas)
{
    FILE *arquivo = fopen("/tmp/players.csv", "r");
    // Strings para leitura e separar em virgulas.
    char *jogador = (char *)calloc(MAX_SIZE, sizeof(char));
    char *semVirgula = (char *)calloc(MAX_SIZE, sizeof(char));
    int contador = 0;

    if (arquivo != NULL)
    {
        // Descartando a primeira linha
        fgets(jogador, MAX_SIZE, arquivo);

        while (contador < linhas)
        {
            fgets(jogador, MAX_SIZE, arquivo);
            semVirgula = strdup(jogador);

            // Tratando \n do strsep
            semVirgula[strlen(semVirgula) - 1] = ',';

            // Atoi para valores inteiros e strsep para limitar entre virgulas.
            player[contador].id               = atoi(strsep(&semVirgula, ","));
            player[contador].nome             = strsep(&semVirgula, ",");
            player[contador].altura           = atoi(strsep(&semVirgula, ","));
            player[contador].peso             = atoi(strsep(&semVirgula, ","));
            player[contador].universidade     = strsep(&semVirgula, ",");
            player[contador].anoNascimento    = atoi(strsep(&semVirgula, ","));
            player[contador].cidadeNascimento = strsep(&semVirgula, ",");
            player[contador].estadoNascimento = strsep(&semVirgula, ",");

            // Tratando possiveis valores nulos de acordo com o tamanho ( ", ," ).
            if (strlen(player[contador].universidade) <= 2)
            {
                player[contador].universidade = strdup("nao informado");
            }
            if (strlen(player[contador].cidadeNascimento) <= 2)
            {
                player[contador].cidadeNascimento = strdup("nao informado");
            }
            if (strlen(player[contador].estadoNascimento) <= 2)
            {
                player[contador].estadoNascimento = strdup("nao informado");
            }

            contador++;
        }
        fclose(arquivo);
    }
    else
    {
        printf("\nArquivo Inexistente\n");
    }
} // end ler

/** Método para Imprimir valores da Struct Jogador mediante a leitura anterior.
 * @param indice  - Indice (ID) de cada variavel para a impressão.
 * @param Jogador - Struct para pegar os valores de Jogador.
 */
void imprimir(int indice, Jogador *player)
{
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", player[indice].id, player[indice].nome, player[indice].altura,
           player[indice].peso, player[indice].anoNascimento,
           player[indice].universidade, player[indice].cidadeNascimento,
           player[indice].estadoNascimento);
} // end imprimir


/** Metodo Para trocar a posição dos jogadores (Struct) mediante a ordem dos nomes em selecoaRecursiva.
 * @param player1 - Struct de jogador para troca.
 * @param player2 - Struct de jogador para troca.
 */
void swap(Jogador *player1, Jogador *player2)
{
    Jogador temp = *player1;
    *player1     = *player2;
    *player2     = temp;
}

// void swap2(Jogador *player1, int i, int j)
// {
//     Jogador temp = &player1;
// }

/**
 * 
 */
void constroi(Jogador *player, int tamHeap)
{
    for(int i = tamHeap; (i > 1  && player[i].altura > player[i / 2].altura) 
                                 || (player[i].altura == player[i / 2].altura 
                                 && strcmp(player[i].nome, player[i / 2].nome) > 0); i /= 2)
    {
        // printf("ALT DE I = %d > %d\n", player[i].altura, player[i / 2].altura);
        swap(&player[i], &player[i / 2]);
        // printf("ALT DE I = %d > %d\n\n", player[i].altura, player[i / 2].altura);
    }
}

/**
 * 
 */
int getMaiorFilho(Jogador *player, int i, int tamHeap)
{
    int filho;

    if((2 * i == tamHeap  || player[2 * i].altura > player[2 * i + 1].altura)
                          || (player[2 * i].altura == player[2 * i + 1].altura
                          && strcmp(player[i * 2].nome, player[i * 2 + 1].nome) > 0))
    {
        filho = 2 * i;
    }
    else
    {
        filho = 2 * i + 1;
    }
    return filho;
}

/**
 * 
 */
void reconstroi(Jogador *player, int tamHeap)
{
    int i = 1;
    while(i <= (tamHeap / 2))
    {
        int filho = getMaiorFilho(player, i, tamHeap);
        if((player[i].altura < player[filho].altura) 
            || (player[i].altura == player[filho].altura 
            && strcmp(player[i].nome, player[filho].nome) < 0))
        {
            swap(&player[i], &player[filho]);
            i = filho;
        }
        else
        {
            i = tamHeap;
        }
    }
}

// void reconstroi(Jogador *player, int esq, int dir)
// {
//     int i = esq;
//     int j = 0;
// }

//  void Refaz(TipoIndice Esq, TipoIndice Dir, TipoItem *A)
// { TipoIndice i = Esq;
//  int j;
//  TipoItem x;
//  j = i * 2;
//  x = A[i];
//  while (j <= Dir)
//  { if (j < Dir)
//  { if (A[j].Chave < A[j+1].Chave)
//  j++;
//  }
//  if (x.Chave >= A[j].Chave) goto L999;
//  A[i] = A[j];
//  i = j; j = i * 2;
//  }
//  L999: A[i] = x;
//  }

/**
 * 
 * 
 */
// void heapSort(Jogador *player, int tam, int k)
// {
//     // Alterando o valor e ignorando a posicao zero.
//     Jogador arrayTmp[tam + 1];
//     for(int i = 0; i < tam; i++)
//     {
//         arrayTmp[i + 1] = player[i];
//     }

//     // Construção do Heap
//     for(int tamHeap = 2; tamHeap <= tam; tamHeap++)
//     {
//         constroi(arrayTmp, tamHeap);
//     }

//     for(int i = k + 1; i <= tam; i++)
//     {
//         if(player[i].altura < player[1].altura)
//         {
//             swap(&player[i], &player[1]);
//             reconstroi(player, k);
//         }
//     }

//     // Ordenação Propriamente.
//     int tamHeap = tam;
//     while(tamHeap > 1)
//     {
//         swap(&arrayTmp[1], &arrayTmp[tamHeap--]);
//         reconstroi(player, tamHeap);
//     }

//     // Alterar o vetor para voltar a posicao zero.
//     for(int i = 0; i < tam; i++)
//     {
//         player[i] = arrayTmp[i + 1];
//     }
// }

void heapSort2(Jogador *player, int tam, int k)
{
    // Construção do Heap
    for(int i = 2; i <= k; i++)
    {
        constroi(player, i);
    }

    for(int i = k + 1; i <= tam; i++)
    {   
        if((player[i].altura < player[1].altura) 
            || (player[i].altura == player[1].altura 
            && strcmp(player[i].nome, player[1].nome) < 0))
        {
            swap(&player[i], &player[1]);
            reconstroi(player, k);
        }
    }

    int tamHeap = tam;

    while(tamHeap > 1)
    {
        swap(&player[1], &player[tamHeap--]);
        reconstroi(player, tamHeap);
    }
}

int main()
{
    /* Duas Structs, uma para pegar todo o arquivo e outra para ordenar somente os IDS de entrada,
    para evitar conflitos e ordenar todo o arquivo e printar somente os IDS da entrada, resultando em uma ordem errada */
    Jogador *temp = (Jogador *)calloc(PLAYER_SIZE, sizeof(Jogador));
    Jogador *player = (Jogador *)calloc(PLAYER_SIZE, sizeof(Jogador));
    FILE *arquivoLog = fopen("699531_radixsort.txt", "wt");

    char *linha = (char *)calloc(MAX_SIZE, sizeof(char));
    int i = 0;
    int j = 2;
    clock_t tempo;

    // Lendo todo o arquivo players.csv e armazenando em jogadores temp.
    ler(temp, PLAYER_SIZE);

    // Lendo a primeira linha da entrada padrao.
    scanf("%s", linha);

    while (strcmp(linha, "FIM") != 0)
    {
        /* Struct de player será igual ao atoi da entrada (ID) da struct temp,
        assim serão armazenadas somente os valores da entrada (pub.in) para ordenação. */
        player[i] = temp[atoi(linha)];
        scanf("%s", linha);
        i++;
    }

    // Ordenando mediante ao ID e calculando tempo.
    heapSort2(player, i, 12);

    while (j < 12)
    {
        /* Imprimindo a struct players que foram armazenados somente os valores da entrada */
        imprimir(j, player);
        j++;
    }
}