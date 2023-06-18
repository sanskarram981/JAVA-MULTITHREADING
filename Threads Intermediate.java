/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

class Company
{
    private int item;
    private boolean flag = false;
    
    public Company(int n)
    {
        super();
        this.item = n;
    }
    
    synchronized public void produce_item(int n)
    {
        if(!flag)
        {
            try
            {
            wait();
            }
            catch (Exception e)
            {
                
            }
        }
        this.item = n;
        System.out.println("item produced : "+this.item);
        this.flag = true;
        notify();
    }
    
    synchronized public void consume_item()
    {
        if(!flag)
        {
            try
            {
            wait();
            }
            catch (Exception e)
            {
                
            }
        }
        System.out.println("item consumed : "+this.item);
        this.flag = false;
        notify();
    }
}

class Producer extends Thread
{
    private Company company;
    
    public Producer(Company company)
    {
        this.company = company;
    
    }
    public void run()
    {
        for(int i=1;i<=100;i++)
        {
            this.company.produce_item(i);
        }
        try {
            Thread.sleep(1000);
        } catch(Exception e) {
        }
        
    }
}


class Consumer extends Thread
{
    private Company company;
    
    public Consumer(Company company)
    {
        this.company = company;
    
    }
    public void run()
    {
        for(int i=1;i<=100;i++)
        {
            this.company.consume_item();
             try {
            Thread.sleep(1000);
        } catch(Exception e) {
        }
        }
        
    }
}

public class Main
{
	public static void main(String[] args) 
	{
	    Company company = new Company(0);
	    Producer p1 = new Producer(company);
		Consumer c1 = new Consumer(company);
		p1.start();
		c1.start();
	}
}
