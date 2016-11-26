package reciever;

public class Buffer {

	private StringBuffer zoneDeTexte;

	private Buffer(){
		this.zoneDeTexte = new StringBuffer("");
	}



	private static Buffer INSTANCE = new Buffer();

	public static Buffer getINSTANCE() {
		return INSTANCE;
	}

	public StringBuffer getTexte(){
		return INSTANCE.zoneDeTexte;
	}

	public void setText(StringBuffer zt){
		INSTANCE.zoneDeTexte = zt;
	}

	public  void lire(){
		System.out.println(zoneDeTexte);
	}
}

