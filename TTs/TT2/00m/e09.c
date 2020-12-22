//167


int main(int argc, char *argv[]) {
     FILE *in = fopen (“teste.txt”, “rb”),
     *out = fopen (“copia.txt”, “wb”);
     while ( ! feof(in) ) {
          char ch = getc(in);
          if ( ! feof(in)) putc(ch, out);
     }
     fclose(in);
     fclose(out);
     return 0;
}
