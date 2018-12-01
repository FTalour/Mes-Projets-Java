package tutoriel;

import java.util.ArrayList;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.ZipLocator;
import com.jme3.input.ChaseCamera;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.VertexBuffer;
import com.jme3.scene.shape.Sphere;
import com.jme3.system.AppSettings;
import com.jme3.util.BufferUtils;

import database.Airport;
import database.Route;

public class EarthTest extends SimpleApplication {

	private static final float TEXTURE_LAT_OFFSET = -0.2f;
	private static final float TEXTURE_LON_OFFSET = 2.8f;
	
	private static final float curb_height_var = 0.2f;
	private static final float curb_size_var = 2.0f;
	
	private static final float town_size = 0.005f;
	
	private static Node AirportNode = new Node();
	
	private static Vector3f geoCoordTo3dCoord(float lat, float lon) {
		float lat_cor = lat + TEXTURE_LAT_OFFSET;
		float lon_cor = lon + TEXTURE_LON_OFFSET;
		return new Vector3f (- FastMath.sin(lon_cor * FastMath.DEG_TO_RAD)
							 * FastMath.cos(lat_cor * FastMath.DEG_TO_RAD),
							   FastMath.sin(lat_cor * FastMath.DEG_TO_RAD),
							 - FastMath.cos(lon_cor * FastMath.DEG_TO_RAD)
							 * FastMath.cos(lat_cor * FastMath.DEG_TO_RAD));
		
	}
	
	public Geometry displayTown(Airport airport) {
		System.out.println("displayTown : " + airport.toString());
		Sphere sphere = new Sphere (16, 8, town_size);
		Geometry town = new Geometry(airport.getName(), sphere);
		//System.out.print("displayTown : ass : " + assetManager.toString());
		Material mat = new Material(this.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
		mat.setColor("Color", ColorRGBA.White);
		town.setMaterial(mat);
		town.setLocalTranslation(geoCoordTo3dCoord((float)airport.getLatitude(), (float)airport.getLongitude()));
		return town;
	}
	
	public Geometry displayFlight(Route route, ArrayList<Airport> listAirport)
	{	
		
		float latitudeSource = 0;
		float latitudeDest = 0;
		float longitudeSource = 0;
		float longitudeDest = 0;
		
		for(Airport temp : listAirport){
			if(temp.getId() == route.getSourceAirportID()){
				latitudeSource = (float) temp.getLatitude();
				longitudeSource = (float) temp.getLongitude();
			}
			if(temp.getId() == route.getDestinationAirportID()){
				latitudeDest = (float) temp.getLatitude();
				longitudeDest = (float) temp.getLongitude();
			}
		}
		
		Vector3f pointSource = new Vector3f(geoCoordTo3dCoord(latitudeSource, longitudeSource));
		Vector3f pointDest = new Vector3f(geoCoordTo3dCoord(latitudeDest, longitudeDest));
		Vector3f[] vertices = new Vector3f[101];
		float moyenne = (float) FastMath.sqrt((pointDest.x-pointSource.x)*(pointDest.x-pointSource.x) + (pointDest.y-pointSource.y)*(pointDest.y-pointSource.y) + (pointDest.z-pointSource.z)*(pointDest.z-pointSource.z));
		float coordmultiplier = 0;
		
		for(int i = 0; i <= 100; i++){
			vertices[i] = new Vector3f((1-i/100f) * pointSource.x + i/100f * pointDest.x, (1-i/100f) * pointSource.y + i/100f * pointDest.y, (1-i/100f) * pointSource.z + i/100f * pointDest.z);
			//coordmultiplier = (float) (1+FastMath.sin(i * FastMath.PI / 10)) * rayon / FastMath.sqrt(vertices[i].x * vertices[i].x + vertices[i].y * vertices[i].y + vertices[i].z * vertices[i].z);
			coordmultiplier = (float) (1+FastMath.sin(i * FastMath.PI / 100)*moyenne*curb_height_var);
			System.out.println(coordmultiplier);
			vertices[i].normalizeLocal();
			vertices[i].x *= coordmultiplier;
			vertices[i].y *= coordmultiplier;
			vertices[i].z *= coordmultiplier;
		}
		
		Mesh lineMesh = new Mesh();
		lineMesh.setMode(Mesh.Mode.LineStrip);
		lineMesh.setBuffer(VertexBuffer.Type.Position, 3 , BufferUtils.createFloatBuffer(vertices));
		lineMesh.updateBound();
		lineMesh.setLineWidth(curb_size_var);
		
		Geometry lineGeo = new Geometry("lineGeo", lineMesh);
		Material matline = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		matline.setColor("Color", ColorRGBA.Green);
		
		lineGeo.setMaterial(matline);
		return lineGeo;
	}
	
	public void affichageListeAirport(ArrayList<Airport> listeAirport){
		AirportNode.removeFromParent();
		AirportNode.detachAllChildren();
		for(Airport temp : listeAirport){
			System.out.println(temp);
			Geometry add = displayTown(temp);
			System.out.println(add);
			AirportNode.attachChild(add);
		}
		rootNode.attachChild(AirportNode);
	}
	
	public void affichageListeRoute(Node RouteNode, ArrayList<Route> listRoute,  ArrayList<Airport> listAirport){
		RouteNode.removeFromParent();
		RouteNode = new Node();
		rootNode.attachChild(RouteNode);
		for(Route temp : listRoute){
			RouteNode.attachChild(displayFlight(temp, listAirport));
		}
	}
	
	@Override
	public void simpleInitApp() {
		// TODO Auto-generated method stub
		assetManager.registerLocator("earth.zip", ZipLocator.class);
		Spatial earth_geom = assetManager.loadModel("Sphere.mesh.xml");
		rootNode.attachChild(earth_geom);
		
		//change the color of the background
		viewPort.setBackgroundColor(new ColorRGBA(0.1f, 0.1f, 0.1f ,1.0f));
		
		rootNode.attachChild(AirportNode);
		
		//ArrayList<Airport> listAirport = new AirportData().getCollectionAirport();
		//affichageListeAirport(listAirport);
		
		//listAirport = new ArrayList<Airport>();
		//affichageListeAirport(listAirport);
		
		
		
		/*------------------------ Camera settings ------------------------*/
		
		flyCam.setEnabled(false);
		
		ChaseCamera chaseCam = new ChaseCamera(cam, earth_geom, inputManager);
		chaseCam.setDragToRotate(true); //rotation only with left mouse button push
		
		chaseCam.setInvertVerticalAxis(true);
		chaseCam.setRotationSpeed(10.0f);
		chaseCam.setMinVerticalRotation((float) -(Math.PI/2 - 0.0001f));
		chaseCam.setMaxVerticalRotation((float) Math.PI/2);
		chaseCam.setMinDistance(2.5f);
		chaseCam.setMaxDistance(15.0f);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppSettings settings = new AppSettings(true);
		settings.setResolution(1280, 800);
		settings.setSamples(8); //antialiasing
		
		EarthTest app = new EarthTest();
		app.setSettings(settings);
		app.setShowSettings(false);	//disable the configuration windows
		app.setDisplayStatView(false);
		app.setDisplayFps(false);
		app.start();
	}

}
