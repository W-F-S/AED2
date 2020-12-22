class all {

    public static int[] array = new int[3];
    public static String entrada = " ";
    public static int i = 0;

    /**
    * 
    * 
    */
    public static String retirar(String entrada, int i) {
        String nova = " ";

        if (i < entrada.length()) {
            char letra = entrada.charAt(i);

            if (letra != ' ') {
                nova = letra + retirar(entrada, i + 1);
            } else {
                nova = retirar(entrada, i + 1);
            }
        }
        return nova;
    }

    /**
    * 
    */
    public static int interpretador() {
        int result = 0;
        int aux = 0;//2 1 1 and(not(A), B)

        if (entrada.charAt(i) == 'A') {
            result = array[0];
            i++;
            MyIO.println("O resultado do A:" + result);
        }

        else if (entrada.charAt(i) == 'B'){
            result = array[1];
            i++;
            MyIO.println("O resultado do B:" + result);
        }

        else if (entrada.charAt(i) == 'C'){
            result = array[2];
            i++;
            MyIO.println("O resultado do C:" + result);
        }
        //3 0 0 0 or(and(A,B,C),and(A,not(B),C),and(not(A),not(B),C),and(not(A),not(B),not(C)))
        else if (entrada.charAt(i) == 'n') {
            i+=4;
            result = interpretador();


            MyIO.println("O not esta lendo: "+entrada.charAt(i));
            
            if (result == 1){
                result = 0;
            }else{
                result = 1;
            }
            i++;
            MyIO.println("O resultado do not: "+result);
        }
        else if (entrada.charAt(i) == 'a') {
            i+=4;
            result = interpretador();
            
            MyIO.println("O and esta lendo: "+entrada.charAt(i));
            while (entrada.charAt(i) == ',') {
                i++;
                aux = interpretador();

                if( (result == 1) && (aux == 1) ) {
                    result = 1;
                } else {
                    result = 0;
                }
               
            }
            MyIO.println("O resultado do and: "+result);
            
        } else if (entrada.charAt(i) == 'o') {
            i += 3;

            result = interpretador();
                MyIO.println("O or esta lendo: "+entrada.charAt(i));
            while (entrada.charAt(i) == ',') {
                i++;
                aux = interpretador();

                if ((result == 1) || (aux == 1)) {
                    result = 1;
                } else {
                    result = 0;
                }
            }
            i++;
            MyIO.println("O resultado do or: "+result);
        }

        return result;
    }

    public static void main(String[] args) {
        int numeroOperadores = 0;
        numeroOperadores = MyIO.readInt();

        while (numeroOperadores != 0) {

            for (int i = 0; i < numeroOperadores; i++) {
                array[i] = MyIO.readInt();
            }

            entrada = MyIO.readLine();

            entrada = retirar(entrada, 0);

            MyIO.println(interpretador());

            numeroOperadores = MyIO.readInt();
        }

    }
}
