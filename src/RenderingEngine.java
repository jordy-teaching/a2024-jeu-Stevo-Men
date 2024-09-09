import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class RenderingEngine {

    private JFrame frame;
    private JPanel panel;
    private Graphics2D bufferEngine;
    private BufferedImage bufferedImage;


    public RenderingEngine() {
        initializedFrame();
        initializedPanel();

    }

    public void start() {
        frame.setVisible(true);
    }

    public void stop() {
        frame.setVisible(false);
        frame.dispose();
    }

    public Graphics2D buildBuffer() {

        bufferedImage = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
        bufferEngine = bufferedImage.createGraphics();
        bufferEngine.setRenderingHints(buildRenderingHints());
        return bufferEngine;
    }

    public void drawBufferOnScreen() {
        Graphics2D graphics = (Graphics2D) panel.getGraphics();
        graphics.drawImage(bufferedImage, 0, 0, panel);
        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();
    }

    private void initializedPanel() {
        panel = new JPanel();
        panel.setFocusable(true);
        panel.setDoubleBuffered(true);
        frame.add(panel);
    }
    private void initializedFrame() {
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setTitle("Bouncing Balls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setState(JFrame.NORMAL);
    }

    private static RenderingHints buildRenderingHints() {
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        return hints;
    }
}
