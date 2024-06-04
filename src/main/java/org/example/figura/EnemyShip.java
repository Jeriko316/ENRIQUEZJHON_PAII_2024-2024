package org.example.figura;

import org.example.Interfaces.IDibujar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;





public class EnemyShip implements IDibujar {

    private static final int WIDTH = 40;
    private static final int HEIGHT = 20;
    private static final int SPEED = 1;

    private int x;
    private int y;
    private boolean alive;

    private int health;



    public static EnemyShip spawnEnemy() {
        Random random = new Random();
        int startX = random.nextInt(800 - WIDTH);
        int startY = -HEIGHT; // Empieza fuera de la pantalla
        return new EnemyShip(startX, startY);
    }


    public EnemyShip(int startX, int startY) {
        x = startX;
        y = startY;
        alive = true;
        health = 3; // Vida inicial del enemigo
    }

    @Override
    public void draw(Graphics g) {
        if (alive) {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, WIDTH, HEIGHT);
            drawHealthBar(g);
        }
    }


    private void drawHealthBar(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y - 10, WIDTH, 5);
        g.setColor(Color.GREEN);
        g.fillRect(x, y - 10, (int) (WIDTH * (health / 3.0)), 5); // Dibujar la vida restante
    }

    public void move() {
        y += SPEED;

        if (y > 600) {
            alive = false;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }


    public void hit() {
        health--; // Reducir la vida en 1 cuando es golpeado
        if (health <= 0) {
            alive = false;
        }
    }


    ////////////////////// GETTERS AND SETTERS ///////////////////////////

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int getWidth() {
        return WIDTH;
    }

    public static int getHeight() {
        return HEIGHT;
    }

    public static int getSpeed() {
        return SPEED;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
