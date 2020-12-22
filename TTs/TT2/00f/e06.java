class e06{
	public static void lerArq(String FILE, String FILE2){
	
		Arq.openRead(FILE);
          StringBuilder ent = new StringBuilder();
          
		while(Arq.hasNext() == true){
			ent.append(Arq.readLine() + "\n");
                              
		}
          ent = ent.reverse();
          System.out.print("\n"+ent+"\n");
		Arq.close();
		Arq.openWrite(FILE2);
		Arq.print(ent.toString());
		Arq.close();
	}

	public static void main (String[] args){
		lerArq(MyIO.readLine(), MyIO.readLine());
	}
}
