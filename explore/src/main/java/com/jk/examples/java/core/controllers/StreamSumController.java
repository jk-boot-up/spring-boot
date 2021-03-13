package com.jk.examples.java.core.controllers;

import com.jk.examples.java.domain.streams.SimpleSum;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StreamSumController {

    @Resource
    private SimpleSum simpleSum;

    @RequestMapping(value = "/streams/sum/even", method = RequestMethod.GET)
    @ApiOperation(value = "get the sum of even numbers", notes = "test sum of even numbers", response = String.class)
    @ResponseBody
    public String findSumOfEvenNumbers() {

        List<Integer> mixedNumbers = new ArrayList<Integer>();

        mixedNumbers.add(10);
        mixedNumbers.add(5);
        mixedNumbers.add(3);
        mixedNumbers.add(8);
        mixedNumbers.add(1);

        return String.valueOf(simpleSum.findSumOfEvenNumbers(mixedNumbers));
    }

}
