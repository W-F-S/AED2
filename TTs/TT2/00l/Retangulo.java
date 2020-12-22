import java.lang.Math;
import java.io.*;
import java.nio.charset.*;


class Retangulo{
	int base;
	int altura;

	public Retangulo(){

	}

	public Retangulo(int x, int y){
		base   = x;
		altura = y;
	}

	public int getArea(){
		return (base * altura);
	}

	public int getPerimetro(){
		return 2*(base+altura);	
	}

	public double getDiagonal(){
		return Math.srqt(Math.pow(base, base) * Math.pow(altura, altura));
	}



}
