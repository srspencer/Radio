public class TableTempFile{
    filePhilosopher[] P = new filePhilosopher[5];
    static filePhilosopher D;
    Chopstick[] C = new Chopstick[5];

    public TableTempFile(){
	for(int i=0;i<5;i++){
	    P[i] = new filePhilosopher(this, i);
	    C[i] = new Chopstick();
	}

    }

    public static void main(String args[]){
	TableTempFile T = new TableTempFile();
	for(int i=0;i<5;i++){
	    D = T.P[i];
	    D.start();
	}
    }

}
