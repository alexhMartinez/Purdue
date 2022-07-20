import java.util.concurrent.Semaphore;

public class dressRoom implements Runnable {
	int rooms;
	Semaphore semaphore;
	long waitTimer;
	long startWait;
	long endWait;
	long startRun;

	long endRun;
	long runTimer;
	int numberOfItems;
	Thread runner;

	public dressRoom() {
		rooms = 3;
		semaphore = new Semaphore(rooms);
	}

	public dressRoom(int r) {
		rooms = r;
		semaphore = new Semaphore(rooms);
	}

	public void requestRoom(int num) {
		numberOfItems = num;
		this.runner = new Thread(this);
		startRun = System.nanoTime();
		this.runner.start();
	}

	public static int getRandNum(int maxValue) {
		int x = 1 + (int) (Math.random() * maxValue );
		return x;
	}

	public void run() {
		try {
			semaphore.acquire();
			endRun = System.nanoTime();
			runTimer += (endRun - startRun);
			int wait = getRandNum(3);
			System.out.println(Thread.currentThread().getName() + " thread waiting");

			System.out.println(Thread.currentThread().getName() + " thread ran");

			startWait = System.nanoTime();
			Thread.sleep(wait * numberOfItems );
			endWait = System.nanoTime();
			waitTimer += (endWait - startWait);
			semaphore.release();
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public long getRunTime() {
		return runTimer;
	}

	public long getWaitTime() {
		return waitTimer;
	}
}