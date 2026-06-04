package Enum;

public enum Difficulty {

        EASY(0.5), MEDIUM(1.0), HARD(1.5);

        double multiplier;


        Difficulty(double multiplier) {
            this.multiplier = multiplier;
        }

        public double getMultiplier() {
            return multiplier;
        }


}
