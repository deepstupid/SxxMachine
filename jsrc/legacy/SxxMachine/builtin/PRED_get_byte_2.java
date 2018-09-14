package SxxMachine.builtin;

import java.io.IOException;
import java.io.PushbackReader;

import SxxMachine.exceptions.ExistenceException;
import SxxMachine.exceptions.IllegalDomainException;
import SxxMachine.exceptions.IllegalTypeException;
import SxxMachine.exceptions.PInstantiationException;
import SxxMachine.exceptions.PermissionException;
import SxxMachine.exceptions.RepresentationException;
import SxxMachine.exceptions.TermException;
import SxxMachine.IntegerTerm;
import SxxMachine.JavaObjectTerm;
import SxxMachine.Operation;
import SxxMachine.Predicate;
import SxxMachine.Prolog;
import SxxMachine.SymbolTerm;
import SxxMachine.Term;
import SxxMachine.VariableTerm;
/**
 * <code>get_byte/2</code><br>
 * @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 * @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 * @version 1.1
 * @since 1.1
*/
public class PRED_get_byte_2 extends Predicate.P2 {
    private static final IntegerTerm INT_EOF = new IntegerTerm(-1);

    public PRED_get_byte_2(Term a1, Term a2, Operation cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public Operation exec(Prolog engine) {
        engine.setB0();
        Term a1, a2;
        a1 = arg1;
        a2 = arg2;
	Object stream = null;

	// InByte
	a2 = a2.dereference(); 
	if (! (a2 instanceof VariableTerm)) {
	    if (! (a2 instanceof IntegerTerm))
		throw new IllegalTypeException(this, 2, "in_byte", a2);
	    int n = ((IntegerTerm)a2).intValue();
	    if (n != -1 && (n < 0 || n > 255))
		throw new RepresentationException(this, 2, "in_byte");
	}
	// S_or_a
	a1 = a1.dereference(); 
	if ((a1 instanceof VariableTerm)) {
	    throw new PInstantiationException(this, 1);
	} else if ((a1 instanceof SymbolTerm)) {
	    if (! engine.getStreamManager().containsKey(a1))
		throw new ExistenceException(this, 1, "stream", a1, "");
	    stream = ((JavaObjectTerm) engine.getStreamManager().get(a1)).object();
	} else if ((a1 instanceof JavaObjectTerm)) {
	    stream = ((JavaObjectTerm) a1).object();
	} else {
	    throw new IllegalDomainException(this, 1, "stream_or_alias", a1);
	}
	if (! (stream instanceof PushbackReader))
	    throw new PermissionException(this, "input", "stream", a1, "");
	// read single byte
	try {
	    int c = ((PushbackReader)stream).read();
	    if (c < 0) { // EOF
		if (! a2.unify(INT_EOF, engine.trail))
		    return engine.fail();
		return cont;
	    } 
	    if (c > 255)
		throw new RepresentationException(this, 0, "byte");
	    if (! a2.unify(new IntegerTerm(c), engine.trail))
		return engine.fail();
	    return cont;
	} catch (IOException e) {
	    throw new TermException(new JavaObjectTerm(e));
	}
    }
}
