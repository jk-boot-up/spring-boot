package com.jk.examples.java.domain.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamedFloat {

    private List<Float> floats = null;

    public StreamedFloat(List<Float> floats) {
        this.floats = floats;
    }

    public List<Float> getFloats() {
        return floats;
    }

    public void setFloats(List<Float> floats) {
        this.floats = floats;
    }

    public Float getSumOfFloats() {
        Double results = floats.stream().map(aFloat -> aFloat*aFloat).collect(Collectors.toList()).stream().mapToDouble(Float::doubleValue).sum();
        return new Float(results.floatValue());
    }

    public static void main(String [] args) {
        StreamedFloat sf = new StreamedFloat(Arrays.asList(1.2f, 3.4f, 5.6f));
        System.out.println(sf.getSumOfFloats());
    }
}
