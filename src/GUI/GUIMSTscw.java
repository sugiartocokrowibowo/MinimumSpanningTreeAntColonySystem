package GUI;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.UIManager;

import java.awt.Dimension;
import javax.swing.JTabbedPane;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;



import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;


import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import AntColonySystem.AntColonySystem;
import AntColonySystem.Graph;
import AntColonySystem.StackVertex;
import AntColonySystem.Vertex;
import java.awt.Rectangle;
import java.awt.Point;
import java.io.File;
import java.net.URL;

public class GUIMSTscw extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JTabbedPane jTabbedPane = null;

	private JPanel jPanelHome = null;

	private JPanel jPanelCreateGraph = null;

	private JPanel jPanelSolusi = null;

	private JPanel jPanelHelp = null;

	private JTabbedPane jTabbedPane1 = null;

	private JPanel jPanelSolusiMST = null;

	private JTabbedPane jTabbedPane3 = null;

	private JPanel jPanelAddVertex = null;

	private JPanel jPanelSetEdge = null;

	private JLabel jLabelLabelVertex = null;

	private JTextField jTextFieldLabelVertex = null;

	private JLabel jLabelX = null;

	private JTextField jTextFieldX = null;

	private JLabel jLabelY = null;

	private JTextField jTextFieldY = null;

	private JButton jButtonAddVertex = null;

	private JButton jButtonOpenGraph = null;

	private JButton jButtonSaveGraph = null;

	private JLabel jLabelV1 = null;

	private JTextField jTextFieldV1 = null;

	private JLabel jLabelV2 = null;

	private JTextField jTextFieldV2 = null;

	private JButton jButtonSetEdge = null;

	private JPanel jPanelGraphAwal = null;

	private JButton jButtonNew = null;

	private JButton jButtonSetGraph = null;

	private JButton jButtonRemoveLastVertex = null;

	/**
	 * This method initializes jTabbedPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.addTab("Home", null, getJPanelHome(), null);
			jTabbedPane.addTab("Create Graph", null, getJPanelCreateGraph(), null);
			jTabbedPane.addTab("Solusi MST", null, getJPanelSolusi(), null);
			jTabbedPane.addTab("Help", null, getJPanelHelp(), null);
		}
		return jTabbedPane;
	}

	/**
	 * This method initializes jPanelHome	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelHome() {
		if (jPanelHome == null) {
			jPanelHome = new PanelImage(getClass().getResource("/res/imgbgi1.png"));//JPanel();
			jPanelHome.setLayout(null);
			jPanelHome.add(getJButtonPresentase(), null);
			jPanelHome.add(getJButtonExit(), null);
		}
		return jPanelHome;
	}

	/**
	 * This method initializes jPanelCreateGraph	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelCreateGraph() {
		if (jPanelCreateGraph == null) {
			jPanelCreateGraph = new PanelImage(getClass().getResource("/res/imgbgi1.png"));//JPanel();
			jPanelCreateGraph.setLayout(new BorderLayout());
			jPanelCreateGraph.setVisible(true);
			jPanelCreateGraph.add(getJTabbedPane3(), BorderLayout.NORTH);
			jPanelCreateGraph.add(getJPanelGraphAwal(), BorderLayout.CENTER);
		}
		return jPanelCreateGraph;
	}

	/**
	 * This method initializes jPanelSolusi	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelSolusi() {
		if (jPanelSolusi == null) {
			jPanelSolusi = new JPanel();
			jPanelSolusi.setLayout(new BorderLayout());
			jPanelSolusi.setVisible(true);
			jPanelSolusi.add(getJTabbedPane1(), BorderLayout.CENTER);
		}
		return jPanelSolusi;
	}

	/**
	 * This method initializes jPanelHelp	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelHelp() {
		if (jPanelHelp == null) {
			jPanelHelp = new PanelImage(getClass().getResource("/res/imgbgi1.png"));//JPanel();
			jPanelHelp.setLayout(new BorderLayout());
		}
		return jPanelHelp;
	}

	/**
	 * This method initializes jTabbedPane1	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane1() {
		if (jTabbedPane1 == null) {
			jTabbedPane1 = new TabbedpaneImage(getClass().getResource("/res/imgbgitrans.png"));;//JTabbedPane();
			jTabbedPane1.setTabPlacement(JTabbedPane.BOTTOM);
			jTabbedPane1.addTab("Set Parameter Algoritma", null, getJPanelSetParameter(), null);
			jTabbedPane1.addTab("Solusi Minimum Spanning Tree", null, getJPanelSolusiMST(), null);
		}
		return jTabbedPane1;
	}

	/**
	 * This method initializes jPanelSolusiMST	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelSolusiMST() {
		if (jPanelSolusiMST == null) {
			jPanelSolusiMST = new JPanel();
			jPanelSolusiMST.setLayout(new BorderLayout());
			jPanelSolusiMST.add(canvas1, BorderLayout.CENTER);//
			jPanelSolusiMST.add(getJPanelButtonSolusiMST(), BorderLayout.SOUTH);
		}
		return jPanelSolusiMST;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	/*
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridy = 1;
		}
		return jPanel;
	}
	*/

	/**
	 * This method initializes jTabbedPane3	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane3() {
		if (jTabbedPane3 == null) {
			jTabbedPane3 = new JTabbedPane();
			jTabbedPane3.setTabPlacement(JTabbedPane.BOTTOM);
			jTabbedPane3.addTab("Add Vertex", null, getJPanelAddVertex(), null);
			jTabbedPane3.addTab("Set Edge", null, getJPanelSetEdge(), null);
		}
		return jTabbedPane3;
	}

	/**
	 * This method initializes jPanelAddVertex	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelAddVertex() {
		if (jPanelAddVertex == null) {
			jLabelY = new JLabel();
			jLabelY.setText("     y");
			jLabelX = new JLabel();
			jLabelX.setText("     x");
			jLabelLabelVertex = new JLabel();
			jLabelLabelVertex.setText("Label Vertex");
			jPanelAddVertex = new JPanel();
			jPanelAddVertex.setLayout(new FlowLayout());
			jPanelAddVertex.add(getJButtonNew(), null);
			jPanelAddVertex.add(jLabelLabelVertex, null);
			jPanelAddVertex.add(getJTextFieldLabelVertex(), null);
			jPanelAddVertex.add(jLabelX, null);
			jPanelAddVertex.add(getJTextFieldX(), null);
			jPanelAddVertex.add(jLabelY, null);
			jPanelAddVertex.add(getJTextFieldY(), null);
			jPanelAddVertex.add(getJButtonAddVertex(), null);
			jPanelAddVertex.add(getJButtonRemoveLastVertex(), null);
			jPanelAddVertex.add(getJButtonOpenGraph(), null);
		}
		return jPanelAddVertex;
	}

	/**
	 * This method initializes jPanelSetEdge	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelSetEdge() {
		if (jPanelSetEdge == null) {
			jLabelV2 = new JLabel();
			jLabelV2.setText("     V2");
			jLabelV1 = new JLabel();
			jLabelV1.setText("V1");
			jPanelSetEdge = new JPanel();
			jPanelSetEdge.setLayout(new FlowLayout());
			jPanelSetEdge.add(getJButtonSetGraph(), null);
			jPanelSetEdge.add(jLabelV1, null);
			jPanelSetEdge.add(getJTextFieldV1(), null);
			jPanelSetEdge.add(jLabelV2, null);
			jPanelSetEdge.add(getJTextFieldV2(), null);
			jPanelSetEdge.add(getJButtonSetEdge(), null);
			jPanelSetEdge.add(getJButtonSaveGraph(), null);
		}
		return jPanelSetEdge;
	}

	/**
	 * This method initializes jTextFieldLabelVertex	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldLabelVertex() {
		if (jTextFieldLabelVertex == null) {
			jTextFieldLabelVertex = new JTextField();
			jTextFieldLabelVertex.setPreferredSize(new Dimension(100, 30));
			jTextFieldLabelVertex.setEnabled(false);
		}
		return jTextFieldLabelVertex;
	}

	/**
	 * This method initializes jTextFieldX	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldX() {
		if (jTextFieldX == null) {
			jTextFieldX = new JTextField();
			jTextFieldX.setPreferredSize(new Dimension(100, 30));
			jTextFieldX.setEnabled(false);
		}
		return jTextFieldX;
	}

	/**
	 * This method initializes jTextFieldY	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldY() {
		if (jTextFieldY == null) {
			jTextFieldY = new JTextField();
			jTextFieldY.setPreferredSize(new Dimension(100, 30));
			jTextFieldY.setEnabled(false);
		}
		return jTextFieldY;
	}

	/**
	 * This method initializes jButtonAddVertex	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAddVertex() {
		if (jButtonAddVertex == null) {
			jButtonAddVertex = new JButton();
			jButtonAddVertex.setText("Add Vertex");
			jButtonAddVertex.setEnabled(false);
			jButtonAddVertex.setPreferredSize(new Dimension(100, 30));
			jButtonAddVertex.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String label=jTextFieldLabelVertex.getText().toUpperCase();
					int x=Integer.parseInt(jTextFieldX.getText().trim());
					int y=Integer.parseInt(jTextFieldY.getText().trim());
					addNewVertex(label, x, y);
					jTextFieldLabelVertex.setText("");
					jTextFieldX.setText("");
					jTextFieldY.setText("");					
					drawGraph(getVertice());
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonAddVertex;
	}

	/**
	 * This method initializes jButtonOpenGraph	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonOpenGraph() {
		if (jButtonOpenGraph == null) {
			jButtonOpenGraph = new JButton();
			jButtonOpenGraph.setText("OpenGraph");
			jButtonOpenGraph.setPreferredSize(new Dimension(100, 30));
			jButtonOpenGraph.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					openGraph();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonOpenGraph;
	}

	/**
	 * This method initializes jButtonSaveGraph	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSaveGraph() {
		if (jButtonSaveGraph == null) {
			jButtonSaveGraph = new JButton();
			jButtonSaveGraph.setText("Save Graph");
			jButtonSaveGraph.setPreferredSize(new Dimension(100, 30));
			jButtonSaveGraph.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					saveGraph();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonSaveGraph;
	}

	/**
	 * This method initializes jTextFieldV1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldV1() {
		if (jTextFieldV1 == null) {
			jTextFieldV1 = new JTextField();
			jTextFieldV1.setPreferredSize(new Dimension(100, 30));
			jTextFieldV1.setEnabled(false);
		}
		return jTextFieldV1;
	}

	/**
	 * This method initializes jTextFieldV2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldV2() {
		if (jTextFieldV2 == null) {
			jTextFieldV2 = new JTextField();
			jTextFieldV2.setPreferredSize(new Dimension(100, 30));
			jTextFieldV2.setEnabled(false);
		}
		return jTextFieldV2;
	}

	/**
	 * This method initializes jButtonSetEdge	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSetEdge() {
		if (jButtonSetEdge == null) {
			jButtonSetEdge = new JButton();
			jButtonSetEdge.setText("Set Edge");
			jButtonSetEdge.setEnabled(false);
			jButtonSetEdge.setPreferredSize(new Dimension(100, 30));
			jButtonSetEdge.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String v1=jTextFieldV1.getText().toUpperCase();
					String v2=jTextFieldV2.getText().toUpperCase();
					setEdge(v1, v2);
					jTextFieldV1.setText("");
					jTextFieldV2.setText("");
					drawGraph(graph);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonSetEdge;
	}

	/**
	 * This method initializes jPanelGraphAwal	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelGraphAwal() {
		if (jPanelGraphAwal == null) {
			jPanelGraphAwal = new JPanel();
			jPanelGraphAwal.setLayout(new BorderLayout());
			jPanelGraphAwal.add(canvas, BorderLayout.CENTER);//
		}
		return jPanelGraphAwal;
	}

	/**
	 * This method initializes jButtonNew	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNew() {
		if (jButtonNew == null) {
			jButtonNew = new JButton();
			jButtonNew.setText("New");
			jButtonNew.setPreferredSize(new Dimension(100, 30));
			jButtonNew.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					setKomponenAddVertexEnable();
					setKomponenSetEdgeDisable();
					clearVertex();	
					canvas.emptyGraph();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonNew;
	}

	/**
	 * This method initializes jButtonSetGraph	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSetGraph() {
		if (jButtonSetGraph == null) {
			jButtonSetGraph = new JButton();
			jButtonSetGraph.setText("Set Graph");
			jButtonSetGraph.setPreferredSize(new Dimension(100, 30));
			jButtonSetGraph.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					setKomponenAddVertexDisable();
					setKomponenSetEdgeEnable();
					setGraph();
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonSetGraph;
	}

	/**
	 * This method initializes jButtonRemoveLastVertex	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRemoveLastVertex() {
		if (jButtonRemoveLastVertex == null) {
			jButtonRemoveLastVertex = new JButton();
			jButtonRemoveLastVertex.setText("Undo");
			jButtonRemoveLastVertex.setEnabled(false);
			jButtonRemoveLastVertex.setPreferredSize(new Dimension(100, 30));
			jButtonRemoveLastVertex.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					removeLastVertex();					
					drawGraph(getVertice());
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonRemoveLastVertex;
	}

	/**
	 * This method initializes jPanelSetParameter	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelSetParameter() {
		if (jPanelSetParameter == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = -1;
			gridBagConstraints.gridy = -1;
			jPanelSetParameter = new JPanel();
			jPanelSetParameter.setLayout(new GridBagLayout());
			jPanelSetParameter.add(getJPanelSetParameterAlgoritma(), gridBagConstraints);
		}
		return jPanelSetParameter;
	}

	/**
	 * This method initializes jPanelSetParameterAlgoritma	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelSetParameterAlgoritma() {
		if (jPanelSetParameterAlgoritma == null) {
			jLabelBeta1 = new JLabel();
			jLabelBeta1.setText("beta(konstanta pengendali visibilitas jejak semut)");
			jLabelNCmax1 = new JLabel();
			jLabelNCmax1.setText("NCmax(jumlah siklus semut)");
			jLabelTou1 = new JLabel();
			jLabelTou1.setText("tou(intensitas jejak semut awal)");
			jLabelRho1 = new JLabel();
			jLabelRho1.setText("rho(konstanta penguapan jejak semut)");
			jLabelM = new JLabel();
			jLabelM.setText("m(banyaknya semut)");
			jLabelAlpha1 = new JLabel();
			jLabelAlpha1.setText("alpha(konstanta pengendali intensitas jejak semut)");
			jLabelQ1 = new JLabel();
			jLabelQ1.setText("Q(konstanta siklus semut)");
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(8);
			gridLayout1.setColumns(2);
			jPanelSetParameterAlgoritma = new JPanel();
			jPanelSetParameterAlgoritma.setLayout(gridLayout1);
			jPanelSetParameterAlgoritma.setPreferredSize(new Dimension(600, 250));
			jPanelSetParameterAlgoritma.add(jLabelQ1, null);
			jPanelSetParameterAlgoritma.add(getJTextFieldQ(), null);
			jPanelSetParameterAlgoritma.add(jLabelAlpha1, null);
			jPanelSetParameterAlgoritma.add(getJTextFieldAlpha(), null);
			jPanelSetParameterAlgoritma.add(jLabelBeta1, null);
			jPanelSetParameterAlgoritma.add(getJTextFieldBeta(), null);
			jPanelSetParameterAlgoritma.add(jLabelM, null);
			jPanelSetParameterAlgoritma.add(getJTextFieldM(), null);
			jPanelSetParameterAlgoritma.add(jLabelRho1, null);
			jPanelSetParameterAlgoritma.add(getJTextFieldRho(), null);
			jPanelSetParameterAlgoritma.add(jLabelTou1, null);
			jPanelSetParameterAlgoritma.add(getJTextFieldTou(), null);
			jPanelSetParameterAlgoritma.add(jLabelNCmax1, null);
			jPanelSetParameterAlgoritma.add(getJTextFieldNCmax(), null);
			jPanelSetParameterAlgoritma.add(getJButtonProses(), null);
			jPanelSetParameterAlgoritma.add(getJButtonVisualisasi(), null);			
		}
		return jPanelSetParameterAlgoritma;
	}	

	/**
	 * This method initializes jTextFieldQ	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldQ() {
		if (jTextFieldQ == null) {
			jTextFieldQ = new JTextField();
			jTextFieldQ.setPreferredSize(new Dimension(200, 30));
		}
		return jTextFieldQ;
	}

	/**
	 * This method initializes jTextFieldAlpha	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldAlpha() {
		if (jTextFieldAlpha == null) {
			jTextFieldAlpha = new JTextField();
			jTextFieldAlpha.setPreferredSize(new Dimension(200, 30));
		}
		return jTextFieldAlpha;
	}

	/**
	 * This method initializes jTextFieldBeta	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldBeta() {
		if (jTextFieldBeta == null) {
			jTextFieldBeta = new JTextField();
			jTextFieldBeta.setPreferredSize(new Dimension(200, 30));
		}
		return jTextFieldBeta;
	}

	/**
	 * This method initializes jTextFieldM	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldM() {
		if (jTextFieldM == null) {
			jTextFieldM = new JTextField();
			jTextFieldM.setPreferredSize(new Dimension(200, 30));
		}
		return jTextFieldM;
	}

	/**
	 * This method initializes jTextFieldRho	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldRho() {
		if (jTextFieldRho == null) {
			jTextFieldRho = new JTextField();
			jTextFieldRho.setPreferredSize(new Dimension(200, 30));
		}
		return jTextFieldRho;
	}

	/**
	 * This method initializes jTextFieldTou	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldTou() {
		if (jTextFieldTou == null) {
			jTextFieldTou = new JTextField();
			jTextFieldTou.setPreferredSize(new Dimension(200, 30));
		}
		return jTextFieldTou;
	}

	/**
	 * This method initializes jTextFieldNCmax	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldNCmax() {
		if (jTextFieldNCmax == null) {
			jTextFieldNCmax = new JTextField();
			jTextFieldNCmax.setPreferredSize(new Dimension(200, 30));
		}
		return jTextFieldNCmax;
	}

	/**
	 * This method initializes jButtonProses	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonProses() {
		if (jButtonProses == null) {
			jButtonProses = new JButton();
			jButtonProses.setText("Proses");
			jButtonProses.setPreferredSize(new Dimension(100, 30));
			jButtonProses.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					double q	=Double.parseDouble(jTextFieldQ.getText().trim());
					double alpha=Double.parseDouble(jTextFieldAlpha.getText().trim());
					double beta	=Double.parseDouble(jTextFieldBeta.getText().trim());
					int m		=Integer.parseInt(jTextFieldM.getText().trim());
					double rho	=Double.parseDouble(jTextFieldRho.getText().trim());
					double tou	=Double.parseDouble(jTextFieldTou.getText().trim());
					int ncmax	=Integer.parseInt(jTextFieldNCmax.getText().trim());
					prosesACO(graph, q, alpha, beta, m, rho, tou, ncmax);
					getResultACO();
					showSolusiTerbaik(graph, theBestResultValue, theBestResult);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonProses;
	}

	/**
	 * This method initializes jButtonVisualisasi	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonVisualisasi() {
		if (jButtonVisualisasi == null) {
			jButtonVisualisasi = new JButton();
			jButtonVisualisasi.setText("Visualisasi");
			jButtonVisualisasi.setPreferredSize(new Dimension(100, 30));
		}
		return jButtonVisualisasi;
	}

	/**
	 * This method initializes jPanelButtonSolusiMST	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelButtonSolusiMST() {
		if (jPanelButtonSolusiMST == null) {
			jPanelButtonSolusiMST = new JPanel();
			jPanelButtonSolusiMST.setLayout(new FlowLayout());
			jPanelButtonSolusiMST.add(getJButtonAnimate(), null);
			jPanelButtonSolusiMST.add(getJButtonSolusiTerbaik(), null);
		}
		return jPanelButtonSolusiMST;
	}

	/**
	 * This method initializes jButtonAnimate	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAnimate() {
		if (jButtonAnimate == null) {
			jButtonAnimate = new JButton();
			jButtonAnimate.setText("Lihat Siklus");
		}
		return jButtonAnimate;
	}

	/**
	 * This method initializes jButtonSolusiTerbaik	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSolusiTerbaik() {
		if (jButtonSolusiTerbaik == null) {
			jButtonSolusiTerbaik = new JButton();
			jButtonSolusiTerbaik.setText("Solusi MST");
			jButtonSolusiTerbaik.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(graph!=null&&theBestResult!=null){
						showSolusiTerbaik(graph, theBestResultValue, theBestResult);
					}					
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonSolusiTerbaik;
	}

	/**
	 * This method initializes jButtonPresentase	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPresentase() {
		if (jButtonPresentase == null) {
			jButtonPresentase = new JButton();
			jButtonPresentase.setText("Presentase");
			jButtonPresentase.setSize(new Dimension(100, 30));
			jButtonPresentase.setLocation(new Point(655, 266));
		}
		return jButtonPresentase;
	}

	/**
	 * This method initializes jButtonExit	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonExit() {
		if (jButtonExit == null) {
			jButtonExit = new JButton();
			jButtonExit.setText("Exit");
			jButtonExit.setLocation(new Point(655, 361));
			jButtonExit.setSize(new Dimension(100, 30));
			jButtonExit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonExit;
	}

	/**
	 * This method initializes jPanelPresentase	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelPresentase() {
		if (jPanelPresentase == null) {
			jPanelPresentase = new JPanel();
			//jPanelPresentase.setLayout(null);//(new GridBagLayout());
			//jPanelPresentase.setPreferredSize(new Dimension(800, 600));
			jPanelPresentase.setLayout(new BorderLayout());
			jPanelPresentase.add(jPanelPresentase, BorderLayout.CENTER);//
			
		}
		return jPanelPresentase;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUIMSTscw thisClass = new GUIMSTscw();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public GUIMSTscw() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		try {
            UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
       // set UI manager properties here that affect Quaqua
       } catch (Exception e) {
           // take an appropriate action here
       }
       
		canvas = new Canvas();
		TranslateHandler translater = new TranslateHandler();
		canvas.addMouseListener(translater);
		canvas.addMouseMotionListener(translater);
		canvas.addMouseWheelListener(new ScaleHandler());
		
		canvas1 = new Canvas();
		TranslateHandler1 translater1 = new TranslateHandler1();
		canvas1.addMouseListener(translater1);
		canvas1.addMouseMotionListener(translater1);
		canvas1.addMouseWheelListener(new ScaleHandler1());
				
		panelPresentase=new PanelPresentase();
		setImageSlide(0);
		
		this.setSize(1024, 600);
		this.setUndecorated(true);
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		if(device.isFullScreenSupported()) {
			device.setFullScreenWindow(this);
		}
		this.setContentPane(getJContentPane());
		this.setTitle("Ant Colony System");
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJTabbedPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}
	
	
//////////////////////////////////////////////////////////////////////////////////
	AntColonySystem antColonySystem=null;  //  @jve:decl-index=0:
	Graph graph				=null;  //  @jve:decl-index=0:
	StackVertex stackVertex	=new StackVertex();  //  @jve:decl-index=0:
	Vertex[] vertice		=null;
	
	//Hasil Proses MST ACO
	int[][] result				=null;
	
	double resultValue;
	
	int[][][] resultSiklus		=null;
	
	double[] resultValueSiklus	=null;
	
	int[][] theBestResult		=null;
	
	double theBestResultValue;

	private JPanel jPanelSetParameter = null;

	private JPanel jPanelSetParameterAlgoritma = null;

	private JLabel jLabelQ = null;

	private JTextField jTextFieldQ = null;

	private JLabel jLabelAlpha = null;

	private JTextField jTextFieldAlpha = null;

	private JLabel jLabelBeta = null;

	private JTextField jTextFieldBeta = null;

	private JLabel jLabelm = null;

	private JTextField jTextFieldM = null;

	private JLabel jLabelRho = null;

	private JTextField jTextFieldRho = null;

	private JLabel jLabelTou = null;

	private JTextField jTextFieldTou = null;

	private JLabel jLabelNCmax = null;

	private JTextField jTextFieldNCmax = null;

	private JButton jButtonProses = null;

	private JButton jButtonVisualisasi = null;

	private JLabel jLabelQ1 = null;

	private JLabel jLabelAlpha1 = null;

	private JLabel jLabelM = null;

	private JLabel jLabelRho1 = null;

	private JLabel jLabelTou1 = null;

	private JLabel jLabelNCmax1 = null;

	private JLabel jLabelBeta1 = null;

	public void addNewVertex(String label, int x, int y){
		label=label.toUpperCase();
		stackVertex.insertVetex(label, x, y);
	}//end of addNewVertex()
	
	public void removeLastVertex(){
		stackVertex.removeLast();
	}//end of RemoveLastVertex()
	
	public void clearVertex(){
		stackVertex.reset();
	}//end of clearVertex()
	
	public Vertex[] getVertice(){
		return stackVertex.getVertice();
	}//end of getVertice()
	
	public void setVertice(){
		vertice=stackVertex.getVertice();
	}//end of getVertice()
		
	public void createGraph(){
		if(vertice!=null){
			graph=new Graph(vertice);
		}
	}//end of createGraph();
	
	public void createGraph(Vertex[] vertex, int[][] adjMat){
		if(vertice!=null){
			graph=new Graph(vertex, adjMat);
		}
	}//end of createGraph();
	
	public void setGraph(){
		setVertice();
		createGraph();
	}//end of setGraph()
	
	public void setEdge(String v1,String v2){
		if(graph!=null){
			graph.setEdge(v1,v2);
		}//end of if(graph!=null)
	}//end of setEdge(String v1,String v2)
		
	public void prosesACO(Graph graph, double q, double alpha, double beta, int m, double rho, double tou, int ncmax){
		if(	(graph!=null)&&
			(alpha>=0)&&
			(beta>0)&&
			((rho>0)&&(rho<=1))	
		){
			antColonySystem=new AntColonySystem(graph, q, alpha, beta, m, rho, tou, ncmax);
		}//end of if()
	}//end of prosesACO()
	
	
	public void getResultACO(){
		if(antColonySystem!=null){
			result				=antColonySystem.getResult();
			resultValue			=antColonySystem.getResultValue();
			resultSiklus		=antColonySystem.getResultSiklus();
			resultValueSiklus	=antColonySystem.getResultValueSiklus();
			theBestResult		=antColonySystem.getTheBestResult();
			theBestResultValue	=antColonySystem.getTheBestResultValue();
		}//end of if(antColonySystem!=null)
	}//end of getResultACO()
	
	public void setKomponenAddVertexEnable(){
		jTextFieldLabelVertex.setEnabled(true);
		jTextFieldX.setEnabled(true);
		jTextFieldY.setEnabled(true);
		jButtonAddVertex.setEnabled(true);
		jButtonRemoveLastVertex.setEnabled(true);
	}//end of setButtonAddVertexEnable()
	
	public void setKomponenAddVertexDisable(){
		jTextFieldLabelVertex.setEnabled(false);
		jTextFieldX.setEnabled(false);
		jTextFieldY.setEnabled(false);
		jButtonAddVertex.setEnabled(false);
		jButtonRemoveLastVertex.setEnabled(false);
	}//end of setButtonAddVertexDisable()
	
	public void setKomponenSetEdgeEnable(){
		jTextFieldV1.setEnabled(true);
		jTextFieldV2.setEnabled(true);
		jButtonSetEdge.setEnabled(true);
	}//end of setKomponenSetEdgeEnable()
	
	public void setKomponenSetEdgeDisable(){
		jTextFieldV1.setEnabled(false);
		jTextFieldV2.setEnabled(false);
		jButtonSetEdge.setEnabled(false);
	}//end of setKomponenSetEdgeDisable()
	
	public void drawGraph(Graph graph1){
		canvas.setGraph(graph1);
	}//end of void drawGraph()
	
	public void drawGraph(Vertex[] vertice1){
		canvas.setVertice(vertice1);
	}//end of void drawGraph()
	
	public void showSolusiTerbaik(Graph graph1, double solusiMST1, int[][] result1){
		if(theBestResult!=null){
			canvas1.setGraph(graph1, solusiMST1, result1); 
		}
	}//end of showSolusiTerbaik() 
	
	private JFileChooser fc= new JFileChooser();
	
	private File file=null;
	
	public void openGraph(){
		int hasil = fc.showOpenDialog(this);
		if(hasil==JFileChooser.APPROVE_OPTION){
			file=fc.getSelectedFile();
			graph=new Open(file).getGraph();
			drawGraph(graph);
		}//end of if(hasil==JFileChooser.APPROVE_OPTION)
	}//end of openGraph()
	
	public void saveGraph(){
		int hasil = fc.showSaveDialog(this);
		if(hasil==JFileChooser.APPROVE_OPTION){
			file=fc.getSelectedFile();
			if(graph!=null){
				new Save(graph,file);
			}
		}//end of if(hasil==JFileChooser.APPROVE_OPTION)
	}//end of saveGraph()
	
	private static Canvas canvas;
	
	private static Canvas canvas1;

	private JPanel jPanelButtonSolusiMST = null;

	private JButton jButtonAnimate = null;

	private JButton jButtonSolusiTerbaik = null;

	private JButton jButtonPresentase = null;

	private JButton jButtonExit = null;

	private static class TranslateHandler implements MouseListener,	MouseMotionListener {//---------------------------
		private int lastOffsetX;
		private int lastOffsetY;

		public void mousePressed(MouseEvent e) {
			// capture starting point
			lastOffsetX = e.getX();
			lastOffsetY = e.getY();
		}

		public void mouseDragged(MouseEvent e) {	
			// new x and y are defined by current mouse location subtracted
			// by previously processed mouse location
			int newX = e.getX() - lastOffsetX;
			int newY = e.getY() - lastOffsetY;

			// increment last offset to last processed by drag event.
			lastOffsetX += newX;
			lastOffsetY += newY;

			// update the canvas locations
			canvas.translateX += newX;
			canvas.translateY += newY;
		
			// schedule a repaint.
			canvas.repaint();
		}

		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseMoved(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		}//end of class TranslateHandler------------------------------------------------------------------------------

		private static class ScaleHandler implements MouseWheelListener {//-------------------------------------------
			public void mouseWheelMoved(MouseWheelEvent e) {
				if(e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {			
					canvas.scale += (.1 * e.getWheelRotation());
					canvas.scale = Math.max(0.00001, canvas.scale); 
					canvas.repaint();
				}
			}
		}//end of class ScaleHandler----------------------------------------------------------------------------------
	//////////////////////
		private static class TranslateHandler1 implements MouseListener,	MouseMotionListener {//---------------------------
			private int lastOffsetX;
			private int lastOffsetY;

			public void mousePressed(MouseEvent e) {
				// capture starting point
				lastOffsetX = e.getX();
				lastOffsetY = e.getY();
			}

			public void mouseDragged(MouseEvent e) {	
				// new x and y are defined by current mouse location subtracted
				// by previously processed mouse location
				int newX = e.getX() - lastOffsetX;
				int newY = e.getY() - lastOffsetY;

				// increment last offset to last processed by drag event.
				lastOffsetX += newX;
				lastOffsetY += newY;

				// update the canvas locations
				canvas1.translateX += newX;
				canvas1.translateY += newY;
			
				// schedule a repaint.
				canvas1.repaint();
			}

			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseMoved(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			}//end of class TranslateHandler------------------------------------------------------------------------------

			private static class ScaleHandler1 implements MouseWheelListener {//-------------------------------------------
				public void mouseWheelMoved(MouseWheelEvent e) {
					if(e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {			
						canvas1.scale += (.1 * e.getWheelRotation());
						canvas1.scale = Math.max(0.00001, canvas1.scale); 
						canvas1.repaint();
					}
				}
	}//end of class ScaleHandler----------------------------------------------------------------------------------
			
	PanelPresentase panelPresentase=new PanelPresentase();
	
	public void setImagePresentase(String imageURL){
		try{
		URL url=getClass().getResource(imageURL);
		panelPresentase.setImage(url);
		}catch(Exception e){}
	}
	
	int index=0;
	int indexLength=1;
	int indexPresentase=0;
	
	String[] sImage=null;

	private JPanel jPanelPresentase = null;
	
	public void setImageSlide(int nImage){
		indexLength=nImage;
		sImage=new String[nImage];
		for(int i=0;i<sImage.length;i++){
			sImage[i]="slide"+(i)+".jpg";
		}
	}
	
	public void next(){
		indexPresentase=1+index;
		indexPresentase=indexPresentase%indexLength;
		setImageSlide(indexPresentase);
		index=indexPresentase;
	}//end next()
	
	public void previous(){
		indexPresentase=-1+index;
		indexPresentase=indexPresentase%indexLength;
		setImageSlide(indexPresentase);
		index=indexPresentase;
	}//end next()
	
//////////////////////////////////////////////////////////////////////////////////

}  //  @jve:decl-index=0:visual-constraint="10,10"
//E n d    O f    C l a s s
