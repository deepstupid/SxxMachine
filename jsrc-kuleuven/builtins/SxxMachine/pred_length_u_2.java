
// Generated java file - release 0.1 - do not edit !
// Copyright August 16, 1996, KUL and CUM
// Authors: Bart Demoen and Paul Tarau

package SxxMachine;

import static SxxMachine.pterm.TermData.CONST;
import static SxxMachine.pterm.TermData.Integer;
import static SxxMachine.pterm.TermData.Jv;
import static SxxMachine.pterm.TermData.S;
import static SxxMachine.pterm.TermData.internS;

public class pred_length_u_2 extends Code {
    static Code entry_code;
    static Code cl1 = new pred_length_u_2_1();
    static Code cl2 = new pred_length_u_2_2();
    static String string0 = internS("cut");
    static String string1 = internS(".");
    static String string2 = internS("[]");
    static String string3 = internS("call");
    static String string4 = internS("inc");
    static String string5 = internS("length_u");
    static NumberTerm posint0 = Integer(0);

    @Override
    public void init(PredikatenPrologMachine mach) {
        entry_code = this;
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

class pred_length_u_2_1 extends pred_length_u_2 {
    @Override
    public Code exec(PrologMachine mach) {
        mach.fillAlternative(cl2);
        final TermArray local_aregs = mach.getAreg();
        final Term continuation = mach.getCont(local_aregs, 2);
        final Term areg1 = local_aregs.getTermDRef(1);
        final Term areg0 = local_aregs.getTermDRef(0);
        if (!((areg0).unifyJP(CONST(string2))))
            return mach.Fail0;
        if (!((areg1).unifyJP(posint0)))
            return mach.Fail0;
        mach.setCont(local_aregs, 0, continuation);
        mach.updateCUTB();
        mach.setARegENull(local_aregs, 2, 1);
        return mach.getCall1();
    }
}

class pred_length_u_2_2 extends pred_length_u_2 {
    @Override
    public Code exec(PrologMachine mach) {
        mach.removeChoice();
        final TermArray local_aregs = mach.getAreg();
        final Term continuation = mach.getCont(local_aregs, 2);
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
        local_aregs.setAreg0((var2.dref()));
        local_aregs.setAreg1((var4));
        mach.setCont(local_aregs, 2, S(string4, var3.dref(), var4.dref(), continuation));
        mach.updateCUTB();
        return entry_code;
    }
}
