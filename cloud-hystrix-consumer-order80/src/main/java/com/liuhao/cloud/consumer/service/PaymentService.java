package com.liuhao.cloud.consumer.service;


import com.liuhao.cloud.commons.entity.CommonResult;
import com.liuhao.cloud.commons.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient("cloud-payment-service")
public interface PaymentService {

    @RequestMapping(method = RequestMethod.GET, value = "/payment/uuid")
    CommonResult<String> getUUID();

    @RequestMapping(method = RequestMethod.POST, value = "/payment/create")
    CommonResult<Payment> create(@RequestBody Payment payment);

    @RequestMapping(method = RequestMethod.GET, value = "/payment/get/{id}")
    CommonResult<Payment> selectOne(@PathVariable("id") Long id);

}
