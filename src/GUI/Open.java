package GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import AntColonySystem.Graph;
import AntColonySystem.Vertex;

public class Open {
	
	private Graph graph	=null;
	
	private File file=null;

	public Open(File file) {
		super();
		this.file = file;
		initialize();
	}//end of constructor
	
	public void initialize(){
		if(file!=null){
			try {
				FileInputStream data=new FileInputStream(this.file);
				BufferedReader dataIn=new BufferedReader(new InputStreamReader(data));
				String thisLine1=dataIn.readLine();
				String[] dataCols=new String[2];
				dataCols=thisLine1.split(";");
				int n=Integer.parseInt(dataCols[0]);
				Vertex[] vertice=new Vertex[n];
				for(int i=0;i<vertice.length;i++){
					String thisLinei=dataIn.readLine();
					String[] dataValue=new String[3];
					dataValue=thisLinei.split(";");
					String label=dataValue[0];
					int x=Integer.parseInt(dataValue[1]);
					int y=Integer.parseInt(dataValue[2]);
					int index=i;
					vertice[i]=new Vertex(label, x, y, index);
				}//end of for(int i=0;i<vertice.length;i++)
				//graph=new Graph(vertice);
				int[][] adjc=new int[n][n];
				for(int i=0;i<n;i++){
					String thisLinei=dataIn.readLine();
					String[] dataValue=new String[n];
					dataValue=thisLinei.split(";");
					for(int j=0;j<n;j++){
						adjc[i][j]=Integer.parseInt(dataValue[j]);
					}
				}//end of for(int i=0;i<vertice.length;i++)
				graph=new Graph(vertice,adjc);
				dataIn.close();
				data.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//end of try
		}//end of if(file!=null)	
	}//end of initialize

	public Graph getGraph() {
		return graph;
	}
	
}//end of class Open()
