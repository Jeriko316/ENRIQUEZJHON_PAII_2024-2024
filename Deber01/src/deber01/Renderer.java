package deber01;

import javax.swing.JFrame;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;




public class Renderer extends JFrame implements GLEventListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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


	@Override
	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		GL2 gl = drawable.getGL().getGL2();		
		gl.glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);		
		gl.glBegin(GL.GL_TRIANGLES);
		gl.glVertex3f(-0.5f, -0.5f, 0.0f);
		gl.glVertex3f(0.0f, 0.5f, 0.0f);
		gl.glVertex3f(0.5f, -0.5f, 0.0f);
		gl.glEnd();
		//
		gl.glFlush();

	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		
	}

}
