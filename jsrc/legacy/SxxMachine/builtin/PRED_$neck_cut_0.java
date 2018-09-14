package SxxMachine.builtin;

import SxxMachine.Operation;
import SxxMachine.Predicate;
import SxxMachine.Prolog;
/**
 <code>'$neck_cut'/0</code><br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
public class PRED_$neck_cut_0 extends Predicate {

    public PRED_$neck_cut_0(Operation cont) {
        this.cont = cont;
    }

    public Operation exec(Prolog engine) {
	//        engine.setB0(); 
        engine.neckCut();
        return cont;
    }
}
