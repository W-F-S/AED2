#include "stdio.h"
#include "stdlib.h"

/** 
 * Author = Walker Freitas dos Santos
 * n      = 698774
 */


/**
 * function to read and write in files
 * 
 * @param: int n : number of data to be read
 * @return: ...
 */
void ler_arq( int n )
{
	FILE* arq = fopen( "num.txt", "wb");//opening the file as a binary
	double nums = 0; 

	for(int i = 0; i < n; i++)
	{
		scanf( "%lf", &nums );
		fwrite( &nums, sizeof(double), 1, arq); //writing data as a binary 
	}

	fclose(arq);
	arq = fopen("num.txt", "rb"); 
	int i = n;

	for (int i = 1; i <= n ; i++)                                       
	{
		fseek(arq, -(i * sizeof(double)), SEEK_END );//if we start shifting(the offset) from negative to positive we read the file as a backwards
		fread( &nums, sizeof(double), 1, arq);
		printf("%g\n", nums);                                  
	}                                                                   
	fclose(arq);
}

int main()
{
	int n = 0;
	scanf("%d", &n);
	ler_arq( n );
}
