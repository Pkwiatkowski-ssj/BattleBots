import java.util.Random;

public class BattleBots {
    public static void main(String[] args) {

        class BattleBot{
        private String name;
        private int health;
        private int attackPower;
        private Random random;

        public BattleBot(String name){
            this.name = name;
            this.health = 100;
            this.random = new Random();
            this.attackPower = random.nextInt(10) + 5;
        }
        public void powerUp() {
            int heal = random.nextInt(10) + 5;
            this.health += heal;
            System.out.println(name + "powers up and regains" + heal + "HP!");
        }
        public void attack(BattleBot opponent){
            int damage = random.nextInt(attackPower) + 1;
            if (random.nextInt(5) == 0){
                damage *= 2;
                System.out.println("Critical Hit!");
            }

            opponent.health -= damage;
            System.out.println(name + " attacks " + opponent.name + " for " + damage + "damage!");

            if (opponent.health <=0) {
                System.out.println(opponent.name + " has been defeated");
            }
        }
     }
    }
}