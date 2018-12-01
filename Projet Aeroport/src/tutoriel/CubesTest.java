package tutoriel;

import com.jme3.app.SimpleApplication;
import com.jme3.input.ChaseCamera;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

public class CubesTest extends SimpleApplication {

	@Override
	public void simpleInitApp() {
		// TODO Auto-generated method stub
		Box b = new Box(1, 1, 1);
		Geometry geom = new Geometry("Box",b);
		Geometry geom2 = new Geometry("Box",b);
		geom2.setLocalTranslation(0, 3, 0);
		Geometry geom3 = new Geometry("Box",b);
		geom3.setLocalTranslation(3, 0, -3);
		Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		Material mat3 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		mat.setColor("Color", ColorRGBA.Blue);
		mat2.setColor("Color", ColorRGBA.Green);
		mat3.setColor("Color", ColorRGBA.Red);
		geom.setMaterial(mat);
		geom2.setMaterial(mat2);
		geom3.setMaterial(mat3);
		rootNode.attachChild(geom);
		rootNode.attachChild(geom2);
		rootNode.attachChild(geom3);
		
		flyCam.setEnabled(false);
		
		ChaseCamera	chaseCam = new ChaseCamera(cam, geom, inputManager);
		chaseCam.setDragToRotate(true);
		
		chaseCam.setInvertVerticalAxis(true);
		chaseCam.setRotationSpeed(10.0f);
		chaseCam.setMinVerticalRotation((float) -(Math.PI/2 - 0.0001f));
		chaseCam.setMaxVerticalRotation((float) Math.PI/2);
		chaseCam.setMinDistance(7.5f);
		chaseCam.setMaxDistance(30.0f);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppSettings settings = new AppSettings(true);
		settings.setResolution(1280, 800);
		settings.setSamples(8);
		
		CubesTest app = new CubesTest();
		app.setSettings(settings);
		app.setShowSettings(false);
		app.setDisplayStatView(false);
		app.setDisplayFps(false);
		app.start();
	}

}
