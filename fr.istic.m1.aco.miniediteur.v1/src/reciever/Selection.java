package reciever;

public class Selection {

	private int debutSelection;
	private int finSelection;

	private static Selection INSTANCE = new Selection();

	private Selection(){
		this.debutSelection = 0;
		this.finSelection = 0;
	}

	public static Selection getInstance(){
		return INSTANCE;
	}

	public int getSelectionDebut(){
		return debutSelection;
	}

	public int getSelectionFin(){
		return finSelection;
	}

	public void setSelectionDebut(int deb){
		this.debutSelection = deb;
	}

	public void setSelectionFin(int fin){
		this.finSelection = fin;
	}

	public void setSelection(int deb, int fin){
		setSelectionDebut(deb);
		setSelectionFin(fin);
	}

}
