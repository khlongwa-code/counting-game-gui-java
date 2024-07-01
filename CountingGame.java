import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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
    
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        JPanel buttonPanel = getButtonPanel();
        JPanel scorePanel = getScorePanel();
        frame.add(buttonPanel);
        frame.add(scorePanel);
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
    
    private JPanel getButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3, 10, 10));
    
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("" + (i+1));
            buttons[i].setBackground(Color.WHITE);
            buttons[i].addActionListener(buttonActionListener(buttons[i]));
            buttonPanel.add(buttons[i]);
        }
        randomButtons();
    
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 50, 50));
    
        return buttonPanel;
    }

    private void randomButtons() {
        Random random = new Random();
        boolean[] setButtons = new boolean[9];
    
        for (int i = 0; i < 9; i++) {
            setButtons[i] = false;
            buttons[i].setEnabled(true);
            buttons[i].setBackground(Color.WHITE);
        }
    
        for (int i = 0; i < 9; i++) {
            int num = random.nextInt(9);
    
            while (setButtons[num]) {
                num = random.nextInt(9);
            }
            buttons[i].setText("" + (num + 1));
            setButtons[num] = true;
        }
    }

    private ActionListener buttonActionListener(final JButton button) {
        return new ActionListener() {
    
            @Override
            public void actionPerformed(ActionEvent e) {
                int buttonNum = Integer.parseInt(button.getText());
    
                if (buttonNum == nextCorrect) {
                    button.setBackground(Color.YELLOW);
                    button.setEnabled(false);
                    nextCorrect++;
                    score.setText(String.valueOf(Integer.parseInt(score.getText()) + 1));
                } else {
                    button.setBackground(Color.RED);
                    for (int i = 0; i < 9; i++) {
                        button.setEnabled(false);
                    }
                }
            }
        };
    }

    public static void main(String[] args) {
        CountingGame game = new CountingGame();
    }
}