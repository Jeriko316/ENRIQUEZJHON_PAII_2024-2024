package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import figura.Bullet;
import figura.EnemyShip;
import figura.TriangularShip;

public class GameControl extends JPanel implements KeyListener, ActionListener {
	private TriangularShip ship;
	private Timer timer;
	private Bullet bullet;
	private List<EnemyShip> enemies = EnemyShip.spawnEnemies(7, 26, 30); // Spawn 10 enemies
	private boolean gameOver;

	public GameControl() {
		setPreferredSize(new Dimension(800, 600));
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);

		ship = new TriangularShip(400, 500);
		

		timer = new Timer(10, this); // Cada 10 milisegundos
		timer.start();
		gameOver = false;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ship.draw(g);

		if (gameOver) {
			drawGameOverMessage(g);
		} else {
			for (EnemyShip enemy : enemies) {
				enemy.draw(g);
			}
		}
	}

	private void drawGameOverMessage(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.drawString("GAME OVER", 250, 300);
	}

	private void checkGameOver() {
		for (EnemyShip enemy : enemies) {
			if (enemy.getY() > 370) { // 66% of screen height
				gameOver = true;
				timer.stop();
				break;
			}
		}
	}
	
	
	private void handleBulletRectangleCollisions() {
		 List<Bullet> bullets = ship.getBullets();
		    Iterator<Bullet> bulletIterator = bullets.iterator();
		    while (bulletIterator.hasNext()) {
		        Bullet bullet = bulletIterator.next();
		        for (EnemyShip enemy : enemies) {
		            if (bullet.getBounds().intersects(enemy.getBounds()) && enemy.isAlive()) {
		                // Remove the bullet first
		                bulletIterator.remove();

		                // Then mark the enemy as destroyed
		                enemy.setAlive(false);
		                break; // Exit inner loop after collision is detected
		            }
		        }
		        bullet.move();
		        if (bullet.getY() < 0) {
		            bulletIterator.remove();
		        }
		    }
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		updateBullets();
		
		 
		//handleBulletRectangleCollisions();
		
		for (EnemyShip enemy : enemies) {
			enemy.move();
			if (!enemy.isAlive()) {
				enemies.remove(enemy); // Remove dead enemies
			}
		}

	
		checkGameOver();
		repaint();
	}

	private void updateBullets() {
		List<Bullet> bullets = ship.getBullets();
		for (int i = 0; i < bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			bullet.move();
			if (bullet.getY() < 0) {
				bullets.remove(i);
				i--;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			ship.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			ship.moveRight();
			break;
		case KeyEvent.VK_UP:
			ship.moveUp();
			break;
		case KeyEvent.VK_DOWN:
			ship.moveDown();
			break;
		}
		repaint();

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			ship.shoot();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
