/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
class MyThd implements Runnable
{
    public void run()
    {
        for(int i=10;i>=1;i--)
        {
            System.out.println("the value of j : "+i);
            try {
                Thread.sleep(1000);
            } 
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
public class Main implements Runnable
{
    public void run()
    {
        for(int i=1;i<=10;i++)
        {
            System.out.println("the value of i : "+i);
            try {
                Thread.sleep(1000);
            } 
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
	public static void main(String[] args) 
	{
		System.out.println("Entering main");
		
		Main m1 = new Main();
		Thread t1 = new Thread(m1);
		
		MyThd m2 = new MyThd();
		Thread t2 = new Thread(m2);
		t1.start();
		t2.start();
		
		 try {
                Thread.sleep(20000);
            } 
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
            
        Thread curr = Thread.currentThread();
        System.out.println("ThreadName -> "+curr.getName());
        curr.setName("impala");
        System.out.println("ThreadName -> "+curr.getName());
        System.out.println("ThreadId -> "+curr.getId());
        
		System.out.println("Exiting main");
	}
}
