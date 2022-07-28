import java.util.Random;
import java.util.stream.IntStream;

public class ArrayBuilder {

	public static int[] Generate(int size) {
		return IntStream.generate(() -> new Random().nextInt(size)).limit(size).toArray();
	}
}
