
package SxxMachine;

import static SxxMachine.pterm.TermData.CONST;
import static SxxMachine.pterm.TermData.Jv;
import static SxxMachine.pterm.TermData.S;
import static SxxMachine.pterm.TermData.internS;

// Generated java file - release 0.1 - do not edit !
// Copyright August 16, 1996, KUL and CUM
// Authors: Bart Demoen and Paul Tarau

public class pred_ap_3 extends Code {
    static Code entry_code;

    static Code cl1 = new pred_ap_3_1();

    static Code cl2 = new pred_ap_3_2();

    static String string0 = internS("cut");

    static String string1 = internS(".");

    static String string2 = internS("[]");

    static String string3 = internS("ap");

    static String string4 = internS("call");

    @Override
    public void init(PredikatenPrologMachine mach) {
        entry_code = this;
    }

    @Override
    public int arity() {
        return 3;
    }

    @Override
    public Code exec(PrologMachine mach) {
        final Term aregs[] = mach.createAregCopy(4);
        mach.createChoicePoint(aregs);
        return cl1.exec(mach);
    }
}

class pred_ap_3_1 extends pred_ap_3 {
    @Override
    public Code exec(PrologMachine mach) {
        mach.fillAlternative(cl2);
        final TermArray local_aregs = mach.getAreg();
        final Term continuation = mach.getCont(local_aregs, 3);
        final Term areg2 = local_aregs.getTermDRef(2);
        final Term areg1 = local_aregs.getTermDRef(1);
        final Term areg0 = local_aregs.getTermDRef(0);
        final Term var1 = Jv(mach);
        if (!((areg0).unifyJP(CONST(string2))))
            return mach.Fail0;
        if (!((areg1).unifyJP(var1)))
            return mach.Fail0;
        if (!((areg2).unifyJP(var1.dref())))
            return mach.Fail0;
        mach.setCont(local_aregs, 0, continuation);
        mach.updateCUTB();
        mach.setARegENull(local_aregs, 3, 1);
        return mach.getCall1();
    }
}

class pred_ap_3_2 extends pred_ap_3 {
    @Override
    public Code exec(PrologMachine mach) {
        mach.removeChoice();
        final TermArray local_aregs = mach.getAreg();
        final Term continuation = mach.getCont(local_aregs, 3);
        final Term areg2 = local_aregs.getTermDRef(2);
        final Term areg1 = local_aregs.getTermDRef(1);
        final Term areg0 = local_aregs.getTermDRef(0);
        final Term var4 = Jv(mach);
        final Term var3 = Jv(mach);
        final Term var2 = Jv(mach);
        final Term var1 = Jv(mach);
        if (!((areg0).unifyJP(S(string1, var1, var2))))
            return mach.Fail0;
        if (!((areg1).unifyJP(var3)))
            return mach.Fail0;
        if (!((areg2).unifyJP(S(string1, var1.dref(), var4))))
            return mach.Fail0;
        local_aregs.setAreg0((var2.dref()));
        local_aregs.setAreg1((var3.dref()));
        local_aregs.setAreg2((var4.dref()));
        mach.setCont(local_aregs, 3, continuation);
        mach.updateCUTB();
        return entry_code;
    }
}
