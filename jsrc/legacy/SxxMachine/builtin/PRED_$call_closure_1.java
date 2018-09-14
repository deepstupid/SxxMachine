package SxxMachine.builtin;

import SxxMachine.ClosureTerm;
import SxxMachine.Operation;
import SxxMachine.Predicate;
import SxxMachine.Prolog;
import SxxMachine.Term;
/**
 * <code>'$call_closure'/1</code><br>
 * @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 * @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 * @version 1.0
 */
class PRED_$call_closure_1 extends Predicate.P1 {
    public PRED_$call_closure_1(Term a1, Operation cont) {
	LARG[0] = a1;
	this.cont = cont;
    }

    public Operation exec(Prolog engine) {
        engine.setB0();
	Term a1;
	Predicate code;

	// a1 must be closure
	a1 = LARG[0].dref();

	if (! (a1 instanceof ClosureTerm))
	    return engine.fail();
	code = ((ClosureTerm) a1).getCode();
	code.cont = this.cont;
	return code;
    }
}
