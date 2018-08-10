import java.util.LinkedList;
import java.util.Queue;



public class TwoProbeChainMap<Key, Value> implements Map<Key, Value>{
    private int keyValueSize; // number of key-value pairs
    private int hashSize; // hash table size
	private class Entry<Key, Value> {
		public Key key;
		public Value value;
		
		public Entry(Key k, Value v) {
			this.key = k;
			this.value = v;
		}
		
		public Key getKey() {
			return this.key;
		}
		
		public void setKey(Key key) {
			this.key = key;
		}
		
		public Value getValue() {
			return this.value;
		}
		
		public void setValue(Value value) {
			this.value = value;
		}
	}
	private LinkedList<Entry>[] entries;
	
	public TwoProbeChainMap() {
		this(997);
	}
	
	public TwoProbeChainMap(int M) {
		this.keyValueSize = 0;
		this.hashSize = M;
		entries = new LinkedList[M];
		for(int i = 0; i < M; i++) 
			entries[i] = new LinkedList<>();
	}
	
//	private Key hash(Key key) {
//		
//	}
//	
//	private Key hash2(Key key) {
//		
//	}
	
	//private or public? 
    private int hash(Key k) //change to hash and hash2 if others aren't needed
    {
        return (k.hashCode() & 0x7FFFFFFF) % hashSize; 
    }
    private int hash2(Key k)
    {
        return (((k.hashCode() & 0x7FFFFFFF) % hashSize) * 31) % hashSize;
    }
	
	@Override
	public void put(Key key, Value val) {
//		boolean added = false;
//		for(Entry entry : entries[hash(key)]) {
//			if(key.hashCode() == entry.getKey().hashCode()) {
//				entry.value = val;
//				added = true;
//			}
//		}
//		
//		for(Entry entry : entries[hash2(key)]) {
//			if(key.hashCode() == entry.getKey().hashCode()) {
//				entry.value = val;
//				added = true;
//			}
//		}
//		
//		if(added) {
//			entries[hash2(key)].add(new Entry(key, val));
//			N++;
//		} else {
//			if(entries[hash(key)].size() < entries[hash2(key)].size()) {
//				entries[hash(key)].add(new Entry(key, val));
//				N++;
//			}
//		}
//		
//		int first = hash(key);
//		int second = hash2(key);
//		if(contains(key)) {
//			for(Entry e : entries[first]) {
//				if(key.hashCode() == e.getKey().hashCode()) {
//					e.setValue(val);
//					break;
//				}
//			}
//			
//			for(Entry e : entries[second]) {
//				if(key.hashCode() == e.getKey().hashCode()) {
//					e.setValue(val);
//					break;
//				}
//			}
//		}
//		else {
//			int result = 0;
//			if(entries[first].size() <= entries[second].size())
//				result = first;
//			else 
//				result = second;
//			entries[result].add(new Entry(key, val));
//			M++;
//		}
		
		
		boolean put = false;
		int firstNum = hash(key);
		int secondNum = hash2(key);
		
		LinkedList<Entry> entry = entries[firstNum];
		LinkedList<Entry> entry2 = entries[secondNum];
		
//    	boolean put = false;
//    	int firstNum = hash(key);
//    	int secondNum = hash2(key);
//    	LinkedList<Entry> entry = entries[firstNum];
//    	for(int i = 0; entry != null; i++) {
//    		if(entry.key.hashCode() == key.hashCode()) {
//    			entry.
//    			entry.value = val;
//    			put = true;
//    			break;
//    		}
//    		index = hash(key,i);
//    		entry = entries[index];
//    	}
//    	if(put == false) {
//    		entries[index] = new Entry<Key, Value>(key,val);
//    		N++;
//    	}
//    }
//		
	}

	@Override
	public Value get(Key key) {
		int firstKey = hash(key);
		int secondKey = hash2(key);
		
		for(Entry e : entries[firstKey]) {
			if(key.hashCode() == e.key.hashCode())
				return (Value) e.value;
			}
			
		for(Entry e : entries[secondKey]) {
			if(key.hashCode() == e.key.hashCode()) 
				return (Value) e.value;
			}
		return null;
	}

	@Override
	public void remove(Key key) {
		if(contains(key)) {
			Entry target = null;
			
			for(Entry e : entries[hash(key)]) {
				if(e.key == key) {
					target = e;
					entries[hash(key)].remove(target);
				}
			}
			
			for(Entry e : entries[hash2(key)]) {
				if(e.key == key) {
					target = e;
					entries[hash2(key)].remove(e);
				}
			}
			
			keyValueSize--;
		}
	}

	@Override
    public boolean contains(Key key)
    {
        boolean contains = false;
        int num = hash(key);
        int num2 = hash2(key);
        //check first hash
        for(Entry e : entries[num])
        {
            if(key.hashCode() == e.getKey().hashCode())
            {
                contains = true;
                break;
            }
        }
        //check second hash
        if(contains == false)
        {
            for(Entry e : entries[num2])
            {
                if(key.hashCode() == e.getKey().hashCode())
                {
                    contains = true;
                    break;
                }
            }
        }
        return contains;
		
//		return get(key) != null;
		
    }

	@Override
	public boolean isEmpty() {
		return keyValueSize == 0;
	}

	@Override
	public int size() {
		return keyValueSize;
	}

	@Override
	public Iterable<Key> keys() {
		Queue<Key> queue = new LinkedList<>();
		
		for(int i = 0; i < hashSize; i++) {
			for(Entry e : entries[i])
				queue.add((Key) e.key);
		}
		return queue;
	}
}
