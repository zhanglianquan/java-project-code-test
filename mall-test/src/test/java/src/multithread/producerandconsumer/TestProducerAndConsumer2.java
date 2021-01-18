package src.multithread.producerandconsumer;

import src.multithread.producerconsumer.program2.ProducerAndCustomer2;

/**
 * @Author zhanglianquan
 * @Description
 * @Date 2020/1/20
 **/
public class TestProducerAndConsumer2 {
    public static void main(String[] args) {
        ProducerAndCustomer2 producerAndCustomer = new ProducerAndCustomer2();
        for (int i = 1; i <= 5; i++) {
            new Thread(producerAndCustomer.new Producer(), "生产者-" + i).start();
            new Thread(producerAndCustomer.new Consumer(), "消费者-" + i).start();
        }
    }

}
