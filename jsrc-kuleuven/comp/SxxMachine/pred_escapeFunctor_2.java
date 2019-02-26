// Generated java file - release 0.2 - do not edit !
// Copyright August 16, 1996, KUL and CUM
// Authors: Bart Demoen and Paul Tarau

package SxxMachine;

import static SxxMachine.pterm.TermData.CONST;
import static SxxMachine.pterm.TermData.Integer;
import static SxxMachine.pterm.TermData.Jv;
import static SxxMachine.pterm.TermData.S;
import static SxxMachine.pterm.TermData.internS;

import java.util.Iterator;

class pred_escapeFunctor_2_consts {
    Code entry_code;
    Code name_nil_ok3cont;
    Code cut2cont;
    final static String string0 = internS("cut");
    final static String string1 = internS("escapeFunctor");
    final static String string2 = internS("call");
    final static String string3 = internS("name_nil_ok");
    final static String string4 = internS("cut");
    final static String string5 = internS("escapeChars");
    final static String string6 = internS(".");
    final static String string7 = internS("changeChar");
    final static String string8 = internS("[]");
    final static NumberTerm posint1 = Integer(1);
}

public class pred_escapeFunctor_2 extends Code {
    private final pred_escapeFunctor_2_consts consts;

    public pred_escapeFunctor_2() {
        consts = new pred_escapeFunctor_2_consts();
        initAlternatives();
    }

    protected pred_escapeFunctor_2(pred_escapeFunctor_2 c) {
        consts = c.getConsts();
        ALT = null;
    }

    protected final pred_escapeFunctor_2_consts getConsts() {
        return consts;
    }

    private Alternatives ALT = new Alternatives();

    private void initAlternatives() {
        ALT.disable();
        ALT.addAlternative(new pred_escapeFunctor_2_1(this));
        ALT.addAlternative(new pred_escapeFunctor_2_2(this));
        ALT.addAlternative(new pred_escapeFunctor_2_3(this));
        ALT.addAlternative(new pred_escapeFunctor_2_4(this));

    }

    @Override
    public void init(PredikatenPrologMachine mach) {
        consts.entry_code = this;
        consts.name_nil_ok3cont = mach.loadPred("name_nil_ok", 2);
    }

    @Override
    public int arity() {
        return 2;
    }

    @Override
    @SuppressWarnings("static-access")
    public Code exec(PrologMachine mach) {
        final Term aregs[] = mach.createAregCopy(3);
        mach.createChoicePoint(aregs);
        final Iterator<Code> todo = ALT.getIndexedAlternatives(aregs);
        mach.fillAlternatives(todo);
        return todo.next().exec(mach);

    }
}

class pred_escapeFunctor_2_1 extends pred_escapeFunctor_2 {
    pred_escapeFunctor_2_1(pred_escapeFunctor_2 consts) {
        super(consts);
    }

    @Override
    @SuppressWarnings("static-access")
    protected Term[] getArgs() {

        final Term arg0 = CONST(pred_escapeFunctor_2_consts.string8);

        final Term arg1 = CONST(pred_escapeFunctor_2_consts.string8);
        return new Term[] { arg0, arg1 };
    }

    @Override
    @SuppressWarnings("static-access")
    public Code exec(PrologMachine mach) {
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[2];
        final Term areg1 = local_aregs[1].dref();
        final Term areg0 = local_aregs[0].dref();

        if (!(areg0.unify(CONST(pred_escapeFunctor_2_consts.string8))))
            return mach.Fail0;

        if (!(areg1.unify(CONST(pred_escapeFunctor_2_consts.string8))))
            return mach.Fail0;
        mach.doCut(mach.getCUTB());
        local_aregs[0] = continuation;
        mach.updateCUTB();
        local_aregs[2] = null;
        return mach.Call1;
    }
}

class pred_escapeFunctor_2_2 extends pred_escapeFunctor_2 {
    pred_escapeFunctor_2_2(pred_escapeFunctor_2 consts) {
        super(consts);
    }

    @Override
    @SuppressWarnings("static-access")
    protected Term[] getArgs() {

        final Term var4 = new DummyVar();

        final Term var3 = new DummyVar();

        final Term var2 = new DummyVar();

        final Term var1 = new DummyVar();

        final Term arg0 = S(pred_escapeFunctor_2_consts.string6, var1, var2);

        final Term arg1 = S(pred_escapeFunctor_2_consts.string6, var3, var4);
        return new Term[] { arg0, arg1 };
    }

    @Override
    @SuppressWarnings("static-access")
    public Code exec(PrologMachine mach) {
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[2];
        final Term areg1 = local_aregs[1].dref();
        final Term areg0 = local_aregs[0].dref();
        final Term var4 = Jv(mach);
        final Term var3 = Jv(mach);
        final Term var2 = Jv(mach);
        final Term var1 = Jv(mach);

        if (!(areg0.unify(S(pred_escapeFunctor_2_consts.string6, var1.dref(), var2.dref()))))
            return mach.Fail0;

        if (!(areg1.unify(S(pred_escapeFunctor_2_consts.string6, var3.dref(), var4.dref()))))
            return mach.Fail0;
        mach.doCut(mach.getCUTB());

        local_aregs[0] = S(pred_escapeFunctor_2_consts.string7, var1.dref(), var3
                .dref(), S(pred_escapeFunctor_2_consts.string1, var2.dref(), var4.dref(), continuation));
        mach.updateCUTB();
        local_aregs[2] = null;
        return mach.Call1;
    }
}

class pred_escapeFunctor_2_3 extends pred_escapeFunctor_2 {
    pred_escapeFunctor_2_3(pred_escapeFunctor_2 consts) {
        super(consts);
    }

    @Override
    @SuppressWarnings("static-access")
    protected Term[] getArgs() {

        final Term var2 = new DummyVar();

        final Term var1 = new DummyVar();
        final Term arg0 = var1;
        final Term arg1 = var2;
        return new Term[] { arg0, arg1 };
    }

    @Override
    @SuppressWarnings("static-access")
    public Code exec(PrologMachine mach) {
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[2];
        final Term areg1 = local_aregs[1].dref();
        final Term areg0 = local_aregs[0].dref();
        final Term var4 = Jv(mach);
        final Term var3 = Jv(mach);
        final Term var2 = Jv(mach);
        final Term var1 = Jv(mach);
        if (!(areg0.unify(var1.dref())))
            return mach.Fail0;
        if (!(areg1.unify(var2.dref())))
            return mach.Fail0;
        local_aregs[0] = var1.dref();
        local_aregs[1] = var3;

        local_aregs[2] = S(pred_escapeFunctor_2_consts.string0, new HeapChoice(
                mach.getCUTB()), S(pred_escapeFunctor_2_consts.string5, var3
                        .dref(), var4, S(pred_escapeFunctor_2_consts.string3, var2.dref(), var4.dref(), continuation)));
        mach.updateCUTB();
        return getConsts().name_nil_ok3cont;
    }
}

class pred_escapeFunctor_2_4 extends pred_escapeFunctor_2 {
    pred_escapeFunctor_2_4(pred_escapeFunctor_2 consts) {
        super(consts);
    }

    @Override
    @SuppressWarnings("static-access")
    protected Term[] getArgs() {

        final Term var1 = new DummyVar();
        final Term arg0 = var1;
        final Term arg1 = var1.dref();
        return new Term[] { arg0, arg1 };
    }

    @Override
    @SuppressWarnings("static-access")
    public Code exec(PrologMachine mach) {
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[2];
        final Term areg1 = local_aregs[1].dref();
        final Term areg0 = local_aregs[0].dref();
        final Term var1 = Jv(mach);
        if (!(areg0.unify(var1.dref())))
            return mach.Fail0;
        if (!(areg1.unify(var1.dref())))
            return mach.Fail0;
        local_aregs[0] = continuation;
        mach.updateCUTB();
        local_aregs[2] = local_aregs[1] = null;
        return mach.Call1;
    }
}
