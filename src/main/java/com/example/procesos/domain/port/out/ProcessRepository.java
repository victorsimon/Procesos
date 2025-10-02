package com.example.procesos.domain.port.out;

import com.example.procesos.domain.Process;

import java.util.List;

public interface ProcessRepository {

    Process save(Process process);
    List<Process> findAll();

}
