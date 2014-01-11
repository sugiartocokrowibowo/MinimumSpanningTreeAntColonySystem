package GUI;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

import AntColonySystem.Graph;
import AntColonySystem.Vertex;


public class Canvas extends JComponent {//----------------------------------------------------------------
	
	double translateX;
	double translateY;
	double scale;
	private int batasBawah=0;
	private int batasAtas=5000;
	private int X=5000,Y=5000;
	private int gridScale=100;
	private Image image = null;
	private Image imageVertex = null;	

	NumberFormat formatDesimal = new DecimalFormat("#0.00");
	Graph graph				=null;  //  @jve:decl-index=0:
	Vertex[] vertice		=null;
	String solusi			=null;
	int[][] Result			=null;
	
	Canvas() {
		translateX = 0;
		translateY = 0;
		scale = 1;
		setOpaque(false);
		//setOpaque(true);
		setDoubleBuffered(true);				
		ImageIcon icon = new ImageIcon(getClass().getResource("/res/imgbgBigii.png"));
        image = icon.getImage();
        imageVertex=new ImageIcon(getClass().getResource("/res/imgbgBigii.png")).getImage();
	}

	
	public void setGraph(Graph graph) {
		this.graph = graph;
		repaint();
	}
	
	public void setGraph(Graph graph, double solusiMST, int[][] result) {
		this.graph = graph;
		solusi=String.valueOf(formatDesimal.format(solusiMST));
		Result=result;
		repaint();
	}


	public void setVertice(Vertex[] vertice) {
		this.vertice = vertice;
		repaint();
	}
	
	public void setSolusi(double solusiMST){
		solusi=String.valueOf(formatDesimal.format(solusiMST));
		repaint();
	}//end of setSolusi(double solusiMST)
	
	public void emptyGraph(){
		this.Result=null;
		this.graph=null;
		this.vertice=null;
		repaint();
	}//end of emptyGraph()


//	@Override 
public void paint(Graphics g) {
	AffineTransform tx = new AffineTransform();
	tx.translate(translateX, translateY);
	tx.scale(scale, scale);
	Graphics2D ourGraphics = (Graphics2D) g;
	ourGraphics.setColor(Color.WHITE);
	//	mengatur nilai transparansi gambar antara 0.0 - 1.0 Float 
	///ourGraphics.setComposite(AlphaComposite.SrcOver.derive(0.8F));
	ourGraphics.setComposite(AlphaComposite.SrcOver.derive(0.9F));
	ourGraphics.fillRect(0, 0, getWidth(), getHeight());
	ourGraphics.setTransform(tx);
	ourGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	ourGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);		
	//----------------------------------
	//bikin backgroundnya
	//ourGraphics.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
	//ourGraphics.drawImage(image, 0, 0, X, Y, null);
    //menutup Graphics2D 
	//bikin gridnya
	ourGraphics.setColor(Color.GRAY);
	float gridWidth=0;
	float[] dash={10,5,10,5};
	Stroke stroke=new BasicStroke(gridWidth,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0,dash,0);
	ourGraphics.setStroke(stroke);
	for(int i = 0; i<(batasAtas-batasBawah); i+= gridScale) {
		 int k=batasBawah+50+i;
		 ourGraphics.drawLine(k,batasBawah,k,batasAtas);
		 ourGraphics.drawLine(batasBawah,k,batasAtas,k);
	}
	ourGraphics.setColor(Color.BLACK);
	for(int i = 0; i<(batasAtas-batasBawah); i+= gridScale) {
		 int k=batasBawah+i;
		 ourGraphics.drawLine(k,batasBawah,k,batasAtas);
		 ourGraphics.drawLine(batasBawah,k,batasAtas,k);
    }
	
	//sumbu koordinat	
	ourGraphics.setColor(Color.BLUE);
	ourGraphics.setStroke(new BasicStroke(1));
	ourGraphics.drawLine(batasBawah,0,batasAtas,0);
	ourGraphics.drawLine(0,batasBawah,0,batasAtas);	
	for(int i = 0; i<(batasAtas-batasBawah); i+= gridScale) {
		 int k=batasBawah+i;
		 ourGraphics.drawLine(k,-4,k,4);
		 ourGraphics.drawLine(-4,k,4,k);
	}
		
	ourGraphics.setColor(Color.BLACK);
	//ourGraphics.drawString("0", 296, 314);
	for(int i = 0; i<(batasAtas-batasBawah); i+= gridScale) {
		 int k=batasBawah+i;
		 String sSkala=String.valueOf(10*(k)/gridScale);
		 ourGraphics.drawString(sSkala,(-4+k),16);
		 int intSkalaVertical=10*(k)/gridScale;//-(k)/gridScale;
		 if(intSkalaVertical!=0){
			 sSkala=String.valueOf(intSkalaVertical);
			 ourGraphics.drawString(sSkala,-16,(-4+k));
		 }
	}       
	
	//menggambar graph	
	if(Result!=null){
		vertice=graph.getVertex();
		double[][] jarak=graph.getJarak();		
		for(int i=0;i<jarak.length;i++){
			for(int j=0;j<jarak[i].length;j++){
				if(jarak[i][j]>0&&Result[i][j]>0){
					String labelJarak=String.valueOf(formatDesimal.format(jarak[i][j]));
					ourGraphics.setColor(Color.BLUE);
					int x1=vertice[i].getX();x1=x1*10;
					int y1=vertice[i].getY();y1=y1*10;
					int x2=vertice[j].getX();x2=x2*10;
					int y2=vertice[j].getY();y2=y2*10;
					ourGraphics.setStroke(new BasicStroke(2));
					ourGraphics.drawLine(x1, y1, x2, y2);
					ourGraphics.setColor(Color.BLACK);
					ourGraphics.drawString(labelJarak, ((x1+x2)/2), (-5+((y1+y2)/2)));
				}
			}
		}
		//gambar edgenya
		
		//gambar vertexnya
		for(int i=0;i<vertice.length;i++){
			String label=vertice[i].getLabel();
			int x=vertice[i].getX();x=x*10;
			int y=vertice[i].getY();y=y*10;
			ourGraphics.setColor(Color.BLACK);
			ourGraphics.drawString(label,x,(-10+y));
			ourGraphics.setColor(Color.RED);
			ourGraphics.setStroke(new BasicStroke(1));
			ourGraphics.fillOval(-5+x, -5+y, 10, 10);
		}//end of for(int i=0;i<vertice.length;i++)
	}else if(graph!=null){
		vertice=graph.getVertex();
		double[][] jarak=graph.getJarak();
		int[][] hub=graph.getAdjMat();
		for(int i=0;i<jarak.length;i++){
			for(int j=0;j<jarak[i].length;j++){
				if(jarak[i][j]>0&&hub[i][j]>0){
					String labelJarak=String.valueOf(formatDesimal.format(jarak[i][j]));
					ourGraphics.setColor(Color.BLUE);
					int x1=vertice[i].getX();x1=x1*10;
					int y1=vertice[i].getY();y1=y1*10;
					int x2=vertice[j].getX();x2=x2*10;
					int y2=vertice[j].getY();y2=y2*10;
					ourGraphics.setStroke(new BasicStroke(2));
					ourGraphics.drawLine(x1, y1, x2, y2);
					ourGraphics.setColor(Color.BLACK);
					ourGraphics.drawString(labelJarak, ((x1+x2)/2), (-5+((y1+y2)/2)));
				}
			}
		}
		//gambar edgenya
		
		//gambar vertexnya
		for(int i=0;i<vertice.length;i++){
			String label=vertice[i].getLabel();
			int x=vertice[i].getX();x=x*10;
			int y=vertice[i].getY();y=y*10;
			ourGraphics.setColor(Color.BLACK);
			ourGraphics.drawString(label,x,(-10+y));
			ourGraphics.setColor(Color.RED);
			ourGraphics.setStroke(new BasicStroke(1));
			ourGraphics.fillOval(-5+x, -5+y, 10, 10);
		}//end of for(int i=0;i<vertice.length;i++)
	}else if(vertice!=null){
		for(int i=0;i<vertice.length;i++){
			String label=vertice[i].getLabel();
			int x=vertice[i].getX();x=x*10;
			int y=vertice[i].getY();y=y*10;
			ourGraphics.setColor(Color.BLACK);
			ourGraphics.drawString(label,x,(-10+y));
			ourGraphics.setColor(Color.RED);
			ourGraphics.setStroke(new BasicStroke(1));
			ourGraphics.fillOval(-5+x, -5+y, 10, 10);
		}//end of for(int i=0;i<vertice.length;i++)
	}//end of if(graph!=null){}else if(vertice!=null){}
	
	//Menulis Solusi:
	if(solusi!=null){
		ourGraphics.setColor(Color.BLACK);
		String labelSolusi="SOLUSI MST = ";
		labelSolusi=labelSolusi.concat(solusi);
		ourGraphics.drawString(labelSolusi, 40, 50);
	}
	
	//-----------------------------------  
	ourGraphics.dispose();
}//end of paint(Graphics g) 
}//end of class TransformingCanvas extends JComponent---------------------------------------------------------------

