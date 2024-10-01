package com.sustav.ALGORITHM.pattern.creational.abstruct_method.os;

public class OperationSystemFactory {

    private OperationSystemFactory() {
    }

    public static OperationSystem getInstance(String version, String arch) {
        switch (arch) {
            case "WINDOWS":
                return new Windows(version, arch);
            case "LINUX":
                return new Linux(version, arch);
            default:
                throw new IllegalArgumentException("OS not support");
        }
    }
}
