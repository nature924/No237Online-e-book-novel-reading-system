package zl.readCloud;

import zl.readCloud.task.UpdateBookTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhangLei
 * @Description:
 */
public class Application {

    public Application() {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(20);

        service.scheduleAtFixedRate(new UpdateBookTask(), 0, 3, TimeUnit.SECONDS);

    }

}
