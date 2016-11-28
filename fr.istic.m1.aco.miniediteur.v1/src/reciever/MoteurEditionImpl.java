package reciever;
import java.lang.*;

public class MoteurEditionImpl implements MoteurEdition {

	public Buffer buffer = Buffer.getINSTANCE();
	public PressePapier pressePapier = PressePapier.getINSTANCE();
	public Selection selection = Selection.getInstance();
	public static boolean enregistrement = false;


	public MoteurEditionImpl(){

	}


	public void couper(){
		int debut = selection.getSelectionDebut();
		int fin = selection.getSelectionFin();

		if(debut != fin){
            String chaine = buffer.getTexte().substring(debut, fin);
			pressePapier.setText(new StringBuffer(chaine));
			buffer.getTexte().delete(debut,fin);
		}
	}


	public void copier(){
		int debut = selection.getSelectionDebut();
		int fin = selection.getSelectionFin();
		if(debut != fin){
			String acopier = buffer.getTexte().substring(debut, fin);
			StringBuffer a = new StringBuffer(acopier);
			pressePapier.setText(a);
		}
	}

	public void coller(){
		insererTexte(pressePapier.getText());
	}


	public void selectionner(int debut, int fin){
		selection.setSelectionDebut(debut);
		selection.setSelectionFin(fin);

	}

	public void insererTexte(StringBuffer txt){
		int debut = selection.getSelectionDebut();
		int fin = selection.getSelectionFin();
        StringBuffer chaine = buffer.getTexte().delete(debut,fin);
        buffer.setText(chaine.insert(debut,txt));

	}

	public void supprimerDel(){
		int debut = selection.getSelectionDebut();
		int fin = selection.getSelectionFin();

		if(debut!=fin){
			buffer.setText(buffer.getTexte().delete(debut,fin));

		}else{
			buffer.getTexte().deleteCharAt(fin);
			selectionner(debut, debut);

		}


	}

	public void supprimerBack(){
		int debut = selection.getSelectionDebut();
		int fin = selection.getSelectionFin();
		if(debut!=fin){
			buffer.setText(buffer.getTexte().delete(debut,fin));
		}else{
			buffer.getTexte().deleteCharAt(fin-1);
		}


	}






}
