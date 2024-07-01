import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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

    private JPanel getScorePanel() {
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.X_AXIS));
        JLabel instruction = new JLabel("Score:");
        JButton reset = new JButton("Reset");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                score.setText("0");
                nextCorrect = 1;

                for (int i = 0; i < 9; i++) {
                    buttons[i].setBackground(Color.WHITE);
                }
                randomButtons();
            }
        });
        scorePanel.add(instruction);
        scorePanel.add(score);
        scorePanel.add(reset);
        instruction.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        score.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 50));
        scorePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 40));

        return scorePanel;
    }
}