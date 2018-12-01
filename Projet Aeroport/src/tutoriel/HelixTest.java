package tutoriel;

import com.jme3.app.SimpleApplication;
import com.jme3.input.ChaseCamera;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer;
import com.jme3.system.AppSettings;
import com.jme3.util.BufferUtils;

public class HelixTest extends SimpleApplication {

	@Override
	public void simpleInitApp() {
		// TODO Auto-generated method stub
		Vector3f[] vertices = new Vector3f[100];
		for(int i=0; i<100; i++) {
			float t = i / 5.0f;
			vertices[i] = new Vector3f(FastMath.cos(t), t/5.0f, FastMath.sin(t));
		}
		
		Mesh lineMesh = new Mesh();
		lineMesh.setMode(Mesh.Mode.LineStrip);
		lineMesh.setBuffer(VertexBuffer.Type.Position, 3 , BufferUtils.createFloatBuffer(vertices));
		lineMesh.updateBound();
		lineMesh.setLineWidth(2.0f);
		
		Geometry lineGeo = new Geometry("lineGeo", lineMesh);
		Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		mat.setColor("Color", ColorRGBA.Green);
		lineGeo.setMaterial(mat);
		lineGeo.setLocalTranslation(3.0f, -1.0f, 0.0f);
		rootNode.attachChild(lineGeo);
		
		ChaseCamera	chaseCam = new ChaseCamera(cam, lineGeo, inputManager);
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
		
		HelixTest app = new HelixTest();
		app.setSettings(settings);
		app.setShowSettings(false);
		app.setDisplayStatView(false);
		app.setDisplayFps(false);
		app.start();
	}

}
