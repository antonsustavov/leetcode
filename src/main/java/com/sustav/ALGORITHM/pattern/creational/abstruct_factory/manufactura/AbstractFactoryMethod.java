package com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura;

import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.factory.MyCompany;
import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.factory.AsusManufacture;
import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.factory.MsiManufacture;
import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.gpu.Gpu;
import com.sustav.ALGORITHM.pattern.creational.abstruct_factory.manufactura.monitor.Monitor;

public class AbstractFactoryMethod {
    public static void main(String[] args) {
        MyCompany msiManufacture = new MsiManufacture();
        Gpu gpu = msiManufacture.createGpu();
        Monitor monitor = msiManufacture.createMonitor();

        MyCompany asusManufacture = new AsusManufacture();
        Gpu gpua = asusManufacture.createGpu();
        Monitor monitora = asusManufacture.createMonitor();
    }
}
