package com.example.schbusrez.controller;

import com.example.schbusrez.bean.SchbusBean;
import com.example.schbusrez.mapper.SchbusMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
@CrossOrigin
public class BusController {
    private final SchbusMapper schbusMapper;

    public BusController(SchbusMapper schbusMapper){
        this.schbusMapper=schbusMapper;
    }

    @RequestMapping("")
    public List<SchbusBean> getAllBuses(){
        return schbusMapper.showInfo();
    }

    @GetMapping("/{id}")
    public SchbusBean getBusById(@PathVariable Integer id){
        return schbusMapper.findBusById(id);
    }

    @PostMapping("")
    public Integer addBus(@RequestBody SchbusBean schbusBean){
        schbusMapper.addBus(schbusBean);
        return schbusBean.getId();
    }

    @DeleteMapping("/{id}")
    public void deleteBus(@PathVariable Integer id){
        schbusMapper.deleteBus(id);
    }

    @PutMapping("/{id}")
    public void updateBus(@PathVariable Integer id,@RequestBody SchbusBean schbusBean){
        schbusBean.setId(id);
        schbusMapper.updateBus(schbusBean);
    }
}
