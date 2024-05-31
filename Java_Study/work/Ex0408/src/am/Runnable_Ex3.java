package am;

public class Runnable_Ex3 implements Runnable {
	
	int 농심라면 = 10;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		
		while(true) {
			synchronized (this) {
				//교착상태(deadlock)
				if(농심라면>1)
					notify();
				
				농심라면--;
				System.out.printf("--[%s] 먼저(농심라면:%d)\n",name,농심라면);
				
				try {
					wait();
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				} 
				
			}
		}
	}

}
