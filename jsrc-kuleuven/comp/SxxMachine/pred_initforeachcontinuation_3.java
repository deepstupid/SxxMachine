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

class pred_initforeachcontinuation_3_consts {
    Code entry_code;
    Code is3cont;
    Code cut2cont;
    final static String string0 = internS("cut");
    final static String string1 = internS("initforeachcontinuation");
    final static String string2 = internS(".");
    final static String string3 = internS("/");
    final static String string4 = internS("is");
    final static String string5 = internS("-");
    final static String string6 = internS("changeIllegalTerms");
    final static String string7 = internS("writel");
    final static String string8 = internS("consts.");
    final static String string9 = internS("cont = mach.loadPred(\"");
    final static String string10 = internS("\",");
    final static String string11 = internS(") ;");
    final static String string12 = internS("wr");
    final static String string13 = internS("nl");
    final static String string14 = internS("[]");
    final static String string15 = internS("cut");
    final static String string16 = internS("cut");
    final static String string17 = internS("call");
    final static NumberTerm posint1 = Integer(1);
    final static NumberTerm posint2 = Integer(2);
}

public class pred_initforeachcontinuation_3 extends Code {
    private final pred_initforeachcontinuation_3_consts consts;

    public pred_initforeachcontinuation_3() {
        consts = new pred_initforeachcontinuation_3_consts();
        initAlternatives();
    }

    protected pred_initforeachcontinuation_3(pred_initforeachcontinuation_3 c) {
        consts = c.getConsts();
        ALT = null;
    }

    protected final pred_initforeachcontinuation_3_consts getConsts() {
        return consts;
    }

    private Alternatives ALT = new Alternatives();

    private void initAlternatives() {
        ALT.addAlternative(new pred_initforeachcontinuation_3_1(this));
        ALT.addAlternative(new pred_initforeachcontinuation_3_2(this));
        ALT.addAlternative(new pred_initforeachcontinuation_3_3(this));
        ALT.addAlternative(new pred_initforeachcontinuation_3_4(this));
        ALT.addAlternative(new pred_initforeachcontinuation_3_5(this));
        ALT.addAlternative(new pred_initforeachcontinuation_3_6(this));

    }

    @Override
    public void init(PredikatenPrologMachine mach) {
        consts.entry_code = this;
        consts.is3cont = mach.loadPred("is", 2);
    }

    @Override
    public int arity() {
        return 3;
    }

    @Override
    @SuppressWarnings("static-access")
    public Code exec(PrologMachine mach) {
        final Term aregs[] = mach.createAregCopy(4);
        mach.createChoicePoint(aregs);
        final Iterator<Code> todo = ALT.getIndexedAlternatives(aregs);
        mach.fillAlternatives(todo);
        return todo.next().exec(mach);

    }
}

class pred_initforeachcontinuation_3_1 extends pred_initforeachcontinuation_3 {
    pred_initforeachcontinuation_3_1(pred_initforeachcontinuation_3 consts) {
        super(consts);
    }

    @Override
    @SuppressWarnings("static-access")
    protected Term[] getArgs() {

        final Term var2 = new DummyVar();

        final Term var1 = new DummyVar();

        final Term arg0 = CONST(pred_initforeachcontinuation_3_consts.string14);
        final Term arg1 = var1;
        final Term arg2 = var2;
        return new Term[] { arg0, arg1, arg2 };
    }

    @Override
    @SuppressWarnings("static-access")
    public Code exec(PrologMachine mach) {
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[3];
        final Term areg2 = local_aregs[2].dref();
        final Term areg1 = local_aregs[1].dref();
        final Term areg0 = local_aregs[0].dref();
        final Term var2 = Jv(mach);
        final Term var1 = Jv(mach);

        if (!(areg0.unify(CONST(pred_initforeachcontinuation_3_consts.string14))))
            return mach.Fail0;
        if (!(areg1.unify(var1.dref())))
            return mach.Fail0;
        if (!(areg2.unify(var2.dref())))
            return mach.Fail0;
        local_aregs[0] = continuation;
        mach.updateCUTB();
        local_aregs[3] = local_aregs[2] = local_aregs[1] = null;
        return mach.Call1;
    }
}

class pred_initforeachcontinuation_3_2 extends pred_initforeachcontinuation_3 {
    pred_initforeachcontinuation_3_2(pred_initforeachcontinuation_3 consts) {
        super(consts);
    }

    @Override
    @SuppressWarnings("static-access")
    protected Term[] getArgs() {

        final Term var3 = new DummyVar();

        final Term var2 = new DummyVar();

        final Term var1 = new DummyVar();

        final Term arg0 = S(pred_initforeachcontinuation_3_consts.string2, S(pred_initforeachcontinuation_3_consts.string3, var1, var2), var3);
        final Term arg1 = var1.dref();
        final Term arg2 = var2.dref();
        return new Term[] { arg0, arg1, arg2 };
    }

    @Override
    @SuppressWarnings("static-access")
    public Code exec(PrologMachine mach) {
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[3];
        final Term areg2 = local_aregs[2].dref();
        final Term areg1 = local_aregs[1].dref();
        final Term areg0 = local_aregs[0].dref();
        final Term var3 = Jv(mach);
        final Term var2 = Jv(mach);
        final Term var1 = Jv(mach);

        if (!(areg0
                .unify(S(pred_initforeachcontinuation_3_consts.string2, S(pred_initforeachcontinuation_3_consts.string3, var1
                        .dref(), var2.dref()), var3.dref()))))
            return mach.Fail0;
        if (!(areg1.unify(var1.dref())))
            return mach.Fail0;
        if (!(areg2.unify(var2.dref())))
            return mach.Fail0;
        mach.doCut(mach.getCUTB());

        local_aregs[0] = S(pred_initforeachcontinuation_3_consts.string1, var3.dref(), var1.dref(), var2
                .dref(), continuation);
        mach.updateCUTB();
        local_aregs[3] = local_aregs[2] = null;
        return mach.Call1;
    }
}

class pred_initforeachcontinuation_3_3 extends pred_initforeachcontinuation_3 {
    pred_initforeachcontinuation_3_3(pred_initforeachcontinuation_3 consts) {
        super(consts);
    }

    @Override
    @SuppressWarnings("static-access")
    protected Term[] getArgs() {

        final Term var3 = new DummyVar();

        final Term var2 = new DummyVar();

        final Term var1 = new DummyVar();

        final Term arg0 = S(pred_initforeachcontinuation_3_consts.string2, S(pred_initforeachcontinuation_3_consts.string3, CONST(pred_initforeachcontinuation_3_consts.string17), pred_initforeachcontinuation_3_consts.posint1), var1);
        final Term arg1 = var2;
        final Term arg2 = var3;
        return new Term[] { arg0, arg1, arg2 };
    }

    @Override
    @SuppressWarnings("static-access")
    public Code exec(PrologMachine mach) {
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[3];
        final Term areg2 = local_aregs[2].dref();
        final Term areg1 = local_aregs[1].dref();
        final Term areg0 = local_aregs[0].dref();
        final Term var3 = Jv(mach);
        final Term var2 = Jv(mach);
        final Term var1 = Jv(mach);

        if (!(areg0
                .unify(S(pred_initforeachcontinuation_3_consts.string2, S(pred_initforeachcontinuation_3_consts.string3, CONST(pred_initforeachcontinuation_3_consts.string17), pred_initforeachcontinuation_3_consts.posint1), var1
                        .dref()))))
            return mach.Fail0;
        if (!(areg1.unify(var2.dref())))
            return mach.Fail0;
        if (!(areg2.unify(var3.dref())))
            return mach.Fail0;
        mach.doCut(mach.getCUTB());

        local_aregs[0] = S(pred_initforeachcontinuation_3_consts.string1, var1.dref(), var2.dref(), var3
                .dref(), continuation);
        mach.updateCUTB();
        local_aregs[3] = local_aregs[2] = null;
        return mach.Call1;
    }
}

class pred_initforeachcontinuation_3_4 extends pred_initforeachcontinuation_3 {
    pred_initforeachcontinuation_3_4(pred_initforeachcontinuation_3 consts) {
        super(consts);
    }

    @Override
    @SuppressWarnings("static-access")
    protected Term[] getArgs() {

        final Term var3 = new DummyVar();

        final Term var2 = new DummyVar();

        final Term var1 = new DummyVar();

        final Term arg0 = S(pred_initforeachcontinuation_3_consts.string2, S(pred_initforeachcontinuation_3_consts.string3, CONST(pred_initforeachcontinuation_3_consts.string17), pred_initforeachcontinuation_3_consts.posint2), var1);
        final Term arg1 = var2;
        final Term arg2 = var3;
        return new Term[] { arg0, arg1, arg2 };
    }

    @Override
    @SuppressWarnings("static-access")
    public Code exec(PrologMachine mach) {
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[3];
        final Term areg2 = local_aregs[2].dref();
        final Term areg1 = local_aregs[1].dref();
        final Term areg0 = local_aregs[0].dref();
        final Term var3 = Jv(mach);
        final Term var2 = Jv(mach);
        final Term var1 = Jv(mach);

        if (!(areg0
                .unify(S(pred_initforeachcontinuation_3_consts.string2, S(pred_initforeachcontinuation_3_consts.string3, CONST(pred_initforeachcontinuation_3_consts.string17), pred_initforeachcontinuation_3_consts.posint2), var1
                        .dref()))))
            return mach.Fail0;
        if (!(areg1.unify(var2.dref())))
            return mach.Fail0;
        if (!(areg2.unify(var3.dref())))
            return mach.Fail0;
        mach.doCut(mach.getCUTB());

        local_aregs[0] = S(pred_initforeachcontinuation_3_consts.string1, var1.dref(), var2.dref(), var3
                .dref(), continuation);
        mach.updateCUTB();
        local_aregs[3] = local_aregs[2] = null;
        return mach.Call1;
    }
}

class pred_initforeachcontinuation_3_5 extends pred_initforeachcontinuation_3 {
    pred_initforeachcontinuation_3_5(pred_initforeachcontinuation_3 consts) {
        super(consts);
    }

    @Override
    @SuppressWarnings("static-access")
    protected Term[] getArgs() {

        final Term var3 = new DummyVar();

        final Term var2 = new DummyVar();

        final Term var1 = new DummyVar();

        final Term arg0 = S(pred_initforeachcontinuation_3_consts.string2, S(pred_initforeachcontinuation_3_consts.string3, CONST(pred_initforeachcontinuation_3_consts.string0), pred_initforeachcontinuation_3_consts.posint2), var1);
        final Term arg1 = var2;
        final Term arg2 = var3;
        return new Term[] { arg0, arg1, arg2 };
    }

    @Override
    @SuppressWarnings("static-access")
    public Code exec(PrologMachine mach) {
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[3];
        final Term areg2 = local_aregs[2].dref();
        final Term areg1 = local_aregs[1].dref();
        final Term areg0 = local_aregs[0].dref();
        final Term var3 = Jv(mach);
        final Term var2 = Jv(mach);
        final Term var1 = Jv(mach);

        if (!(areg0
                .unify(S(pred_initforeachcontinuation_3_consts.string2, S(pred_initforeachcontinuation_3_consts.string3, CONST(pred_initforeachcontinuation_3_consts.string0), pred_initforeachcontinuation_3_consts.posint2), var1
                        .dref()))))
            return mach.Fail0;
        if (!(areg1.unify(var2.dref())))
            return mach.Fail0;
        if (!(areg2.unify(var3.dref())))
            return mach.Fail0;
        mach.doCut(mach.getCUTB());

        local_aregs[0] = S(pred_initforeachcontinuation_3_consts.string1, var1.dref(), var2.dref(), var3
                .dref(), continuation);
        mach.updateCUTB();
        local_aregs[3] = local_aregs[2] = null;
        return mach.Call1;
    }
}

class pred_initforeachcontinuation_3_6 extends pred_initforeachcontinuation_3 {
    pred_initforeachcontinuation_3_6(pred_initforeachcontinuation_3 consts) {
        super(consts);
    }

    @Override
    @SuppressWarnings("static-access")
    protected Term[] getArgs() {

        final Term var5 = new DummyVar();

        final Term var4 = new DummyVar();

        final Term var3 = new DummyVar();

        final Term var2 = new DummyVar();

        final Term var1 = new DummyVar();

        final Term arg0 = S(pred_initforeachcontinuation_3_consts.string2, S(pred_initforeachcontinuation_3_consts.string3, var1, var2), var3);
        final Term arg1 = var4;
        final Term arg2 = var5;
        return new Term[] { arg0, arg1, arg2 };
    }

    @Override
    @SuppressWarnings("static-access")
    public Code exec(PrologMachine mach) {
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[3];
        final Term areg2 = local_aregs[2].dref();
        final Term areg1 = local_aregs[1].dref();
        final Term areg0 = local_aregs[0].dref();
        final Term var7 = Jv(mach);
        final Term var6 = Jv(mach);
        final Term var5 = Jv(mach);
        final Term var4 = Jv(mach);
        final Term var3 = Jv(mach);
        final Term var2 = Jv(mach);
        final Term var1 = Jv(mach);

        if (!(areg0
                .unify(S(pred_initforeachcontinuation_3_consts.string2, S(pred_initforeachcontinuation_3_consts.string3, var1
                        .dref(), var2.dref()), var3.dref()))))
            return mach.Fail0;
        if (!(areg1.unify(var4.dref())))
            return mach.Fail0;
        if (!(areg2.unify(var5.dref())))
            return mach.Fail0;
        local_aregs[0] = var6;

        local_aregs[1] = S(pred_initforeachcontinuation_3_consts.string5, var2
                .dref(), pred_initforeachcontinuation_3_consts.posint1);

        local_aregs[2] = S(pred_initforeachcontinuation_3_consts.string6, var7, var1
                .dref(), S(pred_initforeachcontinuation_3_consts.string7, S(pred_initforeachcontinuation_3_consts.string2, CONST(pred_initforeachcontinuation_3_consts.string8), S(pred_initforeachcontinuation_3_consts.string2, var1
                        .dref(), S(pred_initforeachcontinuation_3_consts.string2, var2
                                .dref(), S(pred_initforeachcontinuation_3_consts.string2, CONST(pred_initforeachcontinuation_3_consts.string9), S(pred_initforeachcontinuation_3_consts.string2, var7
                                        .dref(), S(pred_initforeachcontinuation_3_consts.string2, CONST(pred_initforeachcontinuation_3_consts.string10), S(pred_initforeachcontinuation_3_consts.string2, var6
                                                .dref(), S(pred_initforeachcontinuation_3_consts.string2, CONST(pred_initforeachcontinuation_3_consts.string11), S(pred_initforeachcontinuation_3_consts.string2, S(pred_initforeachcontinuation_3_consts.string12, CONST(pred_initforeachcontinuation_3_consts.string13)), CONST(pred_initforeachcontinuation_3_consts.string14)))))))))), S(pred_initforeachcontinuation_3_consts.string1, var3
                                                        .dref(), var4.dref(), var5.dref(), continuation)));
        mach.updateCUTB();
        local_aregs[3] = null;
        return getConsts().is3cont;
    }
}
