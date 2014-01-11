package AntColonySystem;

public class AntColonySystem {
	
	protected Graph graph=null;
	
	//-----------------------------
	//Parameter-parameter Algoritma
	private int n;			//n		=banyaknya vertex
	private int numEdge;	//numEdge=banyaknya rusuk = n-1
	private double Q;		//Q		=konstanta siklus semut
	private double alpha;	//alpha	=konstanta pengendali intensitas jejak semut
	private double beta;	//beta	=konstanta pengendali visibilitas
	private int m;			//m		=banyaknya semut
	private double rho;		//rho	=tetapan penguapan jejak semut
	private int NCmax;		//NCmax	=jumlah siklus semut
	private double[][] eta;	//eta	=invers jarak atau visibilitas antar vertex
	private double[][]tou; 	//tou	=intensitas jejak kaki semut
	
	//-----------------------------
	//Variabel-variabel Proses
	private double[][] jarak		=null;
	protected int[][] adjMat		=null;
	private int[][] result			=null;
	private double resultValue;
	private int[][][] resultSiklus	=null;
	private double[] resultValueSiklus=null;
	private int[][] theBestResult	=null;
	private double theBestResultValue;
	
	public AntColonySystem(Graph graph, double q, double alpha, double beta, int m, double rho, double tou1, int ncmax) {
		super();
		this.graph 	= graph;
		this.n		=this.graph.getNVertex();
		this.numEdge=-1+this.n;
		this.Q 		= q;
		this.alpha 	= alpha;
		this.beta 	= beta;
		this.m 		= m;
		this.rho 	= rho;
		this.NCmax 	= ncmax;
		inisiasiTouAwal(tou1, this.n);
		initialize();
	}//end of AntColonySystem(Graph graph, double q, double alpha, double beta, int m, double rho, int ncmax, double[][] eta, double[][] tou) {
	
	public void initialize(){
		this.jarak				=this.graph.getJarak();
		this.adjMat				=this.graph.getAdjMat();
		this.eta				=this.graph.getVisibilitasAntarVertex();
		this.result				=new int[this.n][this.n];
		this.resultValue		=Double.MAX_VALUE;
		this.resultSiklus		=new int[this.NCmax][this.n][this.n];;
		this.resultValueSiklus	=new double[this.NCmax];
		this.theBestResult		=new int[this.n][this.n];
		this.theBestResultValue	=Double.MAX_VALUE;
		solve();
	}//end of initialize()
	
	public void solve(){		
		for(int nc=1;nc<=this.NCmax;nc++){//========================================================================
			System.out.println("nc: "+(nc));
			int ic=nc;ic=ic-1;
			int[][][] resultSemut		=new int[this.m][this.n][this.n];
			double[] resultValueSemut	=new double[this.m];
			int semutTerbaik=0;
			double[][]deltaTou			=new double[this.n][this.n];
			for(int semut=1;semut<=m;semut++){//--------------------------------------------------------------------
				System.out.println("semut: "+(semut));
				int s=semut;s=s-1;
				int[][] rTemp		=new int[this.n][this.n];	
				int[][] arrProses	=new int[this.n][this.n];
				//System.out.println("array Proses");
				//cetakMatriks(arrProses);
				StackInteger si		=new StackInteger();
				int lowerBound=0,upperBound=this.n;
				int vertexAwal = lowerBound + (int) ( Math.random()*(upperBound - lowerBound));				
				si.insert(vertexAwal);
				arrProses=clearKolom(arrProses,vertexAwal);
				//cetakMatriks(arrProses);
				
				int edge=0;
				while(edge<this.numEdge){//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					//System.out.println("edge: "+(edge));
					int vertexAsal=si.getLastValue();
					if(vertexAsal>=0){
						int[] kandidatVertexTujuan=new int[this.n];
						double[] tou_kij=new double[this.n];
						double[] eta_kij=new double[this.n];
						for(int i=0;i<this.n;i++){
							if((arrProses[vertexAsal][i]>-1)&&(this.adjMat[vertexAsal][i]>0)){
								kandidatVertexTujuan[i]=this.adjMat[vertexAsal][i];
								tou_kij[i]=this.tou[vertexAsal][i];
								eta_kij[i]=this.eta[vertexAsal][i];
							}
						}//end of for(int i=0;i<this.n;i++)
						int vertexTujuan=setVertexTujuan(kandidatVertexTujuan,tou_kij,eta_kij);
						if(vertexTujuan<0){
							si.pop();
						}else{
							si.insert(vertexTujuan);
							arrProses=clearKolom(arrProses,vertexTujuan);
							rTemp[vertexAsal][vertexTujuan]=1;
							System.out.println("Edge: "+(vertexAsal)+" - "+(vertexTujuan));
							edge++;
						}//end of if(vertexTujuan<0) else
					}//end of if(arrProses[vertexAsal][i]>0)	
				}//end of while(edge<this.numEdge)++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				resultSemut[s]=rTemp;
				resultValueSemut[s]=hitungResultValue(rTemp);
				
				if(resultValueSemut[s]<this.resultValue){
					this.resultValue=resultValueSemut[s];
					semutTerbaik=s;
				}//end of if(resultValueSemut[s]<this.resultValue)
				
				//update delta tou
				double Lk=resultValueSemut[s];//Lk=total Bobot.
				for(int i=0;i<deltaTou.length;i++){
					for(int j=0;j<deltaTou[i].length;j++){
						if(rTemp[i][j]>0){
							deltaTou[i][j]=deltaTou[i][j]+(this.Q/Lk);
						}
					}
				}//end of for(int i=0;i<this.deltaTou.length;i++)
				
			}//end of for(int semut=0;semut<=m;semut++)-------------------------------------------------------------
			
			this.result=resultSemut[semutTerbaik];
			this.resultSiklus[ic]=this.result;
			this.resultValueSiklus[ic]=this.resultValue;
			if(this.theBestResultValue>this.resultValue){
				this.theBestResultValue=this.resultValue;
				this.theBestResult=this.result;
			}//end of if(this.theBestResultValue>this.resultValue)
			
			//update tou
			for(int i=0;i<this.tou.length;i++){
				for(int j=0;j<this.tou[i].length;j++){
					this.tou[i][j]=this.rho*this.tou[i][j]+deltaTou[i][j];
				}
			}//end of for(int i=0;i<this.tou.length;i++)
			
		}//end of for(int nc=1;nc<=this.NCmax;nc++)=================================================================
		System.out.println("Solusi Terbaik:");
		cetakMatriks(this.theBestResult);
	}//end of solve()
	
	public void inisiasiTouAwal(double to, int en){
		this.tou=new double[en][en];
		for(int i=0;i<en;i++){
			for(int j=0;j<en;j++){
				this.tou[i][j]=to;
			}
		}
	}//end of inisiasiTouAwal()
	
	public int[][] clearKolom(int[][] arrIn,int col){
		int[][] arrOut=arrIn;
		for(int i=0;i<arrOut.length;i++){
			arrOut[i][col]=-1;
		}//end of for(int i=0;i<arrOut.length;i++)
		return arrOut;
	}//end of clearKolom()
	
	public int[][] repairArrayProses(){
		final int[][] arrOut=this.adjMat;
		System.out.println("Array Out");
		cetakMatriks(arrOut);
		return arrOut;
	}//end of clearKolom()
	
	public int setVertexTujuan(int[] kandidatVertexTujuan,double[] tou_kij,double[] eta_kij){
		int tujuan=-1;
		double[] toualphaetabeta=new double[tou_kij.length];
		double sigmatoualphaetabeta	=0;
		int k=0;
		for(int i=0;i<toualphaetabeta.length;i++){
			if(kandidatVertexTujuan[i]>0){
				double toualpha		=Math.pow(tou_kij[i],this.alpha);
				double etabeta		=Math.pow(eta_kij[i], this.beta);
				toualphaetabeta[i]	=toualpha*etabeta;
				sigmatoualphaetabeta=sigmatoualphaetabeta+toualphaetabeta[i];
				k++;
			}//end of if(kandidatVertexTujuan>0)
		}//end of for(int i=0;i<tou_kij_alpha.length;i++)
		if(k>0){
			//Hitung probabilitas
			double[] probabilitas=new double[tou_kij.length];
			double[][] probabilitasKomulatif=new double[k][2];
			double sigmaProbabilitasKomulatif=0;
			int l=0;
			for(int i=0;i<probabilitas.length;i++){
				if(kandidatVertexTujuan[i]>0){
					probabilitas[i]=toualphaetabeta[i]/sigmatoualphaetabeta;
					sigmaProbabilitasKomulatif=sigmaProbabilitasKomulatif+probabilitas[i];
					probabilitasKomulatif[l][0]=sigmaProbabilitasKomulatif;
					probabilitasKomulatif[l][1]=i;				
					l++;
				}//end of if(kandidatVertexTujuan>0)
			}//end of for(int i=0;i<tou_kij_alpha.length;i++)
			double randomProbabilitas=Math.random();
			//memilih verteks tujuan berdasarkan probabilitas komulatif
			for(int i=0;i<probabilitasKomulatif.length;i++){
				if(probabilitasKomulatif[i][0]>=randomProbabilitas){
					tujuan=(int) probabilitasKomulatif[i][1];
					break;
				}//end of if(probabilitasKomulatif[i][0]>=randomProbabilitas)
			}//end of for(int i=0;i<probabilitasKomulatif.length;i++)
		}//end of if(k>0)		
		return tujuan;
	}//end of setVertexTujuan();
	
	
	public void cetakMatriks(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}//end of cetakMatriks(int[][] arr)
	
	public void cetakMatriks(double[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}//end of cetakMatriks(int[][] arr)
	
	public double hitungResultValue(int[][] result1){
		double resultValue=0;
		for(int i=0;i<result1.length;i++){
			for(int j=0;j<result1[i].length;j++){
				if(result1[i][j]>0){
					resultValue=resultValue+this.jarak[i][j];
				}
			}
		}
		return resultValue;
	}//end of hitungResultValueTemp() 
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackVertex stackVertex=new StackVertex();
		stackVertex.insertVetex("A", 10, 10);
		stackVertex.insertVetex("B", 20, 20);
		stackVertex.insertVetex("C", 30, 20);
		stackVertex.insertVetex("D", 40, 30);
		stackVertex.insertVetex("E", 50, 20);
		stackVertex.insertVetex("F", 60, 40);
		Vertex[] vertex=stackVertex.getVertice();
		Graph graph=new Graph(vertex);
		//graph.setEdge("A", "B");
		graph.setEdge("A", "C");
		//graph.setEdge("A", "D");
		graph.setEdge("A", "E");
		graph.setEdge("A", "F");
		graph.setEdge("B", "C");
		//graph.setEdge("B", "D");
		//graph.setEdge("B", "E");
		//graph.setEdge("B", "F");
		graph.setEdge("C", "D");
		graph.setEdge("C", "E");
		//graph.setEdge("C", "F");
		//graph.setEdge("D", "E");
		graph.setEdge("D", "F");
		//graph.setEdge("E", "F");
		double q		=1;
		double alpha	=1;
		double beta		=1;
		int m			=10;
		double rho		=1;
		double tou1		=1;
		int ncmax		=2;
		AntColonySystem acs=new AntColonySystem(graph, q, alpha, beta, m, rho, tou1, ncmax);

	}//end of main

	public int[][] getResult() {
		return result;
	}

	public int[][][] getResultSiklus() {
		return resultSiklus;
	}

	public double getResultValue() {
		return resultValue;
	}

	public double[] getResultValueSiklus() {
		return resultValueSiklus;
	}

	public int[][] getTheBestResult() {
		return theBestResult;
	}

	public double getTheBestResultValue() {
		return theBestResultValue;
	}


	

}//end of class
