import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import java.awt.Color;


public class MorseCodeGUI extends JPanel{
					
	public static final String[] LETTERS = {"A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" , "I" , "J" , "K" , "L" , "M" , "N" , 
											"O" , "P" , "Q" , "R" , "S" , "T" , "U" , "V" , "W" , "X" , "Y" , "Z" , " " , "0" , 
											"1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "," , "." , "?"};
	
	public static final String[] LETTERS_TO_MORSE = { "/" , "--..--" , ".-.-.-" , "-----" , ".----" , "..---" , "...--" , "....-" , 
													  "....." , "-...." , "--..." , "---.." , "----." , "..--.." , ".-" , "-..." , 
													  "-.-." , "-.." , "." , "..-." , "--." , "...." , ".." , ".---" , "-.-" , 
													  ".-.." , "--" , "-." , "---" , ".--." , "--.-" , ".-." , "..." , "-" , "..-" , 
													  "...-" , ".--" , "-..-" , "-.--" , "--.." };
	private JLabel lblOutput;
	private JLabel lblInputText;
	private JTextArea txtIn;
	private JTextArea txtOut;
	
	public String morseTranslator(String txtInput) {
		
		//sorts array LETTERS to user binary search
		Arrays.sort(LETTERS);
		String output = " ";
		for(int i = 0; i < txtInput.length(); i++)
		{
			String item = Character.toString(txtInput.toUpperCase().charAt(i));
			
			//check for exceptions
			try{									
				int location = Arrays.binarySearch( LETTERS, item);
				output = output + LETTERS_TO_MORSE[location] + " ";
			}
			catch(Exception e)
			{
				output = "Invalid input, special characters allowed are: ? , .  ";
			}				
		}
		return output;
	}
	
	public MorseCodeGUI() {
		setBackground(Color.LIGHT_GRAY);
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));					//constructor
		setLayout(null);
		
		JLabel lblTextToMorse = new JLabel("Text to morse translator!");
		lblTextToMorse.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTextToMorse.setBounds(219, 22, 321, 25);
		lblTextToMorse.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTextToMorse);
		
		txtIn = new JTextArea();
		txtIn.setToolTipText("Enter your text here");
		txtIn.setRows(5);
		txtIn.setLineWrap(true);
		txtIn.setText("Enter your text here ");
		txtIn.setFont(new Font("Myanmar Text", Font.PLAIN, 16));
		txtIn.setBounds(12, 69, 735, 115);
		add(txtIn);
		
		JButton btnTranslate = new JButton("Translate!");
		btnTranslate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//geting text from txtIn filed
				String message = txtIn.getText();
				
				//changing the message to morse
				String outupt = morseTranslator(message);
				
				//outputing morse on screen
				txtOut.setText(outupt);
				
			}
		});
		btnTranslate.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnTranslate.setBounds(293, 206, 147, 53);
		add(btnTranslate);
		
		setPreferredSize(new Dimension(760,490));
		
		lblOutput = new JLabel("Result:");
		lblOutput.setBounds(12, 262, 56, 16);
		add(lblOutput);
		
		lblInputText = new JLabel("Input text:");
		lblInputText.setBounds(12, 50, 74, 16);
		add(lblInputText);
		
		txtOut = new JTextArea();
		txtOut.setLineWrap(true);
		txtOut.setFont(new Font("Dialog", Font.PLAIN, 24));
		txtOut.setBounds(12, 281, 735, 187);
		add(txtOut);
				
	}

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("My Morse Coding APP!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
		frame.getContentPane().add(new MorseCodeGUI());
		frame.pack();
		frame.setVisible(true);
	}
}
