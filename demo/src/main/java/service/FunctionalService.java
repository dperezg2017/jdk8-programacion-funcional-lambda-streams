package service;

@FunctionalInterface
public interface FunctionalService {

    int suma(int a, int b);
    default int suma (int a, int b, int c){
        return suma(a,suma(a,b));
    }

    static int suma3(int a, int b, int c){
        return 1;
    }
}
