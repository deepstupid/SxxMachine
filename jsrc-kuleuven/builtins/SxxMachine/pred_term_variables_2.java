
package SxxMachine;

import static SxxMachine.pterm.TermData.CONS;
import static SxxMachine.pterm.TermData.CONST;
import static SxxMachine.pterm.TermData.internS;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class pred_term_variables_2 extends Code {

    private static Code unify;

    @Override
    public int arity() {
        return 2;
    }

    @Override
    public void init(PredikatenPrologMachine machine) {
        if (unify == null) {
            unify = machine.loadPred(internS("unify"), 2);
        }
    }

    @Override
    public Code exec(PrologMachine mach) {
        final TermArray local_aregs = mach.getAreg();
        // PrologObject continuation = mach.getCont(local_aregs, 2);
        // PrologObject variables = local_aregs.a(1).v.Deref();
        Term term = local_aregs.getTermDRef(0);

        final Set<Term> varset = new HashSet<Term>();
        final Queue<Term> queue = new LinkedList<Term>();

        while (term != null) {
            if (term.isVariable()) {
                varset.add(term);
            } else if (term.isCompound()) {
                final Term[] subterms = term.args();
                for (int i = 0; i < subterms.length; i++)
                    queue.add(subterms[i].dref());
            }
            term = queue.poll();
        }

        Term varlist = CONST(internS("[]"));
        for (final Iterator<Term> iter = varset.iterator(); iter.hasNext();) {
            varlist = CONS(iter.next(), varlist);
        }

        local_aregs.setAreg0((varlist));

        return unify;
    }

}
