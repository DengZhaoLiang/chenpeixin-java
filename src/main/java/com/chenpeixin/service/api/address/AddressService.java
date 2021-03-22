package com.chenpeixin.service.api.address;

import com.chenpeixin.model.Address;

import java.util.List;

/**
 * @author chenpeixin
 * 2021-02-11
 */
public interface AddressService {

    /**
     * 获取地址列表
     */
    List<Address> listAddresses(Long userId);

    /**
     * 新增地址
     */
    void insertAddress(Address address);

    /**
     * 删除地址
     */
    void deleteAddress(Long id);
}
