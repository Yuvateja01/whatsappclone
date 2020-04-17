package teja_123.example.android.mywts;

public class Userobject {

    private String phoneno;
    private String name;

    public Userobject(String name,String phoneno){
        this.name=name;
        this.phoneno=phoneno;
    }

    public String getPhoneno(){
        return phoneno;
    }
    public String getName(){
        return name;
    }
}
