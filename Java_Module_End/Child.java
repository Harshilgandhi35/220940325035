public class Child extends Parent {
    Child(String fatherName,String MotherName,String grandFatherName, String grandMotherName)
    {
       super(fatherName, MotherName, grandFatherName, grandMotherName);
    }
    public static void main(String[] args) {
        Child c = new Child("Yu","Me","Jk","RB");
    }
}
