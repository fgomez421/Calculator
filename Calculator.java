package apps;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import org.checkerframework.checker.units.qual.m;

public class Calculator {
    
    private static final int X_LOC = 100;
    private static final int Y_LOC = 100;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 100;
    private static final String NAME = "calculator";
    private static final String RESULT_PREAMBLE = "Result = ";
    private static final String ERROR_MESSAGE = "Error";
    private JFrame frame;
    private JTextField leftOpField;
    private JTextField rightOpField;
    private JLabel resultLabel;


    public Calculator()
    {
        createFrame();
        initializeComponents();
        displayFrame();
    }

    public JFrame getFrame()
    {
        return frame;
    }

    private void createFrame()
    {
        frame = new JFrame();
        frame.setLocation(X_LOC, Y_LOC);
        frame.setSize(WIDTH,HEIGHT);
        frame.setTitle(NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeComponents()
    {
        initializeInputs();
        initializeResults();
        initializeButtons();
    }

    private void displayFrame()
    {
        frame.setVisible(true);
    }

    private void initializeInputs()
    {
        leftOpField = new JTextField(5);

        rightOpField = new JTextField(5);

        leftOpField.setName("leftOperand");

        rightOpField.setName("rightOperand");

        JPanel InputPanel = new JPanel();

        InputPanel.add(leftOpField);
        InputPanel.add(rightOpField);

        frame.add(InputPanel, BorderLayout.NORTH);
    }

    private void initializeResults()
    {
        resultLabel = new JLabel(RESULT_PREAMBLE);

        resultLabel.setName("resultLabel");

        JPanel panel = new JPanel();

        panel.add(resultLabel);

        frame.add(panel, BorderLayout.CENTER);

    }

    private void initializeButtons()
    {
        JPanel buttonPanel = new JPanel();

        JButton addButton = new JButton("ADD");
        JButton subBUtton = new JButton("SUB");
        JButton mulButton = new JButton("MULT");
        JButton divButton = new JButton("DIV");

        addButton.setName("addButton");
        subBUtton.setName("subButton");
        mulButton.setName("multButton");
        divButton.setName("divButton");

        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                double result = getLeftNum() + getRightNum();
                updateResult(result);
            }
        });

        subBUtton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e)
            {
                double result = getLeftNum() - getRightNum();
                updateResult(result);
            }
        });

        mulButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e)
            {
                double result = getLeftNum() * getRightNum();
                updateResult(result);
            }
        });

        divButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e)
            {
                if(getRightNum()== 0.0)
                {
                    updateResult(Double.NaN);
                }else{
                    updateResult(getLeftNum()/getRightNum());
                }
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(subBUtton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);

        frame.add(buttonPanel,BorderLayout.PAGE_END);
    }

    private double getLeftNum()
    {
        String leftText = leftOpField.getText();
        try{
            return Double.parseDouble(leftText);
        }catch (NullPointerException | NumberFormatException e){
            return Double.NaN;
        }
    }

    private double getRightNum()
    {
        String rightText = rightOpField.getText();
        try{
            return Double.parseDouble(rightText);
        }catch(NullPointerException | NumberFormatException e) {
            return Double.NaN;
        }
    }

    private void updateResult(double result)
    {
        if(Double.isNaN(result))
        { 
            resultLabel.setText(RESULT_PREAMBLE + ERROR_MESSAGE);
    
        }else{

            resultLabel.setText(RESULT_PREAMBLE + result);
        }
    }

}

