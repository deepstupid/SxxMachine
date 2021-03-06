// Generated java file - release 0.2 - do not edit !
// Copyright August 16, 1996, KUL and CUM
// Authors: Bart Demoen and Paul Tarau

package be.kuleuven.jProlog;
import java.util.*;
class pred_animal_1_consts {
   Code entry_code;
     Code write2cont ;
final static String string0 = "cut".intern() ;
final static String string1 = "animal".intern() ;
final static String string2 = "write".intern() ;
final static String string3 = "please type one more animal name: ".intern() ;
final static String string4 = "read".intern() ;
final static String string5 = "elephant".intern() ;
final static String string6 = "call".intern() ;
final static String string7 = "goat".intern() ;
}
public class pred_animal_1 extends Code {
private final pred_animal_1_consts consts;
public pred_animal_1(){
  consts = new pred_animal_1_consts();
  initAlternatives();
}
protected pred_animal_1(pred_animal_1 c){
  consts = c.getConsts();
  ALT = null;
}
protected final pred_animal_1_consts getConsts() { return consts; }
private Alternatives ALT = new Alternatives();
private void initAlternatives() {
  ALT.disable();
ALT.addAlternative(new pred_animal_1_1(this));
ALT.addAlternative(new pred_animal_1_2(this));
ALT.addAlternative(new pred_animal_1_3(this));

}

  public void init(PredikatenPrologMachine mach) {
    consts.entry_code = this;
consts.write2cont = mach.loadPred("write",1) ;
}
  @Override public int arity() { return 1 ; }
  @Override
  @SuppressWarnings("static-access")
  public Code exec(PrologMachine mach) {
     PrologObject aregs[] = mach.createAregCopy(2);
     mach.createChoicePoint(aregs) ;
     Iterator<Code> todo = ALT.getIndexedAlternatives(aregs);
     mach.fillAlternatives(todo);
     return todo.next().exec(mach);

}
}

class pred_animal_1_1 extends pred_animal_1 {
pred_animal_1_1(pred_animal_1 consts){
  super(consts);
}

  @Override
  @SuppressWarnings("static-access")
  protected PrologObject[] getArgs() {
    PrologObject arg0 = new Const(getConsts().string7);
    return new PrologObject[]{arg0};
  }
  @Override
  @SuppressWarnings("static-access")
  public Code exec(PrologMachine mach) {
    PrologObject local_aregs[] = mach.getAreg();
    PrologObject continuation = local_aregs[1] ;
PrologObject areg0 = local_aregs[0].dref() ;
    if (!(areg0.unify(new Const(getConsts().string7)))) return mach.Fail0 ;
local_aregs[0] = continuation ;
    mach.updateCUTB();
local_aregs[1] = null ;
    return mach.Call1;
  }
}

class pred_animal_1_2 extends pred_animal_1 {
pred_animal_1_2(pred_animal_1 consts){
  super(consts);
}

  @Override
  @SuppressWarnings("static-access")
  protected PrologObject[] getArgs() {
    PrologObject arg0 = new Const(getConsts().string5);
    return new PrologObject[]{arg0};
  }
  @Override
  @SuppressWarnings("static-access")
  public Code exec(PrologMachine mach) {
    PrologObject local_aregs[] = mach.getAreg();
    PrologObject continuation = local_aregs[1] ;
PrologObject areg0 = local_aregs[0].dref() ;
    if (!(areg0.unify(new Const(getConsts().string5)))) return mach.Fail0 ;
local_aregs[0] = continuation ;
    mach.updateCUTB();
local_aregs[1] = null ;
    return mach.Call1;
  }
}

class pred_animal_1_3 extends pred_animal_1 {
pred_animal_1_3(pred_animal_1 consts){
  super(consts);
}

  @Override
  @SuppressWarnings("static-access")
  protected PrologObject[] getArgs() {
    
    PrologObject var1 = new DummyVar();
    PrologObject arg0 = var1;
    return new PrologObject[]{arg0};
  }
  @Override
  @SuppressWarnings("static-access")
  public Code exec(PrologMachine mach) {
    PrologObject local_aregs[] = mach.getAreg();
    PrologObject continuation = local_aregs[1] ;
PrologObject areg0 = local_aregs[0].dref() ;
PrologObject var1 = new Var(mach) ;
    if (!(areg0.unify(var1.dref()))) return mach.Fail0 ;
local_aregs[0] = new Const(getConsts().string3) ;
local_aregs[1] = new StructureTerm(getConsts().string4,var1.dref(),continuation) ;
    mach.updateCUTB();
    return getConsts().write2cont;
  }
}

