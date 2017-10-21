import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class Mult {

	public static List<Integer> mult(int coefficient, List<Integer> uneListedEntiers) {
		/*
		 * Soit la liste contient une implémentation de RandomAccess comme une
		 * ArrayList par exemple
		 * 
		 */
		if (uneListedEntiers instanceof RandomAccess) {
			/*
			 * Ici, on renvoie une AbstractList afin de ne pas allouer une
			 * nouvelle Liste qui coute bcp en mémoire. On appelle cette Liste
			 * une "VUE". On utilise le principe de la classe anonyme pour créer
			 * la vue
			 */
			return new AbstractList<Integer>() {
				@Override
				public Integer get(int index) {
					return uneListedEntiers.get(index) * coefficient;
				}

				@Override
				public int size() {
					// IL FAUDRAIT IMPLEMENTER LA METHODE
					return uneListedEntiers.size();
				}
			};

		}
		// CODE FOURNI PAR LE PROF PARCE QUE ULTRA CHAUD
		/*
		 * Soit RandomAccess n'est pas implémenté (comme pour une LinkedList),
		 * on ne peut pas accéder à get(i) rapidement. On va utiliser une
		 * AbstractSequentialList qui ne nécessite pas d'implémenter get(i)
		 */
		return new AbstractSequentialList<Integer>() {

			@Override
			public ListIterator<Integer> listIterator(int index) {
				return new ListIterator<Integer>() {
					ListIterator<Integer> li = uneListedEntiers.listIterator(index);

					@Override
					public boolean hasNext() {
						return li.hasNext();
					}

					@Override
					public Integer next() {
						return li.next() * coefficient;
					}

					@Override
					public boolean hasPrevious() {
						// Askip on implemente pas
						throw new UnsupportedOperationException();

					}

					@Override
					public Integer previous() {
						// Askip on implemente pas
						throw new UnsupportedOperationException();

					}

					@Override
					public int nextIndex() {
						return li.nextIndex();
					}

					@Override
					public int previousIndex() {
						// Askip on implemente pas
						throw new UnsupportedOperationException();
					}

					@Override
					public void remove() {
						// Askip on implemente pas
						throw new UnsupportedOperationException();

					}

					@Override
					public void set(Integer e) {
						// Askip on implemente pas
						throw new UnsupportedOperationException();

					}

					@Override
					public void add(Integer e) {
						throw new UnsupportedOperationException();

					}
				};
			}

			@Override
			public int size() {
				// IL FAUDRAIT IMPLEMENTER LA METHODE
				return uneListedEntiers.size();
			}

		};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < 1000000; i++) {
			al.add(i);
		}
		long t0 = System.nanoTime();
		List<Integer> ret = Mult.mult(2, al);
		long sum = 0;
		for (int val : ret) {
			sum += val / 2;
		}
		System.out.println((System.nanoTime() - t0));
		LinkedList<Integer> ll = new LinkedList<>();
		for (int i = 0; i < 1000000; i++) {
			ll.add(i);
		}
		t0 = System.nanoTime();
		sum = 0;
		ret = Mult.mult(2, ll);
		for (int val : ret) {
			sum += val / 2;
		}
		System.out.println((System.nanoTime() - t0));

	}

}
