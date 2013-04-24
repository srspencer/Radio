import java.util.*;


public class diningPhilosopher extends Thread{
    Chopstick left, right;
    int state, identity, myLeft, myRight;
    Table T;

    public diningPhilosopher(Table Tl, int id){
	state = 0;
	identity = id;
	T=Tl;
	myLeft = id-1;
	if(myLeft <0)
	    myLeft = 4;
	myRight = id;
	System.out.print("I am "+ identity + ". My left is " + myLeft);
	System.out.println(". My right is " + myRight);
    }

    public void thinking(){
	state = 0;
	System.out.println("Philosopher "+identity+ " is thinking");
    }

    public void hungry(){
	state = 1;
	System.out.println("Philosopher " + identity + " is hungry");
    }

    public boolean isHungry(){
	if(state ==1)
	    return(true);
	else
	    return(false);
    }
    
    public boolean isEating(){
	if(state == 2)
	    return(true);
	else
	    return(false);
    }

    public boolean isThinking(){
	if(state == 0)
	    return(true);
	else
	    return(false);
    }

    public void tryEat(){
	if(T.C[myLeft].isOnTable()){
	    right = T.C[myRight].pickUp(identity);
	    if(right == null){
		return;
	    }
	    left = T.C[myLeft].pickUp(identity);
	    if(left == null){
		right.putDown();
		return;
	    }
	
	    state = 2;
	    System.out.println("Philosopher " + identity + " is eating");
	}
    }
    
    public void doneEating(){
	left = left.putDown();
	right = right.putDown();

	System.out.println(identity + " is done. Aaah");
	try{
	    Thread.sleep(1000);
	}catch(Exception e){}
	this.thinking();
    }
	

    public void run(){
	System.out.println(identity + " is running");
	while(true){
	    if(this.isThinking()){
		this.hungry();
		//sleep(1000);
	    }
	    if(this.isEating()){
		this.doneEating();
		//sleep(1000);
	    }
	    if(this.isHungry()){
		this.tryEat();
	    }

	}
    }
}
