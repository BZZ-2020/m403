package wordfinder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Marc-Andri Fuchs
 * @version 1.0
 */

public class WordFinderGUI extends JFrame {
    private final ArrayList<Integer> positions;

    /**
     * Constructor initializes the variables
     * @param positions all occurrences of the word we searched for
     */
    public WordFinderGUI(ArrayList<Integer> positions) {
        this.positions = positions;
        initComponents();
    }

    /**
     * Creates the window and adds a Text Area with all found positions
     */
    private void initComponents() {
        setSize(500,225); //Sets the size of the window to 500 * 225
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("WordFinder"); // Sets the window title to WordFinder

        //Adds all found positions to a strings
        StringBuilder foundPositions = new StringBuilder();
        int counter = 0;
        for (int i : positions) {
            foundPositions.append(i).append(", ");
            counter++;
            if (counter >= 10) {
                foundPositions.append(System.lineSeparator());
                counter = 0;
            }
        }

        //Input Field
        JPanel p = new JPanel();
        TextArea textArea = new TextArea(foundPositions.toString()); //Creates a Text Area, which contains all found positions
        textArea.setEditable(false);
        p.add(textArea);
        add(p, BorderLayout.NORTH);
        setResizable(false);
        setVisible(true);
    }
}
