
public class LinearProbingMap<Key, Value> implements Map<Key,Value> {
	private class Entry<Key, Value> {
		public Key key;
		public Value value;
	
		public Entry(Key k, Value v) {
			this.key = k;
			this.value = v;
		}
	}
	
	private int keyValue;
	private int hashSize;
	
	private Entry<Key,Value>[] entries;
	
	public LinearProbingMap() {
		this(997);
	}
	
	public LinearProbingMap(int M) {
		this.keyValue = 0;
		this.hashSize = M;
		
		
		entries = new Entry[M];
	}
	
	@Override
	public void put(Key key, Value val) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Value get(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Key key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Key key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<Key> keys() {
		// TODO Auto-generated method stub
		return null;
	}

}
