package solution;

import java.util.HashMap;
import java.util.Map;

public class LeetCode464 {
    public static void main(String[] args) {
        new LeetCode464().canIWin(10, 40);
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        State state = new State(maxChoosableInteger);
        Map<State, Boolean> cache = new HashMap<>();

        for (int i = 1; i <= maxChoosableInteger; i++) {
            state.changeMyState(i, 1);
            if (canIWin(state, maxChoosableInteger, desiredTotal, i, cache)) {
                return true;
            }

            state.changeMyState(i, 0);
        }

        return false;
    }

    private boolean canIWin(State state, int maxChoosableInteger, int desiredTotal, int currentVal, Map<State, Boolean> cache) {
        if (currentVal >= desiredTotal) {
            cache.put(new State(state), true);
            return true;
        }

        if (cache.containsKey(state)) {
            return cache.get(state);
        }

        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (state.getHisChooseState(i) != 1 && state.getMyChooseState(i) != 1) {
                state.changeHisState(i, 1);
                currentVal += i;

                if (currentVal >= desiredTotal) {
                    state.changeHisState(i, 0);
                    cache.put(new State(state), false);
                    return false;
                }

                boolean canWin = false;
                for (int j = 1; j <= maxChoosableInteger; j++) {
                    if (state.getHisChooseState(j) != 1 && state.getMyChooseState(j) != 1) {
                        state.changeMyState(j, 1);
                        currentVal += j;

                        if (canIWin(state, maxChoosableInteger, desiredTotal, currentVal, cache)) {
                            state.changeHisState(i, 0);
                            state.changeMyState(j, 0);
                            canWin = true;
                            currentVal -= j;
                            break;
                        }

                        state.changeMyState(j, 0);
                        currentVal -= j;
                    }
                }

                state.changeHisState(i, 0);
                currentVal -= i;

                if (!canWin) {
                    cache.put(new State(state), false);
                    return false;
                }
            }
        }

        cache.put(new State(state), true);
        return true;
    }

    private class State {
        private int[] choosebyMe;
        private int[] chooseByHim;

        public State(int maxChoosableInteger) {
            choosebyMe = new int[maxChoosableInteger];
            chooseByHim = new int[maxChoosableInteger];
        }

        public State(State state) {
            choosebyMe = new int[state.choosebyMe.length];
            for (int i = 0; i < choosebyMe.length; i++) {
                choosebyMe[i] = state.choosebyMe[i];
            }

            chooseByHim = new int[state.chooseByHim.length];
            for (int i = 0; i < chooseByHim.length; i++) {
                chooseByHim[i] = state.chooseByHim[i];
            }

        }

        public void changeMyState(int index, int used) {
            choosebyMe[index - 1] = used;
        }

        public void changeHisState(int index, int used) {
            chooseByHim[index - 1] = used;
        }

        public int getMyChooseState(int index) {
            return choosebyMe[index - 1];
        }

        public int getHisChooseState(int index) {
            return chooseByHim[index - 1];
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }

            State obj = (State) o;
            if (obj == null) {
                return false;
            }

            if (obj.choosebyMe.length != this.choosebyMe.length || obj.chooseByHim.length != this.chooseByHim.length) {
                return false;
            }

            for (int i = 0; i < this.choosebyMe.length; i++) {
                if (this.choosebyMe[i] != obj.choosebyMe[i]) {
                    return false;
                }
            }

            for (int i = 0; i < this.chooseByHim.length; i++) {
                if (this.chooseByHim[i] != obj.chooseByHim[i]) {
                    return false;
                }
            }

            return true;
        }
    }
}
