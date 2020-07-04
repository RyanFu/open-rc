package me.jiahuan.stf.agent.controller;

import me.jiahuan.stf.agent.ApiRoutes;
import me.jiahuan.stf.agent.model.Runtime;
import me.jiahuan.stf.agent.pojo.DeviceInfo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class DeviceController {
    @GetMapping(ApiRoutes.API_DEVICES)
    public List<DeviceInfo> query() {
        return Runtime.deviceList;
    }

    @GetMapping(ApiRoutes.API_DEVICE)
    public Optional<DeviceInfo> query(@PathVariable("deviceId") String deviceId) {
        return Runtime.deviceList.stream().filter((deviceInfo -> deviceInfo.getDeviceId().equals(deviceId))).findFirst();
    }
}
