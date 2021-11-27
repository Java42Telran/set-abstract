package telran.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractIterator<T> implements Iterator<T> {

	protected boolean flNext = false;
	protected abstract T nextObject() ;
	protected void removeObject() {
		throw new UnsupportedOperationException();
	}
	@Override 
	public T next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		flNext = true;
		return nextObject();
	}
	@Override
	public void remove() {
		if (!flNext) {
			throw new IllegalStateException();
		}
		removeObject();
		flNext = false;
		
	}
}
