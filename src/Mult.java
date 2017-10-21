import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class Mult {

	public List<Integer> mult(int coefficient, List<Integer> uneListedEntiers) {
		/*
		 * Soit la liste contient une implémentation de RandomAccess comme une
		 * ArrayList par exemple
		 * 
		 */
		if (uneListedEntiers instanceof RandomAccess) {
			return new AbstractList<Integer>() {
				@Override
				public Integer get(int index) {
					return uneListedEntiers.get(index) * coefficient;
				}

				@Override
				public int size() {
					// TODO Auto-generated method stub
					return 0;
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
						TODO();
						return false;
					}

					@Override
					public Integer previous() {
						TODO();
						return null;
					}

					@Override
					public int nextIndex() {
						return li.nextIndex();
					}

					@Override
					public int previousIndex() {
						TODO();
						return 0;
					}

					@Override
					public void remove() {
						TODO();

					}

					@Override
					public void set(Integer e) {
						TODO();

					}

					@Override
					public void add(Integer e) {
						throw new UnsupportedOperationException();

					}
				};
			}

			@Override
			public int size() {
				TODO();
				return 0;
			}

		};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
