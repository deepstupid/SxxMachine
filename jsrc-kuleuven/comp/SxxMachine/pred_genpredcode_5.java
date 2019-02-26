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

class pred_genpredcode_5_consts {
    Code entry_code;
    final static String string0 = internS("cut");
    final static String string1 = internS("genpredcode");
    final static String string2 = internS(".");
    final static String string3 = internS("notlast");
    final static String string4 = internS("inc");
    final static String string5 = internS("genclausecode");
    final static String string6 = internS("[]");
    final static String string7 = internS("call");
    final static NumberTerm posint0 = Integer(0);
}

public class pred_genpredcode_5 extends Code {
    private final pred_genpredcode_5_consts consts;

    public pred_genpredcode_5() {
        consts = new pred_genpredcode_5_consts();
        initAlternatives();
    }

    protected pred_genpredcode_5(pred_genpredcode_5 c) {
        consts = c.getConsts();
        ALT = null;
    }

    protected final pred_genpredcode_5_consts getConsts() {
        return consts;
    }

    private Alternatives ALT = new Alternatives();

    private void initAlternatives() {
        ALT.disable();
        ALT.addAlternative(new pred_genpredcode_5_1(this));
        ALT.addAlternative(new pred_genpredcode_5_2(this));

    }

    @Override
    public void init(PredikatenPrologMachine mach) {
        consts.entry_code = this;
    }

    @Override
    public int arity() {
        return 5;
    }

    @Override
    @SuppressWarnings("static-access")
    public Code exec(PrologMachine mach) {
        final Term aregs[] = mach.createAregCopy(6);
        mach.createChoicePoint(aregs);
        final Iterator<Code> todo = ALT.getIndexedAlternatives(aregs);
        mach.fillAlternatives(todo);
        return todo.next().exec(mach);

    }
}

class pred_genpredcode_5_1 extends pred_genpredcode_5 {
    pred_genpredcode_5_1(pred_genpredcode_5 consts) {
        super(consts);
    }

    @Override
    @SuppressWarnings("static-access")
    protected Term[] getArgs() {

        final Term var3 = new DummyVar();

        final Term var2 = new DummyVar();

        final Term var1 = new DummyVar();

        final Term arg0 = CONST(pred_genpredcode_5_consts.string6);
        final Term arg1 = var1;
        final Term arg2 = var2;

        final Term arg3 = pred_genpredcode_5_consts.posint0;
        final Term arg4 = var3;
        return new Term[] { arg0, arg1, arg2, arg3, arg4 };
    }

    @Override
    @SuppressWarnings("static-access")
    public Code exec(PrologMachine mach) {
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[5];
        final Term areg4 = local_aregs[4].dref();
        final Term areg3 = local_aregs[3].dref();
        final Term areg2 = local_aregs[2].dref();
        final Term areg1 = local_aregs[1].dref();
        final Term areg0 = local_aregs[0].dref();
        final Term var3 = Jv(mach);
        final Term var2 = Jv(mach);
        final Term var1 = Jv(mach);

        if (!(areg0.unify(CONST(pred_genpredcode_5_consts.string6))))
            return mach.Fail0;
        if (!(areg1.unify(var1.dref())))
            return mach.Fail0;
        if (!(areg2.unify(var2.dref())))
            return mach.Fail0;

        if (!(areg3.unify(pred_genpredcode_5_consts.posint0)))
            return mach.Fail0;
        if (!(areg4.unify(var3.dref())))
            return mach.Fail0;
        local_aregs[0] = continuation;
        mach.updateCUTB();
        local_aregs[5] = local_aregs[4] = local_aregs[3] = local_aregs[2] = local_aregs[1] = null;
        return mach.Call1;
    }
}

class pred_genpredcode_5_2 extends pred_genpredcode_5 {
    pred_genpredcode_5_2(pred_genpredcode_5 consts) {
        super(consts);
    }

    @Override
    @SuppressWarnings("static-access")
    protected Term[] getArgs() {

        final Term var6 = new DummyVar();

        final Term var5 = new DummyVar();

        final Term var4 = new DummyVar();

        final Term var3 = new DummyVar();

        final Term var2 = new DummyVar();

        final Term var1 = new DummyVar();

        final Term arg0 = S(pred_genpredcode_5_consts.string2, var1, var2);
        final Term arg1 = var3;
        final Term arg2 = var4;
        final Term arg3 = var5;
        final Term arg4 = var6;
        return new Term[] { arg0, arg1, arg2, arg3, arg4 };
    }

    @Override
    @SuppressWarnings("static-access")
    public Code exec(PrologMachine mach) {
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[5];
        final Term areg4 = local_aregs[4].dref();
        final Term areg3 = local_aregs[3].dref();
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

        if (!(areg0.unify(S(pred_genpredcode_5_consts.string2, var1.dref(), var2.dref()))))
            return mach.Fail0;
        if (!(areg1.unify(var3.dref())))
            return mach.Fail0;
        if (!(areg2.unify(var4.dref())))
            return mach.Fail0;
        if (!(areg3.unify(var5.dref())))
            return mach.Fail0;
        if (!(areg4.unify(var6.dref())))
            return mach.Fail0;
        local_aregs[0] = var2.dref();

        local_aregs[1] = CONST(pred_genpredcode_5_consts.string3);
        local_aregs[2] = var4.dref();
        local_aregs[3] = var7;
        local_aregs[4] = var6.dref();

        local_aregs[5] = S(pred_genpredcode_5_consts.string4, var5.dref(), var7
                .dref(), S(pred_genpredcode_5_consts.string5, var1.dref(), var3.dref(), var4.dref(), var5.dref(), var6
                        .dref(), continuation));
        mach.updateCUTB();
        return getConsts().entry_code;
    }
}
