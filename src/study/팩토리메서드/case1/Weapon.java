package study.팩토리메서드.case1;

interface Weapon {
    void use();
}

class Gun implements Weapon {

    @Override
    public void use() {
        System.out.println("총을 쓴다. 탕탕탕!!");
    }
}

class Knife implements Weapon {

    @Override
    public void use() {
        System.out.println("칼을 쓴다. 슈슈슉!!");
    }
}

abstract class Client {
    abstract Weapon weaponFactory();

    public void execute() {
        Weapon weapon = weaponFactory();
        weapon.use();
    }
}

class GunFactory extends Client {

    @Override
    Weapon weaponFactory() {
        return new Gun();
    }
}

class KnifeFactory extends Client {

    @Override
    Weapon weaponFactory() {
        return new Knife();
    }
}

class Main {
    public static void main(String[] args) {
        Client client1 = new GunFactory();
        client1.execute();

        Client client2 = new KnifeFactory();
        client2.execute();
    }
}