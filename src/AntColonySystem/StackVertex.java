package AntColonySystem;

public class StackVertex {
	final int MAX_VERT=100;
	private Vertex[] ourVertex=new Vertex[MAX_VERT];
	private int index=0;
	
	public StackVertex() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void insertVetex(String label, int x, int y){
		ourVertex[index]=new Vertex(label, x, y, index);
		index++;
	}//end of public void insertVetex(String label, int x, int y)
	
	public void reset(){
		ourVertex=new Vertex[MAX_VERT];
		index=0;
	}//end of reset()
	
	public void removeLast(){
		index--;		
	}//end of removeLast() 
	
	public boolean isEmpty(){
		boolean empty=false;
		if(index==0){
			empty=true;
		}
		return empty;
	}//end of isEmpty()
	
	public Vertex[] getVertice(){
		int length=index;
		length=length-1;
		Vertex[] Vertice=null;
		if(length>=0){
			Vertice=new Vertex[1+length];
			for(int i=0;i<Vertice.length;i++){
				Vertice[i]=ourVertex[i];
			}//end of for(int i=0;i<Vertice.length;i++)
		}//end of if(length>=0)
		return Vertice;
	}//end of getVertice()
	
}//end of StackVertex
