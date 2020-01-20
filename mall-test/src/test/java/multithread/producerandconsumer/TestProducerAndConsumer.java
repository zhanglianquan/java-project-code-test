package multithread.producerandconsumer;

import src.multithread.producerconsumer.program1.ProducerAndCustomer;

/**
 * @Author zhanglianquan
 * @Description
 * @Date 2020/1/20
 **/
public class TestProducerAndConsumer {
    public static void main(String[] args) {
        ProducerAndCustomer producerAndCustomer = new ProducerAndCustomer();
        for (int i = 1; i <= 5; i++) {
            new Thread(producerAndCustomer.new Producer(), "生产者-" + i).start();
            new Thread(producerAndCustomer.new Consumer(), "消费者-" + i).start();
        }
    }

}
