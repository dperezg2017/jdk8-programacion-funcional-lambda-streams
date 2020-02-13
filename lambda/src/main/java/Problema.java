import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problema {
	
	public static void main (String[] args) {
		List<String> nombres = Arrays.asList("cortocortocorto", "medianomediano", "largo");
		List<Integer> numeros = Arrays.asList(5,7,1,6,3,4,2);

		Comparator<String> comparadorLongitud = (o1, o2) -> o1.length() - o2.length();
		Comparator<Integer> ordenaNumero = (o1,o2) -> o1.compareTo(o2);

		Collections.sort(nombres,comparadorLongitud);
		Collections.sort(numeros,ordenaNumero);
		Collections.reverse(numeros);

		System.out.println(nombres);
		System.out.println(numeros);
	}

}
