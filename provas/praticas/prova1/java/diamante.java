class Diamante{

    public static void contar(String string){
        n = string.length()
        int temp1 = 0;
        int resp = 0
        for (int x = 0; x<n; x++)
        {
            if(string.charAt(x) == '<'){
                temp1++;

            }else if(string.charAt(x) == '>' && temp1 > 0){
                temp1--;
                resp++;
            }    
        }
        return resp;
    }

    public static void main(String[] args){
            

    }

}
