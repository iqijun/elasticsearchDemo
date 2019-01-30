package com.fullstacker.elasticsearch.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetAddress;

/**
 * @program: elasticsearch
 * @description:
 * @author: xingguishuai
 * @create: 2019-01-29 14:21
 */
@Configuration
public class ElasticConfigration {
    @Value("${elasticsearch.host}")
    private String esHost;

    @Value("${elasticsearch.port}")
    private int esPort;

    @Value("${elasticsearch.clusterName}")
    private String esClusterName;

    private TransportClient client;

    @PostConstruct
    public void initialize() throws Exception {
        Settings esSettings = Settings.builder()
                .put("cluster.name", esClusterName)
                // TODO 关闭网络嗅探 ，自动嗅探时会报错 原因没搞明白
                .put("client.transport.sniff", false).build();
        client = new PreBuiltTransportClient(esSettings);
        String[] esHosts = esHost.trim().split(",");
        // 循环添加配置中的各个es节点
        for (String host : esHosts) {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host),
                    esPort));
        }
    }

    @Bean
    public Client client() {
        return client;
    }


    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client);
    }


    @PreDestroy
    public void destroy() {
        if (client != null) {
            client.close();
        }
    }
}
