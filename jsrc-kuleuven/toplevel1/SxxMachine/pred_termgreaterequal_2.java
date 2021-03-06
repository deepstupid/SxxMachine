
package SxxMachine;

// Jv;
import static SxxMachine.pterm.TermData.*;

// Generated java file - release 0.1 - do not edit !
// Copyright August 16, 1996, KUL and CUM
// Authors: Bart Demoen and Paul Tarau

public class pred_termgreaterequal_2 extends Code {
    static Code entry_code;

    static Code cl1 = new pred_termgreaterequal_2_1();

    static Code compare4cont;

    static String string0 = internS("cut");

    static String string1 = internS("compare");

    static String string2 = internS("smgr");

    static String string3 = internS("termgreaterequal");

    @Override
    public void init(PredikatenPrologMachine mach) {
        entry_code = this;
        compare4cont = mach.loadPred("compare", 3);
    }

    @Override
    public int arity() {
        return 2;
    }

    @Override
    public Code exec(PrologMachine mach) {
        final Term aregs[] = mach.createAregCopy(3);
        mach.createChoicePoint(aregs);
        return cl1.exec(mach);
    }
}

class pred_termgreaterequal_2_1 extends pred_termgreaterequal_2 {
    @Override
    public Code exec(PrologMachine mach) {
        mach.removeChoice();
        final TermArray local_aregs = mach.getAreg();
        final Term continuation = mach.getCont(local_aregs, 2);
        final Term areg1 = local_aregs.getTermDRef(1);
        final Term areg0 = local_aregs.getTermDRef(0);
        final Term var3 = Jv(mach);
        final Term var2 = Jv(mach);
        final Term var1 = Jv(mach);
        if (!((areg0).unifyJP(var1)))
            return mach.Fail0;
        if (!((areg1).unifyJP(var2)))
            return mach.Fail0;
        local_aregs.setAreg0((var3));
        local_aregs.setAreg1((var1.dref()));
        local_aregs.setAreg2((var2.dref()));
        mach.setCont(local_aregs, 3, S(string2, var3.dref(), continuation));
        mach.updateCUTB();
        return compare4cont;
    }
}
