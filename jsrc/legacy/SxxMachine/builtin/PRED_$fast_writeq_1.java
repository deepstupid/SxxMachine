package SxxMachine.builtin;

import SxxMachine.Operation;
import SxxMachine.Predicate;
import SxxMachine.Prolog;
import SxxMachine.Term;
/**
 * <code>'$fast_writeq'/1</code><br>
 * @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 * @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 * @version 1.0
 */
public class PRED_$fast_writeq_1 extends Predicate.P1 {
    public PRED_$fast_writeq_1(Term a1, Operation cont) {
	LARG[0] = a1;
	this.cont = cont;
    }

    public Operation exec(Prolog engine) {
        engine.setB0();
	Term a1;
	a1 = LARG[0].dref();
	engine.getCurrentOutput().print(a1.toQuotedString());
	return cont;
    }
}
