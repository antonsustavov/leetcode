package com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.factory;

import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.gpu.AsusGpu;
import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.gpu.Gpu;
import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.monitor.AsusMonitor;
import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.monitor.Monitor;

public class AsusManufacture extends MyCompany {
    @Override
    public Gpu createGpu() {
        return new AsusGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new AsusMonitor();
    }
}
