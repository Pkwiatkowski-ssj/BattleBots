import java.util.Random;

class BattleBot {
    private String name;
    private int health;
    private int attackPower;
    private Random random;

    public BattleBot(String name) {
        this.name = name;
        this.health = 100;
        this.random = new Random();
        this.attackPower = random.nextInt(10) + 5;
    }

    public void powerUp() {
        int heal = random.nextInt(10) + 5;
        this.health += heal;
        System.out.println(name + " powers up and regains " + heal + " HP!");
    }

    public void attack(BattleBot opponent) {
        int damage = random.nextInt(attackPower) + 1;
        if (random.nextInt(5) == 0) {
            damage *= 2;
            System.out.println("Critical Hit!");
        }

        opponent.health -= damage;
        System.out.println(name + " attacks " + opponent.name + " for " + damage + " damage!");

        if (opponent.health <= 0) {
            System.out.println(opponent.name + " has been defeated!");
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }
}

public class BattleBots {
    public static void main(String[] args) {
        Random random = new Random();
        
        // ✅ Declare bots before using them
        BattleBot bot1 = new BattleBot("Kilo");
        BattleBot bot2 = new BattleBot("Goku");

        // ✅ Call powerUp AFTER bots are created
        bot1.powerUp();
        bot2.powerUp();

        System.out.println("\n Battle Start: " + bot1.getName() + " vs. " + bot2.getName() + "\n");

        while (bot1.isAlive() && bot2.isAlive()) {
            bot1.attack(bot2);
            if (bot2.isAlive() && random.nextInt(4) == 0) {
                bot2.powerUp();  // ✅ Fixed powerUp method call
            }

            if (!bot2.isAlive()) break;

            bot2.attack(bot1);
            if (bot1.isAlive() && random.nextInt(4) == 0) {
                bot1.powerUp();  // ✅ Fixed powerUp method call
            }
        }
        
        System.out.println("\n Battle Over");
    }
}
