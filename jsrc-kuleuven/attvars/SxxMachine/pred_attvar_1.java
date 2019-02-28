
package SxxMachine;

/**
  * attvar/1 predicate tests whether argument is an attributed variable
  *  @author  toms
  *
  */
public class pred_attvar_1 extends Code {

    @Override
    public int arity() {
        return 1;
    }

    @Override
    public Code exec(PrologMachine mach) {
        final Term local_aregs[] = mach.getAreg();
        final Term continuation = local_aregs[1];
        final Term variable = local_aregs[0].dref();

        local_aregs[1] = null;

        if (variable instanceof AttributedVariable) {
            local_aregs[0] = continuation;
            return (Code)(Object)mach.Call1;
        } else {
            local_aregs[0] = null;
            return mach.Fail0;
        }
    }

}