package com.example.procesos.application.util.validator;

import com.example.procesos.domain.Process;
import com.example.procesos.domain.validation.ProcessValidator;

public class ProcessAlwaysValidValidator implements ProcessValidator {
    @Override
    public Process validate(Process process) {
        return process;
    }
}
