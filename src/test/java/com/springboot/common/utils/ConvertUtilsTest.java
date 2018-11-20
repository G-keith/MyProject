package com.springboot.common.utils;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.codec.Base32;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.*;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.system.SystemUtil;
import com.springboot.modules.project.domain.SysUser;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ConvertUtilsTest {

    @Test
    public void test() throws IOException {
        String content="测试文件读取";
        // 写入文件（追加方式：StandardOpenOption.APPEND）
        Files.write(Paths.get("F:\\wps\\test.txt"), content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        // 读取文件
        byte[] data = Files.readAllBytes(Paths.get("F:\\wps\\test.txt"));
        System.out.println(new String(data, StandardCharsets.UTF_8));

    }

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Thread sThread = new Thread(new Runnable() {
            @Override
            public void run() {
                AsynchronousChannelGroup group = null;
                try {
                    group = AsynchronousChannelGroup.withThreadPool(Executors.newFixedThreadPool(4));
                    AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open(group).bind(new InetSocketAddress(InetAddress.getLocalHost(), 9090));
                    server.accept(null, new CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel>() {
                        @Override
                        public void completed(AsynchronousSocketChannel result, AsynchronousServerSocketChannel attachment) {
                            server.accept(null, this); // 接收下一个请求
                            try {
                                Future<Integer> f = result.write(Charset.defaultCharset().encode("你好，世界"));
                                f.get();
                                System.out.println("服务端发送时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                                result.close();
                            } catch (InterruptedException | ExecutionException | IOException e) {
                                e.printStackTrace();
                            }
                        }
                        @Override
                        public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {
                        }
                    });
                    group.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        sThread.start();
        // Socket 客户端
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        Future<Void> future = client.connect(new InetSocketAddress(InetAddress.getLocalHost(), 9090));
        future.get();
        ByteBuffer buffer = ByteBuffer.allocate(100);
        client.read(buffer, null, new CompletionHandler<Integer, Void>() {
            @Override
            public void completed(Integer result, Void attachment) {
                System.out.println("客户端打印：" + new String(buffer.array()));
            }
            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread.sleep(10 * 1000);
    }
}