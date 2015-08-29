package examples.general.threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public enum EnumSingleton {
	SingletonChocolateBoiler;
	Lock lock = new ReentrantLock();
	private boolean empty = true, boiled = false;

	public void fill() {
		lock.lock();
		if (isEmpty()) {
			empty = false;
			boiled = false;
			System.out.println("-------\nFilling...\n");
		} else {
			System.err.println("reject filling. wrong state\n");
		}
	}

	public void boil() {
		if (!isEmpty() && !isBoiled()) {
			boiled = true;
			System.out.println("Boiling...\n");
		} else {
			System.err.println("reject boiling. wrong state\n");
		}
	}

	public void drain() {
		if (!isEmpty() && isBoiled()) {
			empty = true;
			System.out.println("Draining...\n------------\n");
		} else {
			System.err.println("reject draining. wrong state\n");
		}
		
		lock.unlock();
	}
	
	public boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}

}
