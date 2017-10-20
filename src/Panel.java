import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

public class Panel {
	public static List<Integer> panel(int bornMin, int bornMax) {
		if (bornMax < bornMin) {
			throw new IllegalArgumentException();
		}
		else {
			return new AbstractList<Integer>() {
	
			@Override
			public Integer get(int index) {
				// TODO Auto-generated method stub
				return bornMin + index;
			}
	
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return bornMax - bornMin +1 ;
			}}
		;}
	}
	public static Iterator<Integer> panel1(int bornMin, int bornMax) {

		return new Iterator<Integer>() {

			int i = bornMin;

			@Override
			public boolean hasNext() {
				if (i <= bornMax) {
					return true;
				} else {
					return false;
				}
			}

			@Override
			public Integer next() {
				return i++;
			}
		};

	}

	public static Iterable<Integer> panel2(int bornMin, int bornMax) {

		return new Iterable<Integer>() {

			int i = bornMin;

			@Override
			public Iterator<Integer> iterator() {

				return panel1(bornMin, bornMax);
			}
		};

	}



	public static void main(String[] args) {
		// Ex 1
		Iterator<Integer> it = panel1(1, 5);

		for (; it.hasNext();)

			System.out.println(it.next()); // affiche 1 2 3 4 5

		// Ex2
		for (int i : panel2(1, 5))
			System.out.println(i);

		// Exo 3

		List<Integer> l = panel(3, 6);
		for (int i : l) {
			System.out.println(i);
			// affiche 3 4 5 6
		}

		System.out.println(l.get(1)); // affi

	}
}
