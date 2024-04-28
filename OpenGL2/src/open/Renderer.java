package open;

import com.jogamp.opengl.GLEventListener;

public class Renderer  extends JFrame implements GLEventListener{

	public Renderer() {
		super("Primer Aplicación JOGL");
		this.setSize(640, 480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities caps = new GLCapabilities(profile);
		GLCanvas canvas = new GLCanvas(caps);
		canvas.addGLEventListener(this);
		this.add(canvas);
		this.setVisible(true);
		canvas.requestFocusInWindow();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
