//slide 15
//um aluno desenvolveu o codigo abaixo, corrija-o

boolean isConsoante(String s, int i){
    boolean resp= true;
    if (i == s.length()){
        resp = true;
    } else if (isConsoante(s.charAt(i)) == false){
        resp = false;
    } else {
        resp = isConsoante(s, i + 1);
    }
    return resp;
}
