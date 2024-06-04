package org.example.figura;

import org.example.Interfaces.IDibujar;

import java.awt.*;

public class SuperEnemy implements IDibujar {
    private static final int WIDTH = 40;
    private static final int HEIGHT = 40;
    private static final int SPEED = 1;

    private int x;
    private int y;
    private boolean alive;
    private int health;

    public SuperEnemy(int startX, int startY) {
        x = startX;
        y = startY;
        alive = true;
        health = 7; // Vida inicial del super enemigo
    }

    @Override
    public void draw(Graphics g) {
        if (alive) {
            g.setColor(Color.RED);
            g.fillRect(x, y, WIDTH, HEIGHT);
            drawHealthBar(g);
        }
    }

    private void drawHealthBar(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y - 10, WIDTH, 5);
        g.setColor(Color.GREEN);
        g.fillRect(x, y - 10, (int) (WIDTH * (health / 7.0)), 5);
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

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void hit() {
        health--;
        if (health <= 0) {
            alive = false;
        }
    }

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


}
