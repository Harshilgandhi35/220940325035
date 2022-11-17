public class Parent extends GrandParent {
    
    String fatherName;
    String MotherName;
   
   
    Parent(String fatherName,String MotherName,String grandFatherName, String grandMotherName)
    {
        super(grandFatherName, grandMotherName);
        this.fatherName = fatherName;
        this.MotherName = MotherName;
        System.out.println("father name is : "+fatherName+" and mother name is : "+MotherName);
    }
     Parent(String grandFatherName, String grandMotherName)
    {
        super(grandFatherName, grandMotherName);
    }

    
}
