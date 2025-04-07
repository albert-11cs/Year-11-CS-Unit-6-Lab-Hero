import java.util.Random;

public class Hero {
    private String name;
    private int hitPoints;

    public Hero(String name) {
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                '}';
    }

    public void attack(Hero opponent) {
        Random random = new Random();
        double chance = random.nextDouble();
        if (chance < 0.5) {
            opponent.hitPoints -= 10;
        } else {
            opponent.hitPoints -= 5;
        }
    }

    public void senzuBean() {
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent) {
        while (this.hitPoints > 0 && opponent.hitPoints > 0) {
            this.attack(opponent);
            if (opponent.hitPoints <= 0) break;
            opponent.attack(this);
        }
    }

    public String fightUntilTheDeath(Hero opponent) {
        fightUntilTheDeathHelper(opponent);
        if (this.hitPoints > 0) {
            return this.name + " wins!";
        } else if (opponent.hitPoints > 0) {
            return opponent.name + " wins!";
        } else {
            return "It's a draw...";
        }
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int[] wins = {0, 0};
        for (int i = 0; i < n; i++) {
            fightUntilTheDeathHelper(opponent);
            if (this.hitPoints > 0) {
                wins[0]++;
            } else if (opponent.hitPoints > 0) {
                wins[1]++;
            }
            this.senzuBean();
            opponent.senzuBean();
        }
        return wins;
    }

    public String nFightsToTheDeath(Hero opponent, int n) {
        int[] result = nFightsToTheDeathHelper(opponent, n);
        return this.name + ": " + result[0] + " wins\n" + opponent.name + ": " + result[1] + " wins";
    }

    public void dramaticFightToTheDeath(Hero opponent) {
        while (this.hitPoints > 0 && opponent.hitPoints > 0) {
            this.attack(opponent);
            System.out.println(this.name + ": " + this.hitPoints + "    " + opponent.name + ": " + opponent.hitPoints);
            if (opponent.hitPoints <= 0) break;
            opponent.attack(this);
            System.out.println(this.name + ": " + this.hitPoints + "    " + opponent.name + ": " + opponent.hitPoints);
        }
        if (this.hitPoints > 0) {
            System.out.println(this.name + " wins!");
        } else if (opponent.hitPoints > 0) {
            System.out.println(opponent.name + " wins!");
        } else {
            System.out.println("It's a draw...");
        }
    }
}