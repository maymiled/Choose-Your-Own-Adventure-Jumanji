package representation;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ImageNode extends NodeDecorator {
    private List<String> imagePaths;

    public ImageNode(InnerNode decoratedNode, List<String> imagePaths) {
        super(decoratedNode);
        this.imagePaths = imagePaths;
    }

    @Override
    public void display() {
        displayImages(imagePaths);
        super.display();
    }

    public static void displayImages(List<String> imagePaths) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Images");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel(new GridLayout(0, 5));

            for (String imagePath : imagePaths) {
                ImageIcon originalIcon = new ImageIcon(imagePath);
                // Ajustez la taille de l'image ici (200x200 pixels dans cet exemple)
                ImageIcon scaledIcon = new ImageIcon(originalIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH));
                JLabel label = new JLabel(scaledIcon);
                panel.add(label);
            }

            frame.getContentPane().add(new JScrollPane(panel));
            frame.pack();
            frame.setVisible(true);
        });
    }
}




