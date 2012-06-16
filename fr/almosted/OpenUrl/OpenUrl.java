package fr.almosted.OpenUrl;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OpenUrl extends JFrame {

	private static final long serialVersionUID = 7963854678955336024L;
	
	OpenUrlFrame of = new OpenUrlFrame();

	public OpenUrl() {
		this.setSize(200, 75);
		this.setTitle("OpenUrl");
		this.setContentPane(of);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		of.drawScreen();
		of.run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int fois = Integer.parseInt(of.fois.getText());
				for(int l = 1; fois >= l; l++) {
					String url = of.site.getText();
					url = url.replaceAll("http://", "");
					openLink("http://" + url);
				}
			}
		});
	}
	
	public static void openLink(String site) {
        Desktop desktop = null;
    	URI url = null;
		try {
			url = new URI(site);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
        	if(Desktop.isDesktopSupported())
        	{
        		desktop = Desktop.getDesktop();
        		try {
					desktop.browse(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
	}
	
	public static void main(String[] args) {
		new OpenUrl();
	}
	
public class OpenUrlFrame extends JPanel {
	
	private static final long serialVersionUID = 6197853968511660201L;
	
	JLabel lsite = new JLabel("URL du site? http://");
	JLabel lfois = new JLabel("Combien de fois?");
	
	JButton run = new JButton("GO !");
	
	JTextField site = new JTextField();
	JTextField fois = new JTextField();
	
	Font font = new Font("Arial", Font.PLAIN, 11);
	
	public void paintComponent(Graphics g) {
		lsite.setFont(font);
		lsite.setLocation(0, 0);
		
		site.setFont(font);
		site.setSize(95, 17);
		site.setLocation(95, 2);
		
		lfois.setFont(font);
		lfois.setLocation(0, 20);
		
		fois.setFont(font);
		fois.setSize(30, 17);
		fois.setLocation(90, 22);
		
		run.setFont(font);
		run.setSize(60, 20);
		run.setLocation(125, 22);
	}
	
	public void drawScreen() {
		add(run);
		add(lsite);
		add(lfois);
		add(site);
		add(fois);
	}
}

}
