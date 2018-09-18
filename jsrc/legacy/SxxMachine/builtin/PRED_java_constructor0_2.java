package SxxMachine;

import java.lang.reflect.Constructor;

import SxxMachine.FFIObjectTerm;
import SxxMachine.JavaPredicate;
import SxxMachine.Operation;
import SxxMachine.Prolog;
import SxxMachine.StructureTerm;
import SxxMachine.SymbolTerm;
import SxxMachine.Term;
import SxxMachine.VariableTerm;
import SxxMachine.ExistenceException;
import SxxMachine.IllegalTypeException;
import SxxMachine.JavaException;
import SxxMachine.PInstantiationException;
/**
 * <code>java_constructor0/2</code>
 * @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 * @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 * @version 1.1
 */
public class PRED_java_constructor0_2 extends JavaPredicate {
    // private final Term LARG[0], LARG[1];

    public PRED_java_constructor0_2(Term a1, Term a2, Operation cont) {
	LARG[0] = a1;
	LARG[1] = a2;
	this.cont = cont;
    }

    public Operation exec(Prolog engine) {
        engine.requireFeature(Prolog.Feature.JAVA_REFLECTION, this, LARG[0]);
        engine.setB0();

	Term a1, a2;
	a1 = LARG[0];
	a2 = LARG[1];

	Class clazz = null;
	Object instance = null;
	int arity;
	Constructor[] constrs = null;
	Term[] pArgs = null;
	Object[] jArgs = null;
	Constructor c = null;

	try {
	    // 2nd. argument (unbound variable)
	    a2 = a2.dref();
	    if (! (a2 instanceof VariableTerm))
		throw new IllegalTypeException(this, 2, "variable", a2);
	    // 1st. argument (atom or callable term)
	    a1 = a1.dref();
	    if ((a1 instanceof VariableTerm))
		throw new PInstantiationException(this, 1);
	    if (!(a1 instanceof SymbolTerm) && !(a1 instanceof StructureTerm))
		throw new IllegalTypeException(this, 1, "callable", a1);
	    if ((a1 instanceof SymbolTerm)) { // No argument constructor
		clazz = Class.forName(a1.asSymbolTerm().name());
		instance = clazz.newInstance();
		if (! a2.unify(toPrologTerm(instance), engine.trail))
		    return engine.fail();
		return cont;
	    } 
	    // Parameterized constructor
	    clazz = Class.forName((a1).name());
	    arity  = (a1).arity();
	    constrs = clazz.getConstructors();
	    if (constrs.length == 0)
		throw new ExistenceException(this, 1, "constructor", a1, "");
	    pArgs  = (a1).args();
	    jArgs  = new Object[arity];
	    for (int i=0; i<arity; i++) {
		pArgs[i] = pArgs[i].dref();
		if (! (pArgs[i] instanceof FFIObjectTerm))
		    pArgs[i] = new FFIObjectTerm(pArgs[i]);
		jArgs[i] = pArgs[i].toJava();
	    }
		for (Constructor constr : constrs) {
			if (checkParameterTypes(constr.getParameterTypes(), pArgs)) {
				try {
					c = constr;
					//c.setAccessible(true);
					instance = c.newInstance(jArgs);
					break;    // Succeeds to create new instance
				} catch (Exception e) {
					c = null; // Back to loop
				}
			}
		}
	    if (c == null)
		throw new ExistenceException(this, 1, "constructor", a1, "");
	    if (! a2.unify(toPrologTerm(instance), engine.trail)) 
		return engine.fail();
	    return cont;
	} catch (ClassNotFoundException e) {    // Class.forName(..)
	    throw new JavaException(this, 1, e);
	} catch (InstantiationException e) {    // Class.forName(..) or Constructor.newInstance()
	    throw new JavaException(this, 1, e);
	} catch (IllegalAccessException e) {    // Class.forName(..) or Constructor.newInstance()
	    throw new JavaException(this, 1, e);
	} catch (SecurityException e) {         // Class.getConstructors()
	    throw new JavaException(this, 1, e);
	} catch (IllegalArgumentException e) {  // Constructor.newInstance()
	    throw new JavaException(this, 1, e);
	}
    }

    private Term toPrologTerm(Object obj) {
	if (Term.instanceOfTerm(obj))
	    return (Term)obj;
	else 
	    return new FFIObjectTerm(obj);
    }
}
