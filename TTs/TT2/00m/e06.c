//159

int main(int argc, char *argv[]) {
     FILE *p = fopen (“teste.txt”, “r”);
     char str[100+1];
     char* resp;
     if (p != NULL) {
          do {
               resp = fgets(str, 100, p);
               if (resp != NULL) { printf(“%s\n”, str); }
          } while (resp != NULL);
          fclose(p);
     }
     return 0;
}
