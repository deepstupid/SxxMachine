package SxxMachine.builtin;

import SxxMachine.FFIObjectTerm;
import SxxMachine.Operation;
import SxxMachine.Predicate;
import SxxMachine.Prolog;
import SxxMachine.Term;
/**
 * <code>current_engine/1</code>
 * @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 * @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 * @version 1.0
 */
public class PRED_current_engine_1 extends Predicate.P1 {
    public PRED_current_engine_1(Term a1, Operation cont) {
	LARG[0] = a1;
	this.cont = cont;
    }

    public Operation exec(Prolog engine) {
        engine.setB0();
	Term a1;
	a1 = LARG[0];

	a1 = a1.dref();
	if (! a1.unify(new FFIObjectTerm(engine), engine.trail))
	    return engine.fail();
	return cont;
    }
}
