
package SxxMachine;

import static SxxMachine.pterm.TermData.CONST;
import static SxxMachine.pterm.TermData.Integer;
import static SxxMachine.pterm.TermData.Jv;
import static SxxMachine.pterm.TermData.S;
import static SxxMachine.pterm.TermData.internS;

public class pred_test_3 extends Code {

    public static void main(String args[]) throws JPrologScriptException {

        // this is the application
        // before it can call a Prolog goal, it must make and initialise a
        // machine

        final PrologMachine M = new PrologMachine();
        new AttvarsModule().load(M);
        // any time a new goal is called, the machine has to be "reset"

        M.initAlways();

        // then you can call the goal

        final Term Goal = S(("test"), Jv(M), Jv(M), Jv(M)); // animal(X)
        System.out.println("Running");
        final Term AnswerList = M.solveGoal(Goal);

        // AnswerList is now a list of instances of the Goal
        // you can iterate through it as follows

        Term NextAnswerList, Answer;

        NextAnswerList = AnswerList.dref();
        while (NextAnswerList.isCons()) {
            Answer = (((AFunct) NextAnswerList).getPlainArg(0)).dref();
            // do something with the answer - e.g. print it
            final String s = Answer.toJpString();
            System.out.println(s);
            System.out.flush();

            // get the tail of the next answer list
            NextAnswerList = (((AFunct) NextAnswerList).getPlainArg(1)).dref();
        }
    }

    static Code entry_code;

    static Code cl1 = new pred_test_3_1();

    static Code freeze3cont;

    static String string0 = internS("cut");

    static String conj = internS(",");

    static String unify = internS("unify");

    static String a = internS("a");

    static String b = internS("b");

    static String freeze = internS("freeze");

    static String or = internS("or");

    static String test = internS("test");

    static NumberTerm posint1 = Integer(1);

    static NumberTerm posint2 = Integer(2);

    @Override
    public void init(PredikatenPrologMachine mach) {
        entry_code = this;
        freeze3cont = mach.loadPred("freeze", 2);
    }

    @Override
    public int arity() {
        return 3;
    }

    @Override
    public Code exec(PrologMachine mach) {
        final Term[] machAreg = mach.getAreg();
        final Term aregs[] = { machAreg[0], machAreg[1], machAreg[2], machAreg[3] };
        mach.createChoicePoint(aregs);
        return cl1.exec(mach);
    }
}

class pred_test_3_1 extends pred_test_3 {
    @Override
    public Code exec(PrologMachine mach) {
        mach.removeChoice();
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[3];
        final Term areg2 = local_aregs[2].dref();
        final Term areg1 = local_aregs[1].dref();
        final Term areg0 = local_aregs[0].dref();
        final Term var3 = Jv(mach);
        final Term var2 = Jv(mach);
        final Term var1 = Jv(mach);
        if (!((areg0).unify(var1)))
            return mach.Fail0;
        if (!((areg1).unify(var2)))
            return mach.Fail0;
        if (!((areg2).unify(var3)))
            return mach.Fail0;
        // local_aregs[0] = var1.deref();
        // local_aregs[1] = new Funct(unify, var3.deref(), posint1);

        // local_aregs[2] = new Funct(unify,var1.deref(),new Const(a),continuation);
        // local_aregs[2] = new Funct(unify, var2.deref(),new Const(b), new Funct(unify,
        // new Const(a), var1.deref(), continuation));
        // local_aregs[2] = new Funct(or, new Funct(conj, new Funct(
        // freeze, var2.deref(),
        // new Funct(unify, var3.deref(), posint2)), new Funct(unify,
        // var1.deref(), var2.deref())), new Funct(unify, var2.deref(),
        // new Const(b)), new Funct(unify, new Const(a),
        // var1.deref(), continuation));
        mach.updateCUTB(mach.getCurrentChoice());
        local_aregs[1] = null;
        local_aregs[2] = null;
        local_aregs[3] = null;
        local_aregs[0] = S("put_attr", var1, CONST(a), S("get_attr", var1, var2, S("put_attr", var1, CONST(b), S("get_attr", var1, var3, S("unify", var1, CONST(a), continuation)))));
        return mach.Call1;
        // return freeze3cont;
    }
}
