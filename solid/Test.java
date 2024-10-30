package solid;

public interface Test {
    default void feature1(){}
    default void feature2(){}
}

class Test1 implements Test{
    @Override
    public void feature1() {
        //
    }


}
class Test2 implements Test{

    @Override
    public void feature2() {
    //
    }
}
