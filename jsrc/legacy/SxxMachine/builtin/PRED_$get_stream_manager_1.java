package SxxMachine.builtin;

import SxxMachine.FFIObjectTerm;
import SxxMachine.Operation;
import SxxMachine.Predicate;
import SxxMachine.Prolog;
import SxxMachine.Term;
import SxxMachine.VariableTerm;
import SxxMachine.exceptions.IllegalTypeException;
/**
   <code>'$get_stream_manager'/1</code><br>
   @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
   @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
   @version 1.0
*/
class PRED_$get_stream_manager_1 extends Predicate.P1 {
    public PRED_$get_stream_manager_1(Term a1, Operation cont) {
        LARG[0] = a1;
        this.cont = cont;
    }

    public Operation exec(Prolog engine) {
        engine.setB0();
        Term a1;
        a1 = LARG[0];

	a1 = a1.dref();
	if (! (a1 instanceof VariableTerm))
	    throw new IllegalTypeException(this, 1, "variable", a1);
	if (! a1.unify(new FFIObjectTerm(engine.getStreamManager()), engine.trail))
	    return engine.fail();
        return cont;
    }
}
