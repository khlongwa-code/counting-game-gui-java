import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CountingGame {

    private JLabel score;
    private JButton[] buttons;
    private int nextCorrect;

    public CountingGame() {
        score = new JLabel("0");
        buttons = new JButton[9];
        nextCorrect = 1;
        JFrame frame = new JFrame();

        frame.setSize(300, 400);
        frame.setResizable(false);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
        JPanel scorePanel =  getScorePanel();
        JPanel buttonPanel = getButtonPanel();
        frame.add(scorePanel);
        frame.add(buttonPanel);
        frame.pack();
        frame.setVisible(true);
    }
}