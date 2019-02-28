// Generated java file - release 0.2 - do not edit !
// Copyright August 16, 1996, KUL and CUM
// Authors: Bart Demoen and Paul Tarau

package SxxMachine;

import static SxxMachine.pterm.TermData.CONST;
import static SxxMachine.pterm.TermData.Jv;
import static SxxMachine.pterm.TermData.S;
import static SxxMachine.pterm.TermData.internS;

class pred_printPredExec_7_consts {
    Code entry_code;
    Code writel2cont;
    final static String string0 = internS("cut");
    final static String string1 = internS("printPredExec");
    final static String string2 = internS("writel");
    final static String string3 = internS(".");
    final static String string4 = internS("  @Override");
    final static String string5 = internS("wr");
    final static String string6 = internS("nl");
    final static String string7 = internS("  @SuppressWarnings(\"static-access\")");
    final static String string8 = internS("  public Code exec(PrologMachine mach) {");
    final static String string9 = internS("printPredExecCode");
    final static String string10 = internS("  }");
    final static String string11 = internS("[]");
}

public class pred_printPredExec_7 extends Code {
    private final pred_printPredExec_7_consts consts;

    public pred_printPredExec_7() {
        consts = new pred_printPredExec_7_consts();
        initAlternatives();
    }

    protected pred_printPredExec_7(pred_printPredExec_7 c) {
        consts = c.getConsts();
    }

    protected final pred_printPredExec_7_consts getConsts() {
        return consts;
    }

    private void initAlternatives() {
    }

    @Override
    public void init(PredikatenPrologMachine mach) {
        consts.entry_code = this;
        consts.writel2cont = mach.loadPred("writel", 1);
    }

    @Override
    public int arity() {
        return 7;
    }

    @Override
    @SuppressWarnings("static-access")
    public Code exec(PrologMachine mach) {
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[7];
        final Term areg6 = local_aregs[6].dref();
        final Term areg5 = local_aregs[5].dref();
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
        if (!(areg0.unify(var1)))
            return mach.Fail0;
        if (!(areg1.unify(var2)))
            return mach.Fail0;
        if (!(areg2.unify(var3)))
            return mach.Fail0;
        if (!(areg3.unify(var4)))
            return mach.Fail0;
        if (!(areg4.unify(var5)))
            return mach.Fail0;
        if (!(areg5.unify(var6)))
            return mach.Fail0;
        if (!(areg6.unify(var7)))
            return mach.Fail0;

        local_aregs[0] = S(pred_printPredExec_7_consts.string3, CONST(pred_printPredExec_7_consts.string4), S(pred_printPredExec_7_consts.string3, S(pred_printPredExec_7_consts.string5, CONST(pred_printPredExec_7_consts.string6)), S(pred_printPredExec_7_consts.string3, CONST(pred_printPredExec_7_consts.string7), S(pred_printPredExec_7_consts.string3, S(pred_printPredExec_7_consts.string5, CONST(pred_printPredExec_7_consts.string6)), S(pred_printPredExec_7_consts.string3, CONST(pred_printPredExec_7_consts.string8), S(pred_printPredExec_7_consts.string3, S(pred_printPredExec_7_consts.string5, CONST(pred_printPredExec_7_consts.string6)), S(pred_printPredExec_7_consts.string3, S(pred_printPredExec_7_consts.string9, var1
                .dref(), var2.dref(), var3.dref(), var4.dref(), var5.dref(), var6.dref(), var7
                        .dref()), S(pred_printPredExec_7_consts.string3, CONST(pred_printPredExec_7_consts.string10), S(pred_printPredExec_7_consts.string3, S(pred_printPredExec_7_consts.string5, CONST(pred_printPredExec_7_consts.string6)), CONST(pred_printPredExec_7_consts.string11))))))))));
        local_aregs[1] = continuation;
        mach.updateCUTB();
        local_aregs[7] = local_aregs[6] = local_aregs[5] = local_aregs[4] = local_aregs[3] = local_aregs[2] = null;
        return getConsts().writel2cont;

    }
}