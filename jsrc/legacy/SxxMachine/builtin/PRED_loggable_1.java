package SxxMachine.builtin;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import SxxMachine.exceptions.IllegalTypeException;
import SxxMachine.exceptions.PrologException;
import SxxMachine.Operation;
import SxxMachine.Predicate.P1;
import SxxMachine.Prolog;
import SxxMachine.StructureTerm;
import SxxMachine.SymbolTerm;
import SxxMachine.Term;

/**
 * <p><b>loggable(package:level)</b> - succeed if given level is loggable for given package.
 * If package is absent, then current package is automatically added by prolog compiler.
 * So call loggable('INFO') is valid. Both package and level are expected to be atoms. (Variables will cause errors).
 * Level can be one of 'OFF','SEVERE','WARNING','INFO','CONFIG','FINE','FINER','FINEST','ALL' (from highest to lowest).
 * Also lower case variants without quotes are accepted.  
 *
 * <p>The predicate finds {@link Logger} instance, corresponding to given package, and calls its {@link Logger#isLoggable(Level)}
 * method with given level.
 * 	  
 * @author semenov
 *
 */
public class PRED_loggable_1 extends P1 {

	static final Map<Term, Level> LEVELS = new HashMap<>();
	static {
		LEVELS.put(SymbolTerm.intern("ALL"), Level.ALL);
		LEVELS.put(SymbolTerm.intern("all"), Level.ALL);
		LEVELS.put(SymbolTerm.intern("FINEST"), Level.FINEST);
		LEVELS.put(SymbolTerm.intern("finest"), Level.FINEST);
		LEVELS.put(SymbolTerm.intern("FINER"), Level.FINER);
		LEVELS.put(SymbolTerm.intern("finer"), Level.FINER);
		LEVELS.put(SymbolTerm.intern("FINE"), Level.FINE);
		LEVELS.put(SymbolTerm.intern("fine"), Level.FINE);
		LEVELS.put(SymbolTerm.intern("INFO"), Level.INFO);
		LEVELS.put(SymbolTerm.intern("info"), Level.INFO);
		LEVELS.put(SymbolTerm.intern("CONFIG"), Level.CONFIG);
		LEVELS.put(SymbolTerm.intern("config"), Level.CONFIG);
		LEVELS.put(SymbolTerm.intern("WARNING"), Level.WARNING);
		LEVELS.put(SymbolTerm.intern("warning"), Level.WARNING);
		LEVELS.put(SymbolTerm.intern("SEVERE"), Level.SEVERE);
		LEVELS.put(SymbolTerm.intern("severe"), Level.SEVERE);
	}

	public PRED_loggable_1(Term a0, Operation cont) {
		this.LARG[0] = a0; //0];
		this.cont = cont;
	}
	
	@Override
	public Operation exec(Prolog engine) throws PrologException {

		Term a1 = LARG[0].dref();

		if (!(a1 instanceof StructureTerm) || a1.arity()!=2){
			throw new IllegalTypeException(this, 1, "package:level", a1);
		}
		
		Logger logger = Logger.getLogger(a1.arg0(0).name());
		if (!logger.isLoggable(LEVELS.getOrDefault(a1.arg0(1), Level.INFO))){
			return engine.fail();
		}
		return cont;
	}

}
