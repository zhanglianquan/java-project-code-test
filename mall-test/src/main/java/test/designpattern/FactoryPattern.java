package test.designpattern;

/**
 * @Author zhanglianquan
 * @Description  工厂模式
 * @Date 2020/1/19
 **/
public class FactoryPattern {
    /**
     * @ Product.java
     *   抽象产品
     */
    public interface Product {
        //产品介绍
        public void intro();
    }

    /**
     * @ ProductA.java
     * 具体产品A
     */
    public class ProductA implements Product {
        @Override
        public void intro() {
            System.out.println("饮料A");
        }
    }

    /**
     * @ ProductB.java
     * 具体产品B
     */
    public class ProductB implements Product {
        @Override
        public void intro() {
            System.out.println("饮料B");
        }
    }

    public interface Factory{
        public Product createProduct();
    }

    public class ProductAFactory implements Factory {
        @Override
        public Product createProduct() {
            return new ProductA();
        }
    }

    public class ProductBFactory implements Factory {
        @Override
        public Product createProduct() {
            return new ProductB();
        }
    }

    public  void testFactoryPattern(){
        Factory productAFactory = new ProductAFactory();
        Product productA = productAFactory.createProduct();
        productA.intro();
    }
}
