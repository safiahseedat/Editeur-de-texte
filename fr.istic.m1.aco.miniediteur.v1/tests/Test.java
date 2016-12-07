import command.*;
import reciever.Buffer;
import reciever.MoteurEditionImpl;
import

/**
 * Created by Safiah on 07/12/2016.
 */
public class Test {

    @Test

    public static MoteurEditionImpl m = new MoteurEditionImpl();
    Command coller = new Coller(m);
    Command couper = new Couper(m);
    Command suppB = new SupprimerBack(m);
    Command suppD = new SupprimerDel(m);
    Command copier = new Copier(m);


    public final void testCopier(){
        m.buffer.setText(new StringBuffer("bonjour"));
        m.selectionner(0,0);
        copier.execute();
        assertTrue(m.pressePapier.getText().equals(""));
        m.selectionner(0,4);
        assertTrue(m.pressePapier.getText().equals("bonj"));
        m.selectionner(0,5);
        assertFalse(m.pressePapier.getText().equals("bonj"));
    }

    public final void testCouper(){
        m.buffer.setText(new StringBuffer("bonjour"));
        m.selectionner(0,7);
        couper.execute();
        assertTrue(m.pressePapier.getText().equals("bonjour"));
        assertTrue(m.buffer.getText().equals(""));

        m.selectionner(3,6);
        couper.execute();
        assertTrue(m.pressePapier.getText().equals("jou"));
        assertFalse(m.buffer.getTexte().equals("bonjour"));

    }

    public final void testColler(){
        m.buffer.setText(new StringBuffer("bonjour"));
        m.selectionner(0,7);
        copier.execute();
        m.selectionner(0,0);
        coller.execute();
        assertTrue(m.buffer.getTexte().equals("bonjourbonjour"));

    }

    public final void testInserer(){
        m.buffer.setText(new StringBuffer(""));
        m.selectionner(m.buffer.getTexte().length(),m.buffer.getTexte().length());
        m.insererTexte(new StringBuffer("b"));
        assertTrue(m.buffer.getTexte().equals("b"));
        m.selectionner(m.buffer.getTexte().length(),m.buffer.getTexte().length());
        m.insererTexte(new StringBuffer("o"));
        m.selectionner(m.buffer.getTexte().length(),m.buffer.getTexte().length());
        m.insererTexte(new StringBuffer("n"));
        m.selectionner(m.buffer.getTexte().length(),m.buffer.getTexte().length());
        m.insererTexte(new StringBuffer("j"));
        m.selectionner(m.buffer.getTexte().length(),m.buffer.getTexte().length());
        m.insererTexte(new StringBuffer("o"));
        m.selectionner(m.buffer.getTexte().length(),m.buffer.getTexte().length());
        m.insererTexte(new StringBuffer("u"));
        m.selectionner(m.buffer.getTexte().length(),m.buffer.getTexte().length());
        m.insererTexte(new StringBuffer("r"));

        assertTrue(m.buffer.getTexte().equals("bonjour"));
    }


}
