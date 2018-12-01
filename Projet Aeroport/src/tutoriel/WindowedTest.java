package tutoriel;

import com.jme3.system.AppSettings;
import com.jme3.system.JmeCanvasContext;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
@SuppressWarnings("unused")
public class WindowedTest {
	
	// TODO : Add here a static variable which will make possible 
	// to store a link to your JMonkeyEngine application 
	private static EarthTest canvasApplication;
	
    private static Canvas canvas; // JAVA Swing Canvas
    
	private static JFrame frame;
	private static JPanel panel;
	private static JPanel panelRecherche;
	private JTextField textFieldPaysDepart=new JTextField(32);
	private JTextField textFieldVilleDepart=new JTextField(32);
	private JTextField textFieldAeroportDepart=new JTextField(32);
	private JTextField textFieldPaysArrivee=new JTextField(32);
	private JTextField textFieldVilleArrivee=new JTextField(32);
	private JTextField textFieldAeroportArrivee=new JTextField(32);
	private JButton affichage = new JButton("Affichage");
    
	private static void createNewJFrame() {

		frame = new JFrame("Java - Graphique - IHM");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    frame.addWindowListener(new WindowAdapter(){
	        @Override
	        public void windowClosed(WindowEvent e) {
	        	// TODO : Uncomment this in order to stop the application
	        	// when the windows will be closed.
	        	canvasApplication.stop();
	        }
	    });
		
		panel = new JPanel(new BorderLayout());
		panelRecherche = new JPanel();
		panelRecherche.setLayout(new BoxLayout(panelRecherche, BoxLayout.PAGE_AXIS));

		// Create the menus
		final JMenuBar menubar = new JMenuBar();
		final JMenu objectsMenu = new JMenu("File");
		final JMenu helpMenu = new JMenu("Help");

		final JMenuItem createObjectItem = new JMenuItem("Create an object");
		final JMenuItem deleteObjectItem = new JMenuItem("Delete an object");
		final JMenuItem getControlsItem = new JMenuItem("Get controls");

		objectsMenu.add(createObjectItem);
		objectsMenu.add(deleteObjectItem);
		helpMenu.add(getControlsItem);
		menubar.add(objectsMenu);
		menubar.add(helpMenu);
		frame.setJMenuBar(menubar);

		getControlsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JFrame dial = new JFrame("Controls");
				final JPanel pane = new JPanel();
				pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));

				JTextArea cautionText = new JTextArea(
						"Add some text here to describe the controls \n" + '\n');
				cautionText.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
				cautionText.setEditable(false);
				pane.add(cautionText);

				JButton okButton = new JButton("Ok");
				okButton.setSize(50, okButton.getHeight());
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dial.dispose();
					}
				});

				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
				buttonPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
				buttonPane.add(Box.createHorizontalGlue());
				buttonPane.add(okButton);

				pane.add(buttonPane);
				pane.add(Box.createRigidArea(new Dimension(0, 5)));
				dial.add(pane);
				dial.pack();
				dial.setLocationRelativeTo(frame);
				dial.setVisible(true);
			}
		});
		
		// Add the canvas to the panel
        panel.add(canvas, BorderLayout.CENTER);
		panelRecherche.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.add(panelRecherche, BorderLayout.WEST);
        
        frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		// Fix an alignment bug on Mac OS X:
        // re-add the canvas and resize the JFrame
        /*try { Thread.sleep(2000);} catch (InterruptedException ex) {}
        panel.add(canvas, BorderLayout.CENTER);
        try { Thread.sleep(1000);} catch (InterruptedException ex) {}
        frame.setSize(frame.getWidth()+1, frame.getHeight());
        frame.setSize(frame.getWidth()-1, frame.getHeight());*/
	}

    public static void main(String[] args){
        // create new JME appsettings
		AppSettings settings = new AppSettings(true);
		settings.setResolution(1280, 800);
		settings.setSamples(8);

        // TODO : create here a new JMonkeyEngine application
         canvasApplication = new EarthTest();
		
		// TODO : apply the settings and configure our application
		// in the same way than in the "public static void main()" method
        canvasApplication.setSettings(settings);
        canvasApplication.setShowSettings(false);
        canvasApplication.setDisplayStatView(false);
        canvasApplication.setDisplayFps(false);
         
        // TODO : Uncomment this line to start the application
        // NB : this line is used instead of the app.start();
        canvasApplication.createCanvas(); // create canvas!
        
        // TODO : Uncomment the following lines to get the canvas from our application
        JmeCanvasContext ctx = (JmeCanvasContext) canvasApplication.getContext();
        ctx.setSystemListener(canvasApplication);
        Dimension dim = new Dimension(settings.getWidth(), settings.getHeight());
        canvas = ctx.getCanvas();
        canvas.setPreferredSize(dim);

        
        // Create the JFrame with the Canvas on the middle
        createNewJFrame();
        
		// ArrayList<Airport> listAirport = new
		// AirportsData().getCollectionAirport();

		// long start=System.nanoTime();
		// while((System.nanoTime()-start)<5000000000.0); 
        
		//canvasApplication.affichageListeAirport(listAirport);
        
    }

}
