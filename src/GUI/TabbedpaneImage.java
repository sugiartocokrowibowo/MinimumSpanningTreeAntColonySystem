package GUI;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;

public class TabbedpaneImage extends javax.swing.JTabbedPane {

	/**
	  * @author : SCW ASAISoft
	 **/
	    Image image = null;
	    TabbedpaneImage(File file){
	        if(file != null) {
	            MediaTracker mt = new MediaTracker(this);
	            ImageIcon icon = new ImageIcon(file.getPath());
	            image = icon.getImage();
	            mt.addImage(image, 0);
	            try {
	                mt.waitForAll();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    TabbedpaneImage(URL url){
	        if(url != null) {
	            MediaTracker mt = new MediaTracker(this);
	            ImageIcon icon = new ImageIcon(url);
	            image = icon.getImage();
	            mt.addImage(image, 0);
	            try {
	                mt.waitForAll();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        if(image != null) {
	        	 //melakukan penggambaran dengan memanfaatkan Graphics2D
	            Graphics2D gd = (Graphics2D) g.create();
	            //mengatur nilai transparansi gambar antara 0.0 - 1.0 Float 
	            //gd.setComposite(AlphaComposite.SrcOver.derive(0.5F));
	            //menggambar image 
	            gd.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	            //menutup Graphics2D 
	            gd.dispose();
	        }
	    }

}///


