import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
 
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
 
/*Hangman Midterm
 * 
 * 4/5/15
 * 
 * Project by:  Qaisha Closeil, Tyler Dresslehouse, and Jim Webb
 * 
 */
 
public class GuessPanel extends JPanel {
 
    //insets w/border
    protected static final Insets bottomInsets = new Insets(10, 10, 10, 10);
    protected static final Insets normalInsets = new Insets(10, 10, 0, 10);
    protected static final Insets spacingInsets = new Insets(20, 10, 0, 10);
 
    private int phraseGridy;
 
    private HangmanFrame frame;
 
    private HangmanModel model;
 
    private HangmanShape drawingPanel;
 
    private JButton guessButton;
 
    private JLabel guessesText, possibleLettersText;
 
    private JPanel outsidePanel, panel;
 
    private JTextField guessTextField;
 
    private List<JLabel> phraseText;
    private List<String> phrase;
 
    public GuessPanel(HangmanFrame frame, HangmanModel model) {
        this.frame = frame;
        this.model = model;
        this.phrase = new ArrayList<String>();
        this.phraseText = new ArrayList<JLabel>();
        createPartControl();
    }
 
    public void setDrawingPanel(HangmanShape drawingPanel) {
        this.drawingPanel = drawingPanel;
    }
    //creates the JPanel GUI
    private void createPartControl() {
        
    //each panel uses a different layout for nesting
        outsidePanel = new JPanel();
        outsidePanel.setLayout(new FlowLayout());
 
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
 
        int gridy = 0;
        //Creates the label with the listed alphabets
        JLabel possibleLettersTitle = new JLabel("Remaining");
        possibleLettersTitle.setForeground(Color.red);
        possibleLettersTitle.setHorizontalAlignment(JLabel.CENTER);
        addComponent(panel, possibleLettersTitle, 0, gridy++, 2, 1,
                normalInsets, GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL);
 
        possibleLettersText = new JLabel(model.getUnguessedLetters());
        possibleLettersText.setHorizontalAlignment(JLabel.CENTER);
        addComponent(panel, possibleLettersText, 0, gridy++, 2, 1,
                normalInsets, GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL);

        //Creates the label with the listed guesses
        JLabel guessesTitle = new JLabel("Number of guesses");
        guessesTitle.setHorizontalAlignment(JLabel.CENTER);
        addComponent(panel, guessesTitle, 0, gridy++, 2, 1, spacingInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
 
        guessesText = new JLabel(model.getNumberOfGuesses());
        guessesText.setHorizontalAlignment(JLabel.CENTER);
        addComponent(panel, guessesText, 0, gridy++, 2, 1, normalInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
 
        JLabel guessLetterTitle = new JLabel("Guess letter");
        guessLetterTitle.setHorizontalAlignment(JLabel.CENTER);
        addComponent(panel, guessLetterTitle, 0, gridy++, 2, 1, spacingInsets,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
 
        JPanel guessPanel = new JPanel();
        guessPanel.setLayout(new BoxLayout(guessPanel, BoxLayout.X_AXIS));
 
        guessTextField = new JTextField(10);
        guessPanel.add(guessTextField);
 
        guessPanel.add(Box.createRigidArea(new Dimension(6, 0)));
 
        GuessActionListener listener = new GuessActionListener();
 
        /*
            You can enter a letter within the text field and 
            use the enter key and 
        */
        guessButton = new JButton("Guess");
        guessButton.addActionListener(listener);
        guessButton.registerKeyboardAction(guessButton
                .getActionForKeyStroke(KeyStroke.getKeyStroke(
                        KeyEvent.VK_SPACE, 0, false)), KeyStroke.getKeyStroke(
                KeyEvent.VK_ENTER, 0, false), JButton.WHEN_IN_FOCUSED_WINDOW);
        guessButton.registerKeyboardAction(guessButton
                .getActionForKeyStroke(KeyStroke.getKeyStroke(
                        KeyEvent.VK_SPACE, 0, true)), KeyStroke.getKeyStroke(
                KeyEvent.VK_ENTER, 0, true), JButton.WHEN_IN_FOCUSED_WINDOW);
        guessPanel.add(guessButton);
 
        addComponent(panel, guessPanel, 0, gridy++, 2, 1, spacingInsets,
                GridBagConstraints.CENTER, GridBagConstraints.NONE);
 
        phraseGridy = gridy;
 
        createPhraseControl(panel, gridy);
 
        outsidePanel.add(panel);
    }
    //updates the GuessPanel during a game
    public void updatePartControl() {
        possibleLettersText.setText(model.getUnguessedLetters());
        guessesText.setText(model.getNumberOfGuesses());
 
        phrase = model.getHiddenPhrase();
        for (int i = 0; i < phrase.size(); i++) {
            JLabel label = phraseText.get(i);
            label.setText(phrase.get(i));
        }
    }
    //removes the JLabels that make up the old word, and adds the JLabels that make up the new word. 
    public void resetPartControl() {
        possibleLettersText.setText(model.getUnguessedLetters());
        guessesText.setText(model.getNumberOfGuesses());
 
        removePhraseControl(panel);
        int gridy = phraseGridy;
        createPhraseControl(panel, gridy);
        panel.validate();
    }
        //removes letter from alphabet list
    private void removePhraseControl(JPanel panel) {
        for (int i = phraseText.size() - 1; i >= 0; i--) {
            JLabel label = phraseText.get(i);
            panel.remove(label);
            phraseText.remove(i);
        }
    }
    //creates letters to the given line
    private void createPhraseControl(JPanel panel, int gridy) {
        phrase = model.getHiddenPhrase();
        for (int i = 0; i < phrase.size(); i++) {
            JLabel label = new JLabel(phrase.get(i));
            Font newFont = new Font("Courier New", Font.BOLD, 24);
            label.setFont(newFont);
            label.setHorizontalAlignment(JLabel.CENTER);
            addComponent(panel, label, 0, gridy++, 2, 1, bottomInsets,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
            phraseText.add(label);
        }
    }
        //this allows the letters to appear on the line
    private void addComponent(Container container, Component component,
            int gridx, int gridy, int gridwidth, int gridheight, Insets insets,
            int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 1.0D, 1.0D, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }
 
    public JPanel getOutsidePanel() {
        return outsidePanel;
    }
 
    public class GuessActionListener implements ActionListener {
        
        //Pane window that appears when the user wins or loses the game
        @Override
        public void actionPerformed(ActionEvent event) {
            String letter = guessTextField.getText();
            if ((letter.length() == 1) && (model.isPossibleLetter(letter))) {
                model.guessLetter(letter);
                updatePartControl();
                drawingPanel.repaint();
                guessTextField.setText("");
                guessTextField.requestFocusInWindow();
 
                if (model.isUnsolved()) {
                    JOptionPane.showMessageDialog(getOutsidePanel(),
                            "You Lost.  The word was\n"
                                    + model.getCurrentPhrase(),
                            "Lose", JOptionPane.ERROR_MESSAGE);
                    init();
                } else if (model.isSolved()) {
                    JOptionPane.showMessageDialog(getOutsidePanel(),
                            "You guessed the word!\n"
                                    + model.getCurrentPhrase(),
                            "You  Win", JOptionPane.INFORMATION_MESSAGE);
                    init();
                }
            } else {
                guessTextField.requestFocusInWindow();
            }
        }
        
        //resets new game once the winner/loser pane is exited
        private void init() {
            model.init();
            resetPartControl();
            frame.getFrame().pack();
        }
 
    }
 
}