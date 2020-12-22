int main(int argc, char *argv[]) {
     FILE *p;
     double d;
     int i;
     long l;
     if ((p = fopen(“teste.txt”, “rb”)) == NULL) {
          printf (“\nArquivo nao pode ser aberto!!!”);
          exit(1);
     }
     fread(&d, sizeof(double), 1, p);
     fread (&i, sizeof(int), 1, p);
     fread (&l, sizeof(long), 1, p);
     printf("%f %d %ld", d, i, l);
     fclose(p);
     return 0;
}
