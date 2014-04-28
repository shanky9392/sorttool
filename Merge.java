import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Merge extends JPanel implements ActionListener
{
	  int a[];
 	  JTextField[] tfmer;
  	JButton enter_mer, enter_size, clearmer,clearmer1;
  	int array_size, count1, count2; 
  	JTextField sizeOfArray;
  	JPanel enterPanel, enterArray, initial, resultShow, lresultShow, rresultShow, footer;
  	JLabel forSize, forArray, forResult;
  	JScrollPane lScroll,rScroll;

  	public Merge()
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
        		clearmer1 = new JButton("Clear");
        		clearmer1.addActionListener(this);
        		enterPanel.add(clearmer1);
      		}
      		else
      		{
      			enterArray = new JPanel();
        		tfmer = new JTextField[array_size];
        		enter_mer = new JButton("Enter");
        		enterArray.setMaximumSize(new Dimension(500,160));
        		enterArray.setMinimumSize(new Dimension(500,160));
        		forArray = new JLabel("Enter the array:");
        		enterArray.add(forArray);
        		for (int i=0;i<array_size;i++) 
        		{
          			tfmer[i]=new JTextField(2);
          			enterArray.add(tfmer[i]);
        		}
        		enterArray.add(enter_mer);
        		enter_mer.addActionListener(this);
        		add(enterArray);
      		}
    	}


    	if(e.getSource()==enter_mer)
    	{
		    initial = new JPanel();
    		resultShow = new JPanel();
		    lresultShow = new JPanel();
		    rresultShow = new JPanel();
        footer = new JPanel();
		    initial.setLayout(new BoxLayout(initial,BoxLayout.PAGE_AXIS));
		    initial.setAlignmentX(initial.CENTER_ALIGNMENT);
		    lresultShow.setLayout(new BoxLayout(lresultShow,BoxLayout.PAGE_AXIS));
		    lresultShow.setAlignmentX(lresultShow.CENTER_ALIGNMENT);
		    rresultShow.setLayout(new BoxLayout(rresultShow,BoxLayout.PAGE_AXIS));
		    rresultShow.setAlignmentX(rresultShow.CENTER_ALIGNMENT);
      	resultShow.setLayout(new BoxLayout(resultShow,BoxLayout.LINE_AXIS));
      	resultShow.setAlignmentX(resultShow.CENTER_ALIGNMENT);
        footer.setLayout(new BoxLayout(footer,BoxLayout.PAGE_AXIS));
        footer.setAlignmentX(footer.CENTER_ALIGNMENT);
      	a = new int[array_size];
     		System.out.println("Array Entered Merge Sort :");
      	for(int i=0;i<array_size;i++)
      		{
        		String s= tfmer[i].getText();
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
      	enter_mer.setEnabled(false);
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
        initial.add(new JLabel("Subsequent Iterations:"));
	      add(initial);
      	a=this.msort(a);			//sorting call
      	clearmer = new JButton("Clear");
        clearmer.addActionListener(this);
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
        footer.add(clearmer);  
        lScroll= new JScrollPane(lresultShow);
        rScroll = new JScrollPane(rresultShow);
		    resultShow.add(lScroll);
		    resultShow.add(rScroll);
		    add(resultShow);
        add(footer);
    	}

    if(e.getSource()==clearmer)
    	{
      		this.remove(enterPanel);
      		this.remove(enterArray);
		      this.remove(initial);
      		this.remove(resultShow);
          this.remove(footer);
      		this.add(new Merge());
      		revalidate();
      		repaint();
    	}

    	if(e.getSource()==clearmer1)
    	{
      		this.remove(enterPanel);
      		this.add(new Merge());
      		revalidate();
      		repaint();
    	}	
    	revalidate();
    }


	int [] msort(int x[])
	{
		if(x.length==1)
		{
			return x;
		}
		else
		{
			int left[]=new int[x.length/2]; 
			int right[]=new int[x.length-x.length/2];
			for (int i=0; i<x.length/2 ;i++ ) 
			{
				left[i]=x[i];
			 	
			}
			for (int i=0;i<x.length-x.length/2 ;i++ ) 
			{
				right[i]=x[i+x.length/2];

			}

			System.out.println();
			String s1= new String();
			for (int i=0;i<left.length;i++ ) 
			{
				System.out.print(left[i]);
        if(i==left.length-1)
				  s1=s1+left[i]+" ";
        else
          s1=s1+left[i]+", ";
			}
				s1=s1+"--- ";
			System.out.println();

			for (int i=0;i<right.length ;i++ ) 
			{
				System.out.print(right[i]);
        if(i==right.length-1)
				  s1=s1+right[i]+" ";
        else
          s1=s1+right[i]+", ";
			}
			System.out.println();
			forResult= new JLabel(s1);
      if(count1==0)
      {
        count1++;
      }
			else if(count1<a.length/2)
			{
				lresultShow.add(forResult);
				count1++;
			}
			else
			{
				rresultShow.add(forResult);
			}
			left=msort(left);
			right=msort(right);

			return this.merge(left,right); 

		}
	}

	int [] merge(int l[], int r[])
	{
		int sort[]=new int[l.length+r.length];
		int i=0,j=0,k=0;

		while(i<l.length&&j<r.length)
		{
			if(l[i]<=r[j])
			{
				sort[k]=l[i];
				i++;
				k++;
			}
			else if(r[j]<l[i])
			{
				sort[k]=r[j];
				j++;
				k++;
			}
		}

		if(i<l.length)
		{
			while(i<l.length)
			{
				sort[k]=l[i];
				k++;i++;
			}
		}

		if(j<r.length)
		{
			while(j<r.length)
			{
				sort[k]=r[j];
				k++;j++;
			}
		}
		String sortedArray = new String();
		for(int z=0; z<sort.length;z++)
		{
			if(z==sort.length-1)
				sortedArray = sortedArray+sort[z]+".";
			else
				sortedArray = sortedArray+sort[z]+", ";
		}
    if(count2<a.length/2-1)
    {
      lresultShow.add(new JLabel("Merged Array till now-->"+sortedArray));
      count2++;
    } 
    else if(count2==a.length-2)
    {}
    else
    {
      rresultShow.add(new JLabel("Merged Array till now-->"+sortedArray));
      count2++;
    }
      
		return(sort);

	}
}