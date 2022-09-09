// Lazy Initialization Singleton
/*Lazy initialization approach to implement singleton design pattern solve the
problem of object creation before its being used.
In this approach we will create the instance in the global access method.
*/
/* Lazy initialization approach may not work and may cause issues in multithreading environment.
As we can see there is nock on the getInstance() method,
so if two threads are accessing the getInstance() method at same time
they can get two different objects which will break the singleton concept.*/
/*Singleton design pattern simply states that only single object should be
created and it will be used by all other classes.*/
interface o{
    void run (String user, String password);
}
class services implements o{
    @Override
    public void run(String user, String password) {
        System.out.println(user + password);
    }
}
class Ifactory{
    private Ifactory(){} // noboy can create any object of Type
    private static o instance;
    //they are not going to get a new obj of Services
    public static o createInstance(){
       //this IF condition null once and only one, one object of Type Services
        if (instance == null){
            instance = new services();
        }
        return instance;
    }
    public void ShowMessage(){
        System.out.println("Hello World");
    }
}
class Userr {
    public void exec(){
        o obj = Ifactory.createInstance();
        obj.run("user1 ", "pass1234");
        //System.out.println(obj);
    }
}
public class Singleton {
    public static void main(String[] args) {
//     Ifactory object = (Ifactory) Ifactory.createInstance();
  //   object.ShowMessage();
      o object =  Ifactory.createInstance();
      object.run("omer", "1234");
      object.run("omer", "1234");
      Userr u = new Userr();
      u.exec();
    }
}
