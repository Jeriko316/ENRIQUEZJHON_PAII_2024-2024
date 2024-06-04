package org.example.figura;

import org.example.Interfaces.IDibujar;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TriangularShip implements IDibujar {
    private static final int[] xPoints = { -15, 0, 15 };
    private static final int[] yPoints = { 30, -30, 30 };
    private static final int nPoints = 3;
    private int x, y;
    private List<Bullet> bullets;
    private final int speed = 10;

    public TriangularShip(int startX, int startY) {
        x = startX;
        y = startY;
        bullets = new ArrayList<>();
    }


    public void moveLeft() {
        x -= 25;
        if (x < 0) {
            x = 0;
        }
    }

    public void moveRight() {
        x += 25;
        if (x > 785) {
            x = 785;
        }
    }

    public void moveUp() {
        y -= 25;
        if (y < 0) {
            y = 0;
        }
    }

    public void moveDown() {
        y += 25;
        if (y > 570) {
            y = 570;
        }
    }

    public void shoot() {
        bullets.add(new Bullet(x, y));
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    /////// getters and setters ///////////////////////////////////
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

    public static int[] getXpoints() {
        return xPoints;
    }

    public static int[] getYpoints() {
        return yPoints;
    }

    public static int getNpoints() {
        return nPoints;
    }

    public void setBullets(List<Bullet> bullets) {
        this.bullets = bullets;
    }

    public void move() {
        y -= speed;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        Polygon shipPolygon = new Polygon(xPoints, yPoints, nPoints);
        shipPolygon.translate(x, y);
        g.fillPolygon(shipPolygon);

        // Dibujar los disparos
        for (Bullet bullet : bullets) {
            bullet.draw(g);
        }
    }
}
