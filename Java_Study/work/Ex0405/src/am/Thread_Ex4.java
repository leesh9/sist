package am;

public class Thread_Ex4 extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i<7; i++) {
			try {
				sleep(200);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.printf("%-2s","*");
		}
	}
}
