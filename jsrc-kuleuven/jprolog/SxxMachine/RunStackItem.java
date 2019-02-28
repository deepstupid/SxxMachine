
package SxxMachine;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class RunStackItem implements Comparator<Class<? extends JpModule>> {

    private final static Logger log = Logger.getLogger(RunStackItem.class);

    private Term pendinggoals;
    private Term assumptions;
    private ErrorStatus status;

    private final ArrayDeque<UnTrailOperation> trailStack;
    private final Term areg[] = new Term[32];

    private int cutb;
    private final ArrayDeque<JpChoicePointStackEntry> choicePointStack;
    private final Map<Class<? extends JpModule>, ModuleRunStackInfo> moduleInfo;
    private final RunningPrologMachine mach;

    RunStackItem(RunningPrologMachine machine) {
        if (machine == null)
            throw new NullPointerException();
        mach = machine;
        setPendinggoals(Prolog.Nil);
        setAssumptions(Prolog.Nil);
        status = ErrorStatus.NONE;
        cutb = 0;
        trailStack = new ArrayDeque<UnTrailOperation>(500);
        choicePointStack = new ArrayDeque<JpChoicePointStackEntry>(100);
        moduleInfo = new TreeMap<Class<? extends JpModule>, ModuleRunStackInfo>(this);
    }

    public RunningPrologMachine getMachine() {
        return mach;
    }

    public ModuleRunStackInfo getModuleInfo(Class<? extends JpModule> c) {
        ModuleRunStackInfo info = moduleInfo.get(c);
        if (info == null) {
            info = new ModuleRunStackInfo();
            moduleInfo.put(c, info);
        }
        return info;
    }

    public final int getCurrentChoice() {
        return choicePointStack.size() - 1;
    }

    public Term[] getAreg() {
        return areg;
    }

    public void setExceptionState(ErrorStatus status) {
        if (status == null)
            throw new NullPointerException();
        this.status = status;
    }

    public ErrorStatus getExceptionState() {
        return status;
    }

    public Term getAssumptions() {
        return assumptions;
    }

    public final void setAssumptions(Term assumptions) {
        if (assumptions == null)
            throw new NullPointerException();
        this.assumptions = assumptions;
    }

    public Term getPendinggoals() {
        return pendinggoals;
    }

    public final void setPendinggoals(Term pendinggoals) {
        if (pendinggoals == null)
            throw new NullPointerException();
        this.pendinggoals = pendinggoals;
    }

    void unTrail(int targetSize) {
        while (trailStack.size() > targetSize) {
            trailStack.pollLast().unTrailSelf();
        }
    }

    public int getTrailSize() {
        return trailStack.size();
    }

    public void trailEntry(UnTrailOperation po) {
        if (po == null)
            throw new NullPointerException();
        trailStack.add(po);
    }

    protected JpChoicePointStackEntry getCurrentStackPoint() {
        return choicePointStack.getLast();
    }

    public void removeChoice() {
        choicePointStack.removeLast();
    }

    void restoreArguments() {
        final JpChoicePointStackEntry cp = getCurrentStackPoint();
        final Term[] args = cp.getArguments();
        for (int i = 0; i < args.length; i++) {
            areg[i] = args[i];
        }
    }

    public int getCUTB() {
        return cutb;
    }

    public void updateCUTB(int i) {
        if (i < 0)
            throw new IllegalArgumentException("Invalid index: " + i);
        cutb = i;
    }

    public long getTimestamp() {
        return mach.getTimestamp();
    }

    public long getCurrentChoiceTimeStamp() {
        return getCurrentStackPoint().getTimeStamp();
    }

    void createChoicePoint(Term... args) {
        choicePointStack.add(new JpChoicePointStackEntry(mach.updateTimestamp(), args));
        getCurrentStackPoint().setTrail(getTrailSize());
    }

    void doCut(int cutTo) {
        if (cutTo > getCurrentChoice())
            throw new IllegalArgumentException();
        int ch = getCurrentChoice();
        log.debug("Cut to " + cutTo + " from " + ch);
        while (ch != cutTo) {
            removeChoice();
            ch--;
        }
    }

    @Override
    public int compare(Class<? extends JpModule> o1, Class<? extends JpModule> o2) {
        return o1.getName().compareTo(o2.getName());
    }

    public boolean cleanAlternatives() {
        if (getCurrentChoice() < 0)
            return false;
        if (!getCurrentStackPoint().hasNextAlternative()) {
            removeChoice();
            return true;
        }
        return false;
    }

    public void unTrail() {
        if (choicePointStack.isEmpty())
            unTrail(0);
        else
            unTrail(getCurrentStackPoint().getTrail());
    }

    public Code processException(JPrologInternalException ex) {
        while (getCurrentChoice() >= 0) {
            try {
                return getCurrentStackPoint().handlePrologException(ex, this);
            } catch (final JPrologInternalException ex2) {
                if (!ex.equals(ex2))
                    throw new JPrologInternalException("Unknown exception detected", ex2);
                /*if (getCurrentChoice() >= 0) {
                  removeChoice();
                    unTrail();
                } */
            }
        }
        throw ex;
    }

    Code getAlternative() {
        if (cleanAlternatives()) {
            return getMachine().Fail0;
        }
        return getCurrentStackPoint().getAlternative();
    }

}