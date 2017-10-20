import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

public class Mult {
	
	public List<Integer> mult(int coefficient, List<Integer> uneListedEntiers){
			if (uneListedEntiers instanceof RandomAccess) {
				return new AbstractList<Integer>(){
					@Override
					public Integer get(int index) {
						return uneListedEntiers.get(index)*coefficient;
					}
					@Override
					public int size() {
						// TODO Auto-generated method stub
						return 0;
					}
			};

			
		}
			else {
				//recopier tout le truc de la photo de kevin
				return null;
			}
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
