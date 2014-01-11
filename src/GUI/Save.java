package GUI;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import AntColonySystem.Graph;
import AntColonySystem.Vertex;

public class Save {
	private Graph graph	=null;
	
	private File file=null;

	public Save(Graph graph, File file) {
		super();
		this.graph 	= graph;
		this.file	=file;
		initialize();
	}//end of constructor
	
	public void initialize(){
		Vertex[]vertice=graph.getVertex();
		int n=vertice.length;
		int[][] adjacen=graph.getAdjMat();
		if(graph!=null&&file!=null){
			try {
				FileOutputStream data=new FileOutputStream(this.file);
				PrintStream s=new PrintStream(data);
				s.println(String.valueOf(n)+";vertex");
				for(int i=0;i<vertice.length;i++){
					s.println((vertice[i].getLabel())+";"+(String.valueOf(vertice[i].getX()))+";"+(String.valueOf(vertice[i].getY()))+";");
				}//end of for(int i=0;i<vertice.length;i++)
				for(int i=0;i<adjacen.length;i++){
					for(int j=0;j<adjacen[i].length;j++){
						s.print(adjacen[i][j]+";");
					}//end of for(int j=0;j<adjacen[i].length;j++)
					s.println();
				}//end of for(int i=0;i<adjacen.length;i++)
				s.close();
				data.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end of try
		}//end of if(graph!=null&&file!=null)
	}//end of initialize() 
}//end of class Save 
