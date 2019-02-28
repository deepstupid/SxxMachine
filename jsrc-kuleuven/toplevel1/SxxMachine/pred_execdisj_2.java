
package SxxMachine;

import static SxxMachine.pterm.TermData.Integer;
import static SxxMachine.pterm.TermData.Jv;
import static SxxMachine.pterm.TermData.S;
import static SxxMachine.pterm.TermData.internS;

// Generated java file - release 0.1 - do not edit !
// Copyright August 16, 1996, KUL and CUM
// Authors: Bart Demoen and Paul Tarau

public class pred_execdisj_2 extends Code {
    static Code entry_code;

    static Code cl1 = new pred_execdisj_2_1();

    static Code cl2 = new pred_execdisj_2_2();

    static Code cl3 = new pred_execdisj_2_3();

    static Code cl4 = new pred_execdisj_2_4();

    static Code cut2cont;

    static Code exec2cont;

    static String string0 = internS("cut");

    static String string1 = internS("->");

    static String string2 = internS("cut");

    static String string3 = internS("exec");

    static String string4 = internS("execdisj");

    static NumberTerm posint1 = Integer(1);

    @Override
    public void init(PredikatenPrologMachine mach) {
        entry_code = this;
        exec2cont = mach.loadPred("exec", 1);
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

class pred_execdisj_2_1 extends pred_execdisj_2 {
    @Override
    public Code exec(PrologMachine mach) {
        mach.fillAlternative(cl2);
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[2];
        final Term areg1 = local_aregs[1].dref();
        final Term areg0 = local_aregs[0].dref();
        final Term var3 = Jv(mach);
        final Term var2 = Jv(mach);
        final Term var1 = Jv(mach);
        if (!((areg0).unify(S(string1, var1, var2))))
            return mach.Fail0;
        if (!((areg1).unify(var3)))
            return mach.Fail0;
        local_aregs[0] = var1.dref();
        local_aregs[1] = S(string0, new HeapChoice(mach.getCUTB()), S(string3, var2.dref(), continuation));
        mach.updateCUTB();
        local_aregs[2] = null;
        return exec2cont;
    }
}

class pred_execdisj_2_2 extends pred_execdisj_2 {
    @Override
    public Code exec(PrologMachine mach) {
        mach.fillAlternative(cl3);
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[2];
        final Term areg1 = local_aregs[1].dref();
        final Term areg0 = local_aregs[0].dref();
        final Term var3 = Jv(mach);
        final Term var2 = Jv(mach);
        final Term var1 = Jv(mach);
        if (!((areg0).unify(S(string1, var1, var2))))
            return mach.Fail0;
        if (!((areg1).unify(var3)))
            return mach.Fail0;
        mach.doCut(mach.getCUTB());
        local_aregs[0] = S(string3, var3.dref(), continuation);
        mach.updateCUTB();
        local_aregs[2] = null;
        return mach.Call1;
    }
}

class pred_execdisj_2_3 extends pred_execdisj_2 {
    @Override
    public Code exec(PrologMachine mach) {
        mach.fillAlternative(cl4);
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[2];
        final Term areg1 = local_aregs[1].dref();
        final Term areg0 = local_aregs[0].dref();
        final Term var2 = Jv(mach);
        final Term var1 = Jv(mach);
        if (!((areg0).unify(var1)))
            return mach.Fail0;
        if (!((areg1).unify(var2)))
            return mach.Fail0;
        local_aregs[0] = var1.dref();
        local_aregs[1] = continuation;
        mach.updateCUTB();
        local_aregs[2] = null;
        return exec2cont;
    }
}

class pred_execdisj_2_4 extends pred_execdisj_2 {
    @Override
    public Code exec(PrologMachine mach) {
        mach.removeChoice();
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[2];
        final Term areg1 = local_aregs[1].dref();
        final Term areg0 = local_aregs[0].dref();
        final Term var2 = Jv(mach);
        final Term var1 = Jv(mach);
        if (!((areg0).unify(var1)))
            return mach.Fail0;
        if (!((areg1).unify(var2)))
            return mach.Fail0;
        local_aregs[0] = var2.dref();
        local_aregs[1] = continuation;
        mach.updateCUTB();
        local_aregs[2] = null;
        return exec2cont;
    }
}