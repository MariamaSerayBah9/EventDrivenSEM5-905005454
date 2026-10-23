import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.BorderFactory;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;


public class SwingAssignment {

    private static final Color[] BACKGROUND_COLOURS = {
            new Color(232, 240, 254),
            new Color(232, 245, 233),
            new Color(255, 243, 224),
            new Color(243, 229, 245),
            new Color(224, 247, 250),
            new Color(255, 235, 238),
            new Color(236, 239, 241)
    };
    private static final Color BUTTON_COLOUR = new Color(38, 70, 112);
    private static final Color TEXT_COLOUR = new Color(35, 48, 68);
    private static final Color LOGO_ACCENT = new Color(95, 210, 194);

    private static final String[] LABEL_MESSAGES = {
            "Welcome to Java Swing First Individual Assignment by Mariama Seray Bah",
            "Event Driven Programming is Interactive!",
            "Thanks for exploring this interactive interface.",
           
    };

    private JFrame frame;
    private WelcomePanel panel;
    private JLabel label;
    private int messageIndex;
    private int colourIndex;

    /**
     * Inheritance: WelcomePanel extends JPanel and inherits all of its
     * behaviour. It adds its own constructor and a method for changing
     * the background colour.
     */
    private static class WelcomePanel extends JPanel {

        WelcomePanel() {
            super(new BorderLayout(20, 20));
            setBackground(BACKGROUND_COLOURS[0]);
            setBorder(BorderFactory.createEmptyBorder(40, 48, 32, 48));
        }

        void changeBackground(Color colour) {
            setBackground(colour);
            repaint();
        }
    }

    /**
     * Draws an original, project-specific monogram mark without requiring
     * a separate image file.
     */
    private static class LogoPanel extends JComponent {

        LogoPanel() {
            setPreferredSize(new Dimension(112, 112));
            setAlignmentX(JComponent.CENTER_ALIGNMENT);
            setToolTipText("Custom Java Swing assignment logo");
        }

        static BufferedImage createLogoImage(int size) {
            LogoPanel logo = new LogoPanel();
            logo.setSize(size, size);

            BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = image.createGraphics();
            logo.paint(graphics);
            graphics.dispose();
            return image;
        }

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            Graphics2D g2 = (Graphics2D) graphics.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            double scale = Math.min(getWidth(), getHeight()) / 112.0;
            g2.translate((getWidth() - 112 * scale) / 2,
                    (getHeight() - 112 * scale) / 2);
            g2.scale(scale, scale);

            g2.setColor(new Color(38, 70, 112, 35));
            g2.fill(new Ellipse2D.Double(9, 11, 94, 94));
            g2.setColor(BUTTON_COLOUR);
            g2.fill(new Ellipse2D.Double(7, 7, 94, 94));
            g2.setColor(LOGO_ACCENT);
            g2.setStroke(new BasicStroke(3.5f, BasicStroke.CAP_ROUND,
                    BasicStroke.JOIN_ROUND));

            Path2D.Double monogram = new Path2D.Double();
            monogram.moveTo(28, 70);
            monogram.lineTo(28, 40);
            monogram.lineTo(43, 56);
            monogram.lineTo(54, 43);
            monogram.lineTo(54, 70);
            monogram.moveTo(65, 43);
            monogram.curveTo(74, 34, 87, 41, 78, 51);
            monogram.curveTo(69, 60, 65, 62, 65, 70);
            monogram.lineTo(81, 70);
            g2.draw(monogram);

            g2.setColor(Color.WHITE);
            g2.fill(new Ellipse2D.Double(74, 25, 7, 7));
            g2.dispose();
        }
    }

    /**
     * Constructor: builds the frame, panel, labels and buttons and wires
     * up the event handling.
     */
    public SwingAssignment() {

        frame = new JFrame("Java Swing Assignment");
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(LogoPanel.createLogoImage(128));

        panel = new WelcomePanel();

        JLabel heading = new JLabel("Interactive Java Swing Demo", SwingConstants.CENTER);
        heading.setFont(new Font("Tahoma", Font.BOLD, 26));
        heading.setForeground(TEXT_COLOUR);
        heading.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        label = new JLabel(LABEL_MESSAGES[0], SwingConstants.CENTER);
        label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        label.setForeground(TEXT_COLOUR);
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new javax.swing.BoxLayout(messagePanel, javax.swing.BoxLayout.Y_AXIS));
        messagePanel.setOpaque(false);
        messagePanel.add(heading);
        messagePanel.add(new LogoPanel());
        messagePanel.add(label);
        panel.add(messagePanel, BorderLayout.CENTER);

        JButton changeTextButton = createButton("Change Text");
        changeTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageIndex = (messageIndex + 1) % LABEL_MESSAGES.length;
                label.setText(LABEL_MESSAGES[messageIndex]);
            }
        });

        JButton changeBackgroundButton = createButton("Change Background");
        changeBackgroundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colourIndex = (colourIndex + 1) % BACKGROUND_COLOURS.length;
                panel.changeBackground(BACKGROUND_COLOURS[colourIndex]);
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 16, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(changeTextButton);
        buttonPanel.add(changeBackgroundButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Tahoma", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(BUTTON_COLOUR);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(12, 22, 12, 22));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }

    /** Makes the window visible. */
    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Swing components should be created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new SwingAssignment().show());
    }
}
