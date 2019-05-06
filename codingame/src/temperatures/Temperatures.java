package temperatures;

public class Temperatures {

	public int closestTemperatures(int[] temperatures) {
		int result = temperatures[0];

		for (int i = 0; i < temperatures.length; i++) {
			if (Math.abs(result) >= Math.abs(temperatures[i])) {
				if (Math.abs(result) == Math.abs(temperatures[i])) {
					if (temperatures[i] == result) {
						// Nothing to do
					} else {
						// One is positive and the other is negative
						if (temperatures[i] < result) {
							// result is positive and temperatures[i] is
							// negative then nothing to do

							/**
							 * If two numbers are equally close to zero,
							 * positive integer has to be considered closest to
							 * zero (for instance, if the temperatures are -5
							 * and 5, then display 5).
							 **/
						}

						if (temperatures[i] > result) {
							result = temperatures[i];
						}
					}
				}

				if (Math.abs(result) > Math.abs(temperatures[i])) {
					result = temperatures[i];
				}
			}

			if (Math.abs(result) < Math.abs(temperatures[i])) {
				// Nothing to do because result is closest to 0
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Temperatures t = new Temperatures();

		int[] ints = { -9, 14, 37, 102 };

		System.out.println(t.closestTemperatures(ints));

	}

}
