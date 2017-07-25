package com.googlecode.prolog_cafe.builtin;

import com.googlecode.prolog_cafe.lang.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Hashtable;

/**
 * <code>'$hash_addz'/3</code><br>
 * 
 * @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 * @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 * @version 1.0
 */
class PRED_$hash_addz_3 extends Predicate.P3 {
	private static final SymbolTerm SYM_NIL = Prolog.Nil;

	public PRED_$hash_addz_3(Term a1, Term a2, Term a3, Operation cont) {
		arg1 = a1;
		arg2 = a2;
		arg3 = a3;
		this.cont = cont;
	}

	public Operation exec(Prolog engine) {
		engine.setB0();
		Term a1, a2, a3;
		a1 = arg1;
		a2 = arg2;
		a3 = arg3;

		Object hash = null;

		a1 = a1.dereference();
		if ((a1 instanceof VariableTerm)) {
			throw new PInstantiationException(this, 1);
		} else if ((a1 instanceof SymbolTerm)) {
			if (!engine.getHashManager().containsKey(a1))
				throw new ExistenceException(this, 1, "hash", a1, "");
			hash = ((JavaObjectTerm) engine.getHashManager().get(a1)).object();
		} else if ((a1 instanceof JavaObjectTerm)) {
			hash = ((JavaObjectTerm) a1).object();
		} else {
			throw new IllegalDomainException(this, 1, "hash_or_alias", a1);
		}
		if (!(hash instanceof HashtableOfTerm))
			throw new InternalException(this + ": Hash is not HashtableOfTerm");
		a2 = a2.dereference();
		a3 = a3.dereference();
		Term elem = ((HashtableOfTerm) hash).get(a2);
		if (elem == null || SYM_NIL.equals(elem)) {
			elem = new ListViewTerm(a3);
		} else if (elem instanceof ListTerm) {
			elem = ((ListTerm) elem).add(a3);
		} else {
			throw new InternalException(this + ": elem is not a ListTerm");
		}
		((HashtableOfTerm) hash).put(a2, elem);
		return cont;
	}
}
