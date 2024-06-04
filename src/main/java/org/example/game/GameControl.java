package org.example.game;

import org.example.figura.Bullet;
import org.example.figura.EnemyShip;
import org.example.figura.SuperEnemy;
import org.example.figura.TriangularShip;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.*;


public class GameControl  extends JPanel implements KeyListener, ActionListener {

    private TriangularShip ship;
    private Timer timer;
    private Bullet bullet;
    //private List<EnemyShip> enemies = (List<EnemyShip>) EnemyShip.spawnEnemies(7, 26, 30); // Spawn 10 enemies
    private List<EnemyShip> enemies;

    private boolean gameOver;

    private int enemySpawnCounter;
    private final int maxEnemies = 2;

    private int score;

    private String nickname;

    private SuperEnemy superEnemy;



    public GameControl() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        nickname = JOptionPane.showInputDialog(this, "Enter your nickname:");

        ship = new TriangularShip(400, 500);


        enemies = new LinkedList<>();
        gameOver = false;
        enemySpawnCounter = 0;

        score = 0;

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
            if (superEnemy != null) {
                superEnemy.draw(g);
            }
            drawScore(g);
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
            if (superEnemy != null && bullet.getBounds().intersects(superEnemy.getBounds()) && superEnemy.isAlive()) {
                bulletIterator.remove();
                superEnemy.hit();
                if (!superEnemy.isAlive()) {
                    score += 500; // Incrementar el puntaje en 500 por eliminar el super enemigo
                }
                continue;
            }
            Iterator<EnemyShip> enemyIterator = enemies.iterator();
            while (enemyIterator.hasNext()) {
                EnemyShip enemy = enemyIterator.next();
                if (bullet.getBounds().intersects(enemy.getBounds()) && enemy.isAlive()) {
                    bulletIterator.remove();
                    enemy.hit();
                    if (!enemy.isAlive()) {
                        enemyIterator.remove();
                        score += 100; // Incrementar el puntaje en 100 por cada enemigo eliminado
                        if (score >= 1000) {
                            enemySpawnCounter = Integer.MAX_VALUE; // Para detener el spawn de enemigos normales
                            if (superEnemy == null) {
                                superEnemy = new SuperEnemy(400, -SuperEnemy.getHeight()); // Crear el super enemigo
                            }
                        }
                    }
                    break;
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
        handleBulletRectangleCollisions();

        for (Iterator<EnemyShip> iterator = enemies.iterator(); iterator.hasNext(); ) {
            EnemyShip enemy = iterator.next();
            enemy.move();
            if (!enemy.isAlive()) {
                iterator.remove();
            }
        }

        if (superEnemy != null) {
            superEnemy.move();
        }

        enemySpawnCounter++;
        if (enemySpawnCounter >= 100 && enemies.size() < maxEnemies && score < 2000) {
            enemySpawnCounter = 0;
            enemies.add(EnemyShip.spawnEnemy());
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

    private void drawScore(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Player: " + nickname + " | Score: " + score, 10, 20);

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
