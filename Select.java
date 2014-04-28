import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Select extends JPanel implements ActionListener
{
  int a[];
  JTextField[] tfsel;
  JButton enter_sel, enter_size, clear, clear1;
  int array_size; 
  JTextField sizeOfArray;
  JPanel enterPanel, enterArray, resultShow, footer;
  JLabel forSize, forArray, forResult;
  JScrollPane showScroll;

  public Select()
  {
    enterPanel = new JPanel();
    enterPanel.setMaximumSize(new Dimension(500,70));
    enterPanel.setMinimumSize(new Dimension(500,70));
    forSize = new JLabel("Enter the size of the array: ");
    enterPanel.add(forSize);
    sizeOfArray =new JTextField(2);
    sizeOfArray.setText("0");
    enter_size = new JButton("Enter size");
    enterPanel.add(sizeOfArray);
    enterPanel.add(enter_size);
    enter_size.addActionListener(this);
    add(enterPanel);
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
  }

  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==enter_size)
    {
      enter_size.setEnabled(false);
      array_size= Integer.parseInt(sizeOfArray.getText()); 
      if(array_size==0)
      {
        enterPanel.add(new JLabel("You entered zero!!"));
        clear1 = new JButton("Clear");
        clear1.addActionListener(this);
        enterPanel.add(clear1);
      }
      else
      {
        enterArray = new JPanel();
        tfsel = new JTextField[array_size];
        enter_sel = new JButton("Enter");
        enterArray.setMaximumSize(new Dimension(500,120));
        enterArray.setMinimumSize(new Dimension(500,120));
        forArray = new JLabel("Enter the array:");
        enterArray.add(forArray);
        for (int i=0;i<array_size ; i++) 
        {
          tfsel[i]=new JTextField(2);
          enterArray.add(tfsel[i]);
        }
        enterArray.add(enter_sel);
        enter_sel.addActionListener(this);
        add(enterArray);
      }
    }

    if(e.getSource()==enter_sel)
    {
      resultShow = new JPanel();
      resultShow.setLayout(new BoxLayout(resultShow,BoxLayout.PAGE_AXIS));
      resultShow.setAlignmentX(resultShow.CENTER_ALIGNMENT);
      footer = new JPanel();
      footer.setLayout(new BoxLayout(footer,BoxLayout.PAGE_AXIS));
      footer.setAlignmentX(footer.CENTER_ALIGNMENT);
      a = new int[array_size];
      System.out.println("Array Entered Selection Sort :");
      String s1= null;
      for(int i=0;i<array_size;i++)
      {
        s1= tfsel[i].getText();
        try
        {
          a[i]=Integer.parseInt(s1);
        }
        catch(Exception ex) 
        {
          System.out.println(ex+"Error in input");
          JOptionPane.showMessageDialog(this,"You have entered an invalid character(s).\nAssuming them to be zero");
        }
        System.out.println(a[i]);
      }
      enter_sel.setEnabled(false);
      //Sorting Starts
      int i,j,k,temp;
      
      for(i=0;i<a.length;i++)
        { 
          for(j=i+1;j<a.length;j++)
          {
            if(a[i]>=a[j])
            {
              temp=a[i];
              a[i]=a[j];
              a[j]=temp;
            }
          }
          System.out.println("Array after parse "+(i+1));           //Console
          resultShow.add(new JLabel("Array after parse "+(i+1)+":"));
          String s=new String();
          for(k=0;k<a.length;k++)
          {
            System.out.print(a[k]+" ");         //Console
            if(k==a.length-1)    
              s+=a[k]+".";
            else
              s+=a[k]+", ";
          }
          forResult = new JLabel(s);
          resultShow.add(forResult);
          System.out.println();           //Console
        }
        clear = new JButton("Clear");
        clear.addActionListener(this);
        footer.add(clear);
        showScroll = new JScrollPane(resultShow);
        add(showScroll);
        add(footer);
      System.out.println("The final sorted array is");    //Console
      for(i=0;i<a.length;i++)
      {
        System.out.print(a[i]+" ");       //Console
      }

    }

    if(e.getSource()==clear)
    {
      this.remove(enterPanel);
      this.remove(enterArray);
      this.remove(showScroll);
      this.remove(footer);
      this.add(new Select());
      revalidate();
      repaint();
    }

    if(e.getSource()==clear1)
    {
      this.remove(enterPanel);
      this.add(new Select());
      revalidate();
      repaint();
    }
    revalidate();
  }
}
 