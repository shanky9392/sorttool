import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Insertion extends JPanel implements ActionListener
{
  int a[];
  JTextField[] tfins;
  JButton enter_ins, enter_size, clearins,clearins1;
  int array_size; 
  JTextField sizeOfArray;
  JPanel enterPanel, enterArray, resultShow,footer;
  JLabel forSize, forArray, forResult;
  JScrollPane showScroll;

  public Insertion()
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
        clearins1 = new JButton("Clear");
        clearins1.addActionListener(this);
        enterPanel.add(clearins1);
      }
      else
      {
        enterArray = new JPanel();
        tfins = new JTextField[array_size];
        enter_ins = new JButton("Enter");
        enterArray.setMaximumSize(new Dimension(500,120));
        enterArray.setMinimumSize(new Dimension(500,120));
        forArray = new JLabel("Enter the array:");
        enterArray.add(forArray);
        for (int i=0;i<array_size ; i++) 
        {
          tfins[i]=new JTextField(2);
          enterArray.add(tfins[i]);
        }
        enterArray.add(enter_ins);
        enter_ins.addActionListener(this);
        add(enterArray);
      }
    }
    if(e.getSource()==enter_ins)
    {
      
      resultShow = new JPanel();
      resultShow.setLayout(new BoxLayout(resultShow,BoxLayout.PAGE_AXIS));
      resultShow.setAlignmentX(resultShow.CENTER_ALIGNMENT);
      footer = new JPanel();
      footer.setLayout(new BoxLayout(footer,BoxLayout.PAGE_AXIS));
      footer.setAlignmentX(footer.CENTER_ALIGNMENT);
      a = new int[array_size];
      System.out.println("Array Entered Insertion Sort :");
      for(int i=0;i<array_size;i++)
      {
        String s= tfins[i].getText();
        try
        {
          a[i]=Integer.parseInt(s);
        }
        catch(Exception ex)
        {
          System.out.println(ex+"Error in Input");
          JOptionPane.showMessageDialog(this,"You have entered an invalid character(s).\nAssuming them to be zero");
        }
        
        System.out.println(a[i]);
      }
      enter_ins.setEnabled(false);
    //Sorting Starts
      int i,j,k,l=0,temp;
      
      for(j=1;j<array_size;j++)
        { 
          temp=a[j];
          i=j-1;
          String s=new String();
          while(i>=0&&a[i]>temp)
          {
            a[i+1]=a[i];
            i--;  
          }
          a[++i]=temp; 
          System.out.println("Array after parse "+(j));           //Console
          resultShow.add(new JLabel("Array after parse "+(j)+":"));
          String s1=new String();
          for(k=0;k<a.length;k++)
          {
            System.out.print(a[k]+" ");         //Console
            if(k==a.length-1)    
              s1+=a[k]+".";
            else
              s1+=a[k]+", ";
          }
          forResult = new JLabel(s1);
          resultShow.add(forResult);
          System.out.println();           //Console                 
        }
        clearins = new JButton("Clear");
        clearins.addActionListener(this);
        footer.add(clearins);
        showScroll = new JScrollPane(resultShow);
        add(showScroll);
        add(footer);
      System.out.println("The final sorted array is");    //Console
      for(i=0;i<a.length;i++)
      {
        System.out.print(a[i]+" ");       //Console
      }
    }

    if(e.getSource()==clearins)
    {
      this.remove(enterPanel);
      this.remove(enterArray);
      this.remove(showScroll);
      this.remove(footer);
      this.add(new Insertion());
      revalidate();
      repaint();
    }

    if(e.getSource()==clearins1)
    {
      this.remove(enterPanel);
      this.add(new Insertion());
      revalidate();
      repaint();
    }
    revalidate();
  }
}
 
