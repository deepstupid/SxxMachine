
package SxxMachine;

import static SxxMachine.pterm.TermData.CONST;
import static SxxMachine.pterm.TermData.Integer;
import static SxxMachine.pterm.TermData.internS;

// Generated java file - release 0.1 - do not edit !
// Copyright August 16, 1996, KUL and CUM
// Authors: Bart Demoen and Paul Tarau

public class pred_smgr_1 extends Code {
    static Code entry_code;

    static Code cl1 = new pred_smgr_1_1();

    static Code cl2 = new pred_smgr_1_2();

    static Code cut2cont;

    static String string0 = internS("cut");

    static String string1 = internS("=");

    static String string2 = internS(">");

    static String string3 = internS("call");

    static String string4 = internS("cut");

    static String string5 = internS("smgr");

    static NumberTerm posint1 = Integer(1);

    @Override
    public void init(PredikatenPrologMachine mach) {
        entry_code = this;
    }

    @Override
    public int arity() {
        return 1;
    }

    @Override
    public Code exec(PrologMachine mach) {
        final Term aregs[] = mach.createAregCopy(2);
        mach.createChoicePoint(aregs);
        return cl1.exec(mach);
    }
}

class pred_smgr_1_1 extends pred_smgr_1 {
    @Override
    public Code exec(PrologMachine mach) {
        mach.fillAlternative(cl2);
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[1];
        final Term areg0 = local_aregs[0].dref();
        if (!((areg0).unify(CONST(string2))))
            return mach.Fail0;
        mach.doCut(mach.getCUTB());
        local_aregs[0] = continuation;
        mach.updateCUTB();
        return mach.Call1;
    }
}

class pred_smgr_1_2 extends pred_smgr_1 {
    @Override
    public Code exec(PrologMachine mach) {
        mach.removeChoice();
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[1];
        final Term areg0 = local_aregs[0].dref();
        if (!((areg0).unify(CONST(string1))))
            return mach.Fail0;
        local_aregs[0] = continuation;
        mach.updateCUTB();
        local_aregs[1] = null;
        return mach.Call1;
    }
}