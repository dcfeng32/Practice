package demo;

public class Producer extends Thread{
	private WareHouse house; 
	public void WareHouse(WareHouse house) {
	this.house = house;
}
	
	public void run(WareHouse house) {
		while(true) {
			house.add();
			System.out.println("������ժ����һ�����ϣ�");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
	}
	
	
	
}
