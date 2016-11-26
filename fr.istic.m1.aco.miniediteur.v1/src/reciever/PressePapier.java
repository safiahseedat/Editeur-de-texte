package reciever;

public class PressePapier {

	private PressePapier(){}

	private static PressePapier INSTANCE = new PressePapier();

	public static PressePapier getINSTANCE(){
		return  INSTANCE;
	}

	private StringBuffer texte;

	public StringBuffer getText(){
		return texte;
	}

	public void setText(StringBuffer txt){
		this.texte = txt;
	}



}

