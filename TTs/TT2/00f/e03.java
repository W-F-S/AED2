class e03{


	public static void lerArq(String FILE){
		Arq.openRead(FILE);
		String str = "";
		while(Arq.hasNext() == true){
			str = Arq.readLine();
			System.out.printf("\n"+str);
			
		}
		Arq.close();
			
	}



	public static void main (String[] args){
		
		lerArq(MyIO.readLine());
	}

}
