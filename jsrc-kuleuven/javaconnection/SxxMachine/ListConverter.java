
package SxxMachine;

import static SxxMachine.pterm.TermData.CONST;
import static SxxMachine.pterm.TermData.S;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListConverter extends Code {

    private final static Logger log = Logger.getLogger(ListConverter.class);

    @Override
    public int arity() {
        return 2;
    }

    @Override
    public Code exec(PrologMachine mach) {
        final TermArray local_aregs = mach.getAreg();
        final Term prolog = local_aregs.getTermDRef(0);
        final Term java = local_aregs.getTermDRef(1);
        final Term cont = local_aregs.getTermDRef(2);
        if (prolog.isVariable() && java.isVariable()) {
            log.fatal("Both vars need to have a value");
            return mach.Fail0;
        }
        if (!java.isVariable()) {
            if (!(java.isAtomOrObject()))
                return mach.Fail0;
            final Object o = ((Const) java).getValue();
            if (o instanceof Iterable) {
                if (!prolog.unifyJP(convert2prolog((Iterable<?>) o)))
                    return mach.Fail0;
            } else if (o instanceof Iterator) {
                if (!prolog.unifyJP(convert2prolog((Iterator<?>) o)))
                    return mach.Fail0;
            } else
                return mach.Fail0;
        } else {
            try {
                if (!java.unifyJP(CONST(convert2java(prolog))))
                    return mach.Fail0;
            } catch (final JPrologScriptException ex) {
                log.fatal("Could not convert to java", ex);
                return mach.Fail0;
            }
        }
        local_aregs.setAreg1((local_aregs.setAreg2((null))));
        mach.setCont(local_aregs, 0, cont);
        return mach.getCall1();
    }

    public static List<Object> convert2java(Term list) throws JPrologScriptException {
        final List<Object> l = new ArrayList<Object>();
        list = list.dref();
        while (list.isCons()) {
            final AFunct lf = (AFunct) list;
            l.add(PrimaryConversion.convert2java(lf.getPlainArg(0)));
            list = lf.getPlainArg(1).dref();
        }
        if (!list.isNil())
            throw new JPrologScriptException("Not a valid end of a list");
        return l;
    }

    public static <T> Term convert2prolog(Iterable<T> list) {
        final Iterator<T> it = list.iterator();
        return convert2prolog(it);
    }

    public static <T> Term convert2prolog(Iterator<T> it) {
        if (!it.hasNext())
            return Prolog.Nil;
        return S(".", PrimaryConversion.convert2Prolog(it.next()), convert2prolog(it));
    }

}
