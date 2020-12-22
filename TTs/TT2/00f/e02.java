//leia o nome de um arquivo e uma frase e salve essa frase nesse arquivo

import java.io.*;

class e02{
    public static void lerArq( String FILE, String frase) throws Exception{
        RandomAccessFile txt = new RandomAccessFile( FILE, "rw");
       // System.out.println(frase);
        txt.writeChars(frase);
        txt.close();
    }


    public static void main (String[] args) throws Exception{

        lerArq( MyIO.readLine(), MyIO.readLine() );
    }
}
