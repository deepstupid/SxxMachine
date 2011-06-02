package jp.ac.kobe_u.cs.prolog.builtin;
import  jp.ac.kobe_u.cs.prolog.lang.*;
/**
 * <code>nl/0</code><br>
 * @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 * @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 * @version 1.0
 */
public class PRED_nl_0 extends Predicate {

    public PRED_nl_0(Operation cont) {
	this.cont = cont;
    }

    public Operation exec(Prolog engine) {
        engine.setB0();
	engine.getCurrentOutput().println();
	return cont;
    }
}
