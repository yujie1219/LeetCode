package solution;

public class LeetCode1114 {
	private class Foo {
		private boolean Aused = false;
		private boolean Bused = false;
		private Object lock = new Object();

		public Foo() {

		}

		public void first(Runnable printFirst) throws InterruptedException {
			synchronized (lock) {
				printFirst.run();
				Aused = true;
				lock.notifyAll();
			}
		}

		public void second(Runnable printSecond) throws InterruptedException {
			synchronized (lock) {
				while (!Aused) {
					lock.wait();
				}
				printSecond.run();
				Bused = true;
				lock.notifyAll();
			}
		}

		public void third(Runnable printThird) throws InterruptedException {
			synchronized (lock) {
				while (!(Aused && Bused)) {
					lock.wait();
				}
				printThird.run();
				lock.notifyAll();
			}
		}
	}
}
