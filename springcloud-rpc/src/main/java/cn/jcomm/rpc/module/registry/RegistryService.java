package cn.jcomm.rpc.module.registry;

import java.util.List;

import cn.jcomm.rpc.core.domain.Url;

/**
 * @author: jowang
 * @date: 2018-11-30 13:31
 * @description:
 */
public interface RegistryService {
    void register(Url url);

    void unregister(Url url);

    List<Url> list();
}
