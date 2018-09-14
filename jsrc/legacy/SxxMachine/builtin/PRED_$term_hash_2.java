package SxxMachine.builtin;

import SxxMachine.IntegerTerm;
import SxxMachine.Operation;
import SxxMachine.Predicate;
import SxxMachine.Prolog;
import SxxMachine.Term;
/**
 * <code>'$term_hash'/2</code><br>
 * @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 * @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 * @version 1.1
 */
public class PRED_$term_hash_2 extends Predicate.P2 {
    public PRED_$term_hash_2(Term a1, Term a2, Operation cont) {
	LARG[0] = a1;
	LARG[1] = a2;
	this.cont = cont;
    }

    public Operation exec(Prolog engine) {
        engine.setB0();
	Term a1, a2;
        a1 = LARG[0];
        a2 = LARG[1];

	a1 = a1.dref(); 
	if (! a2.unify(new IntegerTerm(a1.hashCode()), engine.trail))
	    return engine.fail();
	return cont;
    }
}
