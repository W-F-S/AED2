class e04 {
	public static void m1(String s) throws NumFormExc, ArrayIndexOutOfBoundsExc {
		Integer i = new Integer(args[0]); MyIO.println("A variável i vale " + i);
	}
	public static void m2(String s) throws NumberFormatException {
		Integer i = new Integer(args[0]); MyIO.println("A variável i vale " + i);
	}
	public static void main(String[] args) {
		try {
			m1(args[0]);
		} catch (NumberFormatException e) {
			MyIO.println("Erro!!!");
		} catch (ArrayIndexOutOfBoundsException e){ MyIO.println("Erro!!!");
		}
		MyIO.println("--- >>>>> <<<<< -----");
		try {
			m2(args[0]);
		} catch (NumberFormatException e) {
			MyIO.println("Erro!!! ");
		}
		MyIO.println("--- >>>>> <<<<< -----");
	}
}

