package com.sustav.ALGORITHM.pattern.creational.abstruct_method.os;

public abstract class OperationSystem {
    private String version;
    private String arch;

    public OperationSystem(String version, String arch) {
        this.version = version;
        this.arch = arch;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getArch() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }

    public abstract void changeDir(String dir);
    public abstract void removeDir(String dir);
}
