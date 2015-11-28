
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

//Write a Java Program which uses the musicians class from part a to represent a group of musicians. 
//The user interface is to be a Graphical user Interface for example based on Swing or some other library of your choice
//Each icon on the screen is to represent a musician. When clicked the Musician details are to be displayed on screen. 
//You should be able to increase and decrease the number of musicians in the group.
//10 % of the marks are available to anyone who can read the musicians details from a file.
public class MucisianGUI extends JFrame {
	
	static JPanel subPanel = new JPanel();
	static JPanel subPanel2 = new JPanel();
	JScrollPane scroll = new JScrollPane(subPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	static JButton add = new JButton();
	static JButton minus = new JButton();
	final String textFile = "music";
	
	public static void main(String[] args){
		
		MucisianGUI MucisianGUI = new MucisianGUI();
		MucisianGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MucisianGUI.setSize(1200, 700);
		MucisianGUI.setVisible(true);
		MucisianGUI.setResizable(true);
		MucisianGUI.setTitle("Mucisian GUI");
		MucisianGUI.setLayout(new GridLayout(4,4));
		
	
		add.setText("+");
		minus.setText("-");
		subPanel2.add(minus);
		subPanel2.add(add);
		
		
	}
	
	
	public void LoadGUI(){
		String[] words;
		
		int row = 0;
		String currentLine;
		
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\derek\\workspace42\\Mucisian\\img\\" + textFile +".txt")))
		{
		while ((currentLine = br.readLine()) != null) {
			
			words = currentLine.split(" ");
			for (int t=0; t<words.length; t++){

				if (t%4 == 0){
					System.out.println("Row: " + row);
					
						row++;
						
				}
				
			} // end of for loop
			
		}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		final Mucisian person[] = new Mucisian[row];
		final JButton[] buttons = new JButton[row];
		final String name [] = new String[row];
		
		
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\derek\\workspace42\\Mucisian\\img\\" + textFile +".txt")))
		{
			
			String sCurrentLine;
			int row2=0;
			while ((sCurrentLine = br.readLine()) != null) {
				
				words = sCurrentLine.split(" ");
				
			
				for (int t=0; t<words.length; t++){
					int h=0;
					
					person[row2] = new Mucisian(words[h], words[h+1], words[h+2], words[h+3]);
//					System.out.println(words[t]);
//					System.out.println(t);
//					System.out.println("Row2: " + row2);
					
					if (t == 3){
//						System.out.println("Row2: " + row2);
						
							row2++;
			
					}
					
					
				} // end of for loop
				
				
				
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		remove(subPanel);
		remove(subPanel2);

		for(int i=0; i< row; i++){
		
		name[i] = person[i].getName();
		buttons[i] = new JButton(name[i]);
		buttons[i].setIcon(new ImageIcon("C:\\Users\\derek\\workspace42\\Mucisian\\img\\music.png"));
		validate();
		subPanel.add(buttons[i]);
		add(scroll);
		buttons[i].addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int x=0; x< person.length; x++){
				if(e.getActionCommand() == person[x].getName()){
					
					JOptionPane.showMessageDialog (null, "Name: " + person[x].getName() +
					"\n" + "Instrument: " + person[x].getInstrument() 
							+ "\n" + "Band: " + person[x].getBand() 
							+ "\n" + "Genre: " + person[x].getGenre(),  
							"About Mucisian", JOptionPane.INFORMATION_MESSAGE);
				}
			
				}
				
				
			
			}}); // end of actionListener
		
		} // end of for loop
		subPanel.setLayout(new GridLayout(0,4));
		add(subPanel2);
	} // end of LoadGUI
	
	public MucisianGUI(){
		
	
		LoadGUI();

		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			
				
		        JTextField field1 = new JTextField("");
		        JTextField field2 = new JTextField("");
		        JTextField field3 = new JTextField("");
		        JTextField field4 = new JTextField("");
		        JPanel panel = new JPanel(new GridLayout(0, 1));
		        panel.add(new JLabel("Name:"));
		        panel.add(field1);
		        panel.add(new JLabel("Instrument:"));
		        panel.add(field2);
		        panel.add(new JLabel("Solo or Band?"));
		        panel.add(field4);
		        panel.add(new JLabel("Type of Band ?"));
		        panel.add(field3);
		        
				int result = JOptionPane.showConfirmDialog(null, panel, "Add a Mucisian",
			            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			        if (result == JOptionPane.OK_OPTION) {
			        	
			        	BufferedWriter bw = null;
						try {
							bw = new BufferedWriter(new FileWriter("C:\\Users\\derek\\workspace42\\Mucisian\\img\\" + textFile +".txt", true));
						    bw.write(field1.getText() + " " + field2.getText() + " " + field3.getText() + " " + field4.getText());
						    bw.newLine();
						    bw.flush();
						}
						    catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						finally { // always close the file
						    if (bw != null) {
						        try {
						            bw.close();
						            subPanel.removeAll();
						            LoadGUI();
						            
						        } catch (IOException ioe2) {
						            // just ignore it
						        }
						    }
						}
			            
			            
			        } else {
			            System.out.println("Cancelled");
			        }
		
			}}); // end of add button actionListener
		
		
		minus.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}});

	}
}
