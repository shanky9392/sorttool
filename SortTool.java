
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SortTool extends JPanel
{
	
	public SortTool()
	{
		setLayout(new BorderLayout());
		UIManager.put("TabbedPane.selected",null);
		JTabbedPane tabbedPane=new JTabbedPane(JTabbedPane.NORTH);
		Color[] colors={Color.green,Color.red,Color.blue,Color.yellow,Color.magenta}; 

		Select seltab = new Select();
		tabbedPane.addTab("Selection Sort",seltab);   
		tabbedPane.setBackgroundAt(0,colors[0]);

		Insertion instab = new Insertion();
		tabbedPane.addTab("Insertion Sort",instab);
		tabbedPane.setBackgroundAt(1,colors[1]);

		Merge mertab =new Merge();
		tabbedPane.addTab("Merge Sort",mertab);
		tabbedPane.setBackgroundAt(2,colors[2]);
		
		Quick quiktab = new Quick();
		tabbedPane.addTab("QuickSort",quiktab);
		tabbedPane.setBackgroundAt(3,colors[3]);

		tabbedPane.setSelectedIndex(0);

		add(tabbedPane,BorderLayout.CENTER); 
	}
	
	

	public static void main(String[] args) 
	{
		JFrame frame=new JFrame("Sorting Tool");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(new SortTool());
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
}