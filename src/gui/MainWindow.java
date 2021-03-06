package gui;

import gui.map.Environment;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainWindow extends JFrame {

    private static String APP_NAME = "AIRobot";
    private static int DEFAULT_WIDTH = 640;
    private static int DEFAULT_HEIGHT = 480;

    private static final long serialVersionUID = 1L;
    private static MainWindow s_instance;

    private Environment pantalla_;

    /**
     * Botones
     */
    private JPanel buttonPanel_ = new JPanel();
    private JButton startButton_ = new JButton("Start");
    private JButton stopButton_ = new JButton("Stop");

    private static int dimX_;
    private static int dimY_;

    private void initButtons() {
        buttonPanel_.add(startButton_);
        buttonPanel_.add(stopButton_);
        startButton_.setVisible(true);
        stopButton_.setVisible(true);

        /**
         * TODO
         */
        startButton_.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dimX_ = 20;
                dimY_ = 20;
                initScrollPanel();
                System.out.println("me has pulsado");
            }
        });

        stopButton_.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("jaja, me hace cosquillas");
            }
        });
    }

    private void initScrollPanel() {

        pantalla_ = new Environment(dimX_, dimY_);
        JScrollPane envScrollPanel = new JScrollPane(pantalla_);
        add(envScrollPanel, BorderLayout.CENTER);
        pack();
    }

    private void initComponents() {
        add(buttonPanel_, BorderLayout.NORTH);
        initButtons();
    }

    private MainWindow() {
        setLayout(new BorderLayout());

        initComponents();

        pack();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MainWindow wnd = MainWindow.getInstance();

        wnd.setTitle(APP_NAME);
        wnd.setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wnd.setMinimumSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        wnd.setLocationRelativeTo(null);
        wnd.setVisible(true);
    }

    /**
     * @return Instancia única de la clase.
     */
    public static MainWindow getInstance() {

        if (s_instance == null) {
            s_instance = new MainWindow();
        }
        return s_instance;
    }

}
