package com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.factory;

import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.gpu.Gpu;
import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.monitor.Monitor;

public abstract class MyCompany {

    public abstract Gpu createGpu();
    public abstract Monitor createMonitor();
}
