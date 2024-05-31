package am;

public class Thread_Ex5 extends Thread {
	Frame_Ex5 frame;
	public Thread_Ex5(Frame_Ex5 f) {
		this.frame=f;
	}
	
	@Override
	public void run() {
		// f 안에 있는 p의 너비에서 50을 뺀 크기 만큼만 수행
		while(true) {
			frame.x +=5;
			//x의 값이 p의 너비-50 한 값보다 크거나 같다면 탈출
			if(frame.x>=frame.p.getWidth()-50) {
				break;
			}
			
			frame.p.repaint();
			
			try {
				sleep(0);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
