public class Table{
    diningPhilosopher[] P = new diningPhilosopher[5];
    static diningPhilosopher D;
    Chopstick[] C = new Chopstick[5];

    public Table(){
	for(int i=0;i<5;i++){
	    P[i] = new diningPhilosopher(this, i);
	    C[i] = new Chopstick();
	}

    }

    public static void main(String args[]){
	Table T = new Table();
	for(int i=0;i<5;i++){
	    D = T.P[i];
	    D.start();
	}
    }

}
