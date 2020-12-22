//153

int main(int argc, char *argv[]) {
     FILE *p = fopen (“teste.txt”, “r”);
     int ch;
     if (p != NULL) {
          do {
               ch = fgetc(p);
               printf( “%c”, (char)ch);
          } while (ch != EOF);
          fclose(p);
     }
     return 0;
}
