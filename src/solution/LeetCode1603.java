package solution;

public class LeetCode1603 {
    class ParkingSystem {
        private int l, m, s;

        public ParkingSystem(int big, int medium, int small) {
            this.l = big;
            this.m = medium;
            this.s = small;
        }

        public boolean addCar(int carType) {
            switch (carType) {
                case 1:
                    if (this.l > 0) {
                        this.l--;
                        return true;
                    }
                    return false;
                case 2:
                    if (this.m > 0) {
                        this.m--;
                        return true;
                    }
                    return false;
                case 3:
                    if (this.s > 0) {
                        this.s--;
                        return true;
                    }
                    return false;
            }
            return false;
        }
    }
}
