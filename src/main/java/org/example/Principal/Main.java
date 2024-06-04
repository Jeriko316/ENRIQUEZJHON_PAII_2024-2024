package org.example.Principal;

import org.example.game.GameControl;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Galaga Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        GameControl gamePanel = new GameControl();
        frame.add(gamePanel);
        frame.setVisible(true);
    }
}