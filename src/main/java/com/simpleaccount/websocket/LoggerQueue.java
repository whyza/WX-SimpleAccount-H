package com.simpleaccount.websocket;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/5/8 16:59
 * @Version: 1.0
 */
/*
 * 创建一个阻塞队列，作为日志系统输出的日志的一个临时载体
 */
public class LoggerQueue
{
    // 队列大小
    public static final int QUEUE_MAX_SIZE = 10000;
    private static LoggerQueue alarmMessageQueue = new LoggerQueue();
    // 阻塞队列
    private BlockingQueue blockingQueue = new LinkedBlockingQueue<>(QUEUE_MAX_SIZE);

    private LoggerQueue()
    {
    }

    public static LoggerQueue getInstance()
    {
        return alarmMessageQueue;
    }

    /**
     * 消息入队
     *
     * @param log
     * @return boolean
     */
    public boolean push(LoggerMessage log)
    {
        return this.blockingQueue.add(log);// 队列满了就抛出异常，不阻塞
    }

    /**
     * 消息出队
     *
     * @return LoggerMessage
     */
    public LoggerMessage poll()
    {
        LoggerMessage result = null;
        try
        {
            result = (LoggerMessage) this.blockingQueue.take();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}