//slide 13
//faça um programa que abre um arquivo e cria uma copia

class ExemploArq03Exercicio {
    public static void main (String[] args){
        Arq.openRead("exemplo.txt");
        String str = "";
        while (Arq.hasNext() == true){
            str += Arq.readChar();
        }
        Arq.close();
        Arq.openWrite("copia.txt");
        Arq.print(str);
        Arq.close();
    }
}
