package AntColonySystem;

public class Vertex {

	private String label;
	private int x,y,index;
	
	public Vertex(String label, int x, int y, int index) {
		super();
		this.label = label;
		this.x = x;
		this.y = y;
		this.index = index;
	}

	public int getIndex() {
		return index;
	}	
	
	public void setIndex(int index) {
		this.index = index;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	

}//end of class Vertex
