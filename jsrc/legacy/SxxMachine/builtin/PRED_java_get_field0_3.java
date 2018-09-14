package SxxMachine.builtin;

import java.lang.reflect.Field;

import SxxMachine.exceptions.IllegalTypeException;
import SxxMachine.exceptions.JavaException;
import SxxMachine.exceptions.PInstantiationException;
import SxxMachine.JavaObjectTerm;
import SxxMachine.JavaPredicate;
import SxxMachine.Operation;
import SxxMachine.Prolog;
import SxxMachine.SymbolTerm;
import SxxMachine.Term;
import SxxMachine.VariableTerm;
/**
 * <code>java_get_field0/3</code>
 * @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 * @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 * @version 1.1
 */
public class PRED_java_get_field0_3 extends JavaPredicate {
	private final Term arg1, arg2, arg3;

    public PRED_java_get_field0_3(Term a1, Term a2, Term a3, Operation cont) {
	arg1 = a1;
	arg2 = a2;
	arg3 = a3;
	this.cont = cont;
    }

    public Operation exec(Prolog engine) {
        engine.requireFeature(Prolog.Feature.JAVA_REFLECTION, this, arg1);
        engine.setB0();

	Term a1, a2, a3;
	a1 = arg1;
	a2 = arg2;
	a3 = arg3;

	Class  clazz = null;
	Object instance = null;
	Field  field = null;
	Object value = null;

	// 3rd. argument (unbound variable)
	a3 = a3.dereference();
	if (! (a3 instanceof VariableTerm))
	    throw new IllegalTypeException(this, 3, "variable", a3);
	try {
	    // 1st. argument (atom or java term)
	    a1 = a1.dereference();
	    if ((a1 instanceof VariableTerm)) {
		throw new PInstantiationException(this, 1);
	    } else if ((a1 instanceof SymbolTerm)){      // class
		clazz = Class.forName(((SymbolTerm)a1).name());
	    } else if ((a1 instanceof JavaObjectTerm)) { // instance
		instance = ((JavaObjectTerm)a1).object();
		clazz = ((JavaObjectTerm)a1).getClazz();
	    } else {
		throw new IllegalTypeException(this, 1, "atom_or_java", a1);
	    }
	    // 2nd. argument (atom)
	    a2 = a2.dereference();
	    if ((a2 instanceof VariableTerm)) {
		throw new PInstantiationException(this, 2);
	    } else if (! (a2 instanceof SymbolTerm)) {
		throw new IllegalTypeException(this, 2, "atom", a2);
	    }
	    field = clazz.getField(((SymbolTerm)a2).name());
	    value = field.get(instance);
	    // 3rd. argument
	    if (value == null)
		return cont;
	    if (! a3.unify(toPrologTerm(value), engine.trail)) 
		return engine.fail();
	    return cont; 
	} catch (ClassNotFoundException e) {    // Class.forName
	    throw new JavaException(this, 1, e);
	} catch (NoSuchFieldException e) {      // Class.getField(..)
	    throw new JavaException(this, 2, e);
	} catch (SecurityException e) {         // Class.getField(..)
	    throw new JavaException(this, 2, e);
	} catch (NullPointerException e) {      // Class.getField(..)
	    throw new JavaException(this, 2, e);
	} catch (IllegalAccessException e) {    // Field.get(..)
	    throw new JavaException(this, 2, e);
	} catch (IllegalArgumentException e) {  // Field.get(..)
	    throw new JavaException(this, 2, e);
	}
    }

    private Term toPrologTerm(Object obj) {
	if (Term.instanceOfTerm(obj))
	    return (Term)obj;
	else 
	    return new JavaObjectTerm(obj);
    }
}
