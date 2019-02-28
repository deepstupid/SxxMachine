
package SxxMachine;

import static SxxMachine.pterm.TermData.CONST;
import static SxxMachine.pterm.TermData.Integer;
import static SxxMachine.pterm.TermData.S;

import SxxMachine.pterm.StructureTerm;

public class pred_name_2 extends Code {

    @Override
    public int arity() {
        return 2;
    }

    @Override
    public Code exec(PrologMachine mach) {
        final Term local_aregs[] = mach.getAreg();
        final Term atom = local_aregs[0].dref();
        final Term list = local_aregs[1].dref();
        final Term continuation = local_aregs[2];
        local_aregs[0] = local_aregs[1] = local_aregs[2] = null;
        if (atom.isVariable()) {
            if (!(list.isCons() || list.isNil()))
                return mach.Fail0;
            final String st = buildString(list);
            if (!atom.unify(CONST(st)))
                return mach.Fail0;
        } else {
            //van atom naar een lijst gaan, dat unify met list
            if (atom .isCompound()) {
                if (((StructureTerm) atom).arity() != 0)
                    return mach.Fail0;
            }
            final Term l = buildList(atom.toJpString());
            if (!list.unify(l))
                return mach.Fail0;
        }
        local_aregs[0] = continuation;
        return mach.Call1;
    }

    private Term buildList(String st) {
        if (st.length() == 0)
            return CONST("[]");
        return S(".", Integer(st.charAt(0)), buildList(st.substring(1)));
    }

    private String buildString(Term list) {
        final StringBuilder b = new StringBuilder();
        list = list.dref();
        while (!list.isNil()) {
            if (list .isCompound()) {
                final AFunct f = (AFunct) list;
                final Term ch = f.getPlainArg(0).dref();
                if (!(ch instanceof NumberTerm))
                    return null;
                b.append((char) ((NumberTerm) ch).longValue());
                list = f.getPlainArg(1).dref();
            }
        }
        return b.toString();
    }

}