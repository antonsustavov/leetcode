package com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.factory;

import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.gpu.Gpu;
import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.gpu.MsiGpu;
import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.monitor.Monitor;
import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.monitor.MsiMonitor;

public class MsiManufacture extends MyCompany {
    @Override
    public Gpu createGpu() {
        return new MsiGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new MsiMonitor();
    }
}
