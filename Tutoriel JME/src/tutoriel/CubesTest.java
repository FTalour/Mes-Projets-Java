package tutoriel;

import com.jme3.app.SimpleApplication;
import com.jme3.input.ChaseCamera;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

public class CubesTest extends SimpleApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppSettings settings = new AppSettings(true);
		settings.setResolution(1280, 800);
		settings.setSamples(8); //antialiasing
		
		CubesTest app = new CubesTest();
		app.setSettings(settings);
		app.setShowSettings(false); //disable the configuration windows
		app.setDisplayFps(false);
		app.setDisplayFps(false);
		app.start();
	}

	@Override
	public void simpleInitApp() {
		// TODO Auto-generated method stub
		Box b = new Box(1,1,1);
		Geometry geom1 = new Geometry("Box",b);
		Material mat1 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		mat1.setColor("Color", ColorRGBA.Blue);
		geom1.setMaterial(mat1);
		rootNode.attachChild(geom1);
		
		Geometry geom2 = new Geometry("Box",b);
		Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		mat2.setColor("Color", ColorRGBA.Red);
		geom2.setMaterial(mat2);
		geom2.setLocalTranslation(3.0f, 0.0f, 3.0f);
		rootNode.attachChild(geom2);
		
		Geometry geom3 = new Geometry("Box",b);
		Material mat3 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		mat3.setColor("Color", ColorRGBA.Green);
		geom3.setMaterial(mat3);
		geom3.setLocalTranslation(0.0f, 3.0f, 0.0f);
		rootNode.attachChild(geom3);
		
		/*------------------------ Camera settings ------------------------*/
	
		flyCam.setEnabled(false);
		
		ChaseCamera chaseCam = new ChaseCamera(cam, geom1, inputManager);
		chaseCam.setDragToRotate(true); //rotation only with left mouse button push
		
		chaseCam.setInvertVerticalAxis(true);
		chaseCam.setRotationSpeed(10.0f);
		chaseCam.setMinVerticalRotation((float) - (Math.PI/2 - 0.0001f));
		chaseCam.setMaxVerticalRotation((float) Math.PI/2);
		chaseCam.setMinDistance(7.5f);
		chaseCam.setMaxDistance(30.0f);
	}

}
