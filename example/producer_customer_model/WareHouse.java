package demo;

import java.util.ArrayList;

public class WareHouse {
	
	private ArrayList<String> list = new ArrayList<>();
	
	public void add() {
			if(list.size()<20) {
				list.add("a");
			}else {
				return;
			}
		}
	
	public void get() {
		if(list.size()>0) {
			list.remove(0);
		}else {
			return;
		}
	}
}
