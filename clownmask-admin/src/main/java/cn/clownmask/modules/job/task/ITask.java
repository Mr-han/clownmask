package cn.clownmask.modules.job.task;

/**
 * 定时任务接口，所有定时任务都要实现该接口
 *
 * @author Mark hanchaoqun@hotmail.com
 */
public interface ITask {

    /**
     * 执行定时任务接口
     *
     * @param params   参数，多参数使用JSON数据
     */
    void run(String params);
}