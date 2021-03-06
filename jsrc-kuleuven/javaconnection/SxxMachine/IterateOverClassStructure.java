
package SxxMachine;

import static SxxMachine.pterm.TermData.CONST;
import static SxxMachine.pterm.TermData.S;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("rawtypes")
public class IterateOverClassStructure extends Code {

    final static String PREDNAME = "jp_javaStructureIterator";

    private final static IterateOverClassStructure2 next = new IterateOverClassStructure2();

    @Override
    public final int arity() {
        return 2;
    }

    @Override
    public final Code exec(PrologMachine mach) {
        initMach(mach);
        final TermArray local_aregs = mach.getAreg();
        final Term object = local_aregs.getTermDRef(0);
        final Term classType = local_aregs.getTermDRef(1);
        Term cont = local_aregs.getPlainArg(2);
        if (!classType.isVariable())
            return mach.Fail0;
        if (!(object.isAtomOrObject()))
            return mach.Fail0;
        final Object c = ((Const) object).getValue();
        if (!(c instanceof Class))
            return mach.Fail0;
        cont = doAction((Class) c, classType, cont);
        if (cont == null)
            return mach.Fail0;
        local_aregs.setAreg1((local_aregs.setAreg2((null))));
        mach.setCont(local_aregs, 0, cont);
        mach.updateCUTB();
        return mach.getCall1();
    }

    protected void initMach(PrologMachine mach) {
        final Term[] trace = mach.createAregCopy(3);
        mach.createChoicePoint(trace);
        mach.fillAlternative(next);
    }

    protected Term doAction(Class c, Term v, Term cont) {
        v.unifyJP(CONST(c));
        return cont;
    }

}

@SuppressWarnings("rawtypes")
class IterateOverClassStructure2 extends IterateOverClassStructure {

    private final static IterateOverClassStructure3 next = new IterateOverClassStructure3();

    @Override
    protected Term doAction(Class c, Term v, Term cont) {
        //Over classen verder gaan
        if (c.getSuperclass() == null)
            return null;
        return S(PREDNAME, CONST(c.getSuperclass()), v, cont);
    }

    @Override
    protected void initMach(PrologMachine mach) {
        mach.fillAlternative(next);
    }

}

@SuppressWarnings("rawtypes")
class IterateOverClassStructure3 extends IterateOverClassStructure {

    @Override
    protected Term doAction(Class c, Term v, Term cont) {
        final Class[] interfaces = c.getInterfaces();
        if (interfaces == null || interfaces.length == 0)
            return null;
        final List<Class> a = new ArrayList<Class>();
        Collections.addAll(a, interfaces);
        return S(InterfaceIterator.PREDNAME, CONST(a.iterator()), v, cont);
    }

    @Override
    protected void initMach(PrologMachine mach) {
        mach.removeChoice();
    }

}

@SuppressWarnings("rawtypes")
class InterfaceIterator extends Code {

    final static String PREDNAME = "jp_interfaceIterator";

    @Override
    public int arity() {
        return 2;
    }

    @SuppressWarnings({ "unchecked" })
    @Override
    public Code exec(PrologMachine mach) {
        final TermArray local_aregs = mach.getAreg();

        final Term object = local_aregs.getTermDRef(0);
        final Term classType = local_aregs.getTermDRef(1);
        final Term cont = local_aregs.getPlainArg(2);
        if (!classType.isVariable())
            return mach.Fail0;
        if (!(object.isAtomOrObject()))
            return mach.Fail0;
        final Object c = ((Const) object).getValue();
        if (!(c instanceof Iterator))
            return mach.Fail0;
        final Iterator<Class> it = (Iterator<Class>) c;
        if (!it.hasNext()) {
            mach.removeChoice();
            return mach.Fail0;
        }
        final Term[] trace = { local_aregs.getPlainArg(0), local_aregs.getPlainArg(1), local_aregs.getPlainArg(2) };
        mach.createChoicePoint(trace);
        mach.fillAlternative(this);
        if (!classType.unifyJP(CONST(it.next())))
            return mach.Fail0;
        mach.doCut(mach.getCUTB());
        local_aregs.setAreg1((local_aregs.setAreg2((null))));
        mach.setCont(local_aregs, 0, cont);
        mach.updateCUTB();
        return mach.getCall1();
    }

}
