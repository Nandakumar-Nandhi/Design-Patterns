interface Animal{
    public void speak();
}
class Dog implements Animal{
    @override
    public void speak(){
        System.out.println("Bark bark");
    }
}
class Duck implements Animal{
    @override
    public void speak(){
        System.out.println("Quack Quack");
    }
}
class Lion implements Animal{
    @override
    public void speak(){
        System.out.println("Roar");
    }
}
class Octpus implements Animal{
    @override
    public void speak(){
        System.out.println("Swuak");
    }
}
class Shark implements Animal{
    @override
    public void speak(){
        System.out.println("cannot speak");
    }
}

abstract class AnimalFactory{
    public abstract Animal getAnimal(String animalType);
    public static AnimalFactory getAnimalFactory(String factoryType)
    {
        AnimalFactory animalFactory=null;
        if("sea".equals(factoryType)){
            animalFactory=new SeaAnimalFactory();
        }
        else{
            animalFactory=new LandAnimalFactory();
        }
        return animalFactory;
    }
}
class LandAnimalFactory extends AnimalFactory{
    public Animal getAnimal(String animalType){
        Animal animal=null;
        if("dog".equals(animalType)){
            animal=new Dog();
        }
        else if("duck".equals(animalType)){
            animal=new Duck();
        }
        else if("lion".equals(animalType)){
            animal=new Lion();
        }
        return animal;
    }
}
class SeaAnimalFactory extends AnimalFactory{
    public Animal getAnimal(String animalType){
        Animal animal=null;
        if("octpus".equals(animalType)){
            animal=new Octpus();
        }
        else if("shark".equals(animalType)){
            animal=new Shark();
        }
        return animal;
    }
}
public class Main{
    public static void main(String args[]){
        AnimalFactory animalFactory=AnimalFactory.getAnimalFactory("sea");
        Animal animal=animalFactory.getAnimal("shark");
        animal.speak();
    }
}