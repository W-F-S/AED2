/**
	Author = Walker Freitas dos Santos 
	n      = 698774

 */


import java.io.*;

class arq{

	public static void main(String[] args) throws Exception {

		RandomAccessFile file = new RandomAccessFile("num.txt", "rw"); 
		int n = MyIO.readInt(); //amount of data
		double j; //data reading 
		//defining the variables
		
			for(int i = 0; i < (n); i++){//reading and writing responses
				j = MyIO.readDouble();
				file.writeDouble(j);
			}	
			file.close();
			file = new RandomAccessFile("num.txt", "rw");
			
			for(n--; n >= 0; n--){
				file.seek(n * 8); //as the number of bits decreases, reader-pointer starts to read from de end to beginning
				j = file.readDouble();

				if((j - (int) j) > 0  ){
					MyIO.println(j);
				}else{
					MyIO.println((int)j);

				}
			}
			//a medida que o n de bits do seek diminui, passamos a ler o arquivo ao contrario
			file.close();//fechando os arquivos

	}	
}
