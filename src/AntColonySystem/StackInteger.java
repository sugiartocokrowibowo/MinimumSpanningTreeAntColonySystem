package AntColonySystem;

public class StackInteger {
	private int[]box=new int[100];
	private int index=0;
	
	public void reset(){
		box=new int[1000];
		index=0;
	}//end of reset()
	
	public void insert(int value){
		box[index]=value;
		index++;
	}//end of insert(int value)
	
	public void pop(){
		if(index>=0){
			index--;
			box[index]=0;
		}
	}//end of pop()
	
	public int getLastValue(){
		int lastValue=-1;
		int ind=index;
		ind--;
		if(ind>=0){
			lastValue=box[ind];
		}
		return lastValue;
	}
	
}//end of StackInteger 
