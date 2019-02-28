
package SxxMachine;

import SxxMachine.pterm.VariableTerm;

abstract class AbstractVar extends VariableTerm implements UnTrailOperation {

    protected AbstractVar() {
        super();
    }

    @Override
    public Term dref() {
        return this;
    }

    @Override
    public String toStringImpl(int depth) {
        return "_" + Integer.toHexString(termHashCode());
    }

    @Override
    public boolean unify(Term that) {
        if (dref() == this)
            return bind(that);
        return dref().unify(that);
        //return this.deref().bind(that);
    }

    @Override
    public boolean equalsTerm(Term that) {
        if (!(that instanceof AbstractVar)) {
            return false;
        }
        return this == that;
    }

    @Override
    public boolean couldUnify(Term object) {
        return couldUnifyInverse(object);
    }

    @Override
    public boolean couldUnifyInverse(Term object) {
        return true; //een var kan met alles binden
    }

    @Override
    public String fname() {
        return toJpString();
    }

    @Override
    public boolean isVariable() {
        return true;
    }

}