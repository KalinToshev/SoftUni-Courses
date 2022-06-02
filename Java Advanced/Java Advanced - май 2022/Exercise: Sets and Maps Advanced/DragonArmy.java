import java.util.*;

public class DragonArmy {
    static class Dragon {
        int damage;
        int health;
        int armor;

        public Dragon(int damage, int health, int armor) {
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getArmor() {
            return armor;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //default values
        int health = 250;
        int damage = 45;
        int armor = 10;

        Map<String, TreeMap<String, Dragon>> dragons = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            //fill data separated
            String type = data[0];
            String name = data[1];
            String dmg = data[2];
            String hp = data[3];
            String arm = data[4];

            //fill the map
            //check for null
            if (dmg.equals("null")) {
                dmg = String.valueOf(damage);
            }
            if (hp.equals("null")) {
                hp = String.valueOf(health);
            }
            if (arm.equals("null")) {
                arm = String.valueOf(armor);
            }

            //create dragon
            Dragon d = new Dragon(Integer.parseInt(dmg), Integer.parseInt(hp), Integer.parseInt(arm));

            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).putIfAbsent(name, d);
            if (dragons.containsKey(type) && dragons.get(type).containsKey(name)) {
                //replace stats
                dragons.get(type).get(name).setDamage(Integer.parseInt(dmg));
                dragons.get(type).get(name).setHealth(Integer.parseInt(hp));
                dragons.get(type).get(name).setArmor(Integer.parseInt(arm));
            }
        }

        for (Map.Entry<String, TreeMap<String, Dragon>> entry : dragons.entrySet()) {
            //Average stats
            int count = entry.getValue().size();
            double avgDmg = 0.0;
            double avgHp = 0.0;
            double avgArm = 0.0;
            for (Map.Entry<String, Dragon> stringDragonEntry : entry.getValue().entrySet()) {
                avgDmg += stringDragonEntry.getValue().getDamage();
                avgHp += stringDragonEntry.getValue().getHealth();
                avgArm += stringDragonEntry.getValue().getArmor();
            }
            avgDmg /= count;
            avgHp /= count;
            avgArm /= count;

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), avgDmg, avgHp, avgArm);
            for (Map.Entry<String, Dragon> stringDragonEntry : entry.getValue().entrySet()) {
                System.out.println("-" + stringDragonEntry.getKey() + " -> damage: " + stringDragonEntry.getValue().getDamage() + ", health: " + stringDragonEntry.getValue().getHealth() + ", armor: " + stringDragonEntry.getValue().getArmor());
            }
        }
    }
}
