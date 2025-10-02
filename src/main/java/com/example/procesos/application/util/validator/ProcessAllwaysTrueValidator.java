package com.example.procesos.application.util.validator;

import com.example.procesos.domain.Process;
import com.example.procesos.domain.validator.ProcessValidator;

public class ProcessAllwaysTrueValidator implements ProcessValidator {
    @Override
    public boolean validate(Process process) {
        return true;
    }
}
