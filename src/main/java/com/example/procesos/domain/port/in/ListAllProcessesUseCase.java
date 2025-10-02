package com.example.procesos.domain.port.in;

import java.util.List;
import com.example.procesos.domain.Process;

public interface ListAllProcessesUseCase {
    List<Process> list();
}
