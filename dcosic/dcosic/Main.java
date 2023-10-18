package dcosic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Main {
    private static void main(String[] args) {
        Paare paare = null;

            try {
                URL imageUrl = new URL(paare.getBildURL());
                Image image = ImageIO.read(imageUrl);
                JOptionPane.showMessageDialog(null, paare.getWort(), "Aktuelles Wort", JOptionPane.PLAIN_MESSAGE, new ImageIcon(image));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int zahl = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie für ein Wortpaar eine Zahl ein."));

    }

