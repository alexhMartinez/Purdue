public class customers {
	int numItems;
	public customers() {
		numItems = 6;
	}

	public customers(int items) {
	int ClothingItems = items;
	
		if (ClothingItems == 0) {
			numItems = GetRandomNumber(20);
		}

		else {
			numItems = ClothingItems;
		}
	}

	public int getNumberOfItems() {
		return numItems;
	}

	public static int GetRandomNumber(int maxValue) {
		int x = 1 + (int) (Math.random() * maxValue );
		return x;
	}
}