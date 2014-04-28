import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Quick extends JPanel implements ActionListener
{
    int a[], comparisons = 0;
    JTextField[] tfquik;
    JButton enter_quik, enter_size, clearquik,clearquik1;
    int array_size, count1, count2; 
    JTextField sizeOfArray;
    JPanel enterPanel, enterArray, initial, resultShow, footer;
    JLabel forSize, forArray, forResult;
    JScrollPane scroll;

    public Quick()
    {
        enterPanel = new JPanel();
        enterPanel.setMaximumSize(new Dimension(500,50));
        enterPanel.setMinimumSize(new Dimension(500,50));
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
                clearquik1 = new JButton("Clear");
                clearquik1.addActionListener(this);
                enterPanel.add(clearquik1);
            }
            else
            {
                enterArray = new JPanel();
                tfquik = new JTextField[array_size];
                enter_quik = new JButton("Enter");
                enterArray.setMaximumSize(new Dimension(500,160));
                enterArray.setMinimumSize(new Dimension(500,160));
                forArray = new JLabel("Enter the array:");
                enterArray.add(forArray);
                for (int i=0;i<array_size;i++) 
                {
                    tfquik[i]=new JTextField(2);
                    enterArray.add(tfquik[i]);
                }
                enterArray.add(enter_quik);
                enter_quik.addActionListener(this);
                add(enterArray);
            }
        }

        if(e.getSource()==enter_quik)
        {
            initial = new JPanel();
            resultShow = new JPanel();
            footer = new JPanel();
            initial.setLayout(new BoxLayout(initial,BoxLayout.PAGE_AXIS));
            initial.setAlignmentX(initial.CENTER_ALIGNMENT);
            resultShow.setLayout(new BoxLayout(resultShow,BoxLayout.PAGE_AXIS));
            resultShow.setAlignmentX(resultShow.CENTER_ALIGNMENT);
            
            footer.setLayout(new BoxLayout(footer,BoxLayout.PAGE_AXIS));
            footer.setAlignmentX(footer.CENTER_ALIGNMENT);
            a = new int[array_size];
            System.out.println("Array Entered QuickSort :");
            for(int i=0;i<array_size;i++)
            {
                String s= tfquik[i].getText();
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
            enter_quik.setEnabled(false);
            String initialArray=new String();
            initial.add(new JLabel("Initial Array is:"));
            for(int i=0; i<a.length; i++)
            {
                if(i==a.length-1)
                    initialArray=initialArray+a[i]+".";
                else
                    initialArray=initialArray+a[i]+", ";
            }
            initial.add(new JLabel(initialArray));
            this.sort(0,a.length-1);            //sorting call
            add(initial);
            clearquik = new JButton("Clear");
            clearquik.addActionListener(this);
            String finalArray = new String();
            System.out.println("Final array:");
            for(int i=0;i<a.length;i++)
            {
                System.out.println(a[i]);
                if(i==a.length-1)
                    finalArray =finalArray+a[i]+".";
                else
                    finalArray =finalArray+a[i]+", ";
            }
            footer.add(new JLabel("Final Sorted Array is: "+finalArray));
            footer.add(clearquik);  
            scroll= new JScrollPane(resultShow);
            
            add(scroll);
            add(footer);
        }

        if(e.getSource()==clearquik)
        {
            this.remove(enterPanel);
            this.remove(enterArray);
            this.remove(initial);
            this.remove(scroll);
            this.remove(footer);
            this.add(new Quick());
            revalidate();
            repaint();
        }

        if(e.getSource()==clearquik1)
        {
            this.remove(enterPanel);
            this.add(new Quick());
            revalidate();
            repaint();
        }   
        revalidate();     
    }

        
    void sort(int l,int r)
    {
        if(l>=r) return;
        else{
            String piv = "";
            String showPass = "";
            String beforePass="";
            int i=l+1;
            int j;
            for(j=l;j<=r;j++)
            {
                if(j==r)
                {
                    beforePass+=a[j]+".";
                }
                else
                {
                    beforePass+=a[j]+", ";
                }
            }
            int pivot = a[r];
            a[r] = a[l];
            a[l] = pivot;
            piv+=pivot;
            int temp;
            for (j=l+1;j<=r;j++)
            {

                if(a[j]<pivot)
                {
                    temp=a[j];
                    a[j]=a[i];
                    a[i]=temp;
                    i++;
                }	
            }
            //Exchanging pivot with the element to place pivot at correct position.
            temp=a[l];
            a[l]=a[i-1];
            a[i-1]=temp;
            boolean found=false;
            for(j=0;j<a.length;j++)
                {
                    if(a[j]==pivot && found==false)
                    {
                        showPass+="<---"+a[j]+"--->, ";
                        found=true;
                    }
                    else if(j==a.length-1)
                    {
                        showPass+=a[j]+".";
                    }
                    else
                    {
                        showPass+=a[j]+", ";
                    }
                }
            if(count1==0)
            {
                initial.add(new JLabel(new String("Pivot choosen: "+piv)));
                initial.add(new JLabel(new String("First Parse: "+showPass)));
                initial.add(new JLabel("Subsequent Iterations:"));
                count1++;
            }
            else
            {
                resultShow.add(new JLabel(new String("Part of array in focus: "+beforePass)));
                resultShow.add(new JLabel(new String("The pivot now is: "+piv)));
                resultShow.add(new JLabel(new String("After this iteration: "+showPass)));
                count1++;
            }
            
            
            this.sort(l,i-2);
            this.sort(i,r);
        }    
    }
}
