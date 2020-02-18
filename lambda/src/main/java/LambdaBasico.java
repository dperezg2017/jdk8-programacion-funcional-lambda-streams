import service.LambdaService;

public class LambdaBasico {

	public static void main (String[] args) {


		System.out.println(devuelve5());
	}


    /** Devuelve una implemtacion de constante que siempre devuelve 5 */
    static LambdaService devuelve5() {
        return ()-> 5;
    }

}
