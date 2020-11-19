package cn.monitor4all.miaoshaweb.receiver;

import cn.monitor4all.miaoshaservice.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
@RabbitListener(queues = "delCache")
public class DelCacheReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(DelCacheReceiver.class);

    @Resource
    private StockService stockService;

    @RabbitHandler
    public void process(String message) {
        LOGGER.info("DelCacheReceiver收到消息: " + message);
        LOGGER.info("DelCacheReceiver开始删除缓存: " + message);
        stockService.delStockCountCache(Integer.parseInt(message));
    }
}
