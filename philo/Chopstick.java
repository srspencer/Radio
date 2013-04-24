public class Chopstick{
    int holder;
    
    public Chopstick(){
	holder=0;
    }

    public synchronized Chopstick pickUp(int h){
	if(holder == 0){
	    holder=h;
	    return(this);
	}else{
	    return(null);
	}
    }

    public Chopstick putDown(){
	holder=0;
	return(null);
    }

    public boolean isOnTable(){
	if(holder == 0)
	    return(true);
	else
	    return(false);
    }
}
