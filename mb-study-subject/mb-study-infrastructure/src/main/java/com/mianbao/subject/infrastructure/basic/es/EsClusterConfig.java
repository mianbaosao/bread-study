package com.mianbao.subject.infrastructure.basic.es;

import lombok.Data;

import java.io.Serializable;

/**
 * es集群类
 ** */
@Data
public class EsClusterConfig implements Serializable {

    /**
     * 集群名称
     */
    private String name;

    /**
     * 集群节点
     */
    private String nodes;

}
