package AntColonySystem;

public class Graph {

	private Vertex[] Vertex	=null;
	private double[][] jarak=null;
	protected int[][] adjMat=null;
	private int nVertex		=1;
	
	public Graph() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Graph(Vertex[] vertex) {
		super();
		Vertex = vertex;
		this.adjMat = new int[Vertex.length][Vertex.length];
		initialize();
	}

	public Graph(Vertex[] vertex, int[][] adjMat) {
		super();
		Vertex = vertex;
		this.adjMat = adjMat;
		initialize();
	}
	
	public void initialize(){
		nVertex=Vertex.length;
		if(jarak==null){
			jarak=new double[nVertex][nVertex];
			for(int i=0;i<-1+nVertex;i++){
				double xi	=Vertex[i].getX();
				double yi	=Vertex[i].getY();
				int J		=1+i;
				for(int j=J;j<nVertex;j++){
					double xj	=Vertex[j].getX();
					double yj	=Vertex[j].getY();
					double X2	=Math.pow((xj-xi), 2);
					double Y2	=Math.pow((yj-yi), 2);
					double d	=Math.sqrt(X2+Y2);
					jarak[i][j]	=d;
					jarak[j][i]	=d;
				}//end of for(int j=J;j<nVertex;j++)
			}//end of for(int i=0;i<nVertex;i++)
		}//end of if(jarak==null)
	}//end of initialize()
	
	public int getIndex(String label){
		int index=-1;
		if(Vertex!=null){
			String label1=label;label1.toUpperCase();
			for(int i=0;i<Vertex.length;i++){
				String label2=Vertex[i].getLabel();label2.toUpperCase();
				if(label1.equals(label2)){
					index=Vertex[i].getIndex();
					break;
				}//end of if if(label1.equals(label2))				
			}//end of for(int i=0;i<Vertex.length;i++)
		}//end of if(Vertex!=null)
		return index;
	}//end of getIndex(String label)
	
	public void setEdge(String v1,String v2){
		int index1=getIndex(v1);
		int index2=getIndex(v2);
		if((index1>=0)&&(index2>=0)){
			adjMat[index1][index2]=1;
			adjMat[index2][index1]=1;			
		}//end of setEdge(String v1,String v2)
	}//end of setEdge()	
	
	public double[][] getVisibilitasAntarVertex(){
		double[][] visibilitasAntarVertex=new double[jarak.length][jarak.length];
		for(int i=0;i<-1+visibilitasAntarVertex.length;i++){
			int J=i;J=J+1;
			for(int j=J;j<visibilitasAntarVertex.length;j++){
				double eta=1/jarak[i][j];
				visibilitasAntarVertex[i][j]=eta;
				visibilitasAntarVertex[j][i]=eta;
			}
		}
		return visibilitasAntarVertex;
	}//end of getVisibilitasAntarVertex()

	public int[][] getAdjMat() {
		return adjMat;
	}

	public void setAdjMat(int[][] adjMat) {
		this.adjMat = adjMat;
	}

	public double[][] getJarak() {
		return jarak;
	}

	public void setJarak(double[][] jarak) {
		this.jarak = jarak;
	}

	public int getNVertex() {
		return nVertex;
	}

	public void setNVertex(int vertex) {
		nVertex = vertex;
	}

	public Vertex[] getVertex() {
		return Vertex;
	}

	public void setVertex(Vertex[] vertex) {
		Vertex = vertex;
	}
	
	

}//end of class Graph()
