class e05{
	public static void lerArq(String FILE, String FILE2){
	
		Arq.openRead(FILE);
		String str = "";
		while(Arq.hasNext() == true){
			str += Arq.readLine();
               str += "\n";
               
		}
          str = str.toUpperCase();
		Arq.close();
		Arq.openWrite(FILE2);
		Arq.print(str);
		Arq.close();
	}

	public static void main (String[] args){
		lerArq(MyIO.readLine(), MyIO.readLine());
	}
}
