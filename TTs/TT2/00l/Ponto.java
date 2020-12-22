class Ponto{

	private double x         ;
	private double y         ;
	private int    id     = 0;
	private int    nextID = 0;


	public Ponto(){
		x = 0;
		y = 0;
	}


	public Ponto( int x, int y){
		x = x;
		y = y;
	}

	//get X
	public double getX(){
		return x;
	}

	//set X
	public void setX(double num){
		x = num;
	}

	public double getY(){
		return y;
	}

	public void setY(double num){
		y = num;
	}


}
