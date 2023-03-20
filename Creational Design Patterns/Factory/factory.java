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
class AnimalFactory{
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
public class Main
{
    public static void main(String args[]){
        AnimalFactory animalFactory=new AnimalFactory();
        Animal animal=animalFactory.getAnimal("lion");
        animal.speak();
    }
}